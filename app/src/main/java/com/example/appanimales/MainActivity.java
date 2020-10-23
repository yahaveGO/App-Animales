package com.example.appanimales;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private ArrayList<Animal> animales;
    private TextView tvNombre;
    private TextView tvNumCelda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animales = new ArrayList<Animal>();
        rellenarArrayList();
        AnimalesAdapter adapter = new AnimalesAdapter(this, animales);

        ListView lvAnimales = findViewById(R.id.lvItems);
        tvNombre            = findViewById(R.id.tvItemField);
        tvNumCelda          = findViewById(R.id.tvItemContent);

        lvAnimales.setAdapter(adapter);
        lvAnimales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvNombre.setText("Nombre : " + animales.get(position).getNombre());
                tvNumCelda.setText("Posicion : " + String.valueOf(position));
            }
        });
    }

    private void rellenarArrayList() {
        animales.add(new Animal("Colibrí", R.drawable.colibri));
        animales.add(new Animal("Delfin", R.drawable.delfin));
        animales.add(new Animal("Conejo", R.drawable.conejo));
        animales.add(new Animal("Guajolote", R.drawable.guajolote));
        animales.add(new Animal("Guacamaya", R.drawable.guacamaya));
        animales.add(new Animal("Pato", R.drawable.pato));
        animales.add(new Animal("Mariposa", R.drawable.mariposa1));
    }
}