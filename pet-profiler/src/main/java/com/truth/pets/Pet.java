package com.truth.pets;

public abstract class Pet {
    //properties:
    protected String name = "";
    protected int age =0;
    private int ageMultiper = 1;

    //constructor
    public Pet(String name, int age){
        this.name = name;
        this.age = age;

    }

    public Pet(String name, int age, int ageMultiper){
        this.name = name;
        this.age = age;
        this.ageMultiper = ageMultiper;

    }

    //methods:

    public String selfDescribe(){
        return "Name: " + name +
                "\nAge: " + calculateRealAge() + "in human years. " +
                "\nAge: " + age + "in actual" ;
    }

    private int calculateRealAge() {
        return age * ageMultiper;
    }


}
