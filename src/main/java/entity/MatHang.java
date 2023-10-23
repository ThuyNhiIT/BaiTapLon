/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author 84343
 *
 */
public class MatHang {

    public MatHang(String maMH, String tenMH, Double gia) {
        this.maMH = maMH;
        this.tenMH = tenMH;
        this.gia = gia;
    }

    private String maMH;
    private String tenMH;
    private Double gia;

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

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        return "MatHang{" + "maMH=" + maMH + ", tenMH=" + tenMH + ", gia=" + gia + '}';
    }

    public MatHang() {
    }

    public MatHang(String maMH) {
        this.maMH = maMH;
    }

}
