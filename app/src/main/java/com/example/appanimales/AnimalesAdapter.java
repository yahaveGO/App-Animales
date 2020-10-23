package com.example.appanimales;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AnimalesAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<Animal> datos;

    public AnimalesAdapter(Context context, ArrayList<Animal> datos) {
        super(context, R.layout.item_celda,datos);
        //
        this.context = context;
        this.datos   = datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View item               = inflater.inflate(R.layout.item_celda,null);

        ImageView imagen        = item.findViewById(R.id.imaViewCelda);
        imagen.setImageResource(datos.get(position).getDrawableImageID());

        TextView nombre = item.findViewById(R.id.tvAnimal);
        nombre.setText(datos.get(position).getNombre());

        return item;
    }

}
