package vn.uits.hello.model;

/**
 * Copyright © 2017 BAP CO., LTD
 * Created by PHUQUY on 3/8/18.
 */

public class Student {
    private int id;
    private String name;
    static String school = "Dai Hoc Bach Khoa DN";

    /**
     * constructor
     */
    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
