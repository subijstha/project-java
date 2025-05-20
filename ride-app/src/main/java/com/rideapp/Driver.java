package com.rideapp;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    private String name;
    private List<Ride> rides;

    public Driver(String name) {
        this.name = name;
        this.rides = new ArrayList<>();
    }

    public void assign(Ride ride) {
        rides.add(ride);
    }

    public void show() {
        System.out.println("Driver: " + name);
        for (Ride r : rides) {
            r.show();
        }
    }
}
