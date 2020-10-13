package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Atras (View view){
        Intent sig = new Intent(this, PantallaPrincipal.class);
        startActivity(sig);
    }

    public void Respons (View view){
        Intent sig = new Intent(this, Info_vs.class);
        startActivity(sig);
    }
}