package com.rafaelfagundes.arrworkout.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.rafaelfagundes.arrworkout.R;
import com.rafaelfagundes.arrworkout.models.Session;

import java.util.List;

public class SessionAdapter  extends RecyclerView.Adapter<SessionAdapter.SessionViewHolder> {

    private List<Session> sessions;

    public SessionAdapter(List<Session> sessions) {
        this.sessions = sessions;
    }

    @NonNull
    @Override
    public SessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_session_item, parent, false);
        return new SessionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SessionViewHolder holder, int position) {
        Session session = sessions.get(position);
        holder.bind(session);
    }

    @Override
    public int getItemCount() {
        return sessions.size();
    }

    public static class SessionViewHolder extends RecyclerView.ViewHolder {
        private TextView stepCountTextView;
        private TextView heightTextView;
        private TextView weightTextView;
        private TextView caloriesBurnedTextView;

        public SessionViewHolder(@NonNull View itemView) {
            super(itemView);
            stepCountTextView = itemView.findViewById(R.id.textView_step_count);
            heightTextView = itemView.findViewById(R.id.textView_height);
            weightTextView = itemView.findViewById(R.id.textView_weight);
            caloriesBurnedTextView = itemView.findViewById(R.id.textView_calories_burned);
        }

        public void bind(Session session) {
            stepCountTextView.setText("Steps: " + session.getStepCount());
            heightTextView.setText("Height: " + session.getHeight());
            weightTextView.setText("Weight: " + session.getWeight());
            caloriesBurnedTextView.setText("Calories Burned: " + session.getCaloriesBurned());
        }
    }
}

