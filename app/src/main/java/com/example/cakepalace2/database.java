package com.example.cakepalace2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {
    public database(Context context) {
        super(context, "pemesanan.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table datatransaksi(namaorang TEXT primary key, nomororang TEXT, alamatorang TEXT, pesananorang TXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists datatransaksi");
    }
    public boolean insertdatatransaksi(String namaorang, String alamatorang, String nomororang, String pesananorang){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAMA", namaorang);
        contentValues.put("ALAMAT", alamatorang);
        contentValues.put("NO.TELP", nomororang);
        contentValues.put("PESANAN", pesananorang);

        long result = db.insert("datatransaksi", null, contentValues);
        if (result== -1){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean updatedatatransaksi(String namaorang, String alamatorang, String nomororang, String pesananorang){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ALAMAT", alamatorang);
        contentValues.put("No.TELP", nomororang);
        contentValues.put("PESANAN", pesananorang);
        Cursor cursor = db.rawQuery("Select * from datatransaksi where nama = ?", new String[] {namaorang});
        if (cursor.getCount() > 0) {
            long result = db.update("datatransaksi", contentValues, "nama=?", new String[]{namaorang});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else {
            return false;
        }
    }
    public boolean deletedatatransaksi(String nama){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from datatransaksi where nama = ?", new String[] {nama});
        if (cursor.getCount() > 0) {
            long result = db.delete("datatransaksi", "nama=?", new String[]{nama});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else {
            return false;
        }
    }
    public Cursor getdatatransaksi(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from datatransaksi",null);
        return cursor;
    }
}

