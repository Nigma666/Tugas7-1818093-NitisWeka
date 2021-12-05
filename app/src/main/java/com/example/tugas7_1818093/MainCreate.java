package com.example.tugas7_1818093;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Eatribut;
    private String Snama, Satribut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Eatribut = (EditText) findViewById(R.id.create_kelas);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Satribut = String.valueOf(Eatribut.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama Heroes",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Satribut.equals("")) {
                    Eatribut.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi atribut",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Enama.setText("");
                    Eatribut.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateHeroes(new Heroes(null, Snama, Satribut));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
