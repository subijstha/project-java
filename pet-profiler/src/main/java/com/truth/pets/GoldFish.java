package com.truth.pets;

public class GoldFish extends Pet{
    public GoldFish(String name, int age) {
         super(name, age);
    }

    public String selfDescribe(){
        return super.selfDescribe() + "\n I like to take nap all day. ";
    }
}
