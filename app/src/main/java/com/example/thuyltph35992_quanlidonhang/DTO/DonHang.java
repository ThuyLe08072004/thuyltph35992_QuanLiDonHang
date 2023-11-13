package com.example.thuyltph35992_quanlidonhang.DTO;

public class DonHang {
    private  int idDH;

    private  int idKhach;
    private  int idNV;
    private  String ngayMua;
    private  int trangThai;

    public DonHang() {
    }

    public DonHang(int idKhach, int idNV, String ngayMua, int trangThai) {
        this.idKhach = idKhach;
        this.idNV = idNV;
        this.ngayMua = ngayMua;
        this.trangThai = trangThai;
    }

    public int getIdDH() {
        return idDH;
    }

    public void setIdDH(int idDH) {
        this.idDH = idDH;
    }

    public int getIdKhach() {
        return idKhach;
    }

    public void setIdKhach(int idKhach) {
        this.idKhach = idKhach;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
