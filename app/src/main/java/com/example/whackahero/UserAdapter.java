package com.example.whackahero;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<User> usersList;

    public UserAdapter(List<User> recipes) {
        usersList = recipes;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder viewholder, int i) {
        final User user = usersList.get(i);
        viewholder.name.setText(user.getName());
        viewholder.score.setText(String.valueOf(user.getScoreMax()));
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView score;
        public View view;

        public ViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.tvPseudo);
            score = v.findViewById(R.id.tvScore);
            view = v;
        }
    }
}
