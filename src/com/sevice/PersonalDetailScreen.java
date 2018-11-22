package com.sevice;

import com.Enum.Levels;
import com.jdbcHelper.DBHelper;
import com.otherUsefulObject.ConsForLevels;
import com.otherUsefulObject.Navigator;
import com.po.StudentPO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * @program database
 * @description: TODO: A screen shows the details of log-in student info. And he/she can update his password here.
 * @author: tujunda
 * @create: 2018/11/20 19:45
 */
public class PersonalDetailScreen {
    public int enterPersonalScreen(StudentPO studentPO) throws Exception{

        Connection conn = DBHelper.getConnection();
        Scanner sc = new Scanner(System.in);
        System.out.println(studentPO.toString());
        while (true) {
            System.out.println("###Your can access each other portals following: ");
            System.out.println("1.Transcript");
            System.out.println("2.Student menu");
            System.out.println("3.Enroll");
            System.out.println("4.Withdraw");
            System.out.println("5.Personal");
            System.out.println("6.Logout");
            System.out.println("7.Exit");
            System.out.println("###You can enter \"password\" or \"address\" to change password, address.");
            String command = sc.nextLine();
            command = command.toLowerCase();
            command = command.toLowerCase();

            //TODO: go back to other menu
            if (Navigator.navigator.contains(command)) {
                int code = Navigator.toDifferntScreen(command);
                if (code == -1) {
                    System.out.println(command + " is unknown.");
                    System.out.print("Please enter the right command");
                    System.out.print("Enter: ");
                    continue;
                } else {
                    return code;
                }
            } else if (command.equals("password")) {
                //change password
                while (true) {
                    System.out.println("Enter your new password");
                    String newPdw = sc.next();
                    System.out.println("Comfirm your new password");
                    String confirmPdw = sc.next();
                    if (!newPdw.equals(confirmPdw)) {
                        System.out.println("the two passwords your entered are different. ");
                        System.out.println("Try again.");
                        //continue;
                    } else {
                        String updatePassword = "update student set password = '" + newPdw + "' where id = " + studentPO.getId();
                        PreparedStatement psForUpdatePdw = conn.prepareStatement(updatePassword);
                        psForUpdatePdw.executeUpdate();

                        System.out.println("Update your password successfully.");

                        break;
                    }
                }
            } else if (command.equals("address")) {
                //change password
                System.out.println("Enter your new address");
                String newAddr = sc.next();
                String queryForNewAddr = "update student set address = '" + newAddr + "' where id = " + studentPO.getId();
                PreparedStatement psForAddr = conn.prepareStatement(queryForNewAddr);
                int exitIndicator = psForAddr.executeUpdate();

                System.out.println("Update address successfully.");
            } else {
                System.out.println("Your command is unknow.");
                System.out.println("Try again!");
                System.out.println("///////////////////////");
            }
            String query = "select * from student where id = " + studentPO.getId();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                studentPO.setId(rs.getInt(1));
                studentPO.setName(rs.getString(2));
                studentPO.setPassword(rs.getString(3));
                studentPO.setAddress(rs.getString(4));
            }
            System.out.println(studentPO.toString());
        }

        //return 0;
    }
}

