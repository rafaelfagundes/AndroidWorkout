package com.rafaelfagundes.arrworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.SeekBar;

import com.rafaelfagundes.arrworkout.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("WorkoutSessions", Context.MODE_PRIVATE);

        binding.editTextHeight.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                int height = Integer.parseInt(binding.editTextHeight.getText().toString());
                editor.putInt("height", height);
                editor.apply();
                hideKeyboard();
                return true;
            }
            return false;
        });

        binding.editTextWeight.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                int weight = Integer.parseInt(binding.editTextWeight.getText().toString());
                editor.putInt("weight", weight);
                editor.apply();
                hideKeyboard();
                return true;
            }
            return false;
        });


        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.textView2.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        binding.button.setOnClickListener(view -> addWorkoutSession());
    }

    private void addWorkoutSession() {
        int stepCount = binding.seekBar.getProgress();
        int height = Integer.parseInt(binding.editTextHeight.getText().toString());
        int weight = Integer.parseInt(binding.editTextWeight.getText().toString());

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

        // Start new activity or perform necessary actions
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private class OnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            binding.textView2.setText(String.valueOf(progress));

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {


        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
}