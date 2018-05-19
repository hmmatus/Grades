package com.example.hmanr.grades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button but;
    EditText euser,epass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        euser=findViewById(R.id.user);
        epass=findViewById(R.id.pass);
        but=findViewById(R.id.login);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user="fede";
                String pass="1234";
                if(user.equals(euser.getText().toString()) && pass.equals(epass.getText().toString())){
                    Intent intent=new Intent(getApplicationContext(),Menu.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(MainActivity.this, "Credenciales invalidas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
