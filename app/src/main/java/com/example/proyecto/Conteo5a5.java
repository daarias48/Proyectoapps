package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.ImageFormat;
import android.media.Image;
import android.os.Bundle;
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
    public static final int duracion = 1500;
    public static final int tiempo_despues = 2000;
    int cont =35;
    final int repeticion = 5;
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


}