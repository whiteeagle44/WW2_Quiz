package com.example.ww2quiz;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView easyMode = findViewById(R.id.easyModeText);
        TextView mediumMode = findViewById(R.id.mediumModeText);
        TextView hardMode = findViewById(R.id.hardModeText);


        easyMode.setOnClickListener(v -> {
            Intent goToNextActivity = new Intent(MainActivity.this, EasyQuizActivity.class);
            startActivity(goToNextActivity);
        });

        mediumMode.setOnClickListener(v -> {
            Intent goToNextActivity = new Intent(MainActivity.this, MediumQuizActivity.class);
            startActivity(goToNextActivity);
        });

        hardMode.setOnClickListener(v -> {
            Intent goToNextActivity = new Intent(MainActivity.this, HardQuizActivity.class);
            startActivity(goToNextActivity);
        });

//        easyModeImg = (GifImageButton) findViewById(R.id.easy_mode_gif);
//        mediumModeImg = (GifImageButton) findViewById(R.id.medium_mode_gif);
//        hardModeImg = (GifImageButton) findViewById(R.id.hard_mode_gif);

//        easyModeFr = (FrameLayout) findViewById(R.id.frame_layout_easy);
//        mediumModeFr = (FrameLayout) findViewById(R.id.frame_layout_medium);
//        hardModeFr = (FrameLayout) findViewById(R.id.frame_layout_hard);


    }
}
