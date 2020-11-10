package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Texturas extends AppCompatActivity {

    ImageView textura;
    FuncionesRandom funcionesRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texturas);
        funcionesRandom = new FuncionesRandom();
        textura = (ImageView) findViewById(R.id.ImaTextura);
        funcionesRandom.ImagTexturas(textura);
    }
}