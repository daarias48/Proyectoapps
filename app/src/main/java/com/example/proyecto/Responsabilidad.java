package com.example.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Responsabilidad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responsabilidad);
    }

    public void Continuar (View view){
        Intent sig = new Intent(this, Pantalla_inicio.class);
        startActivity(sig);
    }
}