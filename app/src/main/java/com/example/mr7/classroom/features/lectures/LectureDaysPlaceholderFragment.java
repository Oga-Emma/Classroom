package com.example.mr7.classroom.features.lectures;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mr7.classroom.R;
import com.example.mr7.classroom.model.LectureDTO;
import com.example.mr7.classroom.repository.LectureDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LectureDaysPlaceholderFragment extends Fragment {

    public static final String TAG = LectureDaysPlaceholderFragment.class.getSimpleName();
    private static final String ARG_SECTION_NUMBER = "section_number";

    private ProgressDialog progressDialog;
    private AlertDialog errorDialog;

    private RecyclerView recyclerView;
    private TextView noLectureError;

    public LectureDaysPlaceholderFragment() {

    }

    public static LectureDaysPlaceholderFragment newInstance(int sectionNumber) {
        LectureDaysPlaceholderFragment fragment = new LectureDaysPlaceholderFragment();
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

        displayLectures(Collections.EMPTY_LIST);

        setupErrorDialog();
        setupProgressDialog();

        return rootView;
    }

    private void displayLectures(List<LectureDTO> lectureDTOS){
        recyclerView.setAdapter(new LectureAdapter(lectureDTOS));
    }

    private void setupErrorDialog() {
        errorDialog = new AlertDialog.Builder(getContext())
                .setMessage("Error loading lectures, check your internet connection and try again")
                .setCancelable(false)
                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        getActivity().finish();
                    }
                }).setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        progressDialog.show();
                        LectureDAO.getInstance().fetchLectures(FetchLectureListener);
                    }
                }).create();
    }

    private void setupProgressDialog() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Loading lectures");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                getActivity().finish();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

//        Log.i(TAG, "OnResume");

        progressDialog.show();
        LectureDAO.getInstance().fetchLectures(FetchLectureListener);
    }

    private LectureDAO.OnLectureFetchListener FetchLectureListener
            = new LectureDAO.OnLectureFetchListener() {
        @Override
        public void OnLectureFetchSuccess(List<LectureDTO> lectureDTO) {
            progressDialog.dismiss();

            if(!lectureDTO.isEmpty()){

                displayLectures(getTodaysLectures(lectureDTO, getArguments().getInt(ARG_SECTION_NUMBER)));
                noLectureError.setVisibility(View.GONE);
            }else{

                noLectureError.setVisibility(View.VISIBLE);


//            Toast.makeText(getContext(), "Empty", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void OnLectureFetchError() {
            //show error dialog
//        Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();

            noLectureError.setVisibility(View.VISIBLE);
            progressDialog.dismiss();
            errorDialog.show();
        }
    };

    private List<LectureDTO> getTodaysLectures(List<LectureDTO> lectureDTOS, int monday) {

        List<LectureDTO> li = new ArrayList<>();

        for(LectureDTO lect : lectureDTOS) {
            if (lect.getDay() == monday)
                li.add(lect);
        }

        return li;
    }

}
