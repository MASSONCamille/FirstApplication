package com.example.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

import com.example.firstapplication.model.Projet;

public class SaisieActivity extends AppCompatActivity {

    private Projet projet;
    private EditText npost;
    private EditText npres;
    private EditText ntrav;
    private EditText ncomp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie);

        this.projet = (Projet) this.getIntent().getSerializableExtra("proj");
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.npost = (EditText)findViewById(R.id.nbpost);
        this.npres = (EditText)findViewById(R.id.editpres);
        this.ntrav = (EditText)findViewById(R.id.edittrav);
        this.ncomp = (EditText)findViewById(R.id.editcomp);

        this.npost.setText("N° " + String.valueOf(projet.getNum()));
        this.npost.setEnabled(false);

    }

    public void Valid(View view){

        if (npost.getText().toString().isEmpty() || npres.getText().toString().isEmpty() || ntrav.getText().toString().isEmpty() || ncomp.getText().toString().isEmpty()){
            Toast.makeText(this, R.string.msgE1, Toast.LENGTH_LONG).show();
        }
        else if (Integer.parseInt(npres.getText().toString()) > 5 || Integer.parseInt(ntrav.getText().toString()) > 5 || Integer.parseInt(ncomp.getText().toString()) > 5){
            Toast.makeText(this, R.string.msgE2, Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, String.format(getString(R.string.msgR), npost.getText().toString(), npres.getText().toString(), ntrav.getText().toString()),Toast.LENGTH_LONG).show();
            this.finish();
        }
    }

    public void Annul(View view){
        Toast.makeText(this, R.string.givupmark, Toast.LENGTH_LONG).show();
        this.finish();
    }
}
