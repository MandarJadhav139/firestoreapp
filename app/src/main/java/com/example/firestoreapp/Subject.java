package com.example.firestoreapp;

public class Subject {
    String name;
    int attended;
    int total;
    public Subject()
    {

    }

    public String getName() {
        return name;
    }

    public Subject(String name, int attended, int total)
    {
        this.name=name;
        this.attended=attended;
        this.total=total;
    }
    public Subject(String name)
    {
        this.name=name;
    }

}
