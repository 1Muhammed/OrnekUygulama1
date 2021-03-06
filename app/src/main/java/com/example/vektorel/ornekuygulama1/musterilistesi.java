package com.example.vektorel.ornekuygulama1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class musterilistesi extends AppCompatActivity {

ListView ListWiew;
String musteriler[];
VeriTabanislemleri vt;
Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musterilistesi);

        ListWiew = findViewById(R.id.lstmusteri);
        vt = new VeriTabanislemleri(this);
        musteriler = new String[vt.listele().size()];

        int i = 0;
        for(tblmusteri mst: vt.listele()) {
        musteriler[i] = mst.getAd()+ " " + mst.getSoyad();
        i++;
        }

        ArrayAdapter<String> mlist = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1);
        mlist.addAll(musteriler);
        ListWiew.setAdapter(mlist);
        ListWiew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(musterilistesi.this,"Seçilen Müşteri"+musteriler[i],Toast.LENGTH_SHORT).show();

            }
        });
    }


}
