package com.po;

/**
 * @program database
 * @description: TODO:
 * @author: tujunda
 * @create: 2018/11/20 15:14
 */
public class EnrollableCourse {
    private String UoSCode;
    private String UoSName;
    private String quarter;
    private int year;

    @Override
    public String toString() {
        return "EnrollableCourse{" +
                "UoSCode='" + UoSCode + '\'' +
                ", UoSName='" + UoSName + '\'' +
                ", quarter='" + quarter + '\'' +
                ", year=" + year +
                '}';
    }

    public String getUoSCode() {
        return UoSCode;
    }

    public void setUoSCode(String uoSCode) {
        UoSCode = uoSCode;
    }

    public String getUoSName() {
        return UoSName;
    }

    public void setUoSName(String uoSName) {
        UoSName = uoSName;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

