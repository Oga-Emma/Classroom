package com.example.mr7.classroom.features.classExcos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mr7.classroom.R;

public class ClassExcosAdapter extends RecyclerView.Adapter<ClassExcosAdapter.ClassExcosHolder>{

    @NonNull
    @Override
    public ClassExcosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.classroom_class_excos_rv_item, parent, false);


        return new ClassExcosHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassExcosHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ClassExcosHolder extends RecyclerView.ViewHolder{

        public ClassExcosHolder(View itemView) {
            super(itemView);
        }
    }
}
