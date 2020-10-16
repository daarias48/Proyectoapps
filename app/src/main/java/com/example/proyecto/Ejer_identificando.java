package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ejer_identificando extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer_identificando);
    }

    public void  Diario (View view){
        Intent diar= new Intent(this,Diario_R.class);
        startActivity(diar);
    }

    public void  Atras (View view){
        Intent atr= new Intent(this,Menu_ejercdiario.class);
        startActivity(atr);
    }

}