package com.example.mr7.classroom.features.events;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mr7.classroom.R;
import com.example.mr7.classroom.model.EventDTO;
import com.example.mr7.classroom.repository.EventsDAO;

import java.util.Collections;
import java.util.List;

public class EventFragment extends Fragment {

    private ProgressDialog loading;
    RecyclerView eventRecyclerView;

    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.event_fragment, container, false);

        eventRecyclerView = view.findViewById(R.id.event_recycler_view);
        eventRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        eventRecyclerView.setAdapter(new EventsAdapter(Collections.EMPTY_LIST));

        loading = new ProgressDialog(getContext());
        loading.setMessage("Loading");
        loading.setCanceledOnTouchOutside(false);
        loading.setCancelable(false);
        loading.setButton(Dialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                getActivity().finish();
            }
        });
        loading.show();

        EventsDAO.getInstance().fetchEvents(getEventListener);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void showEmptyListDialog(String message) {
        new AlertDialog.Builder(getContext())
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        getActivity().finish();
                    }
                }).show();
    }

    EventsDAO.OnEventFetchListener getEventListener = new EventsDAO.OnEventFetchListener() {
        @Override
        public void onEventFetchSuccess(List<EventDTO> events) {

            loading.dismiss();
            if(!events.isEmpty()){
                //atleast one event found do something
                eventRecyclerView.setAdapter(new EventsAdapter(events));
//                                        Log.i(TAG, ""+ events.size());
            }else{
                //no event found show error
                showEmptyListDialog("No upcoming events");
            }


        }

        @Override
        public void onEventFetchError() {

            //some error occured, update UI
            loading.dismiss();
        }
    };

}
