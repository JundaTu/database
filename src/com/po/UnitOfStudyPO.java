package com.po;

/**
 * @program database
 * @description: TODO:
 * @author: tujunda
 * @create: 2018/11/18 21:21
 */
public class UnitOfStudyPO {
    private String UoSCode;
    private String edptId;
    private String UoSName;
    private int credits;

    @Override
    public String toString() {
        return "UnitOfStudyPO{" +
                "UoSCode='" + UoSCode + '\'' +
                ", edptId='" + edptId + '\'' +
                ", UoSName='" + UoSName + '\'' +
                ", credits=" + credits +
                '}';
    }

    public String getUoSCode() {
        return UoSCode;
    }

    public void setUoSCode(String uoSCode) {
        UoSCode = uoSCode;
    }

    public String getEdptId() {
        return edptId;
    }

    public void setEdptId(String edptId) {
        this.edptId = edptId;
    }

    public String getUoSName() {
        return UoSName;
    }

    public void setUoSName(String uoSName) {
        UoSName = uoSName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}

