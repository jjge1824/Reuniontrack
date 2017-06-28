package com.kubrosmx.reuniontrack;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                redireccionar();
            }
        }, 5000);   //5 segundos

    }

    /**
     *  Como no se puede redireccionar directo en el run del handler, se utiliza este metodo para
     *  hacerlo
     */
    private void redireccionar(){
        startActivity(new Intent(this, LoginActivity.class));
    }
}
