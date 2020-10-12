package com.example.proyecto;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Juegos {

    public void Zoom(Animation animation, ImageView circulo){
        circulo.startAnimation(animation);
    }

}
