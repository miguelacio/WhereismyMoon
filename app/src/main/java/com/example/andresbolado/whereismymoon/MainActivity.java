package com.example.andresbolado.whereismymoon;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.andresbolado.whereismymoon.models.Moon;

public class MainActivity extends AppCompatActivity {

    FrameLayout frame1;
    FrameLayout frame2;
    FrameLayout frame3;
    RelativeLayout frameInicial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        frame1 = (FrameLayout) findViewById(R.id.layout1);
        frame2 = (FrameLayout) findViewById(R.id.layout2);
        frame3 = (FrameLayout) findViewById(R.id.layout3);
        frameInicial = (RelativeLayout) findViewById(R.id.RelativeComplet);


        frame1.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                int coordenadaX1 = (frameInicial.getLeft() + frameInicial.getRight()) / 2;
                int coordenadaY1 = (frameInicial.getBottom() + frameInicial.getTop()) / 2;
                int radioInicial1 = frameInicial.getWidth();
                Animator animacion1 = ViewAnimationUtils.createCircularReveal(frameInicial, coordenadaX1, coordenadaY1, radioInicial1, 0);
                frameInicial.setVisibility(View.VISIBLE);
                animacion1.start();
                Intent intent = new Intent(MainActivity.this, MoonScrollingActivity.class);
                startActivity(intent);
            }
        });
        frame2.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                int coordenadaX1 = (frameInicial.getLeft() + frameInicial.getRight()) / 2;
                int coordenadaY1 = (frameInicial.getBottom() + frameInicial.getTop()) / 2;
                int radioInicial1 = frameInicial.getWidth();
                Animator animacion1 = ViewAnimationUtils.createCircularReveal(frameInicial, coordenadaX1, coordenadaY1, radioInicial1, 0);
                frameInicial.setVisibility(View.VISIBLE);
                animacion1.start();
                Intent intent = new Intent(MainActivity.this, FactsActivity.class);
                startActivity(intent);

            }
        });

        frame3.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {


                int coordenadaX1 = (frameInicial.getLeft() + frameInicial.getRight()) / 2;
                int coordenadaY1 = (frameInicial.getBottom() + frameInicial.getTop()) / 2;
                int radioInicial1 = frameInicial.getWidth();
                Animator animacion1 = ViewAnimationUtils.createCircularReveal(frameInicial, coordenadaX1, coordenadaY1, radioInicial1, 0);
                frameInicial.setVisibility(View.VISIBLE);
                animacion1.start();
                Intent intent = new Intent(MainActivity.this, MoonStoriesActivity.class);
                startActivity(intent);

            }
        });


    }
}
