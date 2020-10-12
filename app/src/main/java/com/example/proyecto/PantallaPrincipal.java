package com.example.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PantallaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
    }

    public void InicioSesion (View view){
        Intent sig = new Intent(this, MainActivity.class);
        startActivity(sig);
    }

    public void Registrarse (View view){
        Intent sig = new Intent(this, Son_Piano.class);
        startActivity(sig);
    }
}