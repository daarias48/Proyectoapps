package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu_ejercicios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ejercicios);
    }

    public void  Atras (View view){
        Intent atr= new Intent(this,Pantalla_inicio.class);
        startActivity(atr);
    }

    public void  ejerdiarios (View view){
        Intent ejr= new Intent(this,Menu_ejercdiario.class);
        startActivity(ejr);
    }

}