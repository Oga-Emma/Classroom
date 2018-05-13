package com.example.mr7.classroom.features.forum;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mr7.classroom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForumPostFragment extends Fragment {


    public ForumPostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.forum_post_fragment, container, false);
    }

}
