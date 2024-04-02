package entity;

import java.util.Objects;
import java.util.regex.Pattern;

public class NhanVien {

    private String maNV;
    private String tenNV;
    private Boolean gioiTinh;
    private String CCCD;
    private String SDT;
    private String diaChi;
    private String caLam;
    private LoaiNhanVien loaiNV;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, Boolean gioiTinh, String cCCD, String sDT, String diaChi, String caLam,
                    LoaiNhanVien loaiNV) {
        super();
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        CCCD = cCCD;
        SDT = sDT;
        this.diaChi = diaChi;
        this.caLam = caLam;
        this.loaiNV = loaiNV;
    }

    public NhanVien(String maNV) {
        this.maNV = maNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) throws Exception {
        if (tenNV.trim().isEmpty()) {
            throw new Exception("Tên nhân viên không được rỗng!");
        }
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        if (!pattern.matcher(tenNV).matches()) {
            throw new Exception("Tên nhân viên chỉ được chứa ký tự chữ");
        }
        // tự động viết hoa
        this.tenNV = tenNV.substring(0, 1).toUpperCase() + tenNV.substring(1);

    }

    public Boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String cCCD) throws Exception {
        if (CCCD.trim().isEmpty()) {
            throw new Exception("CCCD không được rỗng!");
        }
        Pattern pattern = Pattern.compile("[0-9]{12}");
        if (!pattern.matcher(CCCD).matches()) {
            throw new Exception("CCCD gồm 12 số!");
        } else {
            this.CCCD = cCCD;
        }
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String sDT) throws Exception {
        if (SDT.trim().isEmpty()) {
            throw new Exception("SDT không được rỗng!");
        }
        Pattern pattern = Pattern.compile("[0-9]{10}");
        if (!pattern.matcher(SDT).matches()) {
            throw new Exception("SDT gồm 10 số!");
        } else {
            SDT = sDT;
        }
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) throws Exception {
        if (diaChi.trim().isEmpty()) {
            throw new Exception("Địa chỉ không được rỗng!");
        }
        this.diaChi = diaChi;
    }

    public String getCaLam() {
        return caLam;
    }

    public void setCaLam(String caLam) {
        this.caLam = caLam;
    }

    public LoaiNhanVien getLoaiNV() {
        return loaiNV;
    }

    public void setLoaiNV(LoaiNhanVien loaiNV) {
        this.loaiNV = loaiNV;
    }

    @Override
    public String toString() {
        return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh + ", CCCD=" + CCCD + ", SDT="
                + SDT + ", diaChi=" + diaChi + ", caLam=" + caLam + ", loaiNV=" + loaiNV + "]";
    }

    public Object[] getObject() {
        return new Object[]{maNV, tenNV, gioiTinh, CCCD, SDT, diaChi, caLam, loaiNV.getMaLoai()};
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.maNV);
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
        final NhanVien other = (NhanVien) obj;
        return Objects.equals(this.maNV, other.maNV);
    }

}
