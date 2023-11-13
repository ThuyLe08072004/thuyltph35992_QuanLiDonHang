package com.example.thuyltph35992_quanlidonhang.DTO;

public class SanPham {
    private  int idSP;
    private  String tenSp;
    private  int Gia;
    private int idHangSX;

    public SanPham() {
    }

    public SanPham(String tenSp, int gia, int idHangSX) {
        this.tenSp = tenSp;
        Gia = gia;
        this.idHangSX = idHangSX;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }

    public int getIdHangSX() {
        return idHangSX;
    }

    public void setIdHangSX(int idHangSX) {
        this.idHangSX = idHangSX;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "idSP=" + idSP +
                ", tenSp='" + tenSp + '\'' +
                ", Gia=" + Gia +
                ", idHangSX=" + idHangSX +
                '}';
    }
}
