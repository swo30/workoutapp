package com.example.workoutapp;

import java.util.ArrayList;
import java.util.Date;

public class Exercise {
    public String image_name;
    public String exercise_name;
    public ArrayList<Weight> weight_history;

    public Exercise(String image_name, String exercise_name){
        weight_history = new ArrayList<>();
        this.image_name = image_name;
        this.exercise_name = exercise_name;
    }

    public void add_new_weight(double value, String unit, int set){
        weight_history.add(new Weight(value, unit, set, new Date()));
    }

}
