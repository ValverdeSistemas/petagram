package com.valverdesistemas.puppygram;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import com.valverdesistemas.puppygram.adapter.MascotaAdaptador;
import com.valverdesistemas.puppygram.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaContactos;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

       // Agrega barra de navegacion
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);

        inicializarListaContactos();
        inicializaAdaptador();
    }

    public void inicializaAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota( "Mascota 1", R.drawable.mascota1,6 ));
        mascotas.add(new Mascota( "Mascota 2", R.drawable.mascota2,1 ));
        mascotas.add(new Mascota( "Mascota 3", R.drawable.mascota3,6 ));
        mascotas.add(new Mascota( "Mascota 4", R.drawable.mascota4,2 ));
        mascotas.add(new Mascota( "Mascota 5", R.drawable.mascota5,4 ));
    }
}