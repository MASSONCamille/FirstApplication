package com.example.firstapplication.model;

import android.widget.ArrayAdapter;
import android.widget.PopupMenu;

import java.util.ArrayList;

public class Donnees {
    private static ArrayList<Etudiant> list_etu = creatObj();
    private static ArrayList<Evaluateur> list_eva = creatObj();
    private static ArrayList<Projet> list_pro = creatObj();

    public Donnees() {
        Etudiant etu1 = new Etudiant(1,"MASSON","Camille");
        Etudiant etu2 = new Etudiant(2,"VIDAL","Thomas");
        Etudiant etu3 = new Etudiant(3,"ORTEGA","Merej");
        Etudiant etu4 = new Etudiant(4,"devrais pas etre la","l\'inutile");
        this.list_etu.addtolist(list_etu, etu1);
        this.list_etu.addtolist(list_etu, etu2);
        this.list_etu.addtolist(list_etu, etu3);
        this.list_etu.addtolist(list_etu, etu4);

        Evaluateur eva00 = new Evaluateur(1,"SPENGLER","Anne","spengler.anne@univ.fr","lol");
        Evaluateur eva01 = new Evaluateur(2,"LAROCHE","Pierre","laroche.pierre@univ.fr","mdr");
        Evaluateur eva02 = new Evaluateur(3,"TEST","test","test@univ.fr","123");
        this.list_eva.addtolist(list_eva, eva00);
        this.list_eva.addtolist(list_eva, eva01);
        this.list_eva.addtolist(list_eva, eva02);

        ArrayList<Etudiant> list_proj1 = new ArrayList<Etudiant>();
        list_proj1.addtolist(list_etu, etu1);
        list_proj1.addtolist(list_etu, etu2);
        list_proj1.addtolist(list_etu, etu3);
        Projet pro1 = new Projet(1,01,"BookYourRoom", eva02, list_proj1);
        this.list_pro.addtolist(list_pro, pro1);
    }


    private static <T> ArrayList<T> creatObj(){
        return new ArrayList<>();
    }

    private static <T> ArrayList<T> addtolist(ArrayList<T> list, T elem){
        list.add(elem);
        return list;
    }

    public static ArrayList<Etudiant> getList_etu() {
        return list_etu;
    }

    public static void setList_etu(ArrayList<Etudiant> list_etu) {
        Donnees.list_etu = list_etu;
    }

    public static ArrayList<Evaluateur> getList_eva() {
        return list_eva;
    }

    public static void setList_eva(ArrayList<Evaluateur> list_eva) {
        Donnees.list_eva = list_eva;
    }

    public static ArrayList<Projet> getList_pro() {
        return list_pro;
    }

    public static void setList_pro(ArrayList<Projet> list_pro) {
        Donnees.list_pro = list_pro;
    }
}