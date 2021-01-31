package com.example.workoutapp;

import java.util.Date;

public class Weight {
    public double value;
    public String unit;
    public int set;
    public Date date;

    public Weight (double value, String unit, int set, Date date){
        this.value = value;
        this.unit = unit;
        this.set = set;
        this.date = date;
    }
}
