package com.example.mr7.classroom.features.courseInfo;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mr7.classroom.R;

public class CourseInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_info_activity);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.course_info_container, new CourseInfoFragment())
                .commit();
    }
}
