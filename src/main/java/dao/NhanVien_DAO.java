
package dao;

import connectDB.ConnectDB;
import entity.LoaiNhanVien;
import entity.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HO MINH HAU
 */
public class NhanVien_DAO {
    public NhanVien_DAO() {
        
    }
    
    public ArrayList<NhanVien> getalltbNhanVien(){
        ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
        try{
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT *FROM NhanVien";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                String maNV = rs.getString(1);
                String tenNV = rs.getString(2);
                Boolean gioiTinh = rs.getBoolean(3);
                String cccd = rs.getString(4);
                String sdt = rs.getString(5);
                String diaChi = rs.getString(6);
                String caLam = rs.getString(7);
                String loaiNV = rs.getString(8);
                NhanVien nv = new NhanVien(maNV, tenNV, gioiTinh, cccd, sdt, diaChi, caLam, new LoaiNhanVien(loaiNV));
                dsNV.add(nv);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return dsNV;
    }
    
    
    public ArrayList<NhanVien> getNhanVienTheoMaNV(String id) {
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;

        try {
            String sql = "Select * from NhanVien where maNV = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, id);

            // Thực thi câu lệnh SQL trả về đối tượng ResultSet
            ResultSet rs = statement.executeQuery();
            // Duyệt trên kết quả trả về
            while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
                String maNV = rs.getString(1);
                String tenNV = rs.getString(2);
                Boolean gioiTinh = rs.getBoolean(3);
                String cccd = rs.getString(4);
                String sdt = rs.getString(5);
                String diaChi = rs.getString(6);
                String caLam = rs.getString(7);
                String loaiNV = rs.getString(8);
                NhanVien nv = new NhanVien(maNV, tenNV, gioiTinh, cccd, sdt, diaChi, caLam, new LoaiNhanVien(loaiNV));
                dsnv.add(nv);
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
        return dsnv;
    }

    public boolean addStaff(NhanVien nv){
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        
        try{
            stmt = con.prepareStatement("insert into" + 
                   "NhanVien values(?, ?, ?, ?, ?, ?, ?, ?)" );
            stmt.setString(1, nv.getMaNV());
            stmt.setString(2, nv.getTenNV());
            stmt.setBoolean(3, nv.isGioiTinh());
            stmt.setString(4, nv.getCCCD());
            stmt.setString(5, nv.getSDT());
            stmt.setString(6, nv.getDiaChi());
            stmt.setString(7, nv.getCaLam());
            stmt.setString(8, nv.getLoaiNV().getMaLoai());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }
    
    public boolean editStaff(NhanVien nv){
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        
        try{
            stmt = con.prepareStatement("update NhanVien set tenNV= ?, gioiTinh= ?, CCCD= ?, "
                    + "diaChi= ?, caLam= ?, loaiNV= ?");
            stmt.setString(1, nv.getTenNV());
            stmt.setBoolean(2, nv.isGioiTinh());
            stmt.setString(3, nv.getCCCD());
            stmt.setString(4, nv.getDiaChi());
            stmt.setString(5, nv.getCaLam());
            stmt.setString(6, nv.getLoaiNV().getMaLoai());
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }
    
    public NhanVien findStaff(String maTim){
        NhanVien nv = null;
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        
        try{
            String sql = "SELECT *FROM NhanVien WHERE maNV= ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maTim);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String maNV = rs.getString(1);
                String tenNV = rs.getString(2);
                Boolean gioiTinh = rs.getBoolean(3);
                String cccd = rs.getString(4);
                String sdt = rs.getString(5);
                String diaChi = rs.getString(6);
                String caLam = rs.getString(7);
                String loaiNV = rs.getString(8);
                
                nv = new NhanVien(maNV, tenNV, gioiTinh, cccd, sdt, diaChi, caLam, new LoaiNhanVien(loaiNV));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return nv;
    }
}






