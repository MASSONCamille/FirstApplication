package com.example.firstapplication.model;

import java.io.Serializable;

public class Etudiant implements Serializable {
    private int id;
    private String name;
    private String firstname;


    public Etudiant(int id, String name, String firstname) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
    }

    public Etudiant() {
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
