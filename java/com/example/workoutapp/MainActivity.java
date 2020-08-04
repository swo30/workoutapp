package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Boolean[] workout = {false,false,false,false,false,false};


    Button FullBodyButtn;
    Button PushButtn;
    Button PullButtn;
    Button CustomButtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FullBodyButtn = findViewById(R.id.fullbody);
        PushButtn = findViewById(R.id.push);
        PullButtn = findViewById(R.id.pull);
        CustomButtn = findViewById(R.id.custom);


        FullBodyButtn.setOnClickListener(this);
        PushButtn.setOnClickListener(this);
        PullButtn.setOnClickListener(this);
        CustomButtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.fullbody:
                for (int i=0;i<6;i++) {
                    workout[i] = true;
                }
                goExercises();
                break;

            case R.id.push:
                workout[0] = true;
                workout[3] = true;
                workout[4] = true;
                goExercises();
                break;
            case R.id.pull:
                workout[1] = true;
                workout[2] = true;
                goExercises();
                break;

            case R.id.custom:
                goGroups();
                break;
        }
    }

    public void goGroups(){
        Intent intent = new Intent(this, groups.class);
        startActivity(intent);
    }

    public void goExercises(){
        Intent intent = new Intent(this, exercises.class);
        intent.putExtra("workout",workout);
        startActivity(intent);
    }
}