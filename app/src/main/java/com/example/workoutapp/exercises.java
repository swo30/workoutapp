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
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class exercises extends AppCompatActivity implements View.OnClickListener{

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

//        exercise_key.put("chest"    ,"0");
//        exercise_key.put("back"     ,"1");
//        exercise_key.put("biceps"   ,"2");
//        exercise_key.put("triceps"  ,"3");
//        exercise_key.put("shoulders","4");
//        exercise_key.put("legs"     ,"5");

        for (ImageButton exerciseGif : exerciseGifs) {
            exerciseGif.setOnClickListener(this);
        }

        String[] workoutStr;
        Intent intent = getIntent();
        workoutStr = intent.getStringArrayExtra("muscle_group_bool");
        for(int i=0;i<workoutStr.length;i++){
            muscle_group_bool[i] = Boolean.parseBoolean(workoutStr[i]);
        }
        customWorkout();
    }

    public void customWorkout(){

        String[] muscleGroups = new String[] {"chest","back","bis","tris","shoulders","legs"};
        List<Exercise> exercises = new ArrayList<>();

        for(int i=0;i<muscleGroups.length;i++){
            if (muscle_group_bool[i]){
//                exercises.add(muscleGroups[i]);
                exercises = FileManager.exercises_map.get(muscleGroups[i]);
            }
        }

        int index; int resID;
        int[] rand = shuffleArray();
        for(int i=0;i<6;i++) {
//            index = i % exercises.size();
//            exerciseString[i] = String.format(exercises.get(index), rand[i]);
            resID = getResources().getIdentifier(exercises.get(i).image_name, "drawable", "com.example.workoutapp");
            exerciseGifs[i].setImageResource(resID);
            exerciseString[i] = exercises.get(i).image_name;
        }
    }

    public void goExercisesInfo(String exercise){
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

    public static void print(String str) {System.out.println(str);}

    public static int[] shuffleArray() {
        int[] array = {1, 2, 3, 4, 5, 6};
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }
        return array;
    }

    private String readFromFile(Context context) {
        String ret = "";
        try {
            InputStream inputStream = context.openFileInput("config.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("\n").append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void pullWorkout(){
        int back = 4; int bis = 6 - back;
        int resID;
        int[] rand = shuffleArray();
        for(int i=1;i<=back;i++) {
            String exerciseString = String.format("back%s",Integer.toString(rand[i-1]));
            resID = getResources().getIdentifier(exerciseString, "drawable", "com.example.workoutapp");
            exerciseGifs[i-1].setImageResource(resID);
        }
        rand = shuffleArray();
        for(int i=back+1;i<=back+bis;i++) {
            String exerciseString = String.format("bis%s",Integer.toString(rand[i-1]));
            resID = getResources().getIdentifier(exerciseString, "drawable", "com.example.workoutapp");
            exerciseGifs[i-1].setImageResource(resID);
        }
    }

    public void pushWorkout(){
        int chest = 4; int tris = 6 - chest;
        int resID;
        int[] rand = shuffleArray();
        for(int i=1;i<=chest;i++) {
            String exerciseString = String.format("chest%s",Integer.toString(rand[i-1]));
            resID = getResources().getIdentifier(exerciseString, "drawable", "com.example.workoutapp");
            exerciseGifs[i-1].setImageResource(resID);
        }
        rand = shuffleArray();
        for(int i=chest+1;i<=chest+tris;i++) {
            String exerciseString = String.format("tris%s",Integer.toString(rand[i-1]));
            resID = getResources().getIdentifier(exerciseString, "drawable", "com.example.workoutapp");
            exerciseGifs[i-1].setImageResource(resID);
        }
    }

    public void fullWorkout(){
        int resID;
        int[] rand = shuffleArray();
        String muscleGroups[] = new String[] {"chest%s","back%s","bis%s","tris%s","shoulders%s","legs%s"};
        for(int i=0;i<muscleGroups.length;i++) {
            String exerciseString = String.format(muscleGroups[i],Integer.toString(rand[i]));
            resID = getResources().getIdentifier(exerciseString, "drawable", "com.example.workoutapp");
            exerciseGifs[i].setImageResource(resID);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



}