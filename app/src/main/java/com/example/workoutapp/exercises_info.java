package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Hashtable;

public class exercises_info extends AppCompatActivity implements View.OnClickListener {
    EditText weight_text;
    TextView history_weight;
    String current_exercise;
    String str_key;
    Exercise current_exercise_obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_info);

        Intent intent = getIntent();
        ImageView exercise_gif;
        exercise_gif = findViewById(R.id.exercise_gif);
        current_exercise = intent.getStringExtra("exercise");
        str_key = current_exercise.substring(0,current_exercise.length() - 1);
        current_exercise_obj = FileManager.exercises_map.get(str_key).get(Integer.parseInt(current_exercise.substring(current_exercise.length() - 1,current_exercise.length())));

        System.out.println("PRINTINTG THE HISTROY ESTI ");
        for(Weight weight: current_exercise_obj.weight_history){
            System.out.println(weight.value);
        }

        int resID = getResources().getIdentifier(current_exercise, "drawable", "com.example.workoutapp");
        exercise_gif.setImageResource(resID);

        Button save_button = findViewById(R.id.save_button);
        weight_text = findViewById(R.id.weight_id);
        history_weight = findViewById(R.id.history_weight);
        weight_text.setOnClickListener(this);
        save_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        current_exercise_obj.add_new_weight(Integer.parseInt(weight_text.getText().toString()), "lbs",1);
        history_weight.setText(weight_text.getText().toString());
//        writeToFile(current_weight, getApplicationContext());
//        history_weight.setText(readFromFile(getApplicationContext()));
    }

    private void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("history.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String readFromFile(Context context) {
        String ret = "";
        try {
            InputStream inputStream = context.openFileInput("history.txt");

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

}