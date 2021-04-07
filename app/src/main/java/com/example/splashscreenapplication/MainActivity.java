package com.example.splashscreenapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation fade, top_down ;
    private ImageView img ;
    private TextView name, slogan ;
    private View line ;

    private static int TIME = 3000 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN) ;
        setContentView(R.layout.activity_main);

        fade = AnimationUtils.loadAnimation(this, R.anim.fade_animation);
        top_down = AnimationUtils.loadAnimation(this, R.anim.top_down_animation);

        img = findViewById(R.id.imageView);
        name = findViewById(R.id.name);
        slogan = findViewById(R.id.slogan);
        line = findViewById(R.id.divider2);

        img.setAnimation(top_down);
        name.setAnimation(fade);
        slogan.setAnimation(top_down);
        line.setAnimation(fade);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                finish();
            }
        }, TIME) ;

    }
}