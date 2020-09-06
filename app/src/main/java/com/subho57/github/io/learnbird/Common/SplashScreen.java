package com.subho57.github.io.learnbird.Common;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;

import androidx.appcompat.app.AppCompatActivity;

import com.subho57.github.io.learnbird.Common.LoginSignup.Login;
import com.subho57.github.io.learnbird.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(LayoutParams.FLAG_FULLSCREEN, LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);


        int SPLASH_TIMER = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<>(findViewById(R.id.logo_image), "logo_image_for_splashscreen");
                pairs[1] = new Pair<>(findViewById(R.id.splashscreen), "login_page");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this, pairs);
                startActivity(intent, options.toBundle());
                finish();
            }
        }, SPLASH_TIMER);
    }
}