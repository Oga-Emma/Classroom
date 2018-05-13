package com.example.mr7.classroom.repository;

import com.example.mr7.classroom.model.EventDTO;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EventsDAO {

    private static EventsDAO events;


    public static EventsDAO getInstance(){
        if (null == events){
            events = new EventsDAO();
        }

        return events;
    }

    public void fetchEvents(OnEventFetchListener listener){
        listener.onEventFetchSuccess(Arrays.asList(new EventDTO(), new EventDTO(), new EventDTO(), new EventDTO()));
//        listener.onEventFetchSuccess(Collections.EMPTY_LIST);
    }


    public interface OnEventFetchListener{
        void onEventFetchSuccess(List<EventDTO> events);
        void onEventFetchError();
    }
}
