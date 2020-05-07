package com.fehead;

/**
 * @author Nightnessss 2020/4/6 23:08
 */
public class Student {

    private String sno;
    private String sname;

    public Student(String sno, String sname) {
        this.sno = sno;
        this.sname = sname;
    }

    public Student() {
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
