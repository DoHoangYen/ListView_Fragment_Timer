package com.example.hoangyen.myapp;

/**
 * Created by HoangYen on 12/8/2015.
 */
public class AmThuc {
    public String TenMonAn;
    public String HinhAnh;
    public String CachCheBien;

    public AmThuc() {
        super();
    }

    public AmThuc(String tenMonAn, String cachCheBien, String hinhAnh) {
        super();
        TenMonAn = tenMonAn;
        CachCheBien = cachCheBien;
        HinhAnh = hinhAnh;
    }

    public String getTenMonAn() {
        return TenMonAn;
    }

    public void setLesson(String tenMonAn) {
        TenMonAn = tenMonAn;
    }

    public String getCachCheBient() {
        return CachCheBien;
    }

    public void setContent(String cachCheBien) {
        CachCheBien = cachCheBien;
    }
    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }
}