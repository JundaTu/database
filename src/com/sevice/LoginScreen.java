package com.sevice;

import com.jdbcHelper.DBHelper;
import com.po.StudentPO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * @program database
 * @description: TODO: the start part of this system
 * @author: tujunda
 * @create: 2018/11/19 13:23
 */
public class LoginScreen {

    public StudentPO login() throws Exception{
        StudentPO studentPO = new StudentPO();
        while (true) {
            //input the username and password
            System.out.println("THis is Login screen.");
            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            System.out.print("Input your id:");
            String id = sc.nextLine();
            System.out.println();
            System.out.print("Input your password:");
            String password = sc.next();

            //search the data by the name password
            Connection conn = DBHelper.getConnection();

            String query = "select * from student where id = " + id + " and password = " + "'" + password + "'";
            PreparedStatement statement;
            ResultSet rs;
            try {
                statement = conn.prepareStatement(query);
                rs = statement.executeQuery();
            } catch (Exception e) {
                System.out.println("Please input right id and password");
                continue;
            }



            while (rs.next()) {

                studentPO.setId(rs.getInt(1));
                studentPO.setName(rs.getString(2));
                studentPO.setPassword(rs.getString(3));
                studentPO.setAddress(rs.getString(4));
                //System.out.print("find the one");
            }
            if (studentPO.getName() == null) {
                System.out.print("Please input right ID and password");
                continue;
            }

            return studentPO;
        }
    }

    public static void main(String[] args) {
        LoginScreen loginScreen = new LoginScreen();
        StudentPO studentPO = null;
        try {
            studentPO = loginScreen.login();
        } catch (Exception e) {
            System.out.print("the student doesn't exit");
        }
        StudentMenu studentMenu = new StudentMenu();
        int rs = 0;
        try {
            rs = studentMenu.enterSomeoneMenu(studentPO);
        } catch (Exception e) {
            System.out.print("Exception found of student menu");
        }
        System.out.print(rs);

        /////////////test for transcript
        TranscriptLevel transcriptLevel = new TranscriptLevel();
        try {
            transcriptLevel.getTranscript(studentPO);
        } catch (Exception e) {
            System.out.println("There are something wrong with tanscriptLevel");
        }

        /////////////test for enrollLevel
        EnrollLevel enrollLevel = new EnrollLevel();
        try {
            enrollLevel.beginEnroll(studentPO);
        } catch (Exception e) {
            System.out.println("There are something wrong with Enrollment");
        }
    }
}

