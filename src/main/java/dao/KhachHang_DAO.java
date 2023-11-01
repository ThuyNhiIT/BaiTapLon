package dao;

import connectDB.ConnectDB;
import entity.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 84343
 */
public class KhachHang_DAO {

    ArrayList<KhachHang> dskh;
    KhachHang kh;
    private Statement statement;

    public KhachHang_DAO() {
        dskh = new ArrayList<KhachHang>();
        kh = new KhachHang();
    }

    public ArrayList<KhachHang> docTuBang() throws SQLException {
        try {
            ConnectDB db = ConnectDB.getInstance();
            db.connect();
            Connection con = db.getConnection();
            String sql = "Select *from KhachHang";
            statement = con.createStatement();

            // Thực thi câu lệnh SQL trả về đối tượng ResultSet
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String maKH = rs.getString(1);
                String tenKH = rs.getString(2);
                String sdt = rs.getString(3);
                Boolean gioiTinh = rs.getBoolean(4);
                KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh);
                dskh.add(kh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dskh;

    }
// Thêm khách hàng

    public boolean createKH(KhachHang kh) {
        ConnectDB db = ConnectDB.getInstance();
        Connection con = db.getConnection();
        PreparedStatement stmt = null;
        int n = 0;

        try {
            stmt = con.prepareStatement("insert into" + "KhachHang(maKH, tenKH, SDT, gioiTinh) values (?, ?, ?, ?)");
            stmt.setString(1, kh.getMaKH());
            stmt.setString(2, kh.getTenKH());
            stmt.setString(3, kh.getSdt());
            stmt.setBoolean(4, kh.isGioitinh());
            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return n > 0;
    }

    // Xóa khách hàng
    public boolean xoaKH(String maKH) {
        ConnectDB db = ConnectDB.getInstance();
        Connection con = db.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("Delete KhachHang from KhachHang where maKH =?");
            stmt.setString(1, maKH);
            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n > 0;
    }

//    Tìm khách hành 
    public KhachHang timKiem(String maTim) {
        KhachHang kh = null;
        ConnectDB db = ConnectDB.getInstance();
        Connection con = db.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "Select *from KhachHang where maKH=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maTim);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString(1);
                String tenKH = rs.getString(2);
                String sdt = rs.getString(3);
                Boolean gioiTinh = rs.getBoolean(4);
                kh = new KhachHang(maKH, tenKH, sdt, gioiTinh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }

    // Sửa khách hàng
    public boolean update(KhachHang kh) {
        ConnectDB db = ConnectDB.getInstance();
        Connection con = db.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("update " + "KhachHang set TenKH=?, SDT=?,gioiTinh=? where maKH=?");

            stmt.setString(1, kh.getTenKH());
            stmt.setString(2, kh.getSdt());
            stmt.setBoolean(3, kh.isGioitinh());
            stmt.setString(4, kh.getMaKH());
            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n > 0;
    }

}
