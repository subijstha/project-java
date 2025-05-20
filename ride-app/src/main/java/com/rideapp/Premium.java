package com.rideapp;
public class Premium extends Ride {
    public Premium(String id, String from, String to, double miles){
        super(id, from, to, miles);
    }

    @Override
    public double fare() {
        return miles * 3.0;
    }
    
}
