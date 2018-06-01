package com.example.hmanr.grades;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.hmanr.grades.Adapter.NotasAdapter;
import com.example.hmanr.grades.Classes.Nota;

import java.util.ArrayList;

public class Notas extends AppCompatActivity {
    private ActionBarDrawerToggle mToggle;
    RecyclerView rv;
    NotasAdapter notaAdapter;
    ArrayList<Nota> notas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_notas);

        llenar();

        //Mostrar menu desplegable
        DrawerLayout mDrawerLayout = findViewById(R.id.drawer_menu_notas);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        NavigationView nav = findViewById(R.id.nav_menu);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                Intent intent;
                switch (id){
                    case  R.id.account:
                        break;
                    case R.id.settings:
                        break;
                    case R.id.logout:
                        intent =new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        break;

                }
                return false;
            }
        });

        mToggle.syncState();
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


    }
    public void llenar(){
        TextView nombremat = findViewById(R.id.notas_nombre_materia);
        String nomMat = getIntent().getStringExtra("nomMat");
        nombremat.setText(nomMat);
        LinearLayoutManager lManager;
        lManager = new LinearLayoutManager(this);
        rv=findViewById(R.id.recycler_notas);
        rv.setLayoutManager(lManager);
        Nota a= new Nota(1,"PARCIAL 1", nomMat, 8.00);
        Nota b= new Nota(2,"PARCIAL 2", nomMat, 6.00);
        Nota c= new Nota(3,"PARCIAL 3", nomMat, 5.00);
        Nota d= new Nota(4,"TAREA EXT", nomMat, 6.00);
        double total= 25/4;
        Nota e= new Nota(5,"NOTA FINAL", nomMat, total);
        notas.add(a);
        notas.add(b);
        notas.add(c);
        notas.add(d);
        notas.add(e);
        notaAdapter = new NotasAdapter(notas,this, R.id.recycler_notas);
        rv.setAdapter(notaAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item)||mToggle.onOptionsItemSelected(item);
    }
}
