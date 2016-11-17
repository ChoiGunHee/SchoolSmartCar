package com.dku.smartcar.smartcarcontroller;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }
    public void geunOnclick(View view){

    }
    public void voiceOnclick(View view){
        Intent voice_intent = new Intent(MainActivity.this,VoiceActivity.class);
        startActivity(voice_intent);
    }
    public void controlOnclick(View view){
        Intent control_intent = new Intent(MainActivity.this,ControlActivity.class);
        startActivity(control_intent);
    }
}
