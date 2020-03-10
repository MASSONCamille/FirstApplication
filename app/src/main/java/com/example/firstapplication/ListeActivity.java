package com.example.firstapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firstapplication.model.Donnees;
import com.example.firstapplication.model.Evaluateur;
import com.example.firstapplication.model.Notes;
import com.example.firstapplication.model.Projet;

import java.util.ArrayList;

public class ListeActivity extends AppCompatActivity /*implements AdapterView.OnItemClickListener*/ {

    private Evaluateur utilisateur;
    private ListView listView;
    public static final int NOTE_POSTER = 0;
    public static final int NOTE_SOUTENANCE = 1;
    private static ArrayList<Projet> listeProjet = Donnees.getInstance().getList_pro();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        this.utilisateur = (Evaluateur) this.getIntent().getSerializableExtra("user");

        TextView bvn = this.findViewById(R.id.bienvenue);
        bvn.setText(String.format(getString(R.string.msg), this.utilisateur.getName()));
    }

    @Override
    protected void onStart() {
        super.onStart();

        this.listView = this.findViewById(R.id.liste);
        ListeProjetAdaptateur adaptateur = new ListeProjetAdaptateur(this, listeProjet);
        listView.setAdapter(adaptateur);

//        ArrayAdapter<Projet> adaptateur = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Donnees.getInstance().getList_pro());
//        this.listView.setAdapter(adaptateur);
//
//        this.listView.setOnItemClickListener(this);

    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//        Projet proj = new Projet();
//        proj = Donnees.getInstance().getList_pro().get(position);
//        Intent intent = new Intent(ListeActivity.this, SaisieActivity.class);
//        intent.putExtra("proj",proj);
//        startActivity(intent);
//    }

    public void onClickPoster(View view){
        int position = Integer.parseInt(view.getTag().toString());

        Intent intent = new Intent(ListeActivity.this ,SaisieActivity.class);
        intent.putExtra("typeNotation", NOTE_POSTER);
        intent.putExtra("projet", this.listeProjet.get(position));
        startActivityForResult(intent, NOTE_POSTER);
    }

    public void onClickSoutenance(View view){
        int position = Integer.parseInt(view.getTag().toString());

        Intent intent = new Intent(ListeActivity.this ,SaisieActivity.class);
        intent.putExtra("typeNotation", NOTE_SOUTENANCE);
        intent.putExtra("projet", this.listeProjet.get(position));
        startActivityForResult(intent, NOTE_SOUTENANCE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode != SaisieActivity.RESULT_OK) {
            Toast.makeText(this, R.string.givupmark, Toast.LENGTH_LONG).show();
        } else {
            Notes notes = (Notes) data.getSerializableExtra("notes");


        }
    }
}
