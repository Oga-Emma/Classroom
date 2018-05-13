package com.example.mr7.classroom.features;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mr7.classroom.R;
import com.example.mr7.classroom.features.classExcos.ClassExcosFragment;
import com.example.mr7.classroom.features.events.EventFragment;

public class GenericActivity extends AppCompatActivity {

    public static final String TAG = GenericActivity.class.getSimpleName();
    private static final String WHICH_VIEW_TO_SHOW_EXTRA = "view_to_show";
    private int whichViewToShow = 0;


    public static void launchActivity(Context context, int which){
        Intent intent = new Intent(context, GenericActivity.class);
        intent.putExtra(WHICH_VIEW_TO_SHOW_EXTRA, which);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generic_activity);

        if(getIntent().getExtras() != null &&
                getIntent().getExtras().containsKey(WHICH_VIEW_TO_SHOW_EXTRA)){

            whichViewToShow = getIntent().getIntExtra(WHICH_VIEW_TO_SHOW_EXTRA, 0);

        }else if(savedInstanceState.containsKey(WHICH_VIEW_TO_SHOW_EXTRA)){
            whichViewToShow = savedInstanceState.getInt(WHICH_VIEW_TO_SHOW_EXTRA);
        }else{
            finish();
        }

        if(whichViewToShow == 0)
            finish();

//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.generic_fragment_container, new EventFragment(), "EVENT").commit();

        loadFragment(getIntent().getIntExtra(WHICH_VIEW_TO_SHOW_EXTRA, 1));
    }

    private void loadFragment(int whichViewToShow) {

        Log.i(TAG, "" + whichViewToShow);

        if(whichViewToShow == FRAGMENT_TO_LOAD.EVENTS) {
            setTitle("Upcoming events");
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.generic_fragment_container, new EventFragment(), "EVENT").commit();

        }else if(whichViewToShow == FRAGMENT_TO_LOAD.EXCOS) {
            setTitle("Class Executives");
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.generic_fragment_container, new ClassExcosFragment(), "EXCOS").commit();

        }else {
            finish();
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(WHICH_VIEW_TO_SHOW_EXTRA, whichViewToShow);
    }


    static class FRAGMENT_TO_LOAD {
        public static final int EVENTS = 1;
        public static final int EXCOS = 2;
    }
}
