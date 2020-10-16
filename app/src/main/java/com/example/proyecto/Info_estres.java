package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Info_estres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_estres);
    }

    public void  Anterior (View view){
        Intent ant= new Intent(this,Menu_informacion.class);
        startActivity(ant);
    }
}