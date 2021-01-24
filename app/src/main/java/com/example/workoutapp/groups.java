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

    String[] muscle_group_bool = new String[] {"false", "false", "false", "false", "false", "false"};;

    int chestIndex = 0;
    int backIndex = 1;
    int bicepsIndex = 2;
    int tricepsIndex = 3;
    int shouldersIndex = 4;
    int legsIndex = 5;
    int cardioIndex = 6;


    CheckBox muscleCheckBox[] = new CheckBox[7];

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
        muscleCheckBox[cardioIndex] = findViewById(R.id.cardioCheckBox);

        nextButtn = findViewById(R.id.nextButton);
        nextButtn.setOnClickListener(this);

        for (int i=0;i<=6;i++){
            muscleCheckBox[i].setOnClickListener(this);
        }

    }

    public void goExercises(){
        Intent intent = new Intent(this, exercises.class);
        intent.putExtra("muscle_group_bool",muscle_group_bool);
        startActivity(intent);
    }

    public void enableNext(){
        nextButtn.setEnabled(false);
        for(int i=0;i<6;i++){
            if (muscle_group_bool[i].equals("true")){
                nextButtn.setEnabled(true);
            }
        }
    }
//        Toast.makeText(this,Boolean.toString(muscle_group_bool[0]),Toast.LENGTH_SHORT).show();
//        Toast.makeText(this,Boolean.toString(muscle_group_bool[chestIndex]),Toast.LENGTH_SHORT).show();


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.chestCheckBox:
                muscle_group_bool[chestIndex] = String.valueOf(muscleCheckBox[chestIndex].isChecked());
                enableNext();
                break;

            case R.id.backCheckBox:
                muscle_group_bool[backIndex] = String.valueOf(muscleCheckBox[backIndex].isChecked());
                enableNext();
                break;

            case R.id.biCheckBox:
                muscle_group_bool[bicepsIndex] = String.valueOf(muscleCheckBox[bicepsIndex].isChecked());
                enableNext();
                break;

            case R.id.triCheckBox:
                muscle_group_bool[tricepsIndex] = String.valueOf(muscleCheckBox[tricepsIndex].isChecked());
                enableNext();
                break;

            case R.id.shoulderCheckBox:
                muscle_group_bool[shouldersIndex] = String.valueOf(muscleCheckBox[shouldersIndex].isChecked());
                enableNext();
                break;

            case R.id.legCheckBox:
                muscle_group_bool[legsIndex] = String.valueOf(muscleCheckBox[legsIndex].isChecked());
                enableNext();
                break;

            case R.id.cardioCheckBox:
                muscleCheckBox[cardioIndex].setChecked(false);
                Toast.makeText(this,"Lmao, you ain't doing cardio",Toast.LENGTH_SHORT).show();
                break;

            case R.id.nextButton:
                goExercises();
                break;
        }
    }


}