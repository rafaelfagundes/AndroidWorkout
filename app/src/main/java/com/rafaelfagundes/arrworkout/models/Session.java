package com.rafaelfagundes.arrworkout.models;

public class Session {

    private final int stepCount;
    private final int height;
    private final int weight;
    private final float caloriesBurned;


    public Session(int stepCount, int height, int weight, float caloriesBurned) {
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
