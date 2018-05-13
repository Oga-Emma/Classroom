package com.example.mr7.classroom.features;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mr7.classroom.R;
import com.example.mr7.classroom.features.classExcos.ClassExcosActivity;
import com.example.mr7.classroom.features.courseInfo.CourseInfoActivity;
import com.example.mr7.classroom.features.events.EventsActivity;
import com.example.mr7.classroom.features.faq.FAQActivity;
import com.example.mr7.classroom.features.forum.ForumActivity;
import com.example.mr7.classroom.features.lectures.LectureActivity;
import com.example.mr7.classroom.features.manage.ManageActivity;
import com.example.mr7.classroom.features.message.MessageActivity;
import com.example.mr7.classroom.features.reminder.ReminderActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        setTitle("Classroom");

        findViewById(R.id.lectures_button).setOnClickListener(this::onClick);
        findViewById(R.id.events_button).setOnClickListener(this::onClick);
        findViewById(R.id.excos_button).setOnClickListener(this::onClick);
//        findViewById(R.id.forum_button).setOnClickListener(this::onClick);
        findViewById(R.id.course_info_button).setOnClickListener(this::onClick);
        findViewById(R.id.message_button).setOnClickListener(this::onClick);
//        findViewById(R.id.reminder_button).setOnClickListener(this::onClick);
        findViewById(R.id.faq_button).setOnClickListener(this::onClick);
//        findViewById(R.id.manage_button).setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lectures_button:
                startActivity(new Intent(this, LectureActivity.class));
                break;

            case R.id.events_button:
//                GenericActivity.launchActivity(this, GenericActivity.FRAGMENT_TO_LOAD.EVENTS);
                startActivity(new Intent(this, EventsActivity.class));
                break;

            case R.id.excos_button:
//                GenericActivity.launchActivity(this, GenericActivity.FRAGMENT_TO_LOAD.EXCOS);
                startActivity(new Intent(this, ClassExcosActivity.class));
                break;

/*            case R.id.forum_button:
                startActivity(new Intent(this, ForumActivity.class));
                break;*/

            case R.id.course_info_button:
                startActivity(new Intent(this, CourseInfoActivity.class));
                break;

            case R.id.message_button:
                startActivity(new Intent(this, MessageActivity.class));
                break;

/*            case R.id.reminder_button:
                startActivity(new Intent(this, ReminderActivity.class));
                break;*/

            case R.id.faq_button:
                startActivity(new Intent(this, FAQActivity.class));
//
//            case R.id.manage_button:
//                startActivity(new Intent(this, ManageActivity.class));
//                break;
        }
    }
}
