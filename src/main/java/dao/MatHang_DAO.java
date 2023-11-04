package dao;

import connectDB.ConnectDB;
import entity.MatHang;
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
public class MatHang_DAO {

    ArrayList<MatHang> dsmh;
    MatHang mh;
    private Statement statement;

    public MatHang_DAO() {
        dsmh = new ArrayList<MatHang>();
        mh = new MatHang();
    }

    public ArrayList<MatHang> docTuBang() throws SQLException {
        try {
            ConnectDB db = ConnectDB.getInstance();
            db.connect();
            Connection con = db.getConnection();
            String sql = "Select *from MatHang";
            statement = con.createStatement();

            // Thực thi câu lệnh SQL trả về đối tượng ResultSet
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String maMH = rs.getString(1);
                String tenMH = rs.getString(2);
                Double gia = rs.getDouble(3);
                Boolean trangThai = rs.getBoolean(4);
                MatHang mh = new MatHang(maMH, tenMH, gia, trangThai);
                dsmh.add(mh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsmh;

    }
// Thêm mặt hàng

    public boolean createMH(MatHang mh) {
        ConnectDB db = ConnectDB.getInstance();
        Connection con = db.getConnection();
        PreparedStatement stmt = null;
        int n = 0;

        try {
            stmt = con.prepareStatement("insert into" + "MatHang(maMH, tenMH, SDT, tinhTrang) values (?, ?, ?, ?)");
            stmt.setString(1, mh.getMaMH());
            stmt.setString(2, mh.getTenMH());
            stmt.setDouble(3, mh.getGia());
            stmt.setBoolean(4, mh.isTrangThai());
            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return n > 0;
    }

    // Xóa mặt hàng
    public boolean xoaMH(String maMH) {
        ConnectDB db = ConnectDB.getInstance();
        Connection con = db.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("Delete MatHang from MatHang where maMH =?");
            stmt.setString(1, maMH);
            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n > 0;
    }

//    Tìm mặt hành 
    public MatHang timKiem(String maTim) {
        MatHang mh = null;
        ConnectDB db = ConnectDB.getInstance();
        Connection con = db.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "Select *from MatHang where maMH=?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maTim);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String maMH = rs.getString(1);
                String tenMH = rs.getString(2);
                Double gia = rs.getDouble(3);
                Boolean tinhTrang = rs.getBoolean(4);
                mh = new MatHang(maMH, tenMH, gia, tinhTrang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mh;
    }

    // Sửa mặt hàng
    public boolean update(MatHang mh) {
        ConnectDB db = ConnectDB.getInstance();
        Connection con = db.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("update " + "MatHang set TenMH=?, gia=?,trangThai=? where maMH=?");

            stmt.setString(1, mh.getTenMH());
            stmt.setDouble(2, mh.getGia());
            stmt.setBoolean(3, mh.isTrangThai());
            stmt.setString(4, mh.getMaMH());
            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n > 0;
    }

}
