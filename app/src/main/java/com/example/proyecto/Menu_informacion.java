package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu_informacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_informacion);
    }


    public void  Ansiedad (View view){
        Intent ans= new Intent(this,Info_ansiedad.class);
        startActivity(ans);
    }

    public void Estres (View view){
        Intent est= new Intent(this,Info_estres.class);
        startActivity(est);
    }

    public void  AnsvsEs (View view){
        Intent vs= new Intent(this,Info_vs.class);
        startActivity(vs);
    }

    public void  Anterior (View view){
        Intent ant= new Intent(this,Pantalla_inicio.class);
        startActivity(ant);
    }
}