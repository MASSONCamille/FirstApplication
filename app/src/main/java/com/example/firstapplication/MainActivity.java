package com.example.firstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }



    public void connexion(View view){
        EditText mail = this.findViewById(R.id.edit1);
        EditText mdp = this.findViewById(R.id.edit2);

        if (mail.getText().toString().equals( "masson.camille@ymail.com" ) && mdp.getText().toString().equals("123")){
            Intent intent = new Intent(MainActivity.this, ListeActivity.class);
            intent.putExtra("user",mail.getText().toString());
            startActivity(intent);
        }
        else{
            Toast.makeText(this,R.string.msgE3,Toast.LENGTH_LONG).show();
        }

    }

}


