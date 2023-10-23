package entity;

import java.util.Objects;
import java.util.regex.Pattern;

public class PhongHat {

    private String maPhong;
    private String tenPhong;
    private LoaiPhong loaiPhong;
    private String tinhTrangPhong;

    public PhongHat() {
        super();
        // TODO Auto-generated constructor stub
    }

    public PhongHat(String maPhong) {
        this.maPhong = maPhong;
    }

    public PhongHat(String maPhong, String tenPhong, LoaiPhong loaiPhong, String tinhTrangPhong) {
        super();
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.loaiPhong = loaiPhong;
        this.tinhTrangPhong = tinhTrangPhong;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) throws Exception {
        if (tenPhong.trim().isEmpty()) {
            throw new Exception("Tên phòng không được rỗng!");
        }
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        if (!pattern.matcher(tenPhong).matches()) {
            throw new Exception("Tên phòng chỉ được chứa ký tự chữ");
        }
        // tự động viết hoa
        this.tenPhong = tenPhong.substring(0, 1).toUpperCase() + tenPhong.substring(1);

    }

    public LoaiPhong getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(LoaiPhong loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public String getTinhTrangPhong() {
        return tinhTrangPhong;
    }

    public void setTinhTrangPhong(String tinhTrangPhong) throws Exception {
        if (tinhTrangPhong.trim().isEmpty()) {
            throw new Exception("Tình trạng phòng không được rỗng!");
        }
        this.tinhTrangPhong = tinhTrangPhong;
    }

    @Override
    public int hashCode() {
        return Objects.hash(loaiPhong, maPhong, tenPhong, tinhTrangPhong);
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
        PhongHat other = (PhongHat) obj;
        return Objects.equals(loaiPhong, other.loaiPhong) && Objects.equals(maPhong, other.maPhong)
                && Objects.equals(tenPhong, other.tenPhong) && Objects.equals(tinhTrangPhong, other.tinhTrangPhong);
    }

    @Override
    public String toString() {
        return "PhongHat [maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", loaiPhong=" + loaiPhong
                + ", tinhTrangPhong=" + tinhTrangPhong + "]";
    }

}
