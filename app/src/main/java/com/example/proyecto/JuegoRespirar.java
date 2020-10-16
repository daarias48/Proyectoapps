package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class JuegoRespirar extends AppCompatActivity {

    public ImageView circulo;
    Juegos juegos;
    public Button b;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_respirar);
        circulo = (ImageView) findViewById(R.id.ID_v);
        juegos = new Juegos();
        b = (Button) findViewById(R.id.Start);
    }

    public void Empezar (View view){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.scale);
        juegos.Zoom(animation,circulo);
        b.setVisibility(View.INVISIBLE);
    }

    public void Next (View view){
        Intent next= new Intent(this,Son_Piano.class);
        startActivity(next);
    }




}