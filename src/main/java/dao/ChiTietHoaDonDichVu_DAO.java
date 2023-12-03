
package dao;

import connectDB.ConnectDB;
import entity.ChiTietHoaDonDV;
import entity.HoaDon;
import entity.MatHang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author HO MINH HAU
 */
public class ChiTietHoaDonDichVu_DAO {
    public ChiTietHoaDonDichVu_DAO() {

    }

    public boolean createChiTietHoaDonDV(ChiTietHoaDonDV cthddv) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("INSERT INTO ChiTietHoaDonDV VALUES (?, ?, ?, ? )");
            stmt.setString(1, cthddv.getHoaDon().getMaHD());
            stmt.setString(2, cthddv.getMatHang().getMaMH());
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
    }
    public ChiTietHoaDonDV  getChiTietHoaDonDVTheoMaHD(String id){

        ChiTietHoaDonDV cthddv = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;

        try{
            String sql = "Select * from ChiTietHoaDonDV where maHD = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                String maHD = rs.getString(1);
                String maMH = rs.getString(2);
                int soLuong = rs.getInt(3);
                double gia = rs.getDouble(4);
                cthddv = new ChiTietHoaDonDV(new HoaDon(maHD), new MatHang(maMH), soLuong, gia);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cthddv;
    }

    public ArrayList<ChiTietHoaDonDV> getalltbChiTietHoaDonDV() {
        ArrayList<ChiTietHoaDonDV> dsCTHDDV = new ArrayList<>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM ChiTietHoaDonDV";
            PreparedStatement statement = con.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maHD = rs.getString(1);
                String maMH = rs.getString(2);
                int soLuong = rs.getInt(3);
                double gia = rs.getDouble(4);
                ChiTietHoaDonDV cthddv = new ChiTietHoaDonDV(new HoaDon(maHD), new MatHang(maMH), soLuong, gia);
                dsCTHDDV.add(cthddv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsCTHDDV;
    }

    //find maMH
    public ArrayList<ChiTietHoaDonDV> getalltbChiTietHoaDonDVTheoMaMH(String maMH) {
        ArrayList<ChiTietHoaDonDV> dsCTHDDV = new ArrayList<>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM ChiTietHoaDonDV where maMH = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, maMH);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maHD = rs.getString(1);
                String maMH1 = rs.getString(2);
                int soLuong = rs.getInt(3);
                double gia = rs.getDouble(4);
                ChiTietHoaDonDV cthddv = new ChiTietHoaDonDV(new HoaDon(maHD), new MatHang(maMH1), soLuong, gia);
                dsCTHDDV.add(cthddv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsCTHDDV;
    }

    // update sl theo maHD
    public boolean updateChiTietHoaDonDV(ChiTietHoaDonDV cthddv){
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;

        try{
            stmt = con.prepareStatement("UPDATE ChiTietHoaDonDV SET soLuong = ? WHERE maHD = ? AND maMH = ?");
            stmt.setInt(1, cthddv.getSoLuong());
            stmt.setString(2, cthddv.getHoaDon().getMaHD());
            stmt.setString(3, cthddv.getMatHang().getMaMH());
            n = stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();

        }
        return n > 0;

    }

    //deleteChiTietHoaDonDV
    public boolean deleteChiTietHoaDonDV(String maHD, String maMH){
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;

        try{
            stmt = con.prepareStatement("DELETE FROM ChiTietHoaDonDV WHERE maHD = ? AND maMH = ?");
            stmt.setString(1, maHD);
            stmt.setString(2, maMH);
            n = stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return n > 0;
    }


// find findChiTietHoaDonDV by maHD vs maMH
    public ChiTietHoaDonDV findChiTietHoaDonDV(String maHD, String maMH){
        ChiTietHoaDonDV cthddv = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;

        try{
            String sql = "Select * from ChiTietHoaDonDV where maHD = ? AND maMH = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, maHD);
            statement.setString(2, maMH);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                String maHD1 = rs.getString(1);
                String maMH1 = rs.getString(2);
                int soLuong = rs.getInt(3);
                double gia = rs.getDouble(4);
                cthddv = new ChiTietHoaDonDV(new HoaDon(maHD1), new MatHang(maMH1), soLuong, gia);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cthddv;
    }
    // lấy ra ds cthddv theo maHD
    public ArrayList<ChiTietHoaDonDV> getAllTheMaHDDVArray(String maHD) {
        ArrayList<ChiTietHoaDonDV> dsCTHDDV = new ArrayList<>();

        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM ChiTietHoaDonDV WHERE maHD = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, maHD);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maHD1 = rs.getString(1);
                String maMH = rs.getString(2);
                int soLuong = rs.getInt(3);
                double gia = rs.getDouble(4);
                ChiTietHoaDonDV cthddv = new ChiTietHoaDonDV(new HoaDon(maHD1), new MatHang(maMH), soLuong, gia);
                dsCTHDDV.add(cthddv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsCTHDDV;
    }

}
