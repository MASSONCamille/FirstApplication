package com.example.firstapplication.model;

import java.util.ArrayList;

public class Donnees {
    private static Donnees instance = null;
    private static ArrayList<Etudiant> list_etu = creatObj();
    private static ArrayList<Evaluateur> list_eva = creatObj();
    private static ArrayList<Projet> list_pro = creatObj();
    private static ArrayList<Notes> list_notes = creatObj();
    private static int position;
    public static final int NOTE_POSTER = 0;
    public static final int NOTE_SOUTENANCE = 1;

    private Donnees() {

        Etudiant etu1 = new Etudiant(1,"MASSON","Camille");
        Etudiant etu2 = new Etudiant(2,"VIDAL","Thomas");
        Etudiant etu3 = new Etudiant(3,"ORTEGA","Merej");
        Etudiant etu4 = new Etudiant(4,"devrais pas etre la","l\'inutile");
        list_etu = addtolist(list_etu, etu1);
        list_etu = addtolist(list_etu, etu2);
        list_etu = addtolist(list_etu, etu3);
        list_etu = addtolist(list_etu, etu4);

        Evaluateur eva00 = new Evaluateur(1,"SPENGLER","Anne","spengler.anne@univ.fr","lol");
        Evaluateur eva01 = new Evaluateur(2,"LAROCHE","Pierre","laroche.pierre@univ.fr","mdr");
        Evaluateur eva02 = new Evaluateur(3,"TEST","Test","test@univ.fr","123");
        list_eva = addtolist(list_eva, eva00);
        list_eva = addtolist(list_eva, eva01);
        list_eva = addtolist(list_eva, eva02);

        ArrayList<Etudiant> list_proj1 = new ArrayList<Etudiant>();
        list_proj1.add(etu1);
        list_proj1.add(etu2);
        list_proj1.add(etu3);
        Projet pro1 = new Projet(1, 01, "BookYourRoom", eva02, list_proj1);
        list_pro = addtolist(list_pro, pro1);

        ArrayList<Etudiant> list_proj2 = new ArrayList<Etudiant>();
        list_proj2.add(etu3);
        Projet pro2 = new Projet(2, 02, "BookYourRoom", eva00, list_proj2);
        list_pro = addtolist(list_pro, pro2);

        position = 0;
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

    public static ArrayList<Notes> getList_notes() {
        return list_notes;
    }

    public static void setList_notes(ArrayList<Notes> list_notes) {
        Donnees.list_notes = list_notes;
    }

    public Evaluateur getUserById(String mail, String mdp){
        Evaluateur that = new Evaluateur();
        that.setMdp(mdp);
        that.setEmail(mail);

        Evaluateur eva = null;

        for(int i = 0; i<getList_eva().size(); i++) {
            if(getList_eva().get(i).equals(that))
                if(getList_eva().get(i).getMdp().equals(that.getMdp()))
                    eva = getList_eva().get(i);
        }

        return eva;
    }

    public static Evaluateur getUserById(Evaluateur that){
        Evaluateur eva = null;

        for(int i = 0; i<getList_eva().size(); i++) {
            if(getList_eva().get(i).equals(that))
                if(getList_eva().get(i).getMdp().equals(that.getMdp()))
                    eva = getList_eva().get(i);
        }

        return eva;
    }

    public static Donnees getInstance() {
        if (instance == null){
            instance = new Donnees();
        }
        return instance;
    }

    public static void setNotesSoutenance(Projet projet, Evaluateur eva, double notePres, double noteTrav, double noteComp, String com){
        list_notes.add(new Notes(projet, eva, NOTE_SOUTENANCE, notePres, noteTrav, noteComp, com));
    }

    public static void setNotesPoster(Projet projet, Evaluateur eva, double notePres, double noteTrav, double noteComp, String com){
        list_notes.add(new Notes(projet, eva, NOTE_POSTER, notePres, noteTrav, noteComp, com));
    }
}
