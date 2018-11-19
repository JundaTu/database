package com.po;

import java.util.Date;

/**
 * @program database
 * @description: TODO:
 * @author: tujunda
 * @create: 2018/11/18 21:14
 */
public class RequiresPO {
    private String UoSCode;
    private String prereqUoSCode;
    private Date EnforcedSince;

    public String getUoSCode() {
        return UoSCode;
    }

    public void setUoSCode(String uoSCode) {
        UoSCode = uoSCode;
    }

    public String getPrereqUoSCode() {
        return prereqUoSCode;
    }

    public void setPrereqUoSCode(String prereqUoSCode) {
        this.prereqUoSCode = prereqUoSCode;
    }

    public Date getEnforcedSince() {
        return EnforcedSince;
    }

    public void setEnforcedSince(Date enforcedSince) {
        EnforcedSince = enforcedSince;
    }

    @Override
    public String toString() {
        return "RequiresPO{" +
                "UoSCode='" + UoSCode + '\'' +
                ", prereqUoSCode='" + prereqUoSCode + '\'' +
                ", EnforcedSince=" + EnforcedSince +
                '}';
    }
}

