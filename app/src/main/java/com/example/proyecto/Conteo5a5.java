package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.ImageFormat;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Conteo5a5 extends AppCompatActivity {
    ArrayList<ImageFormat> imagenes;

    TextView conteo;
    Button next;
    public static final int duracion = 300;
    public static final int tiempo_despues = 300;
    int cont =35;
    final int repeticion = 5;
    FuncionesRandom funcionesRandom = new FuncionesRandom();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteo5a5);
        next = (Button) findViewById(R.id.next);
        conteo = (TextView) findViewById(R.id.conteo);
        imagenes = new ArrayList<ImageFormat>();
        final AlphaAnimation fadeIn = new AlphaAnimation(0.0f,1.0f);
        fadeIn.setDuration(duracion);
        fadeIn.setStartOffset(tiempo_despues);
        fadeIn.setFillAfter(true);
        funcionesRandom.AnimacionConteo(next,conteo);

    }

    public void Next(View view){
        LayoutInflater inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.dialog_personalizado,null);

        funcionesRandom.MostrarDialogoBasico(this);
        funcionesRandom.SeleccionJuego(this, view1);
    }

}