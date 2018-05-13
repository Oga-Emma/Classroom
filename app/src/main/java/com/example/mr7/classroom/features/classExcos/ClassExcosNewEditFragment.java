package com.example.mr7.classroom.features.classExcos;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mr7.classroom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassExcosNewEditFragment extends DialogFragment {


    public ClassExcosNewEditFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.class_excos_new_edit_fragment, null);

        AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());

        dialog.setView(view)
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Close", null);


        return dialog.create();
    }

}
