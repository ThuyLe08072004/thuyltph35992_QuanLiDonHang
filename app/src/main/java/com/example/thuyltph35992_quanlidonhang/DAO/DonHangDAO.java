package com.example.thuyltph35992_quanlidonhang.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thuyltph35992_quanlidonhang.Model.DonHang;
import com.example.thuyltph35992_quanlidonhang.DbHelper.MyDbHelper;

import java.util.ArrayList;

public class DonHangDAO {
    private MyDbHelper dbHelper;
    SQLiteDatabase database;

    public DonHangDAO(Context context) {
        this.dbHelper = dbHelper;
    }
    public ArrayList<DonHang>getALLDonHang(){
     ArrayList<DonHang> list=new ArrayList<>();
     database=dbHelper.getReadableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM tableDonHang",null);
        while (c.moveToNext()){
            DonHang donHang= new DonHang(
                    c.getInt(1),
                    c.getInt(2),
                    c.getString(3),
                    c.getInt(4)
            );
            donHang.setIdDH(c.getInt(0));
            list.add(donHang);
        }
        return list;
    }
    public long addDH(DonHang donHang){
        database=dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("idKhach",donHang.getIdKhach());
        values.put("idNV",donHang.getIdNV());
        values.put("ngayMua",donHang.getNgayMua());
        values.put("trangThai",donHang.getTrangThai());
        return database.insert("tableDonHang",null,values);
    }
    public long delete(int id){
        database = dbHelper.getWritableDatabase();
        return database.delete("tableDonHang","idDH=?",new String[]{String.valueOf(id)});
    }

}
