package com.example.vektorel.ornekuygulama1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class VeriTabanislemleri extends SQLiteOpenHelper {

    Context context;

    String musteri_table = "create table tblmusteri(" + "id integer primary key autoincrement," + "ad varchar (50)," + "soyad varchar(50)" + ")";

    public VeriTabanislemleri(Context context) {
        super(context, "dbmusteri", null, 1);
        this.context = context;


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(musteri_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void kaydet(tblmusteri mst) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("insert into tblmusteri (ad,soyad) values('" + mst.getAd() + "','" + mst.getSoyad() + "')");

    }

    public List<tblmusteri> listele() {
        SQLiteDatabase db = this.getWritableDatabase();
        String kolonlar[] = {"id", "ad", "soyad"};
        Cursor cr = db.query("tblmusteri", kolonlar, null, null, null, null, null);
        tblmusteri mst;
        List<tblmusteri> liste = new ArrayList<>();
        if (cr.getCount() > 0) {
            while (cr.moveToNext()) {
                mst = new tblmusteri();
                mst.setAd(cr.getString(1));
                mst.setSoyad(cr.getString(2));
                liste.add(mst);

            }
        }

        return  liste;
    }


}

