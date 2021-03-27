package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class exercises extends AppCompatActivity implements View.OnClickListener {

    String[] exerciseString = new String[6];
    boolean[] muscle_group_bool = new boolean[6];
    ImageButton[] exerciseGifs = new ImageButton[6];
//    BiHashMap<String,String,String> exercise_key2 = new BiHashMap<String,String,String>();


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

        for (ImageButton exerciseGif : exerciseGifs) {
            exerciseGif.setOnClickListener(this);
        }

        String[] workoutStr;
        Intent intent = getIntent();
        workoutStr = intent.getStringArrayExtra("muscle_group_bool");
        for (int i = 0; i < workoutStr.length; i++) {
            muscle_group_bool[i] = Boolean.parseBoolean(workoutStr[i]);
        }
        customWorkout();
    }

    public void customWorkout() {

        String[] muscleGroups = new String[]{"chest", "back", "bis", "tris", "shoulders", "legs"};
        ArrayList<String> checked_muscle_groups = new ArrayList<>();
        List<Exercise> exercises = new ArrayList<>();

        for (int i = 0; i < muscleGroups.length; i++) {
            if (muscle_group_bool[i]) {
                checked_muscle_groups.add(muscleGroups[i]);
//                exercises = FileManager.exercises_map.get(muscleGroups[i]);
            }
        }


        int index = 0;
        int resID;
        for (String muscle_group : checked_muscle_groups) {
            Collections.shuffle(FileManager.exercises_map.get(muscle_group));
        }

        for (int i = 0; i < 6; i++) {
            if (i!=0 && i%checked_muscle_groups.size() == 0) {
                index++;
            }
            exercises.add(FileManager.exercises_map.get(checked_muscle_groups.get(i % checked_muscle_groups.size())).get(index));
        }
        for (int i = 0; i < 6; i++) {
            resID = getResources().getIdentifier(exercises.get(i).image_name, "drawable", "com.example.workoutapp");
            exerciseGifs[i].setImageResource(resID);
            exerciseString[i] = exercises.get(i).image_name;
        }
    }

    public void goExercisesInfo(String exercise) {
        Intent intent = new Intent(this, exercises_info.class);
        intent.putExtra("exercise", exercise);
        this.startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        String deez;
        switch (view.getId()) {
            case R.id.exerciseGif1:
                deez = readFromFile(getApplicationContext());
                goExercisesInfo(exerciseString[0]);
                break;

            case R.id.exerciseGif2:
                deez = readFromFile(getApplicationContext());
                goExercisesInfo(exerciseString[1]);
                break;

            case R.id.exerciseGif3:
                deez = readFromFile(getApplicationContext());
                goExercisesInfo(exerciseString[2]);
                break;

            case R.id.exerciseGif4:
                deez = readFromFile(getApplicationContext());
                goExercisesInfo(exerciseString[3]);
                break;

            case R.id.exerciseGif5:
                deez = readFromFile(getApplicationContext());
                goExercisesInfo(exerciseString[4]);
                break;

            case R.id.exerciseGif6:
                deez = readFromFile(getApplicationContext());
                goExercisesInfo(exerciseString[5]);
                break;
        }
    }

    public static void print(String str) {
        System.out.println(str);
    }

    private String readFromFile(Context context) {
        String ret = "";
        try {
            InputStream inputStream = context.openFileInput("config.txt");

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append("\n").append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }
}