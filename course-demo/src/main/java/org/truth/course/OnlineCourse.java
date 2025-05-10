package org.truth.course;

import org.truth.subject.Subject;

public class OnlineCourse extends Course{
    private String videoLessons;
    private int weeks;


    public OnlineCourse(Subject subject, String instructor, int fee, String videoLessons, int weeks){
        //TODO 16: initialize other attributes
        super(subject, instructor, fee);
        this.videoLessons = videoLessons;
        this.weeks = weeks;
    }

    public String getVideoLessons() {
        return videoLessons;
    }

    public void setVideoLessons(String videoLessons) {
        this.videoLessons = videoLessons;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }
}
