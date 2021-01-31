package com.example.workoutapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileManager {
    public static HashMap<String, List <Exercise>> exercises_map;

        public static void map_creation(){
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
        }

}
