package com.example.task11;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {
 LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler=new Handler();
        lottieAnimationView=findViewById(R.id.welcome_animation);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
                finish();
            }
        },2000);
        lottieAnimationView.animate().translationX(2000).setDuration(3000).setStartDelay(2500);
    }
}