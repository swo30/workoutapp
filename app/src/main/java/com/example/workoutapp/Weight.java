package com.example.workoutapp;

import java.util.Date;

public class Weight {
    public double value;
    public String unit;
    public int set;
    public String date;

    public String to_string() {
        return date + " " + value;
    }

    public Weight (double value, String unit, int set, String date){
        this.value = value;
        this.unit = unit;
        this.set = set;
        this.date = date;
    }
}
