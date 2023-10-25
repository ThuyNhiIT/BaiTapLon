/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author 84343
 */
public class MatHang {

    private String maMH;
    private String tenMH;
    private double gia;
    private boolean trangThai;

    public MatHang(String maMH, String tenMH, double gia, boolean trangThai) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.gia = gia;
        this.trangThai = trangThai;
    }

    public MatHang(String maMH) {
        this.maMH = maMH;
    }

    public MatHang() {
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.maMH);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MatHang other = (MatHang) obj;
        return Objects.equals(this.maMH, other.maMH);
    }

    @Override
    public String toString() {
        return "MatHang{" + "maMH=" + maMH + ", tenMH=" + tenMH + ", gia=" + gia + ", trangThai=" + trangThai + '}';
    }

}
