package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ejer_estiramiento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer_estiramiento);
    }
    public void  Atras (View view){
        Intent atr= new Intent(this,Menu_ejercicios.class);
        startActivity(atr);
    }
}