package dao;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiNhanVien;
import entity.NhanVien;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author HO MINH HAU
 */
public class HoaDon_DAO {

    public HoaDon_DAO() {

    }

    public ArrayList<HoaDon> getalltbHoaDon() {
        ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT *FROM HoaDon";
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString(1);
                java.sql.Date ngayLapHD_sql = rs.getDate(2);
                LocalDate ngayLapHD = ngayLapHD_sql.toLocalDate();
                String maKH = rs.getString(3);
                String maNV = rs.getString(4);
                double tongTien = rs.getDouble(5);

                HoaDon hd = new HoaDon(maHD, ngayLapHD, new KhachHang(maKH), new NhanVien(maNV), tongTien);
                dsHD.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHD;
    }

    public boolean createHoaDon(HoaDon hd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("INSERT INTO HoaDon VALUES (?, ?, ?, ?, ? )");
            stmt.setString(1, hd.getMaHD());
            stmt.setDate(2, java.sql.Date.valueOf(hd.getNgayLapHD()));
            stmt.setString(3, hd.getKhachHang().getMaKH());
            stmt.setString(4, hd.getNhanVien().getMaNV());
            stmt.setDouble(5, hd.getTongTien());

            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }
    public static final String TABLE_NAME = "HoaDon";
    public static final String COLUMN_SO_LUONG = "SoLuong";
    public static final String COLUMN_SO_LUONG_HOA_DON = "SoLuongHoaDon";

    public int getSoLuongHoaDon() {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "SELECT COUNT(*) AS SoLuongHoaDon FROM " + TABLE_NAME;
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(COLUMN_SO_LUONG_HOA_DON);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
