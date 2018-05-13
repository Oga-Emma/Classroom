package com.example.mr7.classroom.features.message;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.mr7.classroom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageDetailFragment extends DialogFragment {


    public MessageDetailFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.message_detail_fragment, null);
        EditText messageEditText = view.findViewById(R.id.message_edit_text);
        messageEditText.setClickable(false);
        messageEditText.setText("lorem lorem lorem\\nlorem\\nlorem");

        AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
        dialog.setView(view)
                .setNegativeButton("Close", null);

        return dialog.create();
    }
}
