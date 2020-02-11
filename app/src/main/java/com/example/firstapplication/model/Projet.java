package com.example.firstapplication.model;

import java.util.ArrayList;

public class Projet {
    private int id;
    private int num;
    private String title;
    private Evaluateur ecad;
    private ArrayList<Etudiant> list_etu;

    public Projet(int id, int num, String title, Evaluateur ecad, ArrayList<Etudiant> list_etu) {
        this.id = id;
        this.num = num;
        this.title = title;
        this.ecad = ecad;
        this.list_etu = list_etu;
    }

    public Projet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Evaluateur getEcad() {
        return ecad;
    }

    public void setEcad(Evaluateur ecad) {
        this.ecad = ecad;
    }

    public ArrayList<Etudiant> getList_etu() {
        return list_etu;
    }

    public void setList_etu(ArrayList<Etudiant> list_etu) {
        this.list_etu = list_etu;
    }

    @Override
    public String toString() {
        return "N°" + num + " : " + title + " (" + ecad.toString() + ")"
                + "\n" + list_etu.toString() ;
        
    }
}
