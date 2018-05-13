package com.example.mr7.classroom.features.forum;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mr7.classroom.R;

public class ForumRecyclerViewAdapter extends
        RecyclerView.Adapter<ForumRecyclerViewAdapter.ForumRecyclerViewHolder>{


    private Context context;

    @NonNull
    @Override
    public ForumRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        this.context = parent.getContext();

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.forum_recycler_view_adapter, parent, false);
        return new ForumRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForumRecyclerViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 20;
    }

    public class ForumRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ForumRecyclerViewHolder(View itemView) {
            super(itemView);

            itemView.findViewById(R.id.container).setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            context.startActivity(new Intent(context, ForumDiscussionActivity.class));
        }
    }
}
