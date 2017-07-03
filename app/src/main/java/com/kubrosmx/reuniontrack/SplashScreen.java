package com.kubrosmx.reuniontrack;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();

        obtenerHash();

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

    /**
     *  Metodo para obtener el HASH del dispositivo
     */
    private void obtenerHash() {
        PackageInfo info;
        try {
            info = getPackageManager().getPackageInfo(
                    "com.kubrosmx.reuniontrack",
                    PackageManager.GET_SIGNATURES
            );
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                //String something = new String(Base64.encodeBytes(md.digest()));
                Log.e("hash key", something);
            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("name not found", e1.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("no such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("exception", e.toString());
        }
    }
}
