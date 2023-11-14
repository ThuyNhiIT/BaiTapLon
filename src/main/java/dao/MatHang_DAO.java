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

    private ArrayList<MatHang> ls;

    public MatHang_DAO() {
        ls = new ArrayList<>();
    }

    public ArrayList<MatHang> getalltbMatHang() {
        ArrayList<MatHang> dsmh = new ArrayList<MatHang>();
        try {
            ConnectDB db = ConnectDB.getInstance();
            db.connect();
            Connection con = db.getConnection();
            String sql = "SELECT *FROM MatHang";
            Statement statement = con.createStatement();

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

    public int traVeViTri(MatHang mh) {
        return ls.indexOf(mh);
    }

    public ArrayList<MatHang> getMatHangTheoMaMH(String id) {
        ArrayList<MatHang> dsmh = new ArrayList<MatHang>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;

        try {
            String sql = "SELECT *FROM MatHang WHERE maMH=?";
            statement = con.prepareStatement(sql);
            statement.setString(1, id);

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maMH = rs.getString(1);
                String tenMH = rs.getString(2);
                Double gia = rs.getDouble(3);
                Boolean trangThai = rs.getBoolean(4);
                MatHang mh = new MatHang(maMH, tenMH, gia, trangThai);
                dsmh.add(mh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dsmh;
    }

// Thêm mặt hàng
    public boolean addMatHang(MatHang mh) {
        ConnectDB db = ConnectDB.getInstance();
        Connection con = db.getConnection();
        PreparedStatement stmt = null;
        int n = 0;

        try {
            stmt = con.prepareStatement("INSERT INTO MatHang(maMH, tenMH, Gia, trangThai) VALUES (?, ?, ?, ?)");
//               stmt = con.prepareStatement("INSERT INTO KhachHang (maKH, tenKH, SDT, GioiTinh) VALUES (?, ?, ?, ?)");
            stmt.setString(1, mh.getMaMH());
            stmt.setString(2, mh.getTenMH());
            stmt.setDouble(3, mh.getGia());
            stmt.setBoolean(4, mh.isTrangThai());
            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return n > 0;
    }

    // Xóa mặt hàng
    public boolean DeleteMatHang(String maMH) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("delete MatHang from MatHang where maMH=?");
            stmt.setString(1, maMH);
            n = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n > 0;
    }

//    Tìm mặt hàng 
    public MatHang findMatHang(String maTim) {
        MatHang mh = null;
        Connection con = ConnectDB.getInstance().getConnection();
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
    public boolean editMatHang(MatHang mh) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("update MatHang set TenMH=?, Gia=?, trangThai=? where maMH=?");
            stmt.setString(1, mh.getTenMH());
            System.out.println("Kiêm Tra 1");
            stmt.setDouble(2, mh.getGia());
            System.out.println("Kiêm Tra 2");
            stmt.setBoolean(3, mh.isTrangThai());
            stmt.setString(4, mh.getMaMH());
            n = stmt.executeUpdate();
            System.out.println("Kiêm Tra xong");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n > 0;
    }

}
