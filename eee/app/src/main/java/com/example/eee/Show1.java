package com.example.eee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Show1 extends AppCompatActivity {
    private TextView welcome;
    private Button per,fashion,back,music,movie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);
        welcome = (TextView) this.findViewById(R.id.welcome);
        welcome.setMarqueeRepeatLimit(Integer.MAX_VALUE);
        welcome.setFocusable(true);
        welcome.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        welcome.setSingleLine();
        welcome.setFocusableInTouchMode(true);
        welcome.setHorizontallyScrolling(true);
        per = (Button) this.findViewById(R.id.personal);
        fashion = (Button) this.findViewById(R.id.fashion);
        back = (Button) this.findViewById(R.id.back);
        music = (Button)this.findViewById(R.id.music);
        movie = (Button)this.findViewById(R.id.movie);

        per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Show1.this,Personal1.class);
                startActivity(in);
                finish();
            }
        });

        fashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Show1.this,Fashion1.class);
                startActivity(in);
                finish();
            }
        });
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Show1.this,Music1.class);
                startActivity(in);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Show1.this,MainActivity.class);
                startActivity(in);
                finish();
            }
        });

        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Show1.this,Movie.class);
                startActivity(in);
                finish();
            }
        });

    }
}
