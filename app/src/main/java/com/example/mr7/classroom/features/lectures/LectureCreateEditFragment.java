package com.example.mr7.classroom.features.lectures;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.mr7.classroom.R;
import com.example.mr7.classroom.model.LectureDTO;
import com.example.mr7.classroom.repository.LectureDAO;
import com.example.mr7.classroom.utils.PickerUtils;

import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import butterknife.Unbinder;
import es.dmoral.toasty.Toasty;

public class LectureCreateEditFragment extends DialogFragment  implements LectureDAO.OnLectureModifiedListener{

    public static final String TAG = LectureCreateEditFragment.class.getSimpleName();

    @BindView(R.id.course_code_edit_text)
    EditText courseCodeET;
    @BindView(R.id.course_title_edit_text)
    EditText courseTitleET;
    @BindView(R.id.lecture_venue_edit_text)
    EditText venueET;
    @BindView(R.id.lecture_start_time_button)
    Button startTimeBtn;
    @BindView(R.id.lecture_end_time_button)
    Button endTimeBtn;
    @BindView(R.id.lecture_day_spinner)
    Spinner day_spinner;
    @BindView(R.id.duration_spinner)
    Spinner duration;

    String courseCode, courseTitle, venue, startTime, endTime;
    int day = 1;
    int dur = 1;
    Unbinder unbinder;


    public LectureCreateEditFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.lecture_create_edit_fragment, null);
        ButterKnife.bind(this, view);
        unbinder = ButterKnife.bind(this, view);

        Spinner duration = (Spinner) view.findViewById(R.id.duration_spinner);
        Spinner day_spinner = (Spinner) view.findViewById(R.id.lecture_day_spinner);

        String[] day = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY"};
        ArrayAdapter<String> days
                = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, day);
        days.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        day_spinner.setAdapter(days);

        Integer[] hours = new Integer[]{1, 2, 3, 4};
        //getContext().getResources().getIntArray(R.array.hours);
        ArrayAdapter<Integer> dataAdapter
                = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, hours);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        duration.setAdapter(dataAdapter);


        Dialog dialog = new AlertDialog.Builder(getContext()).setView(view)
                .setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("CANCEL", null)
                .create();

        return dialog;

    }

    @OnClick({R.id.lecture_start_time_button, R.id.lecture_end_time_button})
    public void setTime(View v) {

        PickerUtils.showTimePcker(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                String time = selectedHour > 12 ? String.format(Locale.getDefault(), "%02d", selectedHour%12)
                        + ":" + String.format(Locale.getDefault(), "%02d", selectedMinute) + " PM"
                        : String.format(Locale.getDefault(), "%02d", selectedHour)
                        + ":" + String.format(Locale.getDefault(), "%02d", selectedMinute) + " AM";

                if (v.getId() == R.id.lecture_start_time_button) {
                    startTimeBtn.setText(time);
                }
                else {
                    endTimeBtn.setText(time);
                }
            }
        });

    }



    @OnItemSelected({R.id.lecture_day_spinner, R.id.duration_spinner})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lecture_day_spinner:
                break;
            case R.id.duration_spinner:
                break;
        }
    }

    private void addLecture() {
        courseCode = courseCodeET.getText().toString();
        courseTitle = courseTitleET.getText().toString();
        venue = venueET.getText().toString();
        startTime = startTimeBtn.getText().toString();
        endTime = endTimeBtn.getText().toString();
        day = day_spinner.getSelectedItemPosition() + 1;
        dur = duration.getSelectedItemPosition() + 1;


        if(courseCode.isEmpty() || courseTitle.isEmpty() || venue.isEmpty()
                || startTime.isEmpty() || endTime.isEmpty())
            Toasty.warning(getContext(), "Some fields are empty, please fill all fields correctly " +
                    "and select lecture start and end time", Toast.LENGTH_SHORT).show();

        else {
            Toasty.info(getContext(), "Saving lecture").show();

            LectureDTO lecture = new LectureDTO();
            lecture.setCourseCode(courseCode);
            lecture.setCourseTitle(courseTitle);
            lecture.setVenue(venue);
            lecture.setTime(startTime + "-" + endTime);
            lecture.setDay(day);
            lecture.setDuration(dur);

            LectureDAO.getInstance().addNewLecture(lecture, this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        final android.support.v7.app.AlertDialog d = (android.support.v7.app.AlertDialog)getDialog();
        if(d != null)
        {
            Button positiveButton = (Button) d.getButton(Dialog.BUTTON_POSITIVE);
            positiveButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    addLecture();
                }
            });
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void OnLectureAdd() {
        getDialog().dismiss();
        Toasty.success(getContext(), "Lecture added", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void OnError() {
        Toasty.error(getContext(), "There was an error adding lecture, please try again", Toast.LENGTH_SHORT).show();
    }
}
