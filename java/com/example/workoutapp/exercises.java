package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

public class exercises extends AppCompatActivity {

    Intent intent;
    boolean[] workout = {};
    ImageButton exerciseGifs[] = new ImageButton[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        exerciseGifs[0] = findViewById(R.id.exerciseGif1);
        exerciseGifs[1] = findViewById(R.id.exerciseGif2);
        exerciseGifs[2] = findViewById(R.id.exerciseGif3);
        exerciseGifs[3] = findViewById(R.id.exerciseGif4);
        exerciseGifs[4] = findViewById(R.id.exerciseGif5);
        exerciseGifs[5] = findViewById(R.id.exerciseGif6);

        intent = getIntent();
//        workout = intent.getBooleanArrayExtra("workout");
        randomizeWorkout();

    }

    public void randomizeWorkout(){
        int resID;
        for(int i=0;i<6;i++) {
            resID = getResources().getIdentifier("arms", "drawable", "com.example.workoutapp");
            exerciseGifs[i].setImageResource(resID);
        }
    }
}