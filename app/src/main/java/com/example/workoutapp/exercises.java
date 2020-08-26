package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class exercises extends AppCompatActivity {

    Intent intent;
    String[] workoutStr;
    boolean[] workout = new boolean[6];
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
        workoutStr = intent.getStringArrayExtra("workout");
        for(int i=0;i<workoutStr.length;i++){
            workout[i] = Boolean.parseBoolean(workoutStr[i]);
        }
        customWorkout();
    }

    public void customWorkout(){
        String muscleGroups[] = new String[] {"chest%s","back%s","bis%s","tris%s","shoulders%s","legs%s"};
        ArrayList<String> exercices = new ArrayList<>();

        for(int i=0;i<muscleGroups.length;i++){
            if (workout[i]){
                exercices.add(muscleGroups[i]);
            }
        }
//        for(int i=0;i<exercices.size();i++){
//            System.out.println(exercices.get(i));
//        }
        int index; int resID; String exerciseString;
        int[] rand = shuffleArray();
        for(int i=0;i<6;i++) {
            index = i % exercices.size();
            exerciseString = String.format(exercices.get(index),Integer.toString(rand[i]));
            resID = getResources().getIdentifier(exerciseString, "drawable", "com.example.workoutapp");
            exerciseGifs[i].setImageResource(resID);
        }
    }



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
}