package com.example.samsung.project1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Samsung on 2018-06-26.
 */

public class InflaterActivity extends AppCompatActivity {
    int imageIndex = -1;
    int btnIndex = -1;
    ImageView buttonSpeaker;
    Button buttonA, buttonB, buttonC, buttonExit, buttonCallback;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflate);

        //mediaPlayer = MediaPlayer.create(this, R.raw.music1);

        //Button Click Event
        buttonSpeaker = (ImageView) findViewById(R.id.speaker);
        buttonSpeaker.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageIndex *= -1;
                if(imageIndex == 1)
                {
                    buttonSpeaker.setImageResource(R.drawable.speakeron);
                    Intent intent = new Intent(
                        getApplicationContext(),
                    MusicService.class);
                    startService(intent);
                    //mediaPlayer.start();
                }


                else
                {
                    buttonSpeaker.setImageResource(R.drawable.speakeroff);
                    Intent intent = new Intent(
                            getApplicationContext(),
                            MusicService.class);
                    stopService(intent);
                    //mediaPlayer.pause();
                }
            }
        });

        buttonA = (Button) findViewById(R.id.Btn_A);
        buttonA.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeView(0);
                changeBtn(0);
                btnIndex = 0;
            }
        });

        buttonB = (Button) findViewById(R.id.Btn_B);
        buttonB.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeView(1);
                changeBtn(1);
                btnIndex = 1;
            }
        });

        buttonC = (Button) findViewById(R.id.Btn_C);
        buttonC.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeView(2);
                changeBtn(2);
                btnIndex = 2;
            }
        });

        buttonExit = (Button) findViewById(R.id.btn_exit);
        buttonExit.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonCallback = (Button) findViewById(R.id.btn_callback);
        buttonCallback.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                  CallbackEvent callbackEvent = new CallbackEvent(){
                  @Override
                  public void callbackMethod(){
                      Toast.makeText(InflaterActivity.this, "Call back 실행!", Toast.LENGTH_SHORT).show();
                  }};

                EventRegistration eventRegistration = new EventRegistration(callbackEvent);
                eventRegistration.doWork();
            }
        });
    }


    private void changeView(int index) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
        if (frame.getChildCount() > 0) {
            frame.removeViewAt(0);
        }
        View view = null;

        switch (index) {
            case 0:
                view = inflater.inflate(R.layout.fragment1, frame, false);
                break;
            case 1:
                view = inflater.inflate(R.layout.fragment2, frame, false);
                break;
            case 2:
                view = inflater.inflate(R.layout.fragment3, frame, false);
                break;
        }

        if (view != null)
            frame.addView(view);

    }

    private void changeBtn(int index){
        switch(btnIndex){
            case 0:
                buttonA.setTextColor(Color.parseColor("#000000"));
                buttonA.setBackgroundResource(R.drawable.button_off);
                break;
            case 1:
                buttonB.setTextColor(Color.parseColor("#000000"));
                buttonB.setBackgroundResource(R.drawable.button_off);
                break;
            case 2:
                buttonC.setTextColor(Color.parseColor("#000000"));
                buttonC.setBackgroundResource(R.drawable.button_off);
                break;
        }
        switch(index){
            case 0:
                buttonA.setTextColor(Color.parseColor("#ff9900"));
                buttonA.setBackgroundResource(R.drawable.button_on);
                break;
            case 1:
                buttonB.setTextColor(Color.parseColor("#ff9900"));
                buttonB.setBackgroundResource(R.drawable.button_on);
                break;
            case 2:
                buttonC.setTextColor(Color.parseColor("#ff9900"));
                buttonC.setBackgroundResource(R.drawable.button_on);
                break;
        }
    }

    class EventRegistration {
        private CallbackEvent callbackEvent;

        public EventRegistration(CallbackEvent event){
            callbackEvent = event;
        }

        public void doWork(){

            Toast.makeText(InflaterActivity.this, "Call back 호출!", Toast.LENGTH_SHORT).show();
            callbackEvent.callbackMethod();
        }
    }
    interface CallbackEvent {
        public void callbackMethod();
    }
}



