package com.example.hmanr.grades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuCiclos extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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
