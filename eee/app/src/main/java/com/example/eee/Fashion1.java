package com.example.eee;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class Fashion1 extends AppCompatActivity {
    Button last1,next1,back;
    TextView t;
    ImageView img;
    int num=0;
    int []image={R.drawable.prm,R.drawable.prada,R.drawable.to};
    String title[]={"Parma","Prada","Tommy Hilfiger"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fashion);
        last1=(Button)findViewById(R.id.last1);
        next1=(Button)findViewById(R.id.next1);
        back=(Button)findViewById(R.id.back);
        img=(ImageView)findViewById(R.id.img);
        t=(TextView)findViewById(R.id.title);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Fashion1.this, Show1.class);
                startActivity(in);
                finish();
            }
        });
        next1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                num++;
                img.setImageResource(image[num]);
                t.setText(title[num]);

                if(num==2){
                    next1.setClickable(false);

                }
                last1.setClickable(true);
            }
        });

        last1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                num--;
                if(num>=0){
                    img.setImageResource(image[num]);
                    t.setText(title[num]);
                }
                if(num<0){
                    if(num<0){
                        last1.setClickable(false);

                    }
                }
                next1.setClickable(true);

            }
        });


    }
}
