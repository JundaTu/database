package com.sevice;

import com.Enum.Levels;
import com.jdbcHelper.DBHelper;
import com.po.StudentPO;
import com.po.TranscriptPO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program database
 * @description: TODO: After log in to this system, we come to this main menu
 * @author: tujunda
 * @create: 2018/11/19 14:30
 */
public class StudentMenu {
    public int enterSomeoneMenu(StudentPO studentPO) throws Exception {
        System.out.println("Hi," + studentPO.getName() + ". This is your menu.");

        //a list to store transcripts
        List<TranscriptPO> transcriptPOList = new ArrayList<>();
        //search for all current courses, this student has enrolled already.
        Connection conn = DBHelper.getConnection();
        String query = "select t.*, uos.UoSName\n" +
                       "from transcript as t, unitofstudy as uos\n" +
                       "where t.UoSCode = uos.UoSCode and t.Grade is null and t.studId = " + studentPO.getId() ;
        PreparedStatement queryEnrolledCourse = conn.prepareStatement(query);
        ResultSet rs = queryEnrolledCourse.executeQuery();
        System.out.println("////////////////////////////");
        System.out.println("Current courses");
        System.out.println("////////////////////////////");
        while (rs.next()) {
            TranscriptPO transcriptPO = new TranscriptPO();
            transcriptPO.setStudId(rs.getInt(1));
            transcriptPO.setUoSCode(rs.getString(2));
            transcriptPO.setSemester(rs.getString(3));
            transcriptPO.setYear(rs.getInt(4));
            transcriptPO.setGrade(rs.getString(5));
            transcriptPOList.add(transcriptPO);
            System.out.println(rs.getString(6));
        }

        //show other portals
        System.out.println("Your can access each other portals following: ");
        System.out.println("1.Transcript");
        System.out.println("2.Enroll");
        System.out.println("3.Withdraw");
        System.out.println("4.Personal");
        System.out.println("5.Detail");
        System.out.println("6.Logout");

        System.out.println("You can input the full name like transcript(not matter uppercase or lowercase) to access that part ");

        ////////////////////////////
        Scanner sc = new Scanner(System.in);

        while (true) {
            String levelName = sc.next();
            levelName = levelName.toLowerCase();
            switch (levelName) {
                case "transcript":
                    return Levels.TRANSCRIPT.getIndex();
                case "enroll":
                    return Levels.ENROLL.getIndex();
                case "personal":
                    return Levels.PERSONAL.getIndex();
                case "detail":
                    return Levels.DETAIL.getIndex();
                case "logout":
                    return Levels.LOGOUT.getIndex();
                default:
                    System.out.println(levelName + " is unknown.");
                    System.out.print("Please enter the right command");
                    System.out.print("Enter: ");
                    continue;
            }
        }
    }
}

