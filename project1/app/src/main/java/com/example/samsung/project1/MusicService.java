package com.example.samsung.project1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Samsung on 2018-06-28.
 */
import android.app.Service;


public class MusicService extends Service {

    MediaPlayer backgroundMusic;

    @Override
    public IBinder onBind(Intent intent) {
        // Service 객체와 화면 Activity 사이에서 데이터를 주고받을 때
        // 데이터를 전달할 필요가 없으면 return null;
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        backgroundMusic = MediaPlayer.create(this, R.raw.music1);
        backgroundMusic.setLooping(true);
        backgroundMusic.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        backgroundMusic.stop();
        super.onDestroy();
    }
}