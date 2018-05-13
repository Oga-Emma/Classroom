package com.example.mr7.classroom.features.message;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mr7.classroom.R;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_activity);
        setTitle("Message");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.message_container, new MessageListFragment())
                .commit();

        if(true){
            FloatingActionButton fab = findViewById(R.id.floatingActionButton);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new MessageCreateEditFragment().show(getSupportFragmentManager(), "EDIT MESSAGE");
                }
            });
        }
    }
}
