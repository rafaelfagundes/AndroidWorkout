package com.example.workout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private List<MainActivity3> workoutSessionList;
    private MainActivity3Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        sharedPreferences = getSharedPreferences("WorkoutSessions", Context.MODE_PRIVATE);
        workoutSessionList = retrieveWorkoutSessions();

        RecyclerView recyclerView = findViewById(R.id.recyclerView_workout_sessions);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainActivity3Adapter(workoutSessionList);
        recyclerView.setAdapter(adapter);
    }

    private List<MainActivity3> retrieveWorkoutSessions() {
        List<MainActivity3> sessions = new ArrayList<>();

        int sessionCount = sharedPreferences.getInt("sessionCount", 0);
        for (int i = 0; i < sessionCount; i++) {
            int stepCount = sharedPreferences.getInt("stepCount_" + i, 0);
            int height = sharedPreferences.getInt("height_" + i, 0);
            int weight = sharedPreferences.getInt("weight_" + i, 0);
            float caloriesBurned = sharedPreferences.getFloat("caloriesBurned_" + i, 0);
            sessions.add(new MainActivity3(stepCount, height, weight, caloriesBurned));
        }
        return sessions;
    }
}