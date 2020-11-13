package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class respiracion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respiracion);
    }

    public void audio(View view){
        MediaPlayer mp = MediaPlayer.create(this,R.raw.respiracion);
        mp.start();
    }
    public void atras(View view){
        Intent sig = new Intent(this, Menu_ejercicios.class);
        startActivity(sig);
    }
}