package com.rafaelfagundes.arrworkout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private int stepCount;
    private int height;
    private int weight;
    private float caloriesBurned;


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
