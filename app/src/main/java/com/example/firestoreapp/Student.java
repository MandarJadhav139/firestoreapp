package com.example.firestoreapp;

import java.util.ArrayList;
import java.util.Map;

public class Student {
    String id;
    String name;
    String div;
    ArrayList<Subject> subjects=new ArrayList<>();

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiv(String div) {
        this.div = div;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public Student()
    {

    }
    public Student(String id,String name,String div)
    {
        subjects.add(new Subject("dbms",1,1));
        subjects.add(new Subject("cn",1,1));
        subjects.add(new Subject("toc",1,1));
        subjects.add(new Subject("sdl",1,1));
        subjects.add(new Subject("isee",1,1));
        subjects.add(new Subject("sepm",1,1));
        this.id=id;
        this.name=name;
        this.div=div;


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

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
}
