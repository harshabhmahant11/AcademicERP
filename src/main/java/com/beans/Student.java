package com.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student {

    @Id
    private int roll_no;
    private String Name;

    @ManyToOne
    Domain D_enrolled;

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getName() {
        return Name;
    }

    public Domain getD_enrolled() {
        return D_enrolled;
    }

    public void setD_enrolled(Domain d_enrolled) {
        D_enrolled = d_enrolled;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll_no=" + roll_no +
                ", Name='" + Name + '\'' +
                ", D_enrolled=" + D_enrolled +
                '}';
    }
}
