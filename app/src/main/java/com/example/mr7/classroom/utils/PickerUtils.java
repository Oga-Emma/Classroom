package com.example.mr7.classroom.utils;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;

import com.example.mr7.classroom.R;

import java.util.Locale;

public class PickerUtils {

    public static void showTimePcker(Context context, TimePickerDialog.OnTimeSetListener onTimeSetListener){
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(context, onTimeSetListener, 0, 0, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }
}
