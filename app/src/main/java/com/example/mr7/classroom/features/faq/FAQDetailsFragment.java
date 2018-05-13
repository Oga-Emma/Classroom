package com.example.mr7.classroom.features.faq;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mr7.classroom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FAQDetailsFragment extends Fragment {


    public FAQDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.faq_details_fragment_, container, false);
    }

}
