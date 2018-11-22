package com.sevice;

import com.Enum.Levels;
import com.jdbcHelper.DBHelper;
import com.otherUsefulObject.ConsForLevels;
import com.otherUsefulObject.Navigator;
import com.otherUsefulObject.Semester;
import com.po.EnrollableCourse;
import com.po.RequiresPO;
import com.po.StudentPO;
import com.po.UoSOfferingPO;
import com.utils.TimeUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 * @program database
 * @description: TODO: students can enroll new course here
 * @author: tujunda
 * @create: 2018/11/20 13:56
 */
public class EnrollLevel {
    public int beginEnroll(StudentPO studentPO) throws Exception{
        Set<String> courseSetForEnrollment = new HashSet<>();
        Set<String> finishedCousre = new HashSet<>();
        List<EnrollableCourse> listOfEnrollableCourse = new ArrayList<>();
        Scanner sc = new Scanner(System.in);


        ///how to get the current time

        Semester curSemester = TimeUtils.getCurrrentSemester();
        Semester nextSemester = curSemester.nextQuarter();

        //database operation: find which course a student can register
        Connection conn = DBHelper.getConnection();
        String queryForEnrollableCourse = "select distinct * from\n" +
                "(select uoso.UoSCode, uos.UoSName, uoso.Semester, uoso.Year\n" +
                "from uosoffering as uoso, transcript as t, unitofstudy as uos\n" +
                "where uoso.UoSCode = uos.UoSCode and uoso.UoSCode not in\n" +
                "     (select transcript.UoSCode from transcript\n" +
                "      where transcript.StudId = 3213)) as t1\n" +
                "where t1.Year = "+ curSemester.getYear() +" and t1.Semester = "+ "'" + curSemester.getQuater() + "'" +
                " or t1.Year = "+ nextSemester.getYear()+" and t1.Semester = " + "'" + nextSemester.getQuater() + "'";
        PreparedStatement statementForEnrollableCourse = conn.prepareStatement(queryForEnrollableCourse);
        ResultSet rs = statementForEnrollableCourse.executeQuery();

        while (rs.next()) {
            EnrollableCourse enrollableCourse = new EnrollableCourse();
            enrollableCourse.setUoSCode(rs.getString(1));
            enrollableCourse.setUoSName(rs.getString(2));
            enrollableCourse.setQuarter(rs.getString(3));
            enrollableCourse.setYear(rs.getInt(4));
            courseSetForEnrollment.add(enrollableCourse.getUoSCode());
            //System.out.println(enrollableCourse.toString());
            listOfEnrollableCourse.add(enrollableCourse);
        }
//        for (EnrollableCourse ec : listOfEnrollableCourse) {
//            System.out.println(ec.toString());
//        }
        System.out.println("////////////////////////////////");
        System.out.println("////////////////////////////////");
        System.out.println("////////////////////////////////");


        ///////////////////fill the taken courses set
        //////////////////
        /////////////////////////
        /**
         * @Author tujunda
         * @Description TODO: find the courses finished for future test of pre-requirement
         * @Date 17:43 11/20/18
         * @Param [studentPO]
         * @return int
         **/
        String queryForTakenCourse = "select * from transcript where grade is not null and StudId = " + studentPO.getId();
        PreparedStatement takenCoursesStatement = conn.prepareStatement(queryForTakenCourse);
        ResultSet rsForTakenCourse = takenCoursesStatement.executeQuery();
        while (rsForTakenCourse.next()) {
            //get taken course code
            finishedCousre.add(new String(rsForTakenCourse.getString(2)));

        }




        /**
         * @Author tujunda
         * @Description TODO: the following are enroll
         * @Date 17:42 11/20/18
         * @Param [studentPO]
         * @return int
         **/
        while (true) {
            for (EnrollableCourse ec : listOfEnrollableCourse) {
                System.out.println(ec.toString());
            }
            System.out.println("###Your can access each other portals following: ");
            System.out.println("1.Transcript");
            System.out.println("2.Student menu");
            System.out.println("3.Withdraw");
            System.out.println("4.Personal");
            System.out.println("5.Logout");
            System.out.println("6.Exit");

            System.out.println("###OR Your can enter the course you want to enroll");

            String courseCode = sc.nextLine();
            courseCode = courseCode.toLowerCase();
            if (Navigator.navigator.contains(courseCode)) {
                int code = Navigator.toDifferntScreen(courseCode);
                if (code == -1) {
                    System.out.println(courseCode + " is unknown.");
                    System.out.print("Please enter the right command");
                    System.out.print("Enter: ");
                    continue;
                } else {
                    return code;
                }
            }
            System.out.println("input the year");
            String goalYear = sc.next();
            System.out.println("input the quarter");
            String goalQuarter = sc.next();
            if (courseSetForEnrollment.contains(courseCode)) {
                //maxenrollment
                String queryForOffering = "select distinct * from\n" +
                        "(select uoso.UoSCode, uoso.Enrollment, uoso.MaxEnrollment, uoso.Semester, uoso.Year\n" +
                        "from uosoffering as uoso, transcript as t, unitofstudy as uos\n" +
                        "where uoso.UoSCode = uos.UoSCode and uoso.UoSCode not in\n" +
                        "     (select transcript.UoSCode from transcript\n" +
                        "      where transcript.StudId = "+ studentPO.getId() +")) as t1\n" +
                        "where t1.UoSCode = '" + courseCode +"' and t1.Enrollment < t1.MaxEnrollment " +
                        "and t1.Year = "+ goalYear+" and t1.Semester = '" + goalQuarter + "' ";
                PreparedStatement offerStatement = conn.prepareStatement(queryForOffering);
                ResultSet tmpRs;
                try {
                    tmpRs = offerStatement.executeQuery();;
                } catch (Exception e) {
                    System.out.println("error of input, try again");
                    continue;
                }

                UoSOfferingPO uoSOfferingPO = new UoSOfferingPO();
                //list of offering course
                while (tmpRs.next()) {
                    //UoSOfferingPO uoSOfferingPO = new UoSOfferingPO();
                    uoSOfferingPO.setUoSCode(tmpRs.getString(1));
                    uoSOfferingPO.setEnrollment(tmpRs.getInt(2));
                    uoSOfferingPO.setMaxEnrollment(tmpRs.getInt(3));
                    uoSOfferingPO.setSemester(tmpRs.getString(4));
                    uoSOfferingPO.setYear(tmpRs.getInt(5));
                }
                if (uoSOfferingPO.getEnrollment() < uoSOfferingPO.getMaxEnrollment()) {
                    String queryForRequire = "select PrereqUoSCode\n" +
                            "from requires\n" +
                            "where UoSCode = '" + courseCode+ "'";
                    PreparedStatement statementForRequire = conn.prepareStatement(queryForRequire);
                    ResultSet rsForRequire = statementForRequire.executeQuery();
                    RequiresPO requiresPO = new RequiresPO();
                    while (rsForRequire.next()) {
                        requiresPO.setPrereqUoSCode(rsForRequire.getString(1));
                    }
                    if (finishedCousre.contains(requiresPO.getPrereqUoSCode())) {
                        //call store procesure to
                        EnrollableCourse chosenCourse;
                        for (EnrollableCourse ec : listOfEnrollableCourse) {
                            if (ec.getUoSCode().equals(courseCode)) {
//                                chosenCourse = ec;
                                listOfEnrollableCourse.remove(ec);
                                break;
                            }
                        }
                        System.out.print("you can enroll");





                        ///

                    } else {
                        System.out.println("You do not meet the pre-requirement to take this course.");
                        System.out.println("Enrollment fails.");
                    }
                } else {
                    System.out.println("This course has been fully enrolled.");
                    System.out.println("Enrollment fails.");
                }
                //check the pre-requirement


            } else {
                System.out.println("Please input the right command or the permissible course for enrollment");
            }
        }
        //return 0;
    }
}

