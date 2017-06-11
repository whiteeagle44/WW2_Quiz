package com.example.android.ww2quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView easyMode;
    private TextView mediumMode;
    private TextView hardMode;

//    private GifImageButton easyModeImg;
//    private GifImageButton mediumModeImg;
//    private GifImageButton hardModeImg;

//    private FrameLayout easyModeFr;
//    private FrameLayout mediumModeFr;
//    private FrameLayout hardModeFr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        easyMode =(TextView) findViewById(R.id.easyModeText);
        mediumMode =(TextView) findViewById(R.id.mediumModeText);
        hardMode =(TextView) findViewById(R.id.hardModeText);


        easyMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToNextActivity = new Intent(MainActivity.this, EasyQuizActivity.class);
                startActivity(goToNextActivity);
            }
        });

        mediumMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToNextActivity = new Intent(MainActivity.this, MediumQuizActivity.class);
                startActivity(goToNextActivity);
            }
        });

        hardMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToNextActivity = new Intent(MainActivity.this, HardQuizActivity.class);
                startActivity(goToNextActivity);
            }
        });

//        easyModeImg = (GifImageButton) findViewById(R.id.easy_mode_gif);
//        mediumModeImg = (GifImageButton) findViewById(R.id.medium_mode_gif);
//        hardModeImg = (GifImageButton) findViewById(R.id.hard_mode_gif);

//        easyModeFr = (FrameLayout) findViewById(R.id.frame_layout_easy);
//        mediumModeFr = (FrameLayout) findViewById(R.id.frame_layout_medium);
//        hardModeFr = (FrameLayout) findViewById(R.id.frame_layout_hard);


    }




}
