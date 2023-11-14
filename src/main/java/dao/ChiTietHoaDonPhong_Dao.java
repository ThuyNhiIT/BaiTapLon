
package dao;

import connectDB.ConnectDB;
import entity.ChiTietHoaDonPhong;
import entity.HoaDon;
import entity.PhongHat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author HO MINH HAU
 */
public class ChiTietHoaDonPhong_Dao {
    public ChiTietHoaDonPhong_Dao(){

    }
    public ArrayList<ChiTietHoaDonPhong> getalltbChiTietHoaDonPhong() {
        ArrayList<ChiTietHoaDonPhong> dsCTHDP = new ArrayList<>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM ChiTietHoaDonPhong";
            PreparedStatement statement = con.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maHD = rs.getString(1);
                String maPhong = rs.getString(2);
                Double gia = rs.getDouble(3);
                LocalDateTime gioVao = rs.getTimestamp(4).toLocalDateTime();
                LocalDateTime gioRa = rs.getTimestamp(5).toLocalDateTime();
                String maGiamGia = rs.getString(6);
                ChiTietHoaDonPhong cthdp = new ChiTietHoaDonPhong(new HoaDon(maHD), new PhongHat(maPhong), gia, gioVao, gioRa, maGiamGia);
                dsCTHDP.add(cthdp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsCTHDP;
    }

public ChiTietHoaDonPhong getChiTietHoaDonPhongTheoMaHD(String id) {
        ChiTietHoaDonPhong cthdp = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;

        try {
            String sql = "Select * from ChiTietHoaDonPhong where maHD = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maHD = rs.getString(1);
                String maPhong = rs.getString(2);
                Double gia = rs.getDouble(3);
                LocalDateTime gioVao = rs.getTimestamp(4).toLocalDateTime();
                LocalDateTime gioRa = rs.getTimestamp(5).toLocalDateTime();
                String maGiamGia = rs.getString(6);
                cthdp = new ChiTietHoaDonPhong(new HoaDon(maHD), new PhongHat(maPhong), gia, gioVao, gioRa, maGiamGia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cthdp;
    }
    public boolean createChiTietHoaDonPhong(ChiTietHoaDonPhong cthdp) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("INSERT INTO ChiTietHoaDonPhong VALUES (?, ?, ?, ?, ?, ? )");
            stmt.setString(1, cthdp.getHoaDon().getMaHD());
            stmt.setString(2, cthdp.getPhongHat().getMaPhong());
            stmt.setDouble(3, cthdp.getGia());
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(cthdp.getGioVao()));
            stmt.setTimestamp(5, java.sql.Timestamp.valueOf(cthdp.getGioRa()));
            stmt.setString(6, cthdp.getMaGiamGia());

            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            try {
//                if (stmt != null) {
//                    stmt.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        return n > 0;
    }
    public ChiTietHoaDonPhong finHDByRoomID(String roomID) {
        ChiTietHoaDonPhong cthdp = null;

        try (Connection con = ConnectDB.getConnection();
             PreparedStatement statement = con.prepareStatement("SELECT * FROM ChiTietHoaDonPhong WHERE maPhong = ? AND gioVao = gioRa")) {

            statement.setString(1, roomID);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                String maHD = rs.getString("maHD");
                String maPhong = rs.getString("maPhong");
                Double gia = rs.getDouble("gia");
                LocalDateTime gioVao = rs.getTimestamp("gioVao").toLocalDateTime();
                LocalDateTime gioRa = rs.getTimestamp("gioRa").toLocalDateTime();
                String maGiamGia = rs.getString("maGiamGia");

                cthdp = new ChiTietHoaDonPhong(new HoaDon(maHD), new PhongHat(maPhong), gia, gioVao, gioRa, maGiamGia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cthdp;
    }
    public ChiTietHoaDonPhong finHDByRoomIDDaTT(String roomID) {
        ChiTietHoaDonPhong cthdp = null;

        try (Connection con = ConnectDB.getConnection();
             PreparedStatement statement = con.prepareStatement("SELECT * FROM ChiTietHoaDonPhong WHERE maPhong = ? AND gia <> 0 ")) {

            statement.setString(1, roomID);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                // Retrieve data from the ResultSet
                String maHD = rs.getString("maHD");
                String maPhong = rs.getString("maPhong");
                Double gia = rs.getDouble("gia");
                LocalDateTime gioVao = rs.getTimestamp("gioVao").toLocalDateTime();
                LocalDateTime gioRa = rs.getTimestamp("gioRa").toLocalDateTime();
                String maGiamGia = rs.getString("maGiamGia");

                // Create a ChiTietHoaDonPhong object using the retrieved data
                cthdp = new ChiTietHoaDonPhong(new HoaDon(maHD), new PhongHat(maPhong), gia, gioVao, gioRa, maGiamGia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cthdp;
    }



    public boolean updateGioRaVsGia(String maHD, LocalDateTime gioRa,Float gia) {
        int n = 0;

        try (Connection con = ConnectDB.getConnection();
             PreparedStatement stmt = con.prepareStatement("UPDATE ChiTietHoaDonPhong SET gioRa = ? , gia = ? WHERE maHD = ?")) {

            stmt.setTimestamp(1, java.sql.Timestamp.valueOf(gioRa));
            stmt.setFloat(2, gia);
            stmt.setString(3, maHD);
            n = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n > 0;
    }



}
