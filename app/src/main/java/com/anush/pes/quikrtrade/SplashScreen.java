package com.anush.pes.quikrtrade;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread timerThread =new Thread(){
            public void run(){
                try {
                    sleep(1000);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent i =new Intent("com.anush.pes.quikrtrade");
                    startActivity(i);
                }
            }
        };
        timerThread.start();


    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}

