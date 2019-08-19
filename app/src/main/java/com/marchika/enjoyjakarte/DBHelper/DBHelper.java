package com.marchika.enjoyjakarte.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "db_marchika";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db){
        String kuliner = "CREATE TABLE IF NOT EXISTS tabel_kuliner(namakuliner varchar(20), average varchar(10))";
        db.execSQL(kuliner);

        ContentValues values = new ContentValues();

        values.put("namakuliner", "Bandar Djakarta");
        values.put("average", "Rp. 250.000");
        db.insert("tabel_kuliner", "namakuliner",values);

    }

    public List<Kuliner> getKuliner() {
        List<Kuliner> kulinerList = new ArrayList<Kuliner>();
        String query = "select * from tabel_kuliner";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Kuliner k = new Kuliner();
                k.setNamakuliner(cursor.getString(0));
                k.setAverage(cursor.getString(1));
                kulinerList.add(k);
            } while (cursor.moveToNext());
        }return kulinerList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.v(DBHelper.class.getName(),"Upgrading database version " + oldVersion + newVersion
        + ", which will destroy all old data");

        db.execSQL("DROP TABLE IF EXISTS tabel_kuliner");
        onCreate(db);
    }

}
