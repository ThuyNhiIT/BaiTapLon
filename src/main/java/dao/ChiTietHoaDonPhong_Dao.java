
package dao;

import connectDB.ConnectDB;
import entity.ChiTietHoaDonPhong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HO MINH HAU
 */
public class ChiTietHoaDonPhong_Dao {
    public ChiTietHoaDonPhong_Dao(){

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

}
