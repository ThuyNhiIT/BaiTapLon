package entity;

import java.util.Objects;

public class ChiTietHoaDonDV {

    private HoaDon hoaDon;



    private MatHang matHang;
    private int soLuong;
    private Double gia;

    public ChiTietHoaDonDV() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ChiTietHoaDonDV(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public ChiTietHoaDonDV(HoaDon hoaDon,MatHang matHang, int soLuong, Double gia) {
        super();
        this.hoaDon = hoaDon;
        this.matHang = matHang;

        this.soLuong = soLuong;
        this.gia = gia;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }
    public MatHang getMatHang() {
        return matHang;
    }

    public void setMatHang(MatHang matHang) {
        this.matHang = matHang;
    }


    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) throws Exception {
        if (soLuong <= 0) {
            throw new Exception("Số lượng không được <= 0!");
        }
        this.soLuong = soLuong;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) throws Exception {
        if (gia <= 0) {
            throw new Exception("Giá không được <= 0!");
        }
        this.gia = gia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.hoaDon);
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
        final ChiTietHoaDonDV other = (ChiTietHoaDonDV) obj;
        return Objects.equals(this.hoaDon, other.hoaDon);
    }

    public Double tinhTienDV() {
        return gia * soLuong;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDonDV{" + "hoaDon=" + hoaDon + ", matHang=" + matHang + ", soLuong=" + soLuong + ", gia=" + gia + '}';
    }

}
