package com.example.hmanr.grades.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hmanr.grades.Classes.Materia;
import com.example.hmanr.grades.MainActivity;
import com.example.hmanr.grades.MenuCiclos;
import com.example.hmanr.grades.MenuMateria;
import com.example.hmanr.grades.Notas;
import com.example.hmanr.grades.R;

import java.util.ArrayList;
import java.util.List;

public class MateriasAdapter extends RecyclerView.Adapter<MateriasAdapter.MateriasViewHolder> {
    ArrayList<Materia> materias;
    Context context;
    static final String TAG = "LoadData";
    private int layout;
    private ArrayList<Materia> items;
    private OnItemClickListener listener;

    public MateriasAdapter(ArrayList<Materia> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(Materia item);
    }
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
        public void bind(final Materia item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
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
        final int x =position;
        holder.materiaAbrev.setText(materias.get(position).getAbrevMat());
        holder.materiUv.setText(materias.get(position).getCantUvMat());
        holder.nombreMat.setText(materias.get(position).getNombreMat());
        holder.cardview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent =new Intent(v.getContext(),Notas.class);
                intent.putExtra("nomMat",materias.get(x).getNombreMat());
                Toast.makeText(v.getContext(), materias.get(x).getNombreMat() , Toast.LENGTH_SHORT).show();
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return materias.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

}