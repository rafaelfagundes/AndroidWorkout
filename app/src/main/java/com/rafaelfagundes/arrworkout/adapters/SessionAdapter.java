package com.rafaelfagundes.arrworkout.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rafaelfagundes.arrworkout.R;
import com.rafaelfagundes.arrworkout.databinding.ActivitySessionItemBinding;
import com.rafaelfagundes.arrworkout.models.Session;

import java.util.List;

public class SessionAdapter extends RecyclerView.Adapter<SessionAdapter.SessionViewHolder> {

    private final List<Session> sessions;

    public SessionAdapter(List<Session> sessions) {
        this.sessions = sessions;
    }

    @NonNull
    @Override
    public SessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ActivitySessionItemBinding binding = ActivitySessionItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new SessionViewHolder(binding);
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
        private final ActivitySessionItemBinding binding;

        public SessionViewHolder(ActivitySessionItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Session session) {
            Context context = binding.getRoot().getContext();
            binding.textViewStepCount.setText(context.getString(R.string.step_count_label, session.getStepCount()));
            binding.textViewHeight.setText(context.getString(R.string.height_label, session.getHeight()));
            binding.textViewWeight.setText(context.getString(R.string.weight_label, session.getWeight()));
            binding.textViewCaloriesBurned.setText(context.getString(R.string.calories_burned_label, session.getCaloriesBurned()));
        }
    }
}