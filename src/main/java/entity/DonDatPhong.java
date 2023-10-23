package entity;

import java.time.LocalDate;
import java.util.Objects;

public class DonDatPhong {
	private String maDonDatPhong;
	private LocalDate ngayDat;
	private LocalDate ngayNhan;
	private PhongHat phongHat;
	private KhachHang khachHang;
	
	public DonDatPhong() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DonDatPhong(String maDonDatPhong, LocalDate ngayDat, LocalDate ngayNhan, PhongHat phongHat,
			KhachHang khachHang) {
		super();
		this.maDonDatPhong = maDonDatPhong;
		this.ngayDat = ngayDat;
		this.ngayNhan = ngayNhan;
		this.phongHat = phongHat;
		this.khachHang = khachHang;
	}

	public String getMaDonDatPhong() {
		return maDonDatPhong;
	}

	public void setMaDonDatPhong(String maDonDatPhong) {
		this.maDonDatPhong = maDonDatPhong;
	}

	public LocalDate getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(LocalDate ngayDat) throws Exception {
		if(ngayDat.compareTo(LocalDate.now()) != 0 && ngayDat.isBefore(LocalDate.now())) {
			throw new Exception("Ngày đặt phải bằng hoặc sau ngày hiện tại!");
		}
		else
		this.ngayDat = ngayDat;
	}

	public LocalDate getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(LocalDate ngayNhan) throws Exception {
		if(ngayNhan != ngayDat) {
			throw new Exception("Ngày nhận bằng ngày đặt!");
		}
		else
		this.ngayNhan = ngayNhan;
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
		return Objects.hash(khachHang, maDonDatPhong, ngayDat, ngayNhan, phongHat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonDatPhong other = (DonDatPhong) obj;
		return Objects.equals(khachHang, other.khachHang) && Objects.equals(maDonDatPhong, other.maDonDatPhong)
				&& Objects.equals(ngayDat, other.ngayDat) && Objects.equals(ngayNhan, other.ngayNhan)
				&& Objects.equals(phongHat, other.phongHat);
	}

	@Override
	public String toString() {
		return "DonDatPhong [maDonDatPhong=" + maDonDatPhong + ", ngayDat=" + ngayDat + ", ngayNhan=" + ngayNhan
				+ ", phongHat=" + phongHat + ", khachHang=" + khachHang + "]";
	}
	
	
}
