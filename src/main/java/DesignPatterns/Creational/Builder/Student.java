package DesignPatterns.Creational.Builder;

import lombok.ToString;

/**
 * Method without inner class and simple approach
 */
@ToString
public class Student {
    private int id;
    private String name;

    private Student() {}

    public static Student Builder(){
        return new Student();
    }

    public Student ID(int id){
        this.id = id;
        return this;
    }

    public Student Name(String name){
        this.name = name;
        return this;
    }
}
