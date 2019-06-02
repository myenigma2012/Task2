package com.example.task2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Splash extends AppCompatActivity {
    private static final String TAG = "message";
    private static int SPLASH_TIME_OUT=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i( TAG, "before handler" );
                Intent settingIntent1 = new Intent(Splash.this, PlayerNumber.class);
                finish();
                startActivity(settingIntent1);
                Log.i( TAG, "after handler" );
            }
        },SPLASH_TIME_OUT);

    }
}