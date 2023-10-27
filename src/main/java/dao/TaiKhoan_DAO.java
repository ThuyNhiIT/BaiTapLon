
package dao;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;

import java.sql.*;
import java.util.ArrayList;



/**
 *
 * @author HO MINH HAU
 */
public class TaiKhoan_DAO {
    public TaiKhoan_DAO() {
    }
    public boolean authenticate(String maNV, String Password)
            throws Exception {
        boolean isUser = false;
        try {

            Connection con = ConnectDB.getConnection();
            String sql = "select  *from TaiKhoan where maNV = ? and Password = ?";
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, maNV);
            statement.setString(2, Password);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                isUser = true;
                System.out.println("User authenticated successfully");
            } else {
                System.out.println("Invalid maNV or password!");
            }
        } catch (Exception e) {
            System.out.println("DB related Error");
            e.printStackTrace();
        }
        return isUser;
    }


}



