//
//package dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
///**
// *
// * @author 84934 NguyenThiQuynhGiang
// */
//public class DoiMatKhau_DAO {
//    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=KaraokeAPLUS";
//    private static final String JDBC_USER = "sa";
//    private static final String JDBC_PASSWORD = "0934119430";
//    
//    public boolean doiMatKhau(String userName, String oldPassword, String newPassword){
//       if(!isOldPasswordCorrect(userName, oldPassword)){
//           System.out.println("Old password is incorrect");
//           return false;
//       }
//       
//       String updateQuery = "UPDATE TaiKhoan SET Password = ? WHERE maNV = ?";
//       
//       try(Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//           PreparedStatement preparedStatement = connection.prepareStatement(updateQuery))
//       
//       
//    }
//    
//    @SuppressWarnings("empty-statement")
//    private boolean isOldPasswordCorrect(String userName = null, String oldPassword) throws SQLException{
//        String selectQuery = "SELECT Password FROM TaiKhoan WHERE maNV= ?";
//        try(Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)){
//            preparedStatement.setString(1, userName);
//            
//            try(ResultSet rs = preparedStatement.executeQuery()){
//                if(rs.next()){
//                    String currentPassword = rs.getString("Password");
//                    return currentPassword.equals(oldPassword);
//                }
//            }
//        }catch(SQLException e){
//                e.printStackTrace();}
//        return false;
//    }
//}
