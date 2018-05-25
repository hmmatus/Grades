package com.example.hmanr.grades.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.hmanr.grades.Classes.Materia;
import com.example.hmanr.grades.R;

import java.util.ArrayList;
import java.util.List;

public class MateriasAdapter extends RecyclerView.Adapter<MateriasAdapter.MateriasViewHolder> {
    ArrayList<Materia> materias;
    Context context;
    static final String TAG = "LoadData";
    private int layout;


    public static class MateriasViewHolder extends RecyclerView.ViewHolder {
        CardView cardview;
        TextView materiaAbrev, materiUv, nombreMat;

        public MateriasViewHolder(View itemView) {
            super(itemView);
            cardview = itemView.findViewById(R.id.cardview_materias);
            materiaAbrev = itemView.findViewById(R.id.textabrev);
            materiUv = itemView.findViewById(R.id.textuv);
            nombreMat = itemView.findViewById(R.id.textmateria);

        }
    }

    public MateriasAdapter(ArrayList<Materia> materias, Context context, int layout) {
        this.materias = materias;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public MateriasAdapter.MateriasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_materias, parent, false);
        return (new MateriasViewHolder(v));
    }

    @Override
    public void onBindViewHolder(MateriasAdapter.MateriasViewHolder holder, int position) {
        holder.materiaAbrev.setText(materias.get(position).getAbrevMat());
        holder.materiUv.setText(materias.get(position).getCantUvMat());
        holder.nombreMat.setText(materias.get(position).getNombreMat());
    }

    @Override
    public int getItemCount() {
        return materias.size();
    }

}