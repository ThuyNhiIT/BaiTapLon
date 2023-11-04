//package dao;
//
//import connectDB.ConnectDB;
//import entity.DichVu;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//
///**
// *
// * @author 84343
// */
//public class DichVu_DAO extends MatHang_DAO{
//
//    ArrayList<DichVu> dsdv;
//    DichVu dv;
//    private Statement statement;
//
//    public DichVu_DAO() {
//        dsdv = new ArrayList<DichVu>();
//        dv = new DichVu();
//    }
//
////    @Override
//    public ArrayList<DichVu> docTuBang() {
//        try {
//            ConnectDB db = ConnectDB.getInstance();
//            db.connect();
//            Connection con = db.getConnection();
//            String sql = "Select *from DichVu";
//            statement = con.createStatement();
//
//            // Thực thi câu lệnh SQL trả về đối tượng ResultSet
//            ResultSet rs = statement.executeQuery(sql);
//
//            while (rs.next()) {
//                String maDV = rs.getString(1);
//                String tenDV = rs.getString(2);
//                DichVu dv = new DichVu(maDV, tenDV);
//                dsdv.add(dv);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return dsdv;
//
//    }
//// Thêm mặt hàng
//
//    public boolean createDV(DichVu dv) {
//        ConnectDB db = ConnectDB.getInstance();
//        Connection con = db.getConnection();
//        PreparedStatement stmt = null;
//        int n = 0;
//
//        try {
//            stmt = con.prepareStatement("insert into" + "DichVu(maDV, tenDV) values (?, ?)");
//            stmt.setString(1, dv.getMaDV());
//            stmt.setString(2, dv.getTenDV());
//            n = stmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return n > 0;
//    }
//
//    // Xóa mặt hàng
//    public boolean xoaDV(String maDV) {
//        ConnectDB db = ConnectDB.getInstance();
//        Connection con = db.getConnection();
//        PreparedStatement stmt = null;
//        int n = 0;
//        try {
//            stmt = con.prepareStatement("Delete DichVu from DichVu where maDV =?");
//            stmt.setString(1, maDV);
//            n = stmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return n > 0;
//    }
//
////    Tìm mặt hành 
//    public DichVu timKiem(String maTim) {
//        DichVu dv = null;
//        ConnectDB db = ConnectDB.getInstance();
//        Connection con = db.getConnection();
//        PreparedStatement stmt = null;
//        try {
//            String sql = "Select *from DichVu where maDV=?";
//            stmt = con.prepareStatement(sql);
//            stmt.setString(1, maTim);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                String maDV = rs.getString(1);
//                String tenDV = rs.getString(2);
//                dv = new DichVu(maDV, tenDV);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return dv;
//    }
//
//    // Sửa mặt hàng
//    public boolean update(DichVu dv) {
//        ConnectDB db = ConnectDB.getInstance();
//        Connection con = db.getConnection();
//        PreparedStatement stmt = null;
//        int n = 0;
//        try {
//            stmt = con.prepareStatement("update " + "DichVu set TenDV=? where maDV=?");
//
//            stmt.setString(1, dv.getTenDV());
//            stmt.setString(2, dv.getMaDV());
//            n = stmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return n > 0;
//    }
//
//}
