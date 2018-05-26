package com.example.hmanr.grades.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hmanr.grades.Classes.Nota;
import com.example.hmanr.grades.R;

import java.util.ArrayList;

public class NotasAdapter extends RecyclerView.Adapter<NotasAdapter.NotasViewHolder> {
    ArrayList<Nota> notas;
    Context context;
    private int layout;


    public static class NotasViewHolder extends RecyclerView.ViewHolder {
        CardView cardview;
        TextView nombreM, nombreActivi, valorNota;

        public NotasViewHolder(View itemView) {
            super(itemView);
            cardview = itemView.findViewById(R.id.cardview_notas);
            nombreActivi= itemView.findViewById(R.id.notas_nombre_actividad);
            nombreM = itemView.findViewById(R.id.notas_nombre_materia);
            valorNota = itemView.findViewById(R.id.notas_valor_nota);

        }
    }

    public NotasAdapter(ArrayList<Nota>notas, Context context, int layout) {
        this.notas = notas;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public NotasAdapter.NotasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_notas, parent, false);
        return (new NotasViewHolder(v));
    }

    @Override
    public void onBindViewHolder(NotasAdapter.NotasViewHolder holder, int position) {
        holder.nombreActivi.setText(notas.get(position).getNombreActividad());
        holder.valorNota.setText(String.valueOf(notas.get(position).getNota()));
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }


}