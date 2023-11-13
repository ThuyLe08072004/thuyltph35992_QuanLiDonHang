package com.example.thuyltph35992_quanlidonhang.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thuyltph35992_quanlidonhang.DAO.DonHangDAO;
import com.example.thuyltph35992_quanlidonhang.Model.DonHang;
import com.example.thuyltph35992_quanlidonhang.R;


import java.util.ArrayList;

public class DonHangAdapter extends RecyclerView.Adapter<DonHangAdapter.ViewHolder> {
    private final Context context;
    private final ArrayList<DonHang> list;
    DonHangDAO donHangDAO;

    public DonHangAdapter(Context context, ArrayList<DonHang> list) {
        this.context = context;
        this.list = list;
        donHangDAO = new DonHangDAO(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dsdonhang,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DonHang donHang = list.get(position);

        holder.idDonHang.setText(donHang.getIdDH()+"");
        holder.idKhachHang.setText(donHang.getIdKhach()+"");
        holder.idNhanVien.setText(donHang.getIdNV()+"");
        holder.txtNgayMua.setText(donHang.getNgayMua());

        if (donHang.getTrangThai()==1){
            holder.txtTrangThai.setText("Đã thanh toán");
        }else{
            holder.txtTrangThai.setText("Chưa thanh toán");
        }

        holder.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setCancelable(false);
                builder.setTitle("Xóa đơn hàng");
                builder.setMessage("Bạn có muốn xóa không ?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // bắt sự kiện nhấn nút Yes
                        if (donHangDAO.delete(donHang.getIdDH()) > 0) {
                            list.clear();
                            list.addAll(donHangDAO.getALLDonHang());
                            Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                            notifyDataSetChanged();
                        } else {
                            Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // bắt sự kiện nhấn nút No
                    }
                });
                builder.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView idDonHang,idKhachHang,idNhanVien,txtNgayMua,txtTrangThai;
        Button btnThem,btnXem,btnXoa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idDonHang = itemView.findViewById(R.id.idDonHang);
            idKhachHang = itemView.findViewById(R.id.idKhachHang);
            idNhanVien = itemView.findViewById(R.id.idNhanVien);
            txtNgayMua = itemView.findViewById(R.id.txtNgayMua);
            txtTrangThai = itemView.findViewById(R.id.txtTrangThai);
            btnThem = itemView.findViewById(R.id.btnThem);
            btnXem = itemView.findViewById(R.id.btnXem);
            btnXoa = itemView.findViewById(R.id.btnXoa);
        }
    }
}
