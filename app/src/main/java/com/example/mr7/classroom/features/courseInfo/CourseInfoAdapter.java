package com.example.mr7.classroom.features.courseInfo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mr7.classroom.R;

public class CourseInfoAdapter extends RecyclerView.Adapter<CourseInfoAdapter.CourseInfoHolder> {


    @NonNull
    @Override
    public CourseInfoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CourseInfoHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_info_rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CourseInfoHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class CourseInfoHolder extends RecyclerView.ViewHolder{

        public CourseInfoHolder(View itemView) {
            super(itemView);
        }
    }
}
