package com.rafaelfagundes.arrworkout;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.rafaelfagundes.arrworkout.adapters.SessionAdapter;
import com.rafaelfagundes.arrworkout.models.Session;

import java.util.ArrayList;
import java.util.List;

public class SessionsListActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private List<Session> workoutSessionList;
    private SessionAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_list);

        sharedPreferences = getSharedPreferences("WorkoutSessions", Context.MODE_PRIVATE);
        workoutSessionList = retrieveWorkoutSessions();

        RecyclerView recyclerView = findViewById(R.id.recyclerView_workout_sessions);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SessionAdapter(workoutSessionList);
        recyclerView.setAdapter(adapter);
    }

    private List<Session> retrieveWorkoutSessions() {
        List<Session> sessions = new ArrayList<>();

        int sessionCount = sharedPreferences.getInt("sessionCount", 0);
        for (int i = 0; i < sessionCount; i++) {
            int stepCount = sharedPreferences.getInt("stepCount_" + i, 0);
            int height = sharedPreferences.getInt("height_" + i, 0);
            int weight = sharedPreferences.getInt("weight_" + i, 0);
            float caloriesBurned = sharedPreferences.getFloat("caloriesBurned_" + i, 0);
            sessions.add(new Session(stepCount, height, weight, caloriesBurned));
        }
        return sessions;
    }
}