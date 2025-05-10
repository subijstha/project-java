package org.truth.course;

public abstract class Course {
    private String instructor;
    private int course_fee;
    private int assignmentMarks;
    private int quizmarks;

    private Subject subject;

    public Course(Subject subject, String instructor, int fee) {
        this.subject = subject;
        this.instructor = instructor;
        this.course_fee = fee;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getCourse_fee() {
        return course_fee;
    }

    public int getAssignmentMarks() {
        return assignmentMarks;
    }

    public int getQuizmarks() {
        return quizmarks;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setCourse_fee(int course_fee) {
        this.course_fee = course_fee;
    }

    public void setAssignmentMarks(int assignmentMarks) {
        this.assignmentMarks = assignmentMarks;
    }

    public void setQuizmarks(int quizmarks) {
        this.quizmarks = quizmarks;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
