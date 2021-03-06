package com.example.firstapplication.model;

import android.widget.EditText;

import java.io.Serializable;

public class Evaluateur implements Serializable {
    private int id;
    private String name;
    private String firstname;
    private String email;
    private String mdp;

    public Evaluateur(int id, String name, String firstname, String email, String mdp) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.mdp = mdp;
    }

    public Evaluateur() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return firstname.charAt(0) + ". " + name;
    }

    @Override
    public boolean equals(Object obj) {
        boolean ok = false;

        if (this.getClass().equals(obj.getClass())){
            Evaluateur eva = (Evaluateur)obj;
            if (this.getEmail().equals(eva.getEmail())) ok = true;

        }
        return ok;

    }

}
