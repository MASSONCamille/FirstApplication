package com.example.firstapplication;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

import com.example.firstapplication.model.Donnees;
import com.example.firstapplication.model.Evaluateur;
import com.example.firstapplication.model.Notes;
import com.example.firstapplication.model.Projet;

public class SaisieActivity extends AppCompatActivity {

    private Projet projet;
    private int typenote;
    private EditText npost;
    private EditText npres;
    private EditText ntrav;
    private EditText ncomp;
    private EditText comment;
    public static final int NOTE_POSTER = 0;
    public static final int NOTE_SOUTENANCE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie);

        this.projet = (Projet) this.getIntent().getSerializableExtra("projet");
        this.typenote = (int) this.getIntent().getSerializableExtra("typeNotation");
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.npost = (EditText) findViewById(R.id.nbpost);
        this.npres = (EditText) findViewById(R.id.editpres);
        this.ntrav = (EditText) findViewById(R.id.edittrav);
        this.ncomp = (EditText) findViewById(R.id.editcomp);
        this.comment = (EditText) findViewById(R.id.editTextComment);

        if (this.typenote == NOTE_POSTER) this.npost.setText("Poster N° " + String.valueOf(projet.getNum()));
        if (this.typenote == NOTE_SOUTENANCE) this.npost.setText("Soutenance N° " + String.valueOf(projet.getNum()));


        this.npost.setEnabled(false);

    }


    public void Valid(View view) {

        if (npost.getText().toString().isEmpty() || npres.getText().toString().isEmpty() ||
                ntrav.getText().toString().isEmpty() || ncomp.getText().toString().isEmpty()) {
            Toast.makeText(this, R.string.msgE1, Toast.LENGTH_LONG).show();
        } else if (Integer.parseInt(npres.getText().toString()) > 5 ||
                Integer.parseInt(ntrav.getText().toString()) > 5 ||
                Integer.parseInt(ncomp.getText().toString()) > 5) {
            Toast.makeText(this, R.string.msgE2, Toast.LENGTH_LONG).show();
        } else {
            double[] notes = {Double.parseDouble(npres.getText().toString()), Double.parseDouble(ntrav.getText().toString()), Double.parseDouble(ncomp.getText().toString())};
            Intent intent = new Intent();
            intent.putExtra("notes", notes);
            this.setResult(SaisieActivity.RESULT_OK, intent);
            this.finish();
        }
    }

    public void Annul(View view) {
        this.setResult(SaisieActivity.RESULT_CANCELED);
        this.finish();
    }
}
