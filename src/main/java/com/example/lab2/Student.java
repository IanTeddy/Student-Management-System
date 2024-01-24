package com.example.lab2;

public class Student {

    private int id;
    private String name;
    private String major;

    public Student(int id, String name, String major){
        this.id = id;
        this.name = name;
        this.major = major;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setMajor(String major){
        this.major = major;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getMajor(){
        return major;
    }
}
