package com.example.mr7.classroom.repository;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.mr7.classroom.model.LectureDTO;
import com.example.mr7.classroom.utils.DbStringUtils;
import com.example.mr7.classroom.utils.LectureDays;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LectureDAO {

    public static final String TAG = LectureDAO.class.getSimpleName();

    private static LectureDAO lectureDAO;
    private FirebaseFirestore db;

    public static LectureDAO getInstance(){
        if(null == lectureDAO){
            lectureDAO = new LectureDAO();
        }

        return lectureDAO;
    }

    public LectureDAO() {
        db = FirebaseFirestore.getInstance();
    }

    public void fetchLectures(OnLectureFetchListener onLectureFetchListener){
        db.collection(DbStringUtils.ClassRoom.LECTURES).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if(e != null){
                    Log.e(TAG, e.getMessage(), e);

                    onLectureFetchListener.OnLectureFetchError();
                }else{
                    if(documentSnapshots.isEmpty()){
                        onLectureFetchListener.OnLectureFetchSuccess(Collections.emptyList());
                    }else{
                        List<LectureDTO> lectures = documentSnapshots.toObjects(LectureDTO.class);
                        onLectureFetchListener.OnLectureFetchSuccess(lectures);
                    }
                }
            }
        });
    }

    public void addNewLecture(LectureDTO lecture, OnLectureModifiedListener onLectureModifiedListener){

        db.collection(DbStringUtils.ClassRoom.LECTURES).document(lecture.getId()).set(lecture)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        onLectureModifiedListener.OnLectureAdd();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        onLectureModifiedListener.OnError();
                    }
                });

       /* // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);

// Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

        // Create a new user with a first, middle, and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Alan");
        user.put("middle", "Mathison");
        user.put("last", "Turring");
        user.put("born", 1912);

// Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });*/
    }

    private String getLectureDay(int day) {
        switch (day){
            case LectureDays.MONDAY: return "monday";
            case LectureDays.TUESDAY: return "tuesday";
            case LectureDays.WEDNESDAY: return "wednesday";
            case LectureDays.THURSDAY: return "thursday";
            case LectureDays.FRIDAY: return "friday";
            default: return "monday";
        }
    }

    public interface OnLectureFetchListener{
        void OnLectureFetchSuccess(List<LectureDTO> lectureDTO);
        void OnLectureFetchError();
    }

    public interface OnLectureModifiedListener{
        void OnLectureAdd();
        void OnError();
    }
}
