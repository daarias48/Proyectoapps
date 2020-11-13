package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu_ejercdiario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ejercdiario);
    }

    public void  Atras (View view){
        Intent atr= new Intent(this,Menu_ejercicios.class);
        startActivity(atr);
    }

    public void  autocuidado (View view){
        Intent aut= new Intent(this,Ejer_autocuidado.class);
        startActivity(aut);
    }

    public void  gestionando (View view){
        Intent ges= new Intent(this,Ejer_gestionando.class);
        startActivity(ges);
    }

    public void  identificando (View view){
        Intent ide= new Intent(this,Ejer_identificando.class);
        startActivity(ide);
    }

    public void  atencion (View view){
        Intent ate= new Intent(this,ejer_atencionconcentracion.class);
        startActivity(ate);
    }

    public void  puntos (View view){
        Intent ate= new Intent(this,ejer_puntosrojos.class);
        startActivity(ate);
    }
}