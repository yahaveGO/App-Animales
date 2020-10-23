package com.example.appanimales;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private ArrayList<Animal> animales;
    private TextView tvNombre;
    private TextView tvNumCelda;
    private Button btn_abrir;

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
        btn_abrir           = findViewById(R.id.btn_abrir);

//--------------------------------------------------------------------------------------------------DATOS DEL ITEM SELECCIONADO
        lvAnimales.setAdapter(adapter);
        lvAnimales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvNombre.setText(animales.get(position).getNombre());
                tvNumCelda.setText(String.valueOf(position));
            }
        });
//--------------------------------------------------------------------------------------------------BOTON ABRIR
        btn_abrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Animal_info.class);
                int indice    = Integer.parseInt(tvNumCelda.getText().toString());

                intent.putExtra("posicion", tvNumCelda.getText());
                intent.putExtra("nombre", animales.get(indice).getNombre());
                intent.putExtra("imagen", animales.get(indice).getDrawableImageID());
                intent.putExtra("desc", animales.get(indice).getDesc());

                startActivity(intent);
            }
        });

    }//onCreate
//--------------------------------------------------------------------------------------------------RELLENAR ARRAY
    private void rellenarArrayList() {
        animales.add(new Animal("Colibrí", R.drawable.colibri, "Ave muy pequeña, de plumaje brillante y de colores vivos, el pico muy largo y fino, que le permite alimentarse del néctar de las flores, patas muy cortas y alas muy largas; vuela suspendiéndose en el aire, gracias a la fuerza y velocidad con que bate las alas, y es la única ave capaz de volar hacia atrás; hay muchas especies diferentes, repartidas por toda América."));
        animales.add(new Animal("Delfin", R.drawable.delfin, "Mamífero acuático de unos 2,5 m de longitud, color grisáceo, hocico prolongado en forma de pico, y boca grande provista de multitud de pequeños dientes; vive en mares cálidos y templados, se alimenta de peces y calamares, y sale a la superficie a respirar; es veloz, inteligente y fácilmente domesticable."));
        animales.add(new Animal("Conejo", R.drawable.conejo, "Mamífero de cuerpo alargado y arqueado de unos 40 cm de longitud, pelo suave y espeso, orejas largas, cola corta y patas traseras más desarrolladas que las delanteras; vive en madrigueras y se reproduce con enorme rapidez; es comestible, estimado como pieza de caza y fácilmente domesticable; hay muchas especies."));
        animales.add(new Animal("Guajolote", R.drawable.guajolote, "Ave galliforme originaria de América que en estado salvaje alcanza un metro de altura; tiene el plumaje pardo verdoso con reflejos cobrizos y manchas blanquecinas en los extremos de las alas y de la cola."));
        animales.add(new Animal("Guacamaya", R.drawable.guacamaya, "Los guacamayos son aves del orden Psittaciformes y de la familia Psittacidae, muy llamativas por el colorido de su plumaje."));
        animales.add(new Animal("Pato", R.drawable.pato, "Pato es el nombre común para ciertas aves de la familia Anatidae, principalmente de la subfamilia Anatinae y dentro de ella del género Anas. No son un grupo monofilético, ya que no se incluyen los cisnes ni los gansos."));
        animales.add(new Animal("Mariposa", R.drawable.mariposa1, "Insecto lepidóptero en estado adulto o perfecto; tiene el cuerpo alargado, con cuatro alas grandes y de colores generalmente muy vistosos producidos por unas escamillas o polvillo que las cubre."));
        animales.add(new Animal("Gato", R.drawable.gato, "Mamífero felino de tamaño generalmente pequeño, cuerpo flexible, cabeza redonda, patas cortas, cola larga, pelo espeso y suave, largos bigotes y uñas retráctiles; es carnívoro y tiene gran agilidad, buen olfato, buen oído y excelente visión nocturna; existen muchas especies diferentes."));
        animales.add(new Animal("Perro", R.drawable.perro, "Mamífero carnívoro doméstico de la familia de los cánidos que se caracteriza por tener los sentidos del olfato y el oído muy finos, por su inteligencia y por su fidelidad al ser humano, que lo ha domesticado desde tiempos prehistóricos; hay muchísimas razas, de características muy diversas."));
        animales.add(new Animal("Camaleon", R.drawable.camaleon, "Los camaleones son una familia, Chamaeleonidae, de pequeños saurópsidos escamosos. Existen cerca de 161 especies de camaleones, la mayor parte de ellas en África al sur del Sáhara."));
    }
}