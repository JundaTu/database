package com.utils;

import com.otherUsefulObject.Semester;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program database
 * @description: TODO:
 * @author: tujunda
 * @create: 2018/11/20 14:39
 */
public class TimeUtils {
    public static Semester getCurrrentSemester() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        String currentTime = dateFormat.format(now);
        //System.out.println(currentTime);
        String curYear = currentTime.substring(0,4);
        String curQuarter = currentTime.substring(5, 7);
        Semester curSemester = new Semester(curYear, curQuarter);
        return curSemester;
    }
}

