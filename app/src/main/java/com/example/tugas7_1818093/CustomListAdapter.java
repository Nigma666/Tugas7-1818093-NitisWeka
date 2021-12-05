package com.example.tugas7_1818093;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Heroes> Heroes;
    public CustomListAdapter(Activity activity, List<Heroes>
            Heroes) {
        this.activity = activity;
        this.Heroes = Heroes;
    }
    @Override
    public int getCount() {
        return Heroes.size();
    }
    @Override
    public Object getItem(int location) {
        return Heroes.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama);
        TextView atribut = (TextView)
                convertView.findViewById(R.id.text_kelas);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Heroes h = Heroes.get(position);
        nama.setText("Nama Hero: "+ h.get_nama());
        atribut.setText("Atribut : "+ h.get_atribut());
        return convertView;
    }
}