package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private int stepCount;
    private int height;
    private int weight;
    private float caloriesBurned;

    // Zero-argument constructor
    public MainActivity3() {
        // Default values or initialization if needed
        this.stepCount = 0;
        this.height = 0;
        this.weight = 0;
        this.caloriesBurned = 0.0f;
    }

    public MainActivity3(int stepCount, int height, int weight, float caloriesBurned) {
        this.stepCount = stepCount;
        this.height = height;
        this.weight = weight;
        this.caloriesBurned = caloriesBurned;
    }

    public int getStepCount() {
        return stepCount;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public float getCaloriesBurned() {
        return caloriesBurned;
    }
}
