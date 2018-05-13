package com.example.mr7.classroom.features.events;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mr7.classroom.R;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_activity);

        FloatingActionButton addEventFAB = findViewById(R.id.add_event_FAB);
        addEventFAB.setOnClickListener( (view) -> {
            new EventCreateEditFragment().show(getSupportFragmentManager(), "NEW EVENT");
        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.events_container, new EventFragment())
                .commit();
    }
}
