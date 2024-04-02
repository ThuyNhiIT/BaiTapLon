package entity;

import java.util.Objects;

public class LoaiNhanVien {

    private String maLoai;
    private String tenLoai;

    public LoaiNhanVien() {
        super();
        // TODO Auto-generated constructor stub
    }

    public LoaiNhanVien(String maLoai) {
        this.maLoai = maLoai;
    }

    public LoaiNhanVien(String maLoai, String tenLoai) {
        super();
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) throws Exception {
        if (tenLoai.trim().isEmpty()) {
            throw new Exception("Tên loại không được rỗng!");
        }
        this.tenLoai = tenLoai;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maLoai);
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
        LoaiNhanVien other = (LoaiNhanVien) obj;
        return Objects.equals(maLoai, other.maLoai);
    }

    @Override
    public String toString() {
        return maLoai;
    }


}
