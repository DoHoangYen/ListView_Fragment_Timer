package com.example.hoangyen.myapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by HoangYen on 12/11/2015.
 */
public class detail_cooking extends bottom_bar {
    private MySQLiteOpenHelper dataHelper;
    private Cursor cursor; // tuong duong voi mang
    private SimpleCursorAdapter adapter; // tuong duong voi adapter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amthuc_detail);
        Intent i = getIntent();//  khoi tao lai intent
        String id = i.getStringExtra("_id");// lay gia tri _id từ intend vua khoi tao

        TextView txtTenMonAn = (TextView) findViewById(R.id.txtTenMonAn);
        TextView txtNguyenLieu = (TextView) findViewById(R.id.txtNguyenLieu);
        TextView txtCachCheBien = (TextView) findViewById(R.id.txtCachCheBien);

        dataHelper = new MySQLiteOpenHelper(detail_cooking.this);
        try {
            dataHelper.createDataBase(); // tao database

        } catch (IOException ioe) {

            throw new Error("Unable to create database");
        }
        dataHelper.openDataBase();
        String sql = "select * from AmThuc where _id="+id+" " ;// cau lenh sql co truyen tham so id

        cursor = dataHelper.SELECTSQL(sql);// thuc hien cau lenh
        if(cursor!=null){
            if  (cursor.moveToFirst()) {// chi lay dong dau tien
                String tenMon = cursor.getString(cursor.getColumnIndex("TenMonAn"));
                String nguyenLieu = cursor.getString(cursor.getColumnIndex("NguyenLieu"));
                String cachCheBien = cursor.getString(cursor.getColumnIndex("CachCheBien"));
                txtTenMonAn.setText(tenMon);
                txtNguyenLieu.setText(nguyenLieu);
                txtCachCheBien.setText(cachCheBien);
            }
        }
        dataHelper.CloseBD();// dong databsase
    }
}
