package com.example.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.firstapplication.model.Donnees;
import com.example.firstapplication.model.Projet;

public class ListeActivity extends AppCompatActivity {

    private String utilisateur;
    private static Donnees data = new Donnees();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        this.utilisateur = this.getIntent().getStringExtra("user");

        TextView bvn = this.findViewById(R.id.bienvenue);
        bvn.setText(String.format(getString(R.string.msg), this.utilisateur));
    }

    @Override
    protected void onStart() {
        super.onStart();

        ListView listView = this.findViewById(R.id.liste);
        ArrayAdapter<Projet> adaptateur = new ArrayAdapter<Projet>(this, android.R.layout.simple_list_item_1, this.data.getList_pro());
        listView.setAdapter(adaptateur);


    }
}
