package com.rideapp;

import java.util.ArrayList;
import java.util.List;

public class Rider {
    private String name;
    private List<Ride> history;

    public Rider(String name){
        this.name = name;
        this.history = new ArrayList<>();

    }
    public void bookRide(Ride ride){
        history.add(ride);
    }

    public void show(){
        System.out.println("Rider: " + name);
        for (Ride r : history) {
            r.show();
        }
    }
    
    
}
