package com.truth.pets;

public class Cat extends Pet{

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String selfDescribe(){
        return "Fun Cat to the Party! \n" + super.selfDescribe();
    }
}
