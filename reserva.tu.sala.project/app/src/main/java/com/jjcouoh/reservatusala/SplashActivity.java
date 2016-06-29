package com.jjcouoh.reservatusala;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjcouoh.util.Util;



public class SplashActivity extends AppCompatActivity {

    private MyappApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        app = (MyappApplication) getApplicationContext();

        new Handler().postDelayed(new Runnable(){
            public void run(){
                if(app.isLoginStart()){
                    app.registerLogOut();
                    Util.sendTo(SplashActivity.this, SplashActivity.class);
                }else{
                    Util.sendAndFinish(SplashActivity.this, LoginActivity.class);
                }
            }

        }, 500);

        //getSupportActionBar().hide(); //tratar de usar siempre la version support y no la versión normal getActionBar().hide();

        //el getSupportActionBar esconde la barra superior
    }
}
