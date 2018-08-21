package com.nourshalabi.squareanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nourshalabi.lightwall.LightWall;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LightWall lightWall = findViewById(R.id.lightWall);

        String[] lights = new String[]{"#2f0727", "#854277", "#c192b8", "#f1d0ee", "#da81af"};
        String[] lights2 = new String[]{"#9d382b", "#cc8593", "#ebccd4", "#e3d9df", "#fdfafb"};

        lightWall.animateLightWall(6, lights2);

    }
}
