package com.example.eee;

import android.widget.VideoView;
import android.content.Intent;

import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.MediaController;


public class Video extends AppCompatActivity {
    private VideoView video;
    private Button play, end;
    private Button back;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_play);
        InitView();

    }

    private void InitView() {
        video = (VideoView) findViewById(R.id.videoView);
        play = (Button) findViewById(R.id.btn_play);
        end = (Button) findViewById(R.id.btn_end);
        back = (Button) findViewById(R.id.btn_back);

        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Init();
            }

        });

        end.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                video.stopPlayback();
            }

        });

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                video.stopPlayback();
                Intent intent2 = new Intent(Video.this, Show1.class);
                startActivity(intent2);
            }

        });

    }

    private void Init() {

        String uri = null;
        mediaController = new MediaController(this);
        Intent intent = getIntent();
        String data = intent.getStringExtra("video");
        switch (data){
            case "0":
                uri = "android.resource://" + getPackageName() + "/" + R.raw.box;
                break;
            case "1":
                uri = "android.resource://" + getPackageName() + "/" + R.raw.missing;
                break;
            case "2":
                uri = "android.resource://" + getPackageName() + "/" + R.raw.sy;
                break;
            case "3":
                uri = "android.resource://" + getPackageName() + "/" + R.raw.cssh;
                break;
            case "4":
                uri = "android.resource://" + getPackageName() + "/" + R.raw.aeh;
                break;
            default:
                break;
        }
        video.setVideoURI(Uri.parse(uri));
        video.setMediaController(mediaController);
        mediaController.setMediaPlayer(video);
        video.requestFocus();
        video.start();
    }
}
