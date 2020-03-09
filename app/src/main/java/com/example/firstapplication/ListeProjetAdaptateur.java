package com.example.firstapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.firstapplication.model.Projet;

import java.util.ArrayList;

public class ListeProjetAdaptateur extends ArrayAdapter<Projet> {

    public ListeProjetAdaptateur(Context context, ArrayList<Projet> liste) {
        super(context, 0, liste);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Projet unProjet = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.item_liste_projets, parent, false);
        }

        TextView t1Projet = convertView.findViewById(R.id.textView);
        t1Projet.setText(unProjet.toString());
        TextView t2Projet = convertView.findViewById(R.id.textView2);
        t2Projet.setText(unProjet.ListeEtuToString());

        ImageButton imgPoster = convertView.findViewById(R.id.imageButtonPost);
        imgPoster.setTag("" + position);
        ImageButton imgSoutenance = convertView.findViewById(R.id.imageButtonSout);
        imgSoutenance.setTag("" + position);

        return convertView;
    }
}
