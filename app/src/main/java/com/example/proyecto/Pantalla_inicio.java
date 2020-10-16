package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Pantalla_inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
    }

    public void  Menuinfo (View view){
        Intent inf= new Intent(this,Menu_informacion.class);
        startActivity(inf);
    }

    public void  Menuejer (View view){
        Intent eje= new Intent(this,Menu_ejercicios.class);
        startActivity(eje);
    }

    public void Diario (View view){
        Intent diario= new Intent(this,Diario_R.class);
        startActivity(diario);
    }

    public void BtnEmer (View view){
        Intent btn= new Intent(this,JuegoRespirar.class);
        startActivity(btn);
    }
}