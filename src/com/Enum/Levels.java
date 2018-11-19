package com.Enum;

public enum Levels {
    LOGIN(1), STUDENT_MENU(2),
    TRANSCRIPT(3), ENROLL(4),
    WITHDRAW(5), PERSONAL(6),
    DETAIL(7),     LOGOUT(8);

    private int index;

    Levels(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
