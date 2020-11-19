package com.valverdesistemas.puppygram.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.valverdesistemas.puppygram.R;
import com.valverdesistemas.puppygram.adapter.MiMascotaAdaptador;
import com.valverdesistemas.puppygram.pojo.Mascota;
import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    private RecyclerView rvMiMascota;
    private MiMascotaAdaptador adaptador;
    private ArrayList<Mascota> mascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        // Crear mi recyclerview, asignarle un Administrador de layout
        rvMiMascota = (RecyclerView) v.findViewById(R.id.rvMiMascota);
        rvMiMascota.setHasFixedSize(true);

        // LinearLayoutManager llm = new LinearLayoutManager(getContext());
        GridLayoutManager llm = new GridLayoutManager(getContext(),3);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMiMascota.setLayoutManager(llm);

        // Inicializar lista de mascotas
        inicializarListaMascotas();

        //Inicializar adaptador
        inicializarAdaptador();

        return v;
    }

    public void inicializarListaMascotas(){

        // Se asignan valores para pruebas de demostracion
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota( "Mascota 1", R.drawable.mascota1,3 ));
        mascotas.add(new Mascota( "Mascota 2", R.drawable.mascota2,2 ));
        mascotas.add(new Mascota( "Mascota 3", R.drawable.mascota3,5 ));
        mascotas.add(new Mascota( "Mascota 4", R.drawable.mascota4,1 ));
        mascotas.add(new Mascota( "Mascota 5", R.drawable.mascota5,4 ));
    }

    public void inicializarAdaptador(){
        adaptador = new MiMascotaAdaptador(mascotas, getActivity());
        rvMiMascota.setAdapter(adaptador);
    }
}