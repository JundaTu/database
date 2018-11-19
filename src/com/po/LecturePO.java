package com.po;

/**
 * @program database
 * @description: TODO:
 * @author: tujunda
 * @create: 2018/11/18 21:11
 */
public class LecturePO {
    private String UoSCode;
    private String semester;
    private int year;
    private String classTime;
    private String classRommId;

    public String getUoScode() {
        return UoSCode;
    }

    public void setUoScode(String UoSCode) {
        this.UoSCode = UoSCode;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getClassRommId() {
        return classRommId;
    }

    public void setClassRommId(String classRommId) {
        this.classRommId = classRommId;
    }

    @Override
    public String toString() {
        return "LecturePO{" +
                "uoScode='" + UoSCode + '\'' +
                ", semester='" + semester + '\'' +
                ", year=" + year +
                ", classTime='" + classTime + '\'' +
                ", classRommId='" + classRommId + '\'' +
                '}';
    }
}

