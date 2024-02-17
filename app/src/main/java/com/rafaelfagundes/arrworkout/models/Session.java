package com.rafaelfagundes.arrworkout.models;

public class Session {

    // The number of steps taken in the session
    private final int stepCount;
    // The height of the user
    private final int height;
    // The weight of the user
    private final int weight;
    // The number of calories burned in the session
    private final float caloriesBurned;

    // Constructor for the Session class
    public Session(int stepCount, int height, int weight, float caloriesBurned) {
        this.stepCount = stepCount;
        this.height = height;
        this.weight = weight;
        this.caloriesBurned = caloriesBurned;
    }

    // Getters
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