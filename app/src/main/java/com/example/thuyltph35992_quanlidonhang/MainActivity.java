package com.example.thuyltph35992_quanlidonhang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.thuyltph35992_quanlidonhang.Adapter.DonHangAdapter;
import com.example.thuyltph35992_quanlidonhang.DAO.DonHangDAO;
import com.example.thuyltph35992_quanlidonhang.Model.DonHang;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView danhsach;
    DonHangDAO donHangDAO;
    ArrayList<DonHang> list;
    DonHangAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        danhsach = findViewById(R.id.danhsach);
        donHangDAO = new DonHangDAO(this);
        list = donHangDAO.getALLDonHang();
        adapter = new DonHangAdapter(this,list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        danhsach.setLayoutManager(linearLayoutManager);
        danhsach.setAdapter(adapter);
    }
}