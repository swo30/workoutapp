package com.example.workoutapp;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class FileManager extends AppCompatActivity {
    public static HashMap<String, List <Exercise>> exercises_map;
    static SharedPreferences  mPrefs;

        public static void set_preferences(Context context){
            mPrefs = context.getSharedPreferences("prep", MODE_PRIVATE);
        }

        public static void generate_map(){
            exercises_map = new HashMap<>();

            exercises_map.put("chest", new ArrayList<Exercise>());
            exercises_map.put("back", new ArrayList<Exercise>());
            exercises_map.put("bis", new ArrayList<Exercise>());
            exercises_map.put("tris", new ArrayList<Exercise>());
            exercises_map.put("shoulders", new ArrayList<Exercise>());
            exercises_map.put("legs", new ArrayList<Exercise>());
            exercises_map.put("core", new ArrayList<Exercise>());

            exercises_map.get("chest").add(new Exercise("chest1", "chest1"));
            exercises_map.get("chest").add(new Exercise("chest2", "chest2"));
            exercises_map.get("chest").add(new Exercise("chest3", "chest3"));
            exercises_map.get("chest").add(new Exercise("chest4", "chest4"));
            exercises_map.get("chest").add(new Exercise("chest5", "chest5"));
            exercises_map.get("chest").add(new Exercise("chest6", "chest6"));

            exercises_map.get("back").add(new Exercise("back1", "back1"));
            exercises_map.get("back").add(new Exercise("back2", "back2"));
            exercises_map.get("back").add(new Exercise("back3", "back3"));
            exercises_map.get("back").add(new Exercise("back4", "back4"));
            exercises_map.get("back").add(new Exercise("back5", "back5"));
            exercises_map.get("back").add(new Exercise("back6", "back6"));
            exercises_map.get("back").add(new Exercise("back7", "back7"));
            exercises_map.get("back").add(new Exercise("back8", "back8"));

            exercises_map.get("bis").add(new Exercise("bis1", "bis1"));
            exercises_map.get("bis").add(new Exercise("bis2", "bis2"));
            exercises_map.get("bis").add(new Exercise("bis3", "bis3"));
            exercises_map.get("bis").add(new Exercise("bis4", "bis4"));
            exercises_map.get("bis").add(new Exercise("bis5", "bis5"));
            exercises_map.get("bis").add(new Exercise("bis6", "bis6"));

            exercises_map.get("tris").add(new Exercise("tris1", "tris1"));
            exercises_map.get("tris").add(new Exercise("tris2", "tris2"));
            exercises_map.get("tris").add(new Exercise("tris3", "tris3"));
            exercises_map.get("tris").add(new Exercise("tris4", "tris4"));
            exercises_map.get("tris").add(new Exercise("tris5", "tris5"));
            exercises_map.get("tris").add(new Exercise("tris6", "tris6"));

            exercises_map.get("shoulders").add(new Exercise("shoulders1", "shoulders1"));
            exercises_map.get("shoulders").add(new Exercise("shoulders2", "shoulders2"));
            exercises_map.get("shoulders").add(new Exercise("shoulders3", "shoulders3"));
            exercises_map.get("shoulders").add(new Exercise("shoulders4", "shoulders4"));
            exercises_map.get("shoulders").add(new Exercise("shoulders5", "shoulders5"));
            exercises_map.get("shoulders").add(new Exercise("shoulders6", "shoulders6"));
            exercises_map.get("shoulders").add(new Exercise("shoulders7", "shoulders7"));

            exercises_map.get("legs").add(new Exercise("legs1", "legs1"));
            exercises_map.get("legs").add(new Exercise("legs2", "legs2"));
            exercises_map.get("legs").add(new Exercise("legs3", "legs3"));
            exercises_map.get("legs").add(new Exercise("legs4", "legs4"));
            exercises_map.get("legs").add(new Exercise("legs5", "legs5"));
            exercises_map.get("legs").add(new Exercise("legs6", "legs6"));
            exercises_map.get("legs").add(new Exercise("legs7", "legs7"));

            exercises_map.get("core").add(new Exercise("core1", "core1"));
            exercises_map.get("core").add(new Exercise("core2", "core2"));
            exercises_map.get("core").add(new Exercise("core3", "core3"));
            exercises_map.get("core").add(new Exercise("core4", "core4"));
            exercises_map.get("core").add(new Exercise("core5", "core5"));
            exercises_map.get("core").add(new Exercise("core6", "core6"));
            exercises_map.get("core").add(new Exercise("core7", "core7"));
            exercises_map.get("core").add(new Exercise("core8", "core8"));
            exercises_map.get("core").add(new Exercise("core9", "core9"));
            exercises_map.get("core").add(new Exercise("core10", "core10"));
            exercises_map.get("core").add(new Exercise("core11", "core11"));
            exercises_map.get("core").add(new Exercise("core12", "core12"));
            exercises_map.get("core").add(new Exercise("core13", "core13"));
            exercises_map.get("core").add(new Exercise("core14", "core14"));

        }

        public static void map_creation(){
//            if (!retrieve()){
                generate_map();
//            }
        }

    public static void save() {
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(exercises_map);
        prefsEditor.putString("SerializableObject", json);
        prefsEditor.commit();
    }

    public static boolean retrieve(){
        Gson gson = new Gson();
        String json = mPrefs.getString("SerializableObject", "");
        if (json == ""){
            return false;
        }
        System.out.println("JSON ASDJHASKJDHAFDJHGBDUJKFFHB;AKL");
        System.out.println(json);
        Type map_type = new TypeToken<HashMap<String, List <Exercise>>>(){}.getType(); //black magic
        exercises_map = gson.fromJson(json, map_type);
        return true;
    }
}
