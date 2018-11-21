package com.po;

/**
 * @program database
 * @description: TODO: show the detail of a course taken by a student at his time
 * @author: tujunda
 * @create: 2018/11/19 23:31
 */
public class CourseDetailPO {
    private String UoSCode;
    private String UoSName;
    private String lecturer;
    private int year;
    private String semester;
    private String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    private int enrollment;
    private int maxEnrollment;

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

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
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

    @Override
    public String toString() {
        return "CourseDetailPO{" +
                "UoSCode='" + UoSCode + '\'' +
                ", UoSName='" + UoSName + '\'' +
                ", lecturer='" + lecturer + '\'' +
                ", year=" + year +
                ", semester='" + semester + '\'' +
                ", grade='" + grade + '\'' +
                ", enrollment=" + enrollment +
                ", maxEnrollment=" + maxEnrollment +
                '}';
    }
}

