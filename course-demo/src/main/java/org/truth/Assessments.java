package org.truth;

public interface Assessments {
    final int MAX_ASSIGNMENT_MARKS_ONLINE = 30;
    final int MAX_ASSIGNMENT_MARKS_CLASS = 100;
    final int MAX_QUIZ_MARKS_ONLINE = 10;
    final int MAX_QUIZ_MARKS_CLASS = 30;

    void assignmentScore(int marks);
    void quizScore(int marks);
}
