package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ejer_puntosrojos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer_puntosrojos);
    }

    public void  Atras (View view){
        Intent atr= new Intent(this,Menu_ejercdiario.class);
        startActivity(atr);
    }
}