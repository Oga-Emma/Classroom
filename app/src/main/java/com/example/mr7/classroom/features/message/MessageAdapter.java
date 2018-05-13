package com.example.mr7.classroom.features.message;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mr7.classroom.R;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder>{

    Context context;

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        this.context = parent.getContext();

        return new MessageHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {

        holder.bindView();
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MessageHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        LinearLayout editLayout;

        public MessageHolder(View itemView) {
            super(itemView);

            itemView.findViewById(R.id.card_view).setOnClickListener(this::onClick);
            editLayout = itemView.findViewById(R.id.edit_layout);
//            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            new MessageDetailFragment().show(((AppCompatActivity) context)
                    .getSupportFragmentManager(), "MESSAGE_DETAILS");
        }

        public void bindView() {
            if(true)
                editLayout.setVisibility(View.VISIBLE);
        }
    }
}
