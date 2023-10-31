
package dao;

import connectDB.ConnectDB;
import entity.LoaiNhanVien;
import entity.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HO MINH HAU
 */
public class NhanVien_DAO {
    public NhanVien_DAO() {
        
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


}






