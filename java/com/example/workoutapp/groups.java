package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class groups extends AppCompatActivity implements View.OnClickListener{

    Boolean[] workout = {false,false,false,false,false,false};

    int chestIndex = 0;
    int backIndex = 1;
    int bicepsIndex = 2;
    int tricepsIndex = 3;
    int shouldersIndex = 4;
    int legsIndex = 5;


    CheckBox muscleCheckBox[] = new CheckBox[6];

    Button nextButtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);

        muscleCheckBox[chestIndex] = findViewById(R.id.chestCheckBox);
        muscleCheckBox[backIndex] = findViewById(R.id.backCheckBox);
        muscleCheckBox[bicepsIndex] = findViewById(R.id.biCheckBox);
        muscleCheckBox[tricepsIndex] = findViewById(R.id.triCheckBox);
        muscleCheckBox[shouldersIndex] = findViewById(R.id.shoulderCheckBox);
        muscleCheckBox[legsIndex] = findViewById(R.id.legCheckBox);

        nextButtn = findViewById(R.id.nextButton);
        nextButtn.setOnClickListener(this);

        for (int i=0;i<6;i++){
            muscleCheckBox[i].setOnClickListener(this);
        }

    }

    public void goExercises(){
        Intent intent = new Intent(this, exercises.class);
        intent.putExtra("workout",workout);
        startActivity(intent);
    }

    public void enableNext(){
        nextButtn.setEnabled(false);
        for(int i=0;i<6;i++){
            if (workout[i]){
                nextButtn.setEnabled(true);
            }
        }
    }
//        Toast.makeText(this,Boolean.toString(workout[0]),Toast.LENGTH_SHORT).show();
//        Toast.makeText(this,Boolean.toString(workout[chestIndex]),Toast.LENGTH_SHORT).show();


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.chestCheckBox:
                workout[chestIndex] = muscleCheckBox[chestIndex].isChecked();
                enableNext();
                break;

            case R.id.backCheckBox:
                workout[backIndex] = muscleCheckBox[backIndex].isChecked();
                enableNext();
                break;

            case R.id.biCheckBox:
                workout[bicepsIndex] = muscleCheckBox[bicepsIndex].isChecked();
                enableNext();
                break;

            case R.id.triCheckBox:
                workout[tricepsIndex] = muscleCheckBox[tricepsIndex].isChecked();
                enableNext();
                break;

            case R.id.shoulderCheckBox:
                workout[shouldersIndex] = muscleCheckBox[shouldersIndex].isChecked();
                enableNext();
                break;

            case R.id.legCheckBox:
                workout[legsIndex] = muscleCheckBox[legsIndex].isChecked();
                enableNext();
                break;

            case R.id.nextButton:
                goExercises();
                break;
        }
    }


}