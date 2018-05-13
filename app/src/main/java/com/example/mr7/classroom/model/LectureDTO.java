package com.example.mr7.classroom.model;

import java.util.UUID;

public class LectureDTO {

    String id;
    String courseCode;
    String courseTitle;
    String venue;
    String time;
    int day;
    int duration;

    public LectureDTO() {
        this.id = UUID.randomUUID().toString();
        this.courseCode = "";
        this.courseTitle = "";
        this.venue = "";
        this.time = "";
        this.day = 1;
        this.duration = 1;
    }

    public LectureDTO(String id, String courseCode, String courseTitle, String venue, String time, int duration, int day) {
        this.id = id;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.venue = venue;
        this.time = time;
        this.duration = duration;
        this.day = day;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
