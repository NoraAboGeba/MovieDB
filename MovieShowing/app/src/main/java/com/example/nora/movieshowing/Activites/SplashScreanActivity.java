package com.example.nora.movieshowing.Activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nora.movieshowing.R;

public class SplashScreanActivity extends AppCompatActivity{

        private final int waitingTime =5000;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
           // AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent intent =new Intent(SplashScreanActivity.this,HomePageActivity.class);
                    SplashScreanActivity.this.startActivity(intent);
                    SplashScreanActivity.this.finish();
                }
            },waitingTime);

        }


    }

