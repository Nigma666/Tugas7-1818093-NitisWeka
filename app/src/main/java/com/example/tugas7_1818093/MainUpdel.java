package com.example.tugas7_1818093;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, $atribut;
    private EditText Enama, Eatribut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        $atribut = i.getStringExtra("Iatribut");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Eatribut = (EditText) findViewById(R.id.updel_kelas);
        Enama.setText(Snama);
        Eatribut.setText($atribut);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                $atribut = String.valueOf(Eatribut.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama heroes",
                            Toast.LENGTH_SHORT).show();
                } else if ($atribut.equals("")){
                    Eatribut.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi Atribut",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateHeroes(new Heroes(Sid, Snama, $atribut));
                    Toast.makeText(MainUpdel.this, "Data telah diubah",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteHeroes(new Heroes(Sid, Snama,  $atribut));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}