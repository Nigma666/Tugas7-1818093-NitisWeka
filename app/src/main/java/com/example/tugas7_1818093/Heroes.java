package com.example.tugas7_1818093;

public class Heroes {
    private String _id, _nama, _atribut;
    public Heroes (String id, String nama, String atribut) {
        this._id = id;
        this._nama = nama;
        this._atribut = atribut;
    }
    public Heroes() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_atribut() {
        return _atribut;
    }
    public void set_kelas(String _atribut) {
        this._atribut = _atribut;
    }
}
