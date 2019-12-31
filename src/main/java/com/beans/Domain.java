package com.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Domain {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int D_id;
    @Column(unique = true)
    //@NaturalId   now
    private int D_code;
    private String D_name;
    private String D_qualification;
    private int D_capacity;



    //now
    @JsonIgnore
    @OneToMany(mappedBy = "D_enrolled", cascade=CascadeType.ALL,orphanRemoval = true)
    List<Student> student_enrolled = new ArrayList<Student>();

    public int getD_id() {
        return D_id;
    }

    public void setD_id(int d_id) {
        D_id = d_id;
    }

    public int getD_code() {
        return D_code;
    }

    public void setD_code(int d_code) {
        D_code = d_code;
    }

    public String getD_name() {
        return D_name;
    }

    public void setD_name(String d_name) {
        D_name = d_name;
    }

    public String getD_qualification() {
        return D_qualification;
    }

    public void setD_qualification(String d_qualification) {
        D_qualification = d_qualification;
    }

    public int getD_capacity() {
        return D_capacity;
    }

    public void setD_capacity(int d_capacity) {
        D_capacity = d_capacity;
    }


    @Override
    public String toString() {
        return "Domain{" +
                "D_id=" + D_id +
                ", D_code=" + D_code +
                ", D_name='" + D_name + '\'' +
                ", D_qualification='" + D_qualification + '\'' +
                ", D_capacity=" + D_capacity +
                '}';
    }
}


