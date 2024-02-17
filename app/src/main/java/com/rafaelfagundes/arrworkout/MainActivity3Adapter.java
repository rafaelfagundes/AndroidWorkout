package com.rafaelfagundes.arrworkout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity3Adapter  extends RecyclerView.Adapter<MainActivity3Adapter.MainActivity3ViewHolder> {

    private List<MainActivity3> sessions;

    public MainActivity3Adapter(List<MainActivity3> sessions) {
        this.sessions = sessions;
    }

    @NonNull
    @Override
    public MainActivity3ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main3, parent, false);
        return new MainActivity3ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainActivity3ViewHolder holder, int position) {
        MainActivity3 session = sessions.get(position);
        holder.bind(session);
    }

    @Override
    public int getItemCount() {
        return sessions.size();
    }

    public static class MainActivity3ViewHolder extends RecyclerView.ViewHolder {
        private TextView stepCountTextView;
        private TextView heightTextView;
        private TextView weightTextView;
        private TextView caloriesBurnedTextView;

        public MainActivity3ViewHolder(@NonNull View itemView) {
            super(itemView);
            stepCountTextView = itemView.findViewById(R.id.textView_step_count);
            heightTextView = itemView.findViewById(R.id.textView_height);
            weightTextView = itemView.findViewById(R.id.textView_weight);
            caloriesBurnedTextView = itemView.findViewById(R.id.textView_calories_burned);
        }

        public void bind(MainActivity3 session) {
            stepCountTextView.setText(String.valueOf(session.getStepCount()));
            heightTextView.setText(String.valueOf(session.getHeight()));
            weightTextView.setText(String.valueOf(session.getWeight()));
            caloriesBurnedTextView.setText(String.valueOf(session.getCaloriesBurned()));
        }
    }
}

