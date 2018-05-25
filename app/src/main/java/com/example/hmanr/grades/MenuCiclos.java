package com.example.hmanr.grades;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuCiclos extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_menu);

        //Menu desplegable
        mDrawerLayout = findViewById(R.id.drawer_menu);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.m1:
                Toast.makeText(this, "Ciclo 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m2:
                Toast.makeText(this, "Ciclo 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m3:
                Toast.makeText(this, "Ciclo 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m4:
                Toast.makeText(this, "Ciclo 4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m5:
                Toast.makeText(this, "Ciclo 5", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m6:
                Toast.makeText(this, "Ciclo 6", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
