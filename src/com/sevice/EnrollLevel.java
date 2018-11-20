package com.sevice;

import com.Enum.Levels;
import com.jdbcHelper.DBHelper;
import com.otherUsefulObject.Semester;
import com.po.EnrollableCourse;
import com.po.StudentPO;
import com.utils.TimeUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @program database
 * @description: TODO: students can enroll new course here
 * @author: tujunda
 * @create: 2018/11/20 13:56
 */
public class EnrollLevel {
    public int beginEnroll(StudentPO studentPO) throws Exception{
        Set<String> courseSetForEnrollment = new HashSet<>();
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
            System.out.println(enrollableCourse.toString());
        }
        System.out.println("////////////////////////////////");
        System.out.println("////////////////////////////////");
        System.out.println("////////////////////////////////");
        System.out.println("Your can enter the course you want to enroll or you can enter \"back\" to got back to student menu");

        while (true) {
            String courseCode = sc.next();
            if (courseCode.equals("back")) {
                return Levels.STUDENT_MENU.getIndex();
            } else if (courseSetForEnrollment.contains(courseCode)) {
                //check the pre-requirement and maxenrollment

                //call store
            } else {
                System.out.println("Please input the right command or the permissible course for enrollment");
            }
        }
        //return 0;
    }
}

