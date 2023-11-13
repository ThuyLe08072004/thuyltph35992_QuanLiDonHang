package com.example.thuyltph35992_quanlidonhang.Model;

public class DonHangChiTiet {
    private int idDH;
    private  String tenSP;
    private int soLuong;
    private int giaMua;

    public DonHangChiTiet() {
    }

    public DonHangChiTiet(String tenSP, int soLuong, int giaMua) {
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.giaMua = giaMua;
    }

    public int getIdDH() {
        return idDH;
    }

    public void setIdDH(int idDH) {
        this.idDH = idDH;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(int giaMua) {
        this.giaMua = giaMua;
    }
}
