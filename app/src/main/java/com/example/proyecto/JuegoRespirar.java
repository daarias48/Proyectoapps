package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class JuegoRespirar extends AppCompatActivity {

    public ImageView circulo;

    public ObjectAnimator animatorArriba;
    public ObjectAnimator animatorAbajo;
    public AnimatorSet animatorSet;

    Juegos juegos;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_respirar);
        circulo = (ImageView) findViewById(R.id.ID_v);
        juegos = new Juegos();


    }

    public void Empezar (View view){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.scale);
        circulo.startAnimation(animation);
    }




}