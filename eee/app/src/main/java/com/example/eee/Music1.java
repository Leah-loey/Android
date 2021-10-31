package com.example.eee;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Music1 extends AppCompatActivity implements View.OnClickListener {
    ImageButton next, last,play,stop;
    Button back;
    ImageView img;
    TextView n,s;
    String[] name = new String[] { "Tomrrow","Break the box","Bad Girl","Faded","Freal luv",
            "Ocean View","stay with me", "go away go away", "问候（Anbu)","Confession","Yours"};
    String[] singer = new String[] { "CHANYEOL","CHANYEOL","灿烈xHenry","灿烈xDevine Channel xLoopy",
            "灿烈xFar East Movement","灿烈xRothy","朴灿烈×Punch","朴灿烈×Punch", "朴灿烈x李仙姬","灿烈x艺声","灿烈xRaidenxCHANGMOx李遐怡"};
    int []image={R.drawable.tomorrow,R.drawable.box,R.drawable.bad,R.drawable.faded,R.drawable.freal,
            R.drawable.oce,R.drawable.stay,R.drawable.goaway,R.drawable.anbu,R.drawable.com,R.drawable.yours};
    private int photoIndex = 0;
    private int maxIndex = 10;
    private MediaPlayer mediaPlayer = new MediaPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music1);
        next= (ImageButton)this.findViewById(R.id.next);
        last=(ImageButton)this.findViewById(R.id.last);
        play=(ImageButton)this.findViewById(R.id.play);
        stop=(ImageButton)this.findViewById(R.id.stop);
        back=(Button)findViewById(R.id.back);
        img=(ImageView)this.findViewById(R.id.img);
        n=(TextView)this.findViewById(R.id.name);
        s=(TextView)this.findViewById(R.id.singer);

        next.setOnClickListener(this);
        last.setOnClickListener(this);
        play.setOnClickListener(this);
        stop.setOnClickListener(this);
        back.setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(Music1.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Music1.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            initMediaPlayer();
        }

    }

    private void initMediaPlayer() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "Rhythm After Summer.mp3");
            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.setLooping(true);
            mediaPlayer.prepare();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    initMediaPlayer();
                }else{
                    Toast.makeText(this, "拒绝权限，将无法使用!", Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
            default:
        }

    }


    @Override
    public void onClick(View v) {
        Bundle b = new Bundle ();
        switch (v.getId()) {


            case R.id.last:
                if (photoIndex == 0) {
                    photoIndex = maxIndex;
                } else {
                    photoIndex = photoIndex - 1;
                }

                break;
            case R.id.next:
                if (photoIndex == maxIndex) {
                    photoIndex = 0;
                } else {

                    photoIndex = photoIndex + 1;
                }

                break;

            case R.id.play:
                if(!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                }
            case R.id.stop:
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.reset();
                    initMediaPlayer();
                }

                break;
            case R.id.back:
                Intent in = new Intent(Music1.this,Show1.class);
                startActivity(in);
                finish();

                break;
            default:
                break;

        }
        img.setImageResource(image[photoIndex]);
        s.setText(singer[photoIndex]);
        n.setText(name[photoIndex]);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

}
