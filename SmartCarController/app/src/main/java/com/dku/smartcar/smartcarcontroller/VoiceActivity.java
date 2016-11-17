package com.dku.smartcar.smartcarcontroller;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class VoiceActivity extends AppCompatActivity {

    private Button frontButton;
    private Button rearButton;
    private Button rightButton;
    private Button leftButton;
    private Button stopButton;
    private Button voiceButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);


        frontButton = (Button)findViewById(R.id.frontButton);
        rearButton = (Button)findViewById(R.id.rearButton);
        rightButton = (Button)findViewById(R.id.rightButton);
        leftButton = (Button)findViewById(R.id.leftButton);
        stopButton=(Button)findViewById(R.id.stopButton);
        voiceButton = (Button)findViewById(R.id.voice_button);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);



    }

    public void voiceOnclick2(View view)
    {
        voice();
    }
    public void voice()
    {
        // 인텐트를 만들고 액티비티를 시작한다.
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "말해요");
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 20);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        startActivityForResult(intent, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == 1 && resultCode == RESULT_OK)
        {
            ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            for (int i = 0; i < results.size(); i++) {
                //text.append(results.get(i)+"\n");
            }
            String right_result=results.get(0);        //인식된 것과 가장 유사한거 하나만 추출

            //앞/뒤/오른쪽/왼쪽 구분
            if(right_result.contains("앞")==true) {
                Toast.makeText(VoiceActivity.this,"앞",Toast.LENGTH_SHORT).show(); //앞이라는 단어가 포함된 경우
                frontButton.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View view){

                    }
                });
            }else if(right_result.contains("뒤")==true){
                Toast.makeText(VoiceActivity.this,"뒤",Toast.LENGTH_SHORT).show();
                rearButton.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View view){

                    }
                });
            }else if(right_result.contains("오른쪽")==true){
                Toast.makeText(VoiceActivity.this,"오른쪽",Toast.LENGTH_SHORT).show();
                rightButton.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View view){

                    }
                });
            }else if(right_result.contains("왼쪽")==true){
                Toast.makeText(VoiceActivity.this,"왼쪽",Toast.LENGTH_SHORT).show();
                leftButton.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View view){

                    }
                });
            }else if(right_result.contains("멈춰")==true) {

                Toast.makeText(VoiceActivity.this,"멈춰",Toast.LENGTH_SHORT).show();
                stopButton.setOnClickListener(new Button.OnClickListener(){
                    public void onClick(View view){

                    }
                });
            } else{
                Toast.makeText(VoiceActivity.this,"다시말해라!!!",Toast.LENGTH_SHORT).show();

            }


        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
