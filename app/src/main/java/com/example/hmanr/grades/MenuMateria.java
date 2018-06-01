package com.example.hmanr.grades;

import android.app.Dialog;
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
import android.widget.Toast;

import com.example.hmanr.grades.Adapter.MateriasAdapter;
import com.example.hmanr.grades.Classes.Materia;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MenuMateria extends AppCompatActivity {
    private ActionBarDrawerToggle mToggle;
    RecyclerView rv;
    MateriasAdapter matAdapter;
    ArrayList<Materia> materias = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_materias);

        //Menu desplegable
        DrawerLayout mDrawerLayout = findViewById(R.id.drawer_materia);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);

        NavigationView nav = findViewById(R.id.nav_materia);
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

        mDrawerLayout.addDrawerListener(mToggle);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mToggle.syncState();



        LinearLayoutManager lManager;
        lManager = new LinearLayoutManager(this);
        rv=(RecyclerView)(findViewById(R.id.recycler_materias));
        rv.setLayoutManager(lManager);
        Materia a= new Materia(1,"Matemática 1", "Mat1", "5UV");
        Materia b= new Materia(2,"Fisica 1", "Fis1", "4UV");
        Materia c= new Materia(3,"Psicologia Social", "PsiS", "3UV");
        Materia d= new Materia(4,"Matemática 2", "Mat2", "5UV");
        Materia e= new Materia(5,"Matemática Discreta", "MatD", "4UV");
        materias.add(a);
        materias.add(b);
        materias.add(c);
        materias.add(d);
        materias.add(e);
        matAdapter = new MateriasAdapter(materias,this, R.id.recycler_materias);
        rv.setAdapter(matAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item)||mToggle.onOptionsItemSelected(item);
    }

}
