package entity;

import java.time.LocalDate;
import java.util.Objects;

public class HoaDon {

    private String maHD;
    private LocalDate ngayLapHD;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    private double tongTien;
    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public HoaDon() {
        super();
        // TODO Auto-generated constructor stub
    }

    public HoaDon(String maHD, LocalDate ngayLapHD, KhachHang khachHang, NhanVien nhanVien, double tongTien) {
        this.maHD = maHD;
        this.ngayLapHD = ngayLapHD;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.tongTien = tongTien;
    }

    

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public LocalDate getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(LocalDate ngayLapHD) throws Exception {
        if (!ngayLapHD.isEqual(LocalDate.now())) {
            throw new Exception("Ngày lập hóa đơn là ngày hiện tại!");
        } else {
            this.ngayLapHD = ngayLapHD;
        }
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.maHD);
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
        final HoaDon other = (HoaDon) obj;
        return Objects.equals(this.maHD, other.maHD);
    }

    public HoaDon(String maHD) {
        this.maHD = maHD;
    }

    @Override
    public String toString() {
        return "HoaDon [maHD=" + maHD + ", ngayLapHD=" + ngayLapHD + ", khachHang=" + khachHang + ", nhanVien="
                + nhanVien + "]";
    }

}
