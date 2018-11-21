package com.po;

/**
 * @program database
 * @description: TODO:
 * @author: tujunda
 * @create: 2018/11/18 21:18
 */
public class TranscriptPO {
    private int studId;
    private String UoSCode;
    private String semester;
    private int year;
    private String grade;

    public int getStudId() {
        return studId;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    public String getUoSCode() {
        return UoSCode;
    }

    public void setUoSCode(String uoSCode) {
        UoSCode = uoSCode;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Transcript: {" +
                "studId=" + studId +
                ", UoSCode='" + UoSCode + '\'' +
                ", semester='" + semester + '\'' +
                ", year=" + year +
                ", grade='" + grade + '\'' +
                '}';
    }
}

