package com.valverdesistemas.puppygram;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> arrayMascotas;
    Activity activity;
    int likesM1, likesM2, likesM3, likesM4, likesM5;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.arrayMascotas = mascotas;
        this.activity = activity;
    }

    // Inflar el layout y pasarlo viewholder para los views
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    // Asocia cada elemento de la lista con su view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = arrayMascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());

        mascotaViewHolder.btnLikeCV.setOnClickListener(new View.OnClickListener(){
            private TextView M1;
            private TextView M2;
            private TextView M3;
            private TextView M4;
            private TextView M5;

            @Override
            public void onClick(View v){

                if(mascota.getNombre() == "Mascota 1"){
                    likesM1++;
                    Toast.makeText(activity, "Has dado like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    M1 = mascotaViewHolder.itemView.findViewById(R.id.tvlike);
                    M1.setText(""+likesM1);
                }

                if(mascota.getNombre() == "Mascota 2"){
                    likesM2++;
                    Toast.makeText(activity, "Has dado like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    M2 = mascotaViewHolder.itemView.findViewById(R.id.tvlike);
                    M2.setText(""+likesM2);
                }

                if(mascota.getNombre() == "Mascota 3"){
                    likesM3++;
                    Toast.makeText(activity, "Has dado like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    M3 = mascotaViewHolder.itemView.findViewById(R.id.tvlike);
                    M3.setText(""+likesM3);
                }

                if(mascota.getNombre() == "Mascota 4"){
                    likesM4++;
                    Toast.makeText(activity, "Has dado like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    M4 = mascotaViewHolder.itemView.findViewById(R.id.tvlike);
                    M4.setText(""+likesM4);
                }

                if(mascota.getNombre() == "Mascota 5"){
                    likesM5++;
                    Toast.makeText(activity, "Has dado like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                    M5 = mascotaViewHolder.itemView.findViewById(R.id.tvlike);
                    M5.setText(""+likesM5);
                }
            }
        });
    }

    @Override
    public int getItemCount() { // Cantidad de elementos que contiene mi lista

        return arrayMascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private ImageButton btnLikeCV;

        @SuppressLint("WrongViewCast")
        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto      =(ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV   =(TextView) itemView.findViewById(R.id.tvNombreCV);
            btnLikeCV    =(ImageButton) itemView.findViewById(R.id.btnLikeCV);
        }
    }
}