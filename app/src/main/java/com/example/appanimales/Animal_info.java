package com.example.appanimales;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Animal_info extends AppCompatActivity {
    public TextView tvPosicion;
    public TextView tvNombre;
    public ImageView tvImagen;
    public TextView tvDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_info);
        recibirDatos();
    }

    public void recibirDatos(){
        Bundle extras = getIntent().getExtras();

        String posicion = extras.getString("posicion");
        String nombre   = extras.getString("nombre");
        int imagen      = extras.getInt("imagen");
        String desc     = extras.getString("desc");

        tvPosicion = findViewById(R.id.tvPosicion);
        tvPosicion.setText(posicion);

        tvNombre = findViewById(R.id.tvNombre);
        tvNombre.setText(nombre);

        tvImagen = findViewById(R.id.tvImagen);
        tvImagen.setImageResource(imagen);

        tvDesc = findViewById(R.id.tvDesc);
        tvDesc.setText(desc);

    }

}