package com.sevice;

import com.Enum.Levels;
import com.jdbcHelper.DBHelper;
import com.otherUsefulObject.ConsForLevels;
import com.otherUsefulObject.Navigator;
import com.po.StudentPO;
import com.po.TranscriptPO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 * @program database
 * @description: TODO: a place where the logged in student can withdraw the courses
 * @author: tujunda
 * @create: 2018/11/20 19:09
 */
public class WithdrawScreen {
    public int enterWithdrawScreen(StudentPO studentPO) throws Exception{


        Connection conn = DBHelper.getConnection();


        /**
         * @Author tujunda
         * @Description TODO: following: withdraw course here
         * @Date 19:35 11/20/18
         **/
        Scanner sc = new Scanner(System.in);

        while (true) {
            Map<String, TranscriptPO> courseMap = new HashMap<>();
            Set<String> curCourseSet = new HashSet<>();
            String queryForNotFinishCourse = "select *\n" +
                    "from transcript\n" +
                    "where transcript.Grade is null and transcript.StudId = " + studentPO.getId();
            PreparedStatement ps = conn.prepareStatement(queryForNotFinishCourse);
            ResultSet rsForWithdraw = ps.executeQuery();

            while (rsForWithdraw.next()) {
                TranscriptPO courseTranscript = new TranscriptPO();
                courseTranscript.setStudId(rsForWithdraw.getInt(1));
                courseTranscript.setUoSCode(rsForWithdraw.getString(2));
                courseTranscript.setSemester(rsForWithdraw.getString(3));
                courseTranscript.setYear(rsForWithdraw.getInt(4));
                curCourseSet.add(courseTranscript.getUoSCode());
                courseMap.put(courseTranscript.getUoSCode(), courseTranscript);
            }

            for (String s : curCourseSet) {
                System.out.println(s);
            }
            System.out.println();
            System.out.println("###Your can access each other portals following: ");
            System.out.println("1.Transcript");
            System.out.println("2.Student menu");
            System.out.println("3.Enroll");
            System.out.println("4.Personal");
            System.out.println("5.Logout");
            System.out.println("6.Exit");
            System.out.println("You can enter \"back\" to go back to student menu OR you can enter the course that you want to withdraw");
            String command = sc.nextLine();
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
            } else if (curCourseSet.contains(command)) {
                //call store procedure to finish withdraw
                TranscriptPO tclass =  courseMap.get(command);
                String queryCallWithdrawclass = "call withdrawclass(" + studentPO.getId() +
                        ", '" + tclass.getUoSCode() +"', " + tclass.getYear() + ", '" + tclass.getSemester() + "');";

                CallableStatement cStmt = conn.prepareCall(queryCallWithdrawclass);

                // cStmt.setString(studentPO.getId(), tclass.getUoSCode(), tclass.getYear(),tclass.getSemester());
                cStmt.executeQuery();

                System.out.println("Withdraw the class successfully.");
            } else {
                System.out.println("The command you enter is unknown. Check it and try again");
            }
        }
        //return 0;
    }
}

