package com.example.hasneetsingh.angelhackproject;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {
    int currentPosition;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_view_activity);

        videoView = (VideoView) findViewById(R.id.video_view);



    }

    @Override
    protected void onStart() {
        super.onStart();

        if (currentPosition == 0) {


            videoView.setVideoPath("sdcard/DCIM/short_ad.3gp");
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {

                    videoView.start();
                }

            });
        }


        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                currentPosition = videoView.getCurrentPosition();


                videoView.pause();


                AfterVideoFragment fragment = new AfterVideoFragment();

                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
            }
        });

    }



        @Override
        protected void onPause() {
            super.onPause();
            videoView.stopPlayback();
            videoView=null;
        }

    }

