package com.example.mr7.classroom.features.courseInfo;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mr7.classroom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseInfoFragment extends Fragment {


    public CourseInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.course_info_fragment, container, false);


        if(true){
            FloatingActionButton addCourse = view.findViewById(R.id.add_course_FAB);
            addCourse.setOnClickListener( (v) -> {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.course_info_container, new CourseInfoCreateEditFragment())
                        .commit();
            });
        }


        RecyclerView recyclerView = view.findViewById(R.id.course_info_recycler_view);
//        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CourseInfoAdapter());

        return view;
    }

}
