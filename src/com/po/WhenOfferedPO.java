package com.po;

/**
 * @program database
 * @description: TODO:
 * @author: tujunda
 * @create: 2018/11/18 21:25
 */
public class WhenOfferedPO {
    private String UoSCode;
    private String semester;

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

    @Override
    public String toString() {
        return "WhenOfferedPO{" +
                "UoSCode='" + UoSCode + '\'' +
                ", semester='" + semester + '\'' +
                '}';
    }
}

