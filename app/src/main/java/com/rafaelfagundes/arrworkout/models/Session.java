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

    // Getter for the stepCount property
    public int getStepCount() {
        return stepCount;
    }

    // Getter for the height property
    public int getHeight() {
        return height;
    }

    // Getter for the weight property
    public int getWeight() {
        return weight;
    }

    // Getter for the caloriesBurned property
    public float getCaloriesBurned() {
        return caloriesBurned;
    }
}