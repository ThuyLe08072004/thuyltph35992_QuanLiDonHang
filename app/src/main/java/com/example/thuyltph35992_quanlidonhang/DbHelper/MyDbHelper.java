package com.example.thuyltph35992_quanlidonhang.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

public class MyDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Qlidonhang";
    private static final int DB_VERSION = 1;

    public MyDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tableDonHang = "CREATE TABLE DonHang (" +
                "idDH INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idKhach INTEGER NOT NULL," +
                "idNV INTEGER NOT NULL," +
                "ngayMua TEXT NOT NULL," +
                "trangThai INTEGER NOT NULL" +
                ");";

        String tableSanPham = "CREATE TABLE SanPham (" +
                "idSP INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tenSP TEXT NOT NULL," +
                "GiaSP INTEGER NOT NULL," +
                "idHang INTEGER NOT NULL" +
                ");";
        String tableDonHangChiTiet = "CREATE TABLE DHChiTiet (" +
                "idDH INTEGER REFERENCES DonHang (idDH)," +
                "idSP INTEGER NOT NULL REFERENCES SanPham (idSP)," +
                "soLuong TEXT NOT NULL," +
                "Gia TEXT NOT NULL" +
                ");";
        sqLiteDatabase.execSQL(tableDonHang);
        sqLiteDatabase.execSQL(tableSanPham);
        sqLiteDatabase.execSQL(tableDonHangChiTiet);
        String dataDonHang = "INSERT INTO DonHang VALUES" +
                "(1,9,5,'22-12-2023',1)," +
                "(2,6,9,'11-11-2023',0)";
        String dataSanPham = "INSERT INTO SanPham VALUES" +
                "(1,'May giat',20000000,4)," +
                "(2,'tu lanh',30000000,6)";
        String dataDonHangChiTiet = "INSERT INTO DHChiTiet VALUES" +
                "(1,2,3,100000000)," +
                "(2,3,6,900000000)";
        sqLiteDatabase.execSQL(dataDonHang);
        sqLiteDatabase.execSQL(dataDonHangChiTiet);
        sqLiteDatabase.execSQL(dataSanPham);
    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase db, int i, int i1) {
        String dropTable = "DROP TABLE IF EXISTS DonHang";
        db.execSQL(dropTable);

        String dropTable1 = "DROP TABLE IF EXISTS SanPham";
        db.execSQL(dropTable1);

        String dropTable2 = "DROP TABLE IF EXISTS DHChiTiet";
        db.execSQL(dropTable2);
        onCreate(db);

    }
}
