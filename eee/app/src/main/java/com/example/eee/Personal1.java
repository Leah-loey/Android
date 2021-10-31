package com.example.eee;

import android.content.Intent;
import android.os.Bundle;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class Personal1 extends AppCompatActivity {
    ImageView img;
    TextView wb,ins;
    Button last;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal);
        img=(ImageView)findViewById(R.id.i1);
        wb=(TextView) findViewById(R.id.wb);
        ins=(TextView)findViewById(R.id.ins);
        last=(Button)findViewById(R.id.last);

        wb.setText(Html.fromHtml("         微博<a href='https://weibo.com/u/5675411775'>@real_ _pcyyy</a>"));
        wb.setMovementMethod(LinkMovementMethod.getInstance());
        ins.setText(Html.fromHtml("         Instagram<a href='https://weibo.com/u/5675411775'>@real_ _pcy</a>"));
        ins.setMovementMethod(LinkMovementMethod.getInstance());
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Personal1.this, Show1.class);
                startActivity(in);
                finish();
            }
        });

    }
}
