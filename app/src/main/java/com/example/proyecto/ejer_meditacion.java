package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class ejer_meditacion extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejer_meditacion);

    }
    public void  Atras (View view){
        Intent atr= new Intent(this,Menu_ejercicios.class);
        startActivity(atr);
    }

    public void  medi1 (View view){
        Intent atr= new Intent(this,med1.class);
        startActivity(atr);
    }

    public void  medi2 (View view){
        Intent atr= new Intent(this,med2.class);
        startActivity(atr);
    }

    public void  medi3 (View view){
        Intent atr= new Intent(this,med3.class);
        startActivity(atr);
    }
}