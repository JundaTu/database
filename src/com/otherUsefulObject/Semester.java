package com.otherUsefulObject;

import com.Enum.Quarters;

/**
 * @program database
 * @description: TODO:
 * @author: tujunda
 * @create: 2018/11/20 14:10
 */
public class Semester {
    private int year;
    private String quarter;

    public Semester(String year, String quater) {
        this.year = Integer.parseInt(year);
        int tmpQuarter = Integer.parseInt(quater);
        if (tmpQuarter >= 9 && tmpQuarter <= 12) {
            this.quarter = Quarters.FALL.getQuater();
        } else if (tmpQuarter >= 1 && tmpQuarter <= 3) {
            this.quarter = Quarters.WINTER.getQuater();
        } else if (tmpQuarter >= 4 && tmpQuarter <= 7) {
            this.quarter = Quarters.SPRING.getQuater();
        } else {
            this.quarter = Quarters.SUMMER.getQuater();
        }
    }

    public Semester nextQuarter(){
        Semester nextSemester = new Semester();
        if (quarter == Quarters.FALL.getQuater()) {
            nextSemester.setYear(this.getYear() + 1);
            nextSemester.setQuater(Quarters.WINTER.getQuater());
        } else {
            nextSemester.setYear(this.getYear());
            switch (this.getQuater()) {
                case "Q2":
                    nextSemester.setQuater(Quarters.SPRING.getQuater());
                    break;
                case "Q3":
                    nextSemester.setQuater(Quarters.SUMMER.getQuater());
                    break;
                case "Q4":
                    nextSemester.setQuater(Quarters.FALL.getQuater());
                    break;
                default:
                    break;
            }
        }
        return nextSemester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getQuater() {
        return quarter;
    }

    public Semester() {
    }

    public void setQuater(String quater) {
        this.quarter = quater;
    }
}

