package com.example.hoangyen.myapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by HoangYen on 12/5/2015.
 */
public class Menu_list extends Activity {
    ListView lv;
    Context context;

    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.house_icon,
                                     R.drawable.clothing_icon,
                                     R.drawable.cooking_icon,
                                     R.drawable.flower_icon,
                                     R.drawable.heath_icon,
                                     R.drawable.giamcan_icon,
                                     R.drawable.da_icon,
                                     R.drawable.hair_icon,
                                     R.drawable.baby_icon,
                                     R.drawable.cntt_icon,
                                     R.drawable.love_icon};
    public static String [] prgmNameList={"Nhà cửa",
                                            "Quần áo",
                                            "Ẩm thực",
                                            "Cắm hoa",
                                            "Sức khỏe",
                                            "Giảm cân",
                                            "Da đẹp",
                                            "Tóc đẹp",
                                            "Chăm sóc trẻ",
                                            "Công nghệ thông tin",
                                            "Yêu thích"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_menu);
        context=this;
        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, prgmNameList, prgmImages));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(context, list_menu_of_title.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
