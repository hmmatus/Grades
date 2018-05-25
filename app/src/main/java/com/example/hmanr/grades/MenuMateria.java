package com.example.hmanr.grades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hmanr.grades.Adapter.MateriasAdapter;
import com.example.hmanr.grades.Classes.Materia;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MenuMateria extends AppCompatActivity {
    RecyclerView rv;
    MateriasAdapter matAdapter;
    ArrayList<Materia> materias = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_menu_materia);
        LinearLayoutManager lManager;
        lManager = new LinearLayoutManager(this);
        rv=(RecyclerView)(findViewById(R.id.recycler_materias));
        rv.setLayoutManager(lManager);
        Materia a= new Materia(1,"matematica 1", "Mat1", "3UV");
        Materia b= new Materia(2,"matematica 2", "Mat2", "4UV");
        Materia c= new Materia(3,"matematica 3", "Mat3", "5UV");
        Materia d= new Materia(4,"matematica 4", "Mat4", "5UV");
        Materia e= new Materia(5,"matematica 5", "Mat5", "5UV");
        materias.add(a);
        materias.add(b);
        materias.add(c);
        materias.add(d);
        materias.add(e);
        matAdapter = new MateriasAdapter(materias,this, R.id.recycler_materias);
        rv.setAdapter(matAdapter);


    }
}
