package com.example.vektorel.ornekuygulama1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button btnyenikayit;
    Button btnListe;

Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this.getApplicationContext();
        btnyenikayit = findViewById(R.id.btnMusteri_ekle);
        btnListe = findViewById(R.id.btnMusteri_listesi);

        btnyenikayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent frmmusteri = new Intent(getApplicationContext(),musteriekle.class);
                startActivity(frmmusteri);

            }
        });

    btnListe.setOnClickListener(new View.OnClickListener(){

    @Override
        public void onClick (View view) {

        Intent frmListe = new Intent(context, musterilistesi.class);
        startActivity(frmListe);
    }


});

    }
}
