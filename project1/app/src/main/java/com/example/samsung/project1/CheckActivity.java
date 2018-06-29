package com.example.samsung.project1;

/**
 * Created by Samsung on 2018-06-26.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CheckActivity extends AppCompatActivity {

private ImageView confirm, postpone, request, taxi;
private Button arrived, destination;
Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        //intent
        Intent intent = getIntent();
        EditText editext = (EditText) findViewById(R.id.checkMainText);
        editext.setText(intent.getExtras().getString("message"));




        //animation
        taxi = (ImageView) findViewById(R.id.taxi);
        animation = AnimationUtils.loadAnimation(CheckActivity.this, R.anim.taxi);
        taxi.startAnimation(animation);


        //button onClick Event
        confirm = (ImageView) findViewById(R.id.Btn_confitm);
        confirm.setOnClickListener(new ImageView.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(CheckActivity.this, "확인했습니다!", Toast.LENGTH_SHORT).show();
            }
        });

        postpone = (ImageView) findViewById(R.id.Btn_postpone);
        postpone.setOnClickListener(new ImageView.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(CheckActivity.this, "보류합니다!", Toast.LENGTH_SHORT).show();
                animation.cancel();

            }
        });

        request = (ImageView) findViewById(R.id.Btn_request);
        request.setOnClickListener(new ImageView.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(CheckActivity.this, "다시요청합니다!", Toast.LENGTH_SHORT).show();
            }
        });

        arrived = (Button) findViewById(R.id.arrived);
        arrived.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        destination = (Button) findViewById(R.id.destination);
        destination.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(CheckActivity.this, InflaterActivity.class);
                startActivity(myintent);
            }
        });

    }



}


