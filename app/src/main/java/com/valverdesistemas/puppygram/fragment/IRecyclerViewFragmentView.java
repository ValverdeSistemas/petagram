package com.valverdesistemas.puppygram.fragment;

import com.valverdesistemas.puppygram.adapter.MascotaAdaptador;
import com.valverdesistemas.puppygram.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
