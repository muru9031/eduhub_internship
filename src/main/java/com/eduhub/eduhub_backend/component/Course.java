package com.eduhub.eduhub_backend.component;

public class Course {
    private String coursecode;
    private String coursename;
    private int credits;

    public Course(String coursecode, String coursename, int credits) {
        this.coursecode = coursecode;
        this.coursename = coursename;
        this.credits = credits;
    }

    public String getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(String coursecode) {
        this.coursecode = coursecode;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
