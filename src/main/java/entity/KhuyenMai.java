package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class KhuyenMai {

    private String maKM;
    private String moTa;
    private LocalDate gioBatDau;
    private LocalDate gioKetThuc;
    private Double phanTram;

    public KhuyenMai(String maKM, String moTa, LocalDate gioBatDau, LocalDate gioKetThuc, Double phanTram) {
        this.maKM = maKM;
        this.moTa = moTa;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
        this.phanTram = phanTram;
    }

    public KhuyenMai() {
    }

    public KhuyenMai(String maKM) {
        this.maKM = maKM;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public LocalDate getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(LocalDate gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public LocalDate getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(LocalDate gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public Double getPhanTram() {
        return phanTram;
    }

    public void setPhanTram(Double phanTram) {
        this.phanTram = phanTram;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.maKM);
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
        final KhuyenMai other = (KhuyenMai) obj;
        return Objects.equals(this.maKM, other.maKM);
    }

}
