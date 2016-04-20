package com.example.anjali.project;

/**
 * Created by Anjali on 10-04-2016.
 */
public class Student {

    private int _id;
    private String _studentname;
   // private String _studentprofession;

    public Student(){

    }

    public Student(String studentname){
        this._studentname= studentname;
   //     this._studentprofession= studentprofession;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_studentname() {
        return _studentname;
    }

    public void set_studentname(String _studentname) {
        this._studentname = _studentname;
    }

    }
