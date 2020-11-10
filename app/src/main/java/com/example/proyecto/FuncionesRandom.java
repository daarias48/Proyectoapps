package com.example.proyecto;

import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class FuncionesRandom {

   public void Frases(TextView text){
       String [] frases = {"Nada dura para siempre","Cuando cambias el modo en que ves las cosas, las cosas que ves cambian también",
               "Cuando sentimos un gran temor ante algo que nos parece inminente, siempre sentiremos alivio cuando el problema ya ha llegado",
               "Por mucho que te pisen o te lastimen, tú vales. Vales mucho","Que las cosas sean de una manera no significa que no se puedan cambiar",
               "La felicidad no es una estación a la cual hay que llegar, sino una manera de viajar"};
       Random numeros = new Random();
       int posicion = numeros.nextInt(6);
       text.setText(frases[posicion]);
   }

   public void ImagTexturas(ImageView image){
       int [] imag ={R.drawable.lanasuave,R.drawable.madera,R.drawable.rugoso};
       Random numeros = new Random();
       int posicion = numeros.nextInt(3);
       image.setImageResource(imag[posicion]);
   }
}
