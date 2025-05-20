package com.rideapp;

public class Standard extends Ride{
    public Standard(String id, String from, String to, double miles){
        super(id, from, to, miles);
    }

    @Override
    public double fare() {
       
       return miles * 1.5;
    }
}
