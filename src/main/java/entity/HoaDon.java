package entity;

import java.time.LocalDate;
import java.util.Objects;

public class HoaDon{
	private String maHD;
	private LocalDate ngayLapHD;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDon(String maHD, LocalDate ngayLapHD, KhachHang khachHang, NhanVien nhanVien) {
		super();
		this.maHD = maHD;
		this.ngayLapHD = ngayLapHD;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
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
		if(!ngayLapHD.isEqual(LocalDate.now())) {
			throw new Exception("Ngày lập hóa đơn là ngày hiện tại!");
		}
		else
			this.ngayLapHD = ngayLapHD;
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
		return Objects.hash(khachHang, maHD, ngayLapHD, nhanVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(khachHang, other.khachHang) && Objects.equals(maHD, other.maHD)
				&& Objects.equals(ngayLapHD, other.ngayLapHD) && Objects.equals(nhanVien, other.nhanVien);
	}
	
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", ngayLapHD=" + ngayLapHD + ", khachHang=" + khachHang + ", nhanVien="
				+ nhanVien + "]";
	}
	
}
