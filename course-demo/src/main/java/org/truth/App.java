package org.truth;

import org.truth.Learner.Learner;
import org.truth.course.ClassroomCourse;
import org.truth.course.Course;
import org.truth.course.OnlineCourse;
import org.truth.subject.Subject;

import java.util.Scanner;

public class App {
    static Course selectedCourse;
    static Scanner scanner;

    public static void main(String[] args) {




        displayMenu();



        System.out.print("Enter learners Name : ");
        String learnerName = scanner.nextLine();
        Learner learner1  = new Learner(learnerName, selectedCourse);


        //TODO 21: call assignmentScore() method and quizScore() methods
        String title = selectedCourse.getSubject().getTitle();

        if(title.contains("Online")){
            System.out.println("Reminder: MAx assignment marks = 30, \nMAX quiz marks = 10");
        }else{
            System.out.println("Reminder: MAx assignment marks = 100, \nMAX quiz marks = 30");
        }

        System.out.print("Enter the assignment marks : ");
        int marksAssignment = scanner.nextInt();
        System.out.print("\nEnter the quiz Marks : ");
        int marksQuiz = scanner.nextInt();

        learner1.assignmentScore(marksAssignment);
        learner1.quizScore(marksQuiz);

        //TODO 22: call calculateGrade() method. Display the result as described

        double grade = learner1.calculateGrade();
        System.out.println("Grade Score: " + grade);

        if(grade >= 5.0){
            System.out.println("Status: Successfully Passed the course. Congratulations!!! " + learner1.getName() + " Great JOB");

        }else{
            System.out.println("Status: Completed");
        }
    }

    private static void displayMenu() {

        scanner = new Scanner(System.in);

        System.out.println("Available courses");
        System.out.println("1 = Java");
        System.out.println("2 = Java Online");
        System.out.println("3 = JavaScript ");
        System.out.println("4 = JavaScript Online");
        System.out.print("\nEnter the choice of course ");
        int choice = scanner.nextInt();
        scanner.nextLine();



        switch(choice){
            case 1:
                selectedCourse = new ClassroomCourse(
                        new Subject("Java", 3),
                        "David",
                        400,
                        "MIU",
                        "Summer 2025");
                break;
            case 2:
                selectedCourse = new OnlineCourse(
                        new Subject("Java Online", 1),
                        "Charlie",
                        200,
                        "Basic on Java Programming",
                        8
                );
                break;
            case 3:
                selectedCourse = new ClassroomCourse(
                        new Subject("JavaScript" , 3),
                        "Richard",
                        400,
                        "MIU",
                        "Spring 2025"
                );
                break;
            case 4:
                selectedCourse = new OnlineCourse(
                        new Subject("JavaScript Online", 1),
                        "Robinson",
                        200,
                        "JavaScript and its fundamentals",
                        6
                );
                break;
            default:
                System.out.println("Invalid choice!! PLease choose among available options ");
                System.out.println("Press any button to goto main menu,----->");
                scanner.nextLine();
                displayMenu();
                break;

        }
    }
}