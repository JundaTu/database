package com.sevice;

import com.jdbcHelper.DBHelper;
import com.po.StudentPO;
import com.po.TranscriptPO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
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


        System.out.println("///////////////////////////////////////////////////");
        System.out.println("You can access ");
        return 0;
    }
}

