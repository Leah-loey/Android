package com.example.eee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Movie extends AppCompatActivity {
     private  ListView mListView;
     private  String[] mnames = {"The Box", "missing9", "所以...和黑粉结婚了", "长寿商会", "阿尔罕布拉宫的回忆"};
     private  String[] names = {"饰：智勋", "饰：李烈", "饰：后准", "饰：珉盛", "饰：郑世珠"};
     private  int[] icons = {R.drawable.thebox, R.drawable.missing, R.drawable.sy, R.drawable.cssh, R.drawable.thebox};


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie);
        mListView = (ListView) findViewById(R.id.lv);

        MyBaseAdapter mAdapter = new MyBaseAdapter();//创建一个适配器的实例
        mListView.setAdapter(mAdapter);//设置适配器

    }


    class MyBaseAdapter extends BaseAdapter{

            public int getCount() {
                return names.length;
            }

            public Object getItem(int position){
                return names[position];

            }
            public long getItemId(int position) {
                return position;

            }

            public View getView(final int position, View convertView, ViewGroup parent) {

                View view = View.inflate(Movie.this, R.layout.movie_item , null);

                TextView mTextView = (TextView) view.findViewById(R.id.item_tv);

                mTextView.setText(mnames[position]);

                ImageView mImageView = (ImageView) view.findViewById(R.id.item_image);

                mImageView.setBackgroundResource(icons[position]);

                TextView mTextView1 = (TextView) view.findViewById(R.id.item_name);

                mTextView1.setText(names[position]);

                view.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Movie.this, Video.class);
                        switch (position){
                            case 0:
                                intent.putExtra("video", "0");
                                break;
                            case 1:
                                intent.putExtra("video", "1");
                                break;
                            case 2:
                                intent.putExtra("video", "2");
                                break;
                            case 3:
                                intent.putExtra("video", "3");
                                break;
                            case 4:
                                intent.putExtra("video", "4");
                                break;
                            default:
                                break;
                        }
                        startActivity(intent);
                    }
                });
                return view;
            }
        }
}