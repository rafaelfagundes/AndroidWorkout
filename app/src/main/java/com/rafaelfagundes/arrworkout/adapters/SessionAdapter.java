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

    // List of Session objects to be displayed in the RecyclerView
    private final List<Session> sessions;

    // Constructor for the SessionAdapter class
    public SessionAdapter(List<Session> sessions) {
        this.sessions = sessions;
    }

    // Called when RecyclerView needs a new ViewHolder of the given type to represent an item
    @NonNull
    @Override
    public SessionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each list item
        ActivitySessionItemBinding binding = ActivitySessionItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        // Return a new ViewHolder instance
        return new SessionViewHolder(binding);
    }

    // Called by RecyclerView to display the data at the specified position
    @Override
    public void onBindViewHolder(@NonNull SessionViewHolder holder, int position) {
        // Get the Session object at the specified position
        Session session = sessions.get(position);
        // Bind the Session object to the ViewHolder
        holder.bind(session);
    }

    // Returns the total number of items in the data set held by the adapter
    @Override
    public int getItemCount() {
        return sessions.size();
    }

    // ViewHolder describes an item view and metadata about its place within the RecyclerView
    public static class SessionViewHolder extends RecyclerView.ViewHolder {
        // Binding object for the item's view
        private final ActivitySessionItemBinding binding;

        // Constructor for the SessionViewHolder class
        public SessionViewHolder(ActivitySessionItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        // Binds the data from a Session object to the item's view
        public void bind(Session session) {
            // Get the context from the root view
            Context context = binding.getRoot().getContext();
            // Set the text for each TextView in the item's view
            binding.textViewStepCount.setText(context.getString(R.string.step_count_label, session.getStepCount()));
            binding.textViewHeight.setText(context.getString(R.string.height_label, session.getHeight()));
            binding.textViewWeight.setText(context.getString(R.string.weight_label, session.getWeight()));
            binding.textViewCaloriesBurned.setText(context.getString(R.string.calories_burned_label, session.getCaloriesBurned()));
        }
    }
}