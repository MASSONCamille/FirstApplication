package com.example.firstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.firstapplication.model.Donnees;
import com.example.firstapplication.model.Evaluateur;
import com.example.firstapplication.model.Projet;

public class ListeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Evaluateur utilisateur;
    private ListView listView;

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
        ArrayAdapter<Projet> adaptateur = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Donnees.getInstance().getList_pro());
        this.listView.setAdapter(adaptateur);

        this.listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Projet proj = new Projet();
        parent.getAdapter().get
        Intent intent = new Intent(ListeActivity.this, SaisieActivity.class);
        intent.putExtra("proj",proj);
        startActivity(intent);
    }
}
