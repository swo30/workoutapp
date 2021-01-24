package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String[] muscle_group_bool = new String[] {"false", "false", "false", "false", "false", "false"};;
    Button FullBodyButtn;
    Button PushButtn;
    Button PullButtn;
    Button CustomButtn;
    CheckBox WarmupCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FullBodyButtn = findViewById(R.id.fullbody);
        PushButtn = findViewById(R.id.push);
        PullButtn = findViewById(R.id.pull);
        CustomButtn = findViewById(R.id.custom);
        WarmupCheckbox = findViewById(R.id.warmupcheckBox);


        FullBodyButtn.setOnClickListener(this);
        PushButtn.setOnClickListener(this);
        PullButtn.setOnClickListener(this);
        CustomButtn.setOnClickListener(this);
        WarmupCheckbox.setOnClickListener(this);

    }

    public void resetWorkout() {
        for (int i=0;i<6;i++) {
            muscle_group_bool[i] = "false";
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fullbody:
                for (int i=0;i<6;i++) {
                    muscle_group_bool[i] = "true";
                }
                goExercises();
                break;

            case R.id.push:
                resetWorkout();
                muscle_group_bool[0] = "true";
                muscle_group_bool[3] = "true";
                muscle_group_bool[4] = "true";
                goExercises();
                break;
            case R.id.pull:
                resetWorkout();
                muscle_group_bool[1] = "true";
                muscle_group_bool[2] = "true";
                goExercises();
                break;

            case R.id.custom:
                goGroups();
                break;

            case R.id.warmupcheckBox:
                Toast.makeText(this,"IDK man, do some bike or someshit",Toast.LENGTH_LONG).show();
                break;
        }
    }

    public void goGroups(){
        Intent intent = new Intent(this, groups.class);
        startActivity(intent);
    }

    public void goExercises(){
        Intent intent = new Intent(this, exercises.class);
        intent.putExtra("muscle_group_bool", muscle_group_bool);
        this.startActivity(intent);
    }
}