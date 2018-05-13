package com.example.mr7.classroom.features.classExcos;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mr7.classroom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassExcosFragment extends Fragment {

    private ClassExcosSectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private FloatingActionButton fab;

    public ClassExcosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.class_excos_fragment, container, false);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new ClassExcosSectionsPagerAdapter(getActivity().getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) view.findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        fab = view.findViewById(R.id.add_class_exco_FAB);
        fab.setOnClickListener( (v) -> new ClassExcosNewEditFragment().show(
                getActivity().getSupportFragmentManager(), "ADD CLASS EXCO"));

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        if(true)
            fab.setVisibility(View.VISIBLE);
    }

    public class ClassExcosSectionsPagerAdapter extends FragmentPagerAdapter {

        public ClassExcosSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
//            Log.i(TAG, "Section Pager Adapter");
            return ClassExcosPlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 2;
        }
    }

}
