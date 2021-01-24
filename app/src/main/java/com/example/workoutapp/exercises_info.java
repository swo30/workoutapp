package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

public class exercises_info extends AppCompatActivity implements View.OnClickListener {
    EditText weight_text;
    EditText history_weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_info);

        String current_exercise;
        Intent intent = getIntent();
        ImageView exercise_gif;
        exercise_gif = findViewById(R.id.exercise_gif);

        current_exercise = intent.getStringExtra("exercise");

        int resID = getResources().getIdentifier(current_exercise, "drawable", "com.example.workoutapp");
        exercise_gif.setImageResource(resID);

        Button save_button = findViewById(R.id.save_button);
        weight_text = findViewById(R.id.weight_id);
        history_weight = findViewById(R.id.history_weight);
        history_weight.setText(readFromFile(getApplicationContext()));
        weight_text.setOnClickListener(this);
        save_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String current_weight;
        switch (view.getId()) {
            case R.id.weight_id:
//                Toast.makeText(this,"shouldnt see this ever", Toast.LENGTH_SHORT).show();
                break;

            case R.id.save_button:
                current_weight = weight_text.getText().toString();
                writeToFile(current_weight, getApplicationContext());

                history_weight.setText(readFromFile(getApplicationContext()));
                Toast.makeText(this,current_weight, Toast.LENGTH_SHORT).show();
                break;

        }
    }

    private void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
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

}