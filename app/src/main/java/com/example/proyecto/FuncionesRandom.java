package com.example.proyecto;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class FuncionesRandom {

    int cont =55;
    int duracion = 500;
    int tiempo_despues = 500;
    static int ventana =0;
    final int repeticion = 5;


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

    public void Select(final Context context){
        Random numeros = new Random();
        int juego = numeros.nextInt(5);
        switch (juego) {
            case 0:
                Intent libros = new Intent(context, FrasesLibros.class);
                context.startActivity(libros);
                ventana++;
                break;

            case 1:
                Intent conteo = new Intent(context, Conteo5a5.class);
                context.startActivity(conteo);
                ventana++;
                break;

            case 2:
                Intent respirar = new Intent(context, JuegoRespirar.class);
                context.startActivity(respirar);
                ventana++;
                break;

            case 3:
                Intent sonidos = new Intent(context, Son_Piano.class);
                context.startActivity(sonidos);
                ventana++;
                break;

            case 4:
                Intent textura = new Intent(context, Texturas.class);
                context.startActivity(textura);
                ventana++;
                break;
        }

    }

   public void SeleccionJuego(final Context context, View view){
       if (ventana==3){
           AlertDialog.Builder builder = new AlertDialog.Builder(context);
           builder.setView(view);

           final AlertDialog dialog = builder.create();
           dialog.show();

           Button btnmejor = view.findViewById(R.id.btnmejor);
           btnmejor.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent inicio = new Intent(context, Pantalla_inicio.class);
                   context.startActivity(inicio);
               }
           });

           Button btn_no = view.findViewById(R.id.btn_no);
           btn_no.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Select(context);
               }
           });
           ventana=0;
       }
       else {
           Select(context);

       }
   }

   public void AnimacionConteo (final Button next, final TextView conteo){
       final AlphaAnimation fadeIn = new AlphaAnimation(0.0f,1.0f);
       fadeIn.setDuration(duracion);
       fadeIn.setStartOffset(tiempo_despues);
       fadeIn.setFillAfter(true);

       final AlphaAnimation fadeOut = new AlphaAnimation(1.0f,0.0f);
       fadeOut.setDuration(duracion);
       fadeOut.setStartOffset(tiempo_despues);
       fadeOut.setFillAfter(true);

       fadeIn.setAnimationListener(new Animation.AnimationListener() {
           @Override
           public void onAnimationStart(Animation animation) {
               cont=cont-5;
               conteo.setText(String.valueOf(cont));


           }

           @Override
           public void onAnimationEnd(Animation animation) {
               conteo.startAnimation(fadeOut);
           }

           @Override
           public void onAnimationRepeat(Animation animation) {

           }
       });

       fadeOut.setAnimationListener(new Animation.AnimationListener() {
           @Override
           public void onAnimationStart(Animation animation) {

           }

           @Override
           public void onAnimationEnd(Animation animation) {
               if(cont>repeticion) {
                   conteo.startAnimation(fadeIn);
                   conteo.setVisibility(View.INVISIBLE);
               }
               else{
                   next.setVisibility(View.VISIBLE);
               }
           }

           @Override
           public void onAnimationRepeat(Animation animation) {

           }
       });

       conteo.startAnimation(fadeIn);
   }



   public void MostrarDialogoBasico(final Context context){
       /*
       if (ventana==3) {
           AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.DialogBasicCustomStyle);
           builder.setTitle("Titulo");
           builder.setMessage("¿Cómo te sientes?")
                   .setPositiveButton("Mucho mejor", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           Toast.makeText(context, "Hola mundo", Toast.LENGTH_SHORT).show();
                       }
                   })
                   .setNegativeButton("Aún no", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {

                       }
                   }).show();
           ventana=0;
       }

        */
   }
}
