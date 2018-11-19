package com.po;

/**
 * @program database
 * @description: TODO: classroom
 * @author: tujunda
 * @create: 2018/11/17 15:57
 */
public class ClassroomPO {
    private String classrommId;
    private int seats;
    private String type;

    public String getClassrommId() {
        return classrommId;
    }

    public void setClassrommId(String classrommId) {
        this.classrommId = classrommId;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ClassroomPO{" +
                "classrommId='" + classrommId + '\'' +
                ", seats=" + seats +
                ", type='" + type + '\'' +
                '}';
    }
}

