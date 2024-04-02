package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class DonDatPhong {

    private String maDonDatPhong;
    private LocalDateTime ngayDat;
    private LocalDateTime ngayNhan;
    private PhongHat phongHat;
    private KhachHang khachHang;

    public DonDatPhong() {
        super();
        // TODO Auto-generated constructor stub
    }

    public DonDatPhong(String maDonDatPhong, LocalDateTime ngayDat, LocalDateTime ngayNhan, PhongHat phongHat,
                       KhachHang khachHang) {
        super();
        this.maDonDatPhong = maDonDatPhong;
        this.ngayDat = ngayDat;
        this.ngayNhan = ngayNhan;
        this.phongHat = phongHat;
        this.khachHang = khachHang;
    }

    public DonDatPhong(String maDonDatPhong) {
        this.maDonDatPhong = maDonDatPhong;
    }

    public String getMaDonDatPhong() {
        return maDonDatPhong;
    }

    public void setMaDonDatPhong(String maDonDatPhong) {
        this.maDonDatPhong = maDonDatPhong;
    }

    public LocalDateTime getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(LocalDateTime ngayDat) throws Exception {
        if (ngayDat.compareTo(LocalDateTime.now()) != 0 && ngayDat.isBefore(LocalDateTime.now())) {
            throw new Exception("Ngày đặt phải bằng hoặc sau ngày hiện tại!");
        } else {
            this.ngayDat = ngayDat;
        }
    }

    public LocalDateTime getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(LocalDateTime ngayNhan) throws Exception {
        if (ngayNhan != ngayDat) {
            throw new Exception("Ngày nhận bằng ngày đặt!");
        } else {
            this.ngayNhan = ngayNhan;
        }
    }

    public PhongHat getPhongHat() {
        return phongHat;
    }

    public void setPhongHat(PhongHat phongHat) {
        this.phongHat = phongHat;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.maDonDatPhong);
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
        final DonDatPhong other = (DonDatPhong) obj;
        return Objects.equals(this.maDonDatPhong, other.maDonDatPhong);
    }

    @Override
    public String toString() {
        return "DonDatPhong [maDonDatPhong=" + maDonDatPhong + ", ngayDat=" + ngayDat + ", ngayNhan=" + ngayNhan
                + ", phongHat=" + phongHat + ", khachHang=" + khachHang + "]";
    }

}
