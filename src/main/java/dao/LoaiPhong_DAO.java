/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import entity.LoaiPhong;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 84343
 */
public class LoaiPhong_DAO {

    private ArrayList<LoaiPhong> ls;

    public LoaiPhong_DAO() {
        ls = new ArrayList<>();
    }

    public ArrayList<LoaiPhong> getalltbLoaiPhong() {
        ArrayList<LoaiPhong> dslp = new ArrayList<LoaiPhong>();
        try {
            ConnectDB db = ConnectDB.getInstance();
            db.connect();
            Connection con = db.getConnection();
            String sql = "SELECT *FROM LoaiPhong";
            Statement statement = con.createStatement();

            // Thực thi câu lệnh SQL trả về đối tượng ResultSet
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String maLoaiPhong = rs.getString(1);
                String tenLoaiPhong = rs.getString(2);
                Double Gia = rs.getDouble(3);
                LoaiPhong lp = new LoaiPhong(maLoaiPhong, tenLoaiPhong, Gia);
                dslp.add(lp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dslp;
    }
}
