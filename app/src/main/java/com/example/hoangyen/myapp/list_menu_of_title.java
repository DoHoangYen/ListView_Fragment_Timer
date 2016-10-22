package com.example.hoangyen.myapp;

/**
 * Created by HoangYen on 12/8/2015.
 */
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class list_menu_of_title extends ListActivity {

    private MySQLiteOpenHelper dataHelper;
    private Cursor cursor; // tuong duong voi mang
    private SimpleCursorAdapter adapter; // tuong duong voi adapter
    String tenmonan;
    String hinhanh;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_of_title);
        dataHelper = new MySQLiteOpenHelper(list_menu_of_title.this);// khoi tao MySQLiteOpenHelper
        try {
            dataHelper.createDataBase();// tao database

        } catch (IOException ioe) {

            throw new Error("Unable to create database");
        }
        try {
            dataHelper.openDataBase();// mo database

        }catch(SQLException sqle){
            throw sqle;
        }
        String sql = "select * from AmThuc" ;
        //Log.d(TAG, sql);

        cursor = dataHelper.SELECTSQL(sql);
        while (cursor.moveToNext()) {// chay tu dong trong cursor
            String id = cursor.getString(cursor
                    .getColumnIndex(MySQLiteOpenHelper.CL_id)); // gan gai tri id bang cach lay gia tri cot CL_id trong cursor
            tenmonan = cursor.getString(cursor
                    .getColumnIndex(MySQLiteOpenHelper.CL_TenMonAn));
           hinhanh = cursor.getString(cursor
                    .getColumnIndex(MySQLiteOpenHelper.CL_HinhAnh));

        }
        dataHelper.CloseBD();// dong database
        //khoi tao adater
        //imgPhoto.setImageURI(Uri.parse("android.resource://drawable//background_menu.jpg"));
        //String url ="https://lh3.googleusercontent.com/-40A1N2kiENU/Vm5fsQVoBcI/AAAAAAAAACE/BFrJdN7yqGc/s576-Ic42/B%2525C3%2525A1nh_x%2525C3%2525A8o_with_n%2525C6%2525B0%2525E1%2525BB%25259Bc_m%2525E1%2525BA%2525AFm.jpg";
        String[] from = { MySQLiteOpenHelper.CL_id, MySQLiteOpenHelper.CL_TenMonAn};
        int[] to = { R.id.txtid, R.id.txt1};
        adapter = new SimpleCursorAdapter(list_menu_of_title.this,R.layout.list_item_layout, cursor, from, to);
        //set adapter cho listview
        img = (ImageView) findViewById((R.id.imgMonAn));
        Picasso.with(this)
                .load(hinhanh)
                .centerCrop()
                .into(img);
        setListAdapter(adapter);

        ListView lstSub = (ListView) findViewById(android.R.id.list);
        lstSub.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(getApplicationContext(), detail_cooking.class);
                intent.putExtra("_id", String.valueOf(id));
                startActivity(intent);
            }
        });
    }

}