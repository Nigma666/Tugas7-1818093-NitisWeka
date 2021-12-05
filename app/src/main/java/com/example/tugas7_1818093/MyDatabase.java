package com.example.tugas7_1818093;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_dota";
    private static final String tb_heroes = "tb_heroes";
    private static final String tb_heroes_id = "id";
    private static final String tb_heroes_nama = "nama";
    private static final String tb_heroes_atribut = "atribut";
    private static final String CREATE_TABLE_HEROES = "CREATE TABLE " +
    tb_heroes +"("
            + tb_heroes_id + " INTEGER PRIMARY KEY ,"
            + tb_heroes_nama + " TEXT ,"
            + tb_heroes_atribut + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_HEROES);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateHeroes(Heroes data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_heroes_id, data.get_id());
        values.put(tb_heroes_nama, data.get_nama());
        values.put(tb_heroes_atribut, data.get_atribut());
        db.insert(tb_heroes, null, values);
        db.close();
    }
    public List<Heroes> ReadHeroes() {
        List<Heroes> listMhs = new ArrayList<Heroes>();
        String selectQuery = "SELECT * FROM " + tb_heroes;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Heroes data = new Heroes();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_kelas(cursor.getString(2));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }
    public int UpdateHeroes (Heroes data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_heroes_nama, data.get_nama());
        values.put(tb_heroes_atribut, data.get_atribut());
        return db.update(tb_heroes, values, tb_heroes_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteHeroes(Heroes data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_heroes,tb_heroes_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}