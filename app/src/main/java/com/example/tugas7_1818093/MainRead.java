package com.example.tugas7_1818093;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Heroes> ListHeroes = new
            ArrayList<Heroes>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListHeroes
        );
        mListView = (ListView) findViewById(R.id.list_mahasiswa);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListHeroes.clear();
        List<Heroes> mahasiswa = db.ReadHeroes();
        for (Heroes mhs : mahasiswa) {
            Heroes daftar = new Heroes();
            daftar.set_id(mhs.get_id());
            daftar.set_nama(mhs.get_nama());
            daftar.set_kelas(mhs.get_atribut());
            ListHeroes.add(daftar);
            if ((ListHeroes.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Heroes detailMhs = (Heroes) o;
        String Sid = detailMhs.get_id();
        String Snama = detailMhs.get_nama();
        String Skelas = detailMhs.get_atribut();
        Intent goUpdel = new Intent(MainRead.this,
                MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Iatribut", Skelas);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListHeroes.clear();
        mListView.setAdapter(adapter_off);
        List<Heroes> mahasiswa = db.ReadHeroes();
        for (Heroes mhs : mahasiswa) {
            Heroes daftar = new Heroes();
            daftar.set_id(mhs.get_id());
            daftar.set_nama(mhs.get_nama());
            daftar.set_kelas(mhs.get_atribut());
            ListHeroes.add(daftar);
            if ((ListHeroes.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}