package org.truth.course;

import org.truth.subject.Subject;

public class ClassroomCourse extends Course  {

    private  String school;
    private String session;

    public  ClassroomCourse(Subject subject, String instructor, int fee,
                            String school, String session) {


        super(subject, instructor, fee);
        this.school =school;
        this.session =session;

        //complete constructor code
    }

    public String getSchool() {
        return school;
    }

    public String getSession() {
        return session;
    }
}
