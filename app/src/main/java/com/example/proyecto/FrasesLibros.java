package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class FrasesLibros extends AppCompatActivity {

    ImageView marcohojas;
    TextView frase;
    FuncionesRandom funcionesRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frases_libros);
        marcohojas = (ImageView) findViewById(R.id.marcohojas);
        frase = (TextView) findViewById(R.id.frase);
        funcionesRandom = new FuncionesRandom();
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotar);
        animation.setFillAfter(true);
        marcohojas.startAnimation(animation);
        funcionesRandom.Frases(frase);
    }

    public void Next (View view){
        LayoutInflater inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.dialog_personalizado,null);

        funcionesRandom.MostrarDialogoBasico(this);
        funcionesRandom.SeleccionJuego(this,view1);
    }
}