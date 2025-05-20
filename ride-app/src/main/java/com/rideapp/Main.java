package com.rideapp;

public class Main {
    public static void main(String[] args) {
        Ride s = new Standard("S1", "Station", "Park", 5);
        Ride p = new Premium("P1", "Office", "Airport", 10);

        Driver driver = new Driver("Alice");
        driver.assign(s);
        driver.assign(p);

        Rider rider = new Rider("Bob");
        rider.book(s);
        rider.book(p);

        driver.show();
        System.out.println();
        rider.show();
    }
}