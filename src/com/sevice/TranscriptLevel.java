package com.sevice;

import com.Enum.Levels;
import com.jdbcHelper.DBHelper;
import com.po.CourseDetailPO;
import com.po.StudentPO;
import com.po.TranscriptPO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @program database
 * @description: TODO: the screen will show a student's all courses
 * @author: tujunda
 * @create: 2018/11/19 17:19
 */
public class TranscriptLevel {
    public int getTranscript(StudentPO studentPO) throws Exception{
        Set<String> takenCoursesSet = new HashSet<>();

        //query the data from database
        Connection conn = DBHelper.getConnection();
        String query = "select * from transcript where studId = " + studentPO.getId();
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();

        TranscriptPO transcriptPO = new TranscriptPO();
        while (rs.next()) {
            transcriptPO.setStudId(rs.getInt(1));
            transcriptPO.setUoSCode(rs.getString(2));
            transcriptPO.setSemester(rs.getString(3));
            transcriptPO.setYear(rs.getInt(4));;
            transcriptPO.setGrade(rs.getString(5));
            System.out.println(transcriptPO.toString());
            takenCoursesSet.add(transcriptPO.getUoSCode());
        }


        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("///////////////////////////////////////////////////");
            System.out.println("You can access the detail of courses you enrolled by entering the UoSCode");
            System.out.println("Or you can input \"back\" to go back to student menu");

            String command = sc.next();
            //command = command.toCase();
            if (command == "back") {
                return Levels.STUDENT_MENU.getIndex();
            } else if (takenCoursesSet.contains(command)){
                String courseInfoQuery = "select t.UoSCode, t.Year, t.Semester, t.Grade, f.Name as lecturerName, uoso.Enrollment, uoso.MaxEnrollment" +
                        " from unitofstudy as uos, transcript as t, uosoffering as uoso, faculty as f" +
                        " where uos.UoSCode = t.UoSCode and uos.UoSCode = uoso.UoSCode and t.StudId = " + studentPO.getId() +
                        "  and uoso.Year = t.Year and uoso.Semester = t.Semester and uoso.InstructorId = f.Id and t.UoSCode = " + "'" + command + "'";
                PreparedStatement stament1 = conn.prepareStatement(courseInfoQuery);
                ResultSet detailsRs = stament1.executeQuery();
                while (detailsRs.next()) {
                    CourseDetailPO courseDetailPO = new CourseDetailPO();
                    courseDetailPO.setUoSCode(detailsRs.getString(1));
                    courseDetailPO.setYear(detailsRs.getInt(2));
                    courseDetailPO.setSemester(detailsRs.getString(3));
                    courseDetailPO.setGrade(detailsRs.getString(4));
                    courseDetailPO.setLecturer(detailsRs.getString(5));
                    courseDetailPO.setEnrollment(detailsRs.getInt(6));
                    courseDetailPO.setMaxEnrollment(detailsRs.getInt(7));
                    System.out.println("This is the detail of the course you want:");
                    System.out.println(courseDetailPO.toString());
                }


            } else {
                System.out.println("Your command is unknown or the course has not been taken by you");
            }
        }

    }
}

