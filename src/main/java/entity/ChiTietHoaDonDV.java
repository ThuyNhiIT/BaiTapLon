package entity;

import java.util.Objects;

public class ChiTietHoaDonDV  {
	private HoaDon hoaDon;
	private DichVu dichVu;
	private int soLuong;
	private Double gia;
	
	public ChiTietHoaDonDV() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDonDV(HoaDon hoaDon, DichVu dichVu, int soLuong, Double gia) {
		super();
		this.hoaDon = hoaDon;
		this.dichVu = dichVu;
		this.soLuong = soLuong;
		this.gia = gia;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) throws Exception {
		if(soLuong <= 0) {
			throw new Exception("Số lượng không được <= 0!");
		}
		this.soLuong = soLuong;
	}

	public Double getGia() {
		return gia;
	}

	public void setGia(Double gia) throws Exception {
		if(gia <= 0) {
			throw new Exception("Giá không được <= 0!");
		}
		this.gia = gia;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(dichVu, gia, hoaDon, soLuong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDonDV other = (ChiTietHoaDonDV) obj;
		return Objects.equals(dichVu, other.dichVu) && Objects.equals(gia, other.gia)
				&& Objects.equals(hoaDon, other.hoaDon) && soLuong == other.soLuong;
	}
	public Double tinhTienDV() {
		return gia * soLuong ;
	}
	@Override
	public String toString() {
		return "ChiTietHoaDonDV [hoaDon=" + hoaDon + ", dichVu=" + dichVu + ", gia=" + gia + "]";
	}
	
	
}
