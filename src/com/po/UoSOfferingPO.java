package com.po;

/**
 * @program database
 * @description: TODO:
 * @author: tujunda
 * @create: 2018/11/18 21:23
 */
public class UoSOfferingPO {
    private String UoSCode;
    private String semester;
    private int year;
    private String textBook;
    private int enrollment;
    private int maxEnrollment;
    private String instructorId;

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

    public String getTextBook() {
        return textBook;
    }

    public void setTextBook(String textBook) {
        this.textBook = textBook;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    @Override
    public String toString() {
        return "UoSOfferingPO{" +
                "UoSCode='" + UoSCode + '\'' +
                ", semester='" + semester + '\'' +
                ", year=" + year +
                ", textBook='" + textBook + '\'' +
                ", enrollment=" + enrollment +
                ", maxEnrollment=" + maxEnrollment +
                ", instructorId='" + instructorId + '\'' +
                '}';
    }
}

