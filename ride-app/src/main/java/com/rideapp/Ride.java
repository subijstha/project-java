package com.rideapp;

public abstract class Ride {

    protected String id, from, to;
    protected double miles;

    public Ride(String id, String from, String to, double miles) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.miles = miles;
    }

    public abstract double fare();

    public void show() {
        System.out.printf("%s: %s -> %s, %.1f mi, $%.2f%n", id, from, to, miles, fare());
    }

}
