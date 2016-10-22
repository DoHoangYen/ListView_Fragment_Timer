package com.example.hoangyen.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by HoangYen on 12/11/2015.
 */
public class bottom_bar extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottombar_layout);

        ImageView Home = (ImageView) findViewById(R.id.Home);
        ImageView Like = (ImageView) findViewById(R.id.Like);
        ImageView Search = (ImageView) findViewById(R.id.Search);

        Home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Menu_list.class);
                startActivity(intent);
            }
        });

        Like.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Menu_list.class);
                startActivity(intent);
            }
        });

        Search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Menu_list.class);
                startActivity(intent);
            }
        });
    }
}
