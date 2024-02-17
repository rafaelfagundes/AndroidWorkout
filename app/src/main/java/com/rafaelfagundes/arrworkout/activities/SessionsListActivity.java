package com.rafaelfagundes.arrworkout.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.rafaelfagundes.arrworkout.adapters.SessionAdapter;
import com.rafaelfagundes.arrworkout.databinding.ActivitySessionListBinding;
import com.rafaelfagundes.arrworkout.models.Session;

import java.util.ArrayList;
import java.util.List;

public class SessionsListActivity extends AppCompatActivity {
    // Shared preferences to store workout session data
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize view binding
        com.rafaelfagundes.arrworkout.databinding.ActivitySessionListBinding binding = ActivitySessionListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize shared preferences
        sharedPreferences = getSharedPreferences("WorkoutSessions", Context.MODE_PRIVATE);
        // Retrieve the workout sessions from shared preferences
        List<Session> workoutSessionList = retrieveWorkoutSessions();

        // Set up the RecyclerView to display the workout sessions
        binding.recyclerViewWorkoutSessions.setLayoutManager(new LinearLayoutManager(this));
        SessionAdapter adapter = new SessionAdapter(workoutSessionList);
        binding.recyclerViewWorkoutSessions.setAdapter(adapter);
    }

    private List<Session> retrieveWorkoutSessions() {
        // Create a list to store the workout sessions
        List<Session> sessions = new ArrayList<>();

        // Get the number of workout sessions from shared preferences
        int sessionCount = sharedPreferences.getInt("sessionCount", 0);

        // Loop through the workout sessions and add them to the list
        for (int i = 0; i < sessionCount; i++) {
            int stepCount = sharedPreferences.getInt("stepCount_" + i, 0);
            int height = sharedPreferences.getInt("height_" + i, 0);
            int weight = sharedPreferences.getInt("weight_" + i, 0);
            float caloriesBurned = sharedPreferences.getFloat("caloriesBurned_" + i, 0);
            sessions.add(new Session(stepCount, height, weight, caloriesBurned));
        }

        // Return the list of workout sessions
        return sessions;
    }
}