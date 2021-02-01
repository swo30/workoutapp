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

            exercises_map.get("legs").add(new Exercise("legs1", "legs1"));
            exercises_map.get("legs").add(new Exercise("legs2", "legs2"));
            exercises_map.get("legs").add(new Exercise("legs3", "legs3"));
            exercises_map.get("legs").add(new Exercise("legs4", "legs4"));
            exercises_map.get("legs").add(new Exercise("legs5", "legs5"));
            exercises_map.get("legs").add(new Exercise("legs6", "legs6"));

        }

}
