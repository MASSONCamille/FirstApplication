package com.example.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

public class SaisieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie);
    }

    public void Verif(View view){
        EditText npost = (EditText)findViewById(R.id.nbpost);
        EditText npres = (EditText)findViewById(R.id.editpres);
        EditText ntrav = (EditText)findViewById(R.id.edittrav);
        EditText ncomp = (EditText)findViewById(R.id.editcomp);

        if (npost.getText().toString().isEmpty() || npres.getText().toString().isEmpty() || ntrav.getText().toString().isEmpty() || ncomp.getText().toString().isEmpty()){
            Toast.makeText(this,R.string.msgE1,Toast.LENGTH_LONG).show();
        }
        else if (Integer.parseInt(npres.getText().toString()) > 5 || Integer.parseInt(ntrav.getText().toString()) > 5 || Integer.parseInt(ncomp.getText().toString()) > 5){
            Toast.makeText(this,R.string.msgE2,Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,R.string.msgR,Toast.LENGTH_LONG).show();
        }
    }
}
