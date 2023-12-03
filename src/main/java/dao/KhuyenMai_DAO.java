package dao;

import connectDB.ConnectDB;
import entity.KhuyenMai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class KhuyenMai_DAO {

    private ArrayList<KhuyenMai> ls;

    public KhuyenMai_DAO() {
        ls = new ArrayList<>();
    }

    /**
     *
     * @return ALL DS Khuyến mãi
     */
    public ArrayList<KhuyenMai> getAllKhuyenMai() {
        ArrayList<KhuyenMai> dsKM = new ArrayList<KhuyenMai>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM KhuyenMai";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maKM = rs.getString(1);
                String moTa = rs.getString(2);
                java.sql.Date batDau_sql = rs.getDate(3);
                LocalDate batDau = batDau_sql.toLocalDate();
                java.sql.Date ketThuc_sql = rs.getDate(4);
                LocalDate ketThuc = ketThuc_sql.toLocalDate();
                Double phanTram = rs.getDouble(5);
                KhuyenMai km = new KhuyenMai(maKM, moTa, batDau, ketThuc, phanTram);
                dsKM.add(km);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsKM;
    }

    /**
     * 
     * @param km
     * @return Thêm khuyến mãi
     */
    public boolean createKhuyenMai(KhuyenMai km) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("INSERT INTO KhuyenMai VALUES (?, ?, ?, ?, ? )");
            stmt.setString(1, km.getMaKM());
            stmt.setString(2, km.getMoTa());
            stmt.setDate(3, java.sql.Date.valueOf(km.getGioBatDau()));
            stmt.setDate(4, java.sql.Date.valueOf(km.getGioKetThuc()));
            stmt.setDouble(5, km.getPhanTram());
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }

}
