package com.example.thuyltph35992_quanlidonhang.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDbHelper extends SQLiteOpenHelper {
    private static final
String DB_NAME="Qlidonhang";
    private static final
    int DB_VERSION=1;
public MyDbHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tableDonHang="CREATE TABLE DonHang (" +
                "    idDH      INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idKhach  INTERGER NOT NULL,"+
                "idNV  INTERGER NOT NULL,"+
                "    ngayMua   TEXT    NOT NULL," +
                "    trangThai TEXT    NOT NULL" +
                ");";

        String tableSanPham="CREATE TABLE SanPham (" +
                "    idSP   INTEGER PRIMARY KEY AUTOINCREMENT," +
                "    tenSP  TEXT    NOT NULL," +
                "    GiaSP    TEXT    NOT NULL," +
                "    idHang INTEGER NOT NULL" +
                ");";
        String tableDonHangChiTiet="CREATE TABLE DHChiTiet (" +
        "    idDH    INTEGER REFERENCES DonHang (idDH)," +
        "    idSP    INTEGER NOT NULL" +
        "                    REFERENCES SanPham (idSP)," +
        "    soLuong TEXT    NOT NULL," +
        "    Gia     TEXT    NOT NULL" +
        ");";
        sqLiteDatabase.execSQL(tableDonHang);
        sqLiteDatabase.execSQL(tableSanPham);
        sqLiteDatabase.execSQL(tableDonHangChiTiet);
        String dataDonHang = "INSERT INTO tableDonHang VALUES" +
                "(1,4,5,'22-12-2023',1)" +
                "(1,6,9,'11-11-2023',0)";
        String dataSanPham="INSERT INTO tableSanPham VALUES" +
                "(1,'May giat',20000000,4)" +
                "(2,'tu lanh',30000000,6)";
        String dataDonHangChiTiet  ="INSERT INTO tableDonHangChiTiet VALUES" +
                "(1,2,3,100000000)" +
                "(2,3,6,900000000)";
        sqLiteDatabase.execSQL(dataDonHang);
        sqLiteDatabase.execSQL(dataDonHangChiTiet);
        sqLiteDatabase.execSQL(dataSanPham);
}
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
if(i!=i1){
    sqLiteDatabase.execSQL("");
}

    }
}
