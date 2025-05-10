package org.truth.Learner;

import org.truth.Assessments;
import org.truth.course.Course;

public class Learner implements Assessments {
    private String name;
    private double grade;
    private Course course;
    private double gradeScore;

    public String getName(){
        return name;
    }

    public Learner(String name, Course course) {
        this.name = name;

        this.course = course;

        //TODO 2: complete constructor
    }

    public String toString() {
        return "Name: " + this.name + " " + "Course: " + this.course.getSubject().getTitle();
    }




    public double calculateGrade() {




        String courseTitle = course.getSubject().getTitle();
        int assignmentMarks = course.getAssignmentMarks();
        int quizMarks = course.getQuizmarks();



        if(courseTitle.contains("Online")){
            gradeScore = logic_online(assignmentMarks, quizMarks);
        }else{
            gradeScore = logic_class(assignmentMarks, quizMarks);
        }
        return this.gradeScore;
    }

    private double logic_class(int assignmentMarks, int quizMarks) {
        double assignmentOutof10 = ((double)assignmentMarks / MAX_ASSIGNMENT_MARKS_CLASS) *10;
        double quizOutof10 = ((double)quizMarks/MAX_QUIZ_MARKS_CLASS) *10;
        return (assignmentOutof10 + quizOutof10)/2;
    }

    private double logic_online(int assignmentMarks, int quizMarks) {
        double assignmetOutof10 = ((double)assignmentMarks / MAX_ASSIGNMENT_MARKS_ONLINE) * 10;
        double quizOutof10 = ((double) quizMarks / MAX_QUIZ_MARKS_ONLINE) *10;
        return (assignmetOutof10 + quizOutof10)/2;
    }


    @Override
    public void assignmentScore(int marks) {
        course.setAssignmentMarks(marks);
    }

    @Override
    public void quizScore(int marks) {
        course.setQuizmarks(marks);
    }
}
