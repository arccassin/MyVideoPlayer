package com.example.myvideoplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    int intPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        String pathToVideoFile = "android.resource://com.example.myvideoplayer/" + R.raw.koshmal;
        videoView.setVideoPath(pathToVideoFile);

        if (savedInstanceState != null){
            intPosition = savedInstanceState.getInt("intPosition");
            videoView.seekTo(intPosition);
        }
        videoView.start();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        intPosition = videoView.getCurrentPosition();
        outState.putInt("intPosition", intPosition);
    }

    @Override
    protected void onPause() {
        super.onPause();
        intPosition = videoView.getCurrentPosition();;
        videoView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoView.seekTo(intPosition);
        videoView.start();
    }
}
