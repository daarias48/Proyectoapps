package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class Pantalla_inicio extends AppCompatActivity {

    FuncionesRandom funcionesRandom = new FuncionesRandom();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
    }

    public void  Menuinfo (View view){
        Intent inf= new Intent(this,Menu_informacion.class);
        startActivity(inf);
    }

    public void  Menuejer (View view){
        Intent eje= new Intent(this,Menu_ejercicios.class);
        startActivity(eje);
    }

    public void Diario (View view){
        Intent diario= new Intent(this,MostrarDiarios.class);
        startActivity(diario);
    }

    public void BtnEmer (View view){
        LayoutInflater inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.dialog_personalizado,null);
        funcionesRandom.SeleccionJuego(this,view1);
        // Intent btn= new Intent(this,JuegoRespirar.class);
        //startActivity(btn);
    }

    public void CerrarSesion (View view){
        Intent inten = new Intent(Intent.ACTION_MAIN);
        inten.addCategory(Intent.CATEGORY_HOME);
        inten.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(inten);
    }
}