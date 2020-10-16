package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class Son_Piano extends AppCompatActivity {

    public ImageView imagen;
    Animation animarbtn;
    MediaPlayer mp;
    MediaPlayer vector [] = new MediaPlayer[3];
    int numero;
    public Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_son__piano);
        vector [0] = MediaPlayer.create(this,R.raw.pajaros);
        vector [1] = MediaPlayer.create(this,R.raw.piano1);
        vector [2] = MediaPlayer.create(this,R.raw.rio);
        imagen = (ImageView) findViewById(R.id.ImagSon);
        btn = (Button) findViewById(R.id.btn);
        animarbtn =  AnimationUtils.loadAnimation(this,R.anim.negative_scale);
        btn.startAnimation(animarbtn);
    }

    public void Reproducir(View view){
        numero = (int) (Math.random()*2);
        vector[numero].start();
    }

    public void Next (View view){
        Intent next= new Intent(this,Pantalla_inicio.class);
        startActivity(next);
    }

}