package com.example.hmanr.grades;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuCiclos extends AppCompatActivity {
    private ActionBarDrawerToggle mToggle;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_menu);

        //Menu desplegable
        DrawerLayout mDrawerLayout = findViewById(R.id.drawer_menu);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item)||mToggle.onOptionsItemSelected(item);
    }
    public View cerrarSesion(View v) {
        Intent cerrar=new Intent(this,MainActivity.class);
        startActivity(cerrar);
        return v;
    }
    public View onClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.m1:
                Toast.makeText(this, "Ciclo 1", Toast.LENGTH_SHORT).show();
                intent=new Intent(this,MenuMateria.class);
                startActivity(intent);
                break;
            case R.id.m2:
                Toast.makeText(this, "Ciclo 2", Toast.LENGTH_SHORT).show();
                intent=new Intent(this,MenuMateria.class);
                startActivity(intent);
                break;
            case R.id.m3:
                Toast.makeText(this, "Ciclo 3", Toast.LENGTH_SHORT).show();
                intent=new Intent(this,MenuMateria.class);
                startActivity(intent);
                break;
            case R.id.m4:
                Toast.makeText(this, "Ciclo 4", Toast.LENGTH_SHORT).show();
                intent=new Intent(this,MenuMateria.class);
                startActivity(intent);
                break;
            case R.id.m5:
                Toast.makeText(this, "Ciclo 5", Toast.LENGTH_SHORT).show();
                intent=new Intent(this,MenuMateria.class);
                startActivity(intent);
                break;
            case R.id.m6:
                Toast.makeText(this, "Ciclo 6", Toast.LENGTH_SHORT).show();
                intent=new Intent(this,MenuMateria.class);
                startActivity(intent);
                break;
        }
        return v;
    }
}
