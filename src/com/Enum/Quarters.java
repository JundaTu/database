package com.Enum;

public enum Quarters {
    FALL("Q1"), WINTER("Q2"), SPRING("Q3"), SUMMER("Q4");

    private String quater;

    Quarters(String quater) {
        this.quater = quater;
    }

    public String getQuater() {
        return quater;
    }

    public void setQuater(String quater) {
        this.quater = quater;
    }
}
