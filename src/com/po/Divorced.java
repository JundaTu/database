package com.po;


import java.util.Date;

/**
 * @program database
 * @description: TODO: data to object
 * @author: tujunda
 * @create: 2018/11/12 16:33
 */
public class Divorced {
    private int coupleNum;
    private Date date;

    public void setCoupleNum(int coupleNum) {
        this.coupleNum = coupleNum;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCoupleNum() {
        return coupleNum;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Divorced{" +
                "coupleNum=" + coupleNum +
                ", date=" + date +
                '}';
    }
}

