package com.example.firestoreapp;

import java.util.Map;

public class Student {
    String id;
    String name;
    String div;
    Subject[] subjects;

    Student(String id,String name,String div)
    {
        subjects[0]=new Subject("dbms",1,1);
        subjects[1]=new Subject("cn",1,1);
        subjects[2]=new Subject("toc",1,1);
        subjects[3]=new Subject("sdl",1,1);
        subjects[4]=new Subject("isee",1,1);
        subjects[5]=new Subject("sepm",1,1);


    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDiv() {
        return div;
    }

    public Subject[] getSubjects() {
        return subjects;
    }
}
