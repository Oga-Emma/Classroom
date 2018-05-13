package com.example.mr7.classroom.features.classExcos;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mr7.classroom.R;


public class ClassExcosPlaceholderFragment extends Fragment {

    public static final String TAG = ClassExcosPlaceholderFragment.class.getSimpleName();
    private static final String ARG_SECTION_NUMBER = "section_number";

    private ProgressDialog progressDialog;
    private AlertDialog errorDialog;

    private RecyclerView recyclerView;
    private TextView noLectureError;

    public ClassExcosPlaceholderFragment() {

    }

    public static ClassExcosPlaceholderFragment newInstance(int sectionNumber) {
        ClassExcosPlaceholderFragment fragment = new ClassExcosPlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.lecture_fragment, container, false);

        noLectureError = rootView.findViewById(R.id.no_lecture_eror_textview);

        recyclerView = rootView.findViewById(R.id.lecture_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ClassExcosAdapter());

        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();

//        Log.i(TAG, "OnResume");

//        progressDialog.show();

    }

}
