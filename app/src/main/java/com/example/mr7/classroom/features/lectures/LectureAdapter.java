package com.example.mr7.classroom.features.lectures;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mr7.classroom.R;
import com.example.mr7.classroom.model.LectureDTO;

import java.util.List;

public class LectureAdapter extends RecyclerView.Adapter<LectureAdapter.LectureHolder>{

    private List<LectureDTO> lectureDTOList;

    public LectureAdapter(List<LectureDTO> lectureDTOList) {
        this.lectureDTOList = lectureDTOList;
    }

    @NonNull
    @Override
    public LectureHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new LectureHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lecture_rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LectureHolder holder, int position) {
        holder.onBindView(lectureDTOList.get(position));
    }

    @Override
    public int getItemCount() {
        return lectureDTOList.size();
    }

    public class LectureHolder extends RecyclerView.ViewHolder{

        TextView courseCode, courseTitle, time, venue, duration;

        public LectureHolder(View itemView) {
            super(itemView);

            courseCode = itemView.findViewById(R.id.course_code_text_view);
            courseTitle = itemView.findViewById(R.id.course_title_text_view);
            duration = itemView.findViewById(R.id.duration_text_view);
            venue = itemView.findViewById(R.id.venue_text_view);
            time = itemView.findViewById(R.id.time_text_view);
        }

        public void onBindView(LectureDTO lecture) {
            courseCode.setText(lecture.getCourseCode());
            courseTitle.setText(lecture.getCourseTitle());
            duration.setText(lecture.getDuration() + " hrs");

            String t[] = lecture.getTime().split("-");
            time.setText(t[0] + "\n" + t[1]);
        }
    }
}
