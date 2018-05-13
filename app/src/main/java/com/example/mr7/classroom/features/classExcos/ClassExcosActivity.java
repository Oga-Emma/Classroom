package com.example.mr7.classroom.features.classExcos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mr7.classroom.R;

public class ClassExcosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_excos_activity);

        getSupportFragmentManager().beginTransaction()
        .replace(R.id.class_excos_container, new ClassExcosFragment())
                .commit();

    }
}
