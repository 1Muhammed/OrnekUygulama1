package com.example.vektorel.ornekuygulama1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class musteriekle extends AppCompatActivity {

    EditText ad;
    EditText soyad;
    Button kaydet;
    Button anasayfa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musteriekle);

        ad = findViewById(R.id.txtad);
        soyad = findViewById(R.id.txtsoyad);
        kaydet = findViewById(R.id.btnKaydet);
        anasayfa = findViewById(R.id.btnanasayfa);

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MusteriKaydet();
            }
        });
    }
    public void MusteriKaydet () {

    VeriTabanislemleri vt = new VeriTabanislemleri(this.getApplicationContext());
    tblmusteri mst = new tblmusteri();
    mst.setAd(ad.getText().toString());
    mst.setSoyad(soyad.getText().toString());
    vt.kaydet(mst);

    for (tblmusteri item : vt.listele()) {

        Toast.makeText(this,"Musteri : " + item.getAd()+ "" + item.getSoyad(), Toast.LENGTH_SHORT).show();
    }
    }

}
