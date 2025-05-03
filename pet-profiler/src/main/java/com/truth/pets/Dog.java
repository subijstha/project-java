package com.truth.pets;

public class Dog extends Pet{

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String selfDescribe(){
        return "Fun dog looking to make friends! \n" + super.selfDescribe();
    }

}
