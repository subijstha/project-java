package org.truth.subject;

public class Subject {


    private String title;
    private double credits;


    Subject(String title, double credits) {

        this.title= title;
        this.credits =credits;

    }

    public String getTitle() {
        return title;
    }

    public double getCredits() {
        return credits;
    }

    public String toString() {

        return ("Subject title: " +  title +
                "\ncredits: " + credits
        );

    }
}
