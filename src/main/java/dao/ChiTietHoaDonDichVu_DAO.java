
package dao;

import connectDB.ConnectDB;
import entity.ChiTietHoaDonDV;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HO MINH HAU
 */
public class ChiTietHoaDonDichVu_DAO {
    public ChiTietHoaDonDichVu_DAO(){

    }
    public boolean createChiTietHoaDonPhong(ChiTietHoaDonDV cthddv) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("INSERT INTO ChiTietHoaDonDV VALUES (?, ?, ?, ? )");
            stmt.setString(1, cthddv.getHoaDon().getMaHD());
            stmt.setString(2, cthddv.getDichVu().getMaDV());
            stmt.setInt(3, cthddv.getSoLuong());
            stmt.setDouble(4, cthddv.getGia());

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
    }}
