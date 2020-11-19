package com.valverdesistemas.puppygram.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.valverdesistemas.puppygram.R;
import com.valverdesistemas.puppygram.db.ConstructorMascotas;
import com.valverdesistemas.puppygram.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> arrayMascotas;
    Activity activity;
    static int likesM1;
    static int likesM2;
    static int likesM3;
    static int likesM4;
    static int likesM5;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.arrayMascotas = mascotas;
        this.activity = activity;
    }

    // Inflar el layout y pasarlo al viewholder como objeto de views
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    //  Asociar elementos de views
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = arrayMascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvlike.setText(String.valueOf(mascota.getLikes()));
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.btnLikeCV.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Has dado like a " + mascota.getNombre(),Toast.LENGTH_SHORT).show();
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.tvlike.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));

            }
        });
    }

    @Override
    public int getItemCount() { // Cantidad de elementos que contiene mi lista
        return arrayMascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView    imgFoto;
        private TextView     tvNombreCV;
        private TextView     tvlike;
        private ImageView    btnLikeCV;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto    = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView)  itemView.findViewById(R.id.tvNombreCV);
            tvlike     = (TextView)  itemView.findViewById(R.id.tvlike);
            btnLikeCV  = (ImageView) itemView.findViewById(R.id.btnLikeCV);
        }
    }
}


