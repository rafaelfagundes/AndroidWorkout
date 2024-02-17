package com.rafaelfagundes.arrworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private EditText heightEditText, weightEditText;
    private SeekBar stepCountSeekBar;
    private TextView stepCountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("WorkoutSessions", Context.MODE_PRIVATE);

        heightEditText = ((TextInputLayout)findViewById(R.id.editText_height)).getEditText();
        weightEditText = ((TextInputLayout)findViewById(R.id.editText_weight)).getEditText();

        heightEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                int height = Integer.parseInt(heightEditText.getText().toString());
                editor.putInt("height", height);
                editor.apply();
                hideKeyboard();
                return true;
            }
            return false;
        });

        weightEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                int weight = Integer.parseInt(weightEditText.getText().toString());
                editor.putInt("weight", weight);
                editor.apply();
                hideKeyboard();
                return true;
            }
            return false;
        });

        stepCountSeekBar = findViewById(R.id.seekBar);
        stepCountTextView = findViewById(R.id.textView2);

        stepCountSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                stepCountTextView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        Button addSessionButton = findViewById(R.id.button);
        addSessionButton.setOnClickListener(view -> addWorkoutSession());
    }

    private void addWorkoutSession() {
        int stepCount = stepCountSeekBar.getProgress();
        int height = Integer.parseInt(heightEditText.getText().toString());
        int weight = Integer.parseInt(weightEditText.getText().toString());

        // Calculate stride
        double stride = height * 0.414;

        // Calculate distance
        double distance = stride * stepCount;

        // Calculate speed based on step count
        double speed;
        if (stepCount <= 79) {
            speed = 0.9;
        } else if (stepCount <= 99) {
            speed = 1.34;
        } else {
            speed = 1.79;
        }

        // Calculate walking time
        double time = distance / speed;

        // Calculate calories burned
        double calories = time * 3.5 * weight / (200 * 60);

        // Save session details
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("stepCount", stepCount);
        editor.putInt("height", height);
        editor.putInt("weight", weight);
        editor.putFloat("caloriesBurned", (float) calories);
        editor.apply();

        // Start new activity or perform necessary actions
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

            // Update the TextInputEditText fields
            heightEditText.setText(String.valueOf(sharedPreferences.getInt("height", 0)));
            weightEditText.setText(String.valueOf(sharedPreferences.getInt("weight", 0)));
        }
    }
}