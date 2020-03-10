package com.example.firstapplication.model;

import java.io.Serializable;
import java.util.Objects;

public class Notes implements Serializable {
    private Projet projet;
    private Evaluateur eva;
    private int typeNote;
    private double notePres;
    private double noteTrav;
    private double noteComp;
    private String com;

    public Notes(Projet projet, Evaluateur eva, int typeNote, double notePres, double noteTrav, double noteComp, String com) {
        this.projet = projet;
        this.eva = eva;
        this.typeNote = typeNote;
        this.notePres = notePres;
        this.noteTrav = noteTrav;
        this.noteComp = noteComp;
        this.com = com;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Evaluateur getEva() {
        return eva;
    }

    public void setEva(Evaluateur eva) {
        this.eva = eva;
    }

    public int getTypeNote() {
        return typeNote;
    }

    public void setTypeNote(int typeNote) {
        this.typeNote = typeNote;
    }

    public double getNotePres() {
        return notePres;
    }

    public void setNotePres(double notePres) {
        this.notePres = notePres;
    }

    public double getNoteTrav() {
        return noteTrav;
    }

    public void setNoteTrav(double noteTrav) {
        this.noteTrav = noteTrav;
    }

    public double getNoteComp() {
        return noteComp;
    }

    public void setNoteComp(double noteComp) {
        this.noteComp = noteComp;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }
}
