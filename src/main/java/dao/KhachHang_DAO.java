//package dao;
//
//import connectDB.ConnectDB;
//import entity.KhachHang;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//
///**
// *
// * @author 84343
// */
//public class KhachHang_DAO {
//
//    public KhachHang_DAO() {
//        
//    
//
//    
//
//    
//
//    public ArrayList<KhachHang> getalltbKhachHang() {
//        ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
//        try {
//            ConnectDB db = ConnectDB.getInstance();
//            db.connect(); // establish database connection
//            @SuppressWarnings("static-access")
//            Connection con = db.getConnection();
//            String sql = "Select *from KhachHang ";
//            Statement statement = con.createStatement();
//
//            //Thực thi câu lệnh SQL trả về đối tượng ResultSet
//            ResultSet rs = statement.executeQuery(sql);
//            //Duyệt trên kết quả trả về
//            //maKH, tenKH, SDT, email, CCCD, hoChieu, gioiTinh
//            while (rs.next()) {//Di chuyển con trỏ xuống bản ghi kế tiếp
//
//                String maKH = rs.getString(1);
//                String tenKH = rs.getString(2);
//                String sdt = rs.getString(3);
//                String email = rs.getString(4);
//                String CCCD = rs.getString(5);
//                //int CCCD = rs.getInt(5);
//                boolean hoChieu = rs.getBoolean(6);
//                boolean gioiTinh = rs.getBoolean(7);
//            }
//
//            return null;
//        }
//    }
//}
