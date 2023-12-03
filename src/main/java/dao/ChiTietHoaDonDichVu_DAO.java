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
import java.util.Date;

/**
 * @author HO MINH HAU
 */
public class ChiTietHoaDonDichVu_DAO {

    public ChiTietHoaDonDichVu_DAO() {

    }

    public boolean createChiTietHoaDonPhong(ChiTietHoaDonDV cthddv) {
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

    public ChiTietHoaDonDV getChiTietHoaDonDVTheoMaHD(String id) {

        ChiTietHoaDonDV cthddv = null;
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement statement = null;

        try {
            String sql = "Select * from ChiTietHoaDonDV where maHD = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maHD = rs.getString(1);
                String maMH = rs.getString(2);
                int soLuong = rs.getInt(3);
                double gia = rs.getDouble(4);
                cthddv = new ChiTietHoaDonDV(new HoaDon(maHD), new MatHang(maMH), soLuong, gia);
            }
        } catch (SQLException e) {
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

    /**
     *
     * @param nam
     * @return Top 5 sản phẩm dịch vụ bán chạy nhất năm
     */
    public ArrayList<String[]> getTOPDVNam(String nam) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        ArrayList<String[]> list = new ArrayList<>();
        try {
            String sql = "SELECT TOP 5 sp.maMH, sp.tenMH, SUM(od.soLuong) AS SoLuong, \n"
                    + "    ROUND((SUM(od.soLuong) * 100.0 / (SELECT SUM(SoLuong) FROM (SELECT TOP 5 SUM(od2.soLuong) AS SoLuong FROM [dbo].[ChiTietHoaDonDV] od2 JOIN HoaDon o2 ON od2.maHD = o2.maHD WHERE YEAR(o2.ngayLapHD) = ? GROUP BY od2.maMH ORDER BY SoLuong DESC) AS top5)) , 2) AS TyLe, \n"
                    + "    ROUND(SUM(od.soLuong * sp.gia), 2) AS TongTien\n"
                    + "FROM [dbo].[ChiTietHoaDonDV] od\n"
                    + "JOIN HoaDon o ON od.maHD = o.maHD\n"
                    + "JOIN [dbo].[MatHang] sp ON od.maMH = sp.maMH\n"
                    + "WHERE YEAR(o.ngayLapHD) = ? "
                    + "GROUP BY sp.maMH, sp.tenMH\n"
                    + "ORDER BY SUM(od.soLuong) DESC";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nam);
            stmt.setString(2, nam);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String[] arr = new String[5];
                arr[0] = rs.getString("MaMH");
                arr[1] = rs.getString("TenMH");
                arr[2] = rs.getString("SoLuong");
                arr[3] = rs.getString("TyLe");
                arr[4] = rs.getString("TongTien");
                list.add(arr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     *
     * @param nam
     * @return Tổng tiền dịch vụ (top 5) bán chạy trong năm
     */
    public static final String COLUMN_TONG_TIEN_DV_NAM = "TongTatCaTien";

    public int getTongTienNam(String nam) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "SELECT SUM(TongTien) AS TongTatCaTien\n"
                    + "FROM\n"
                    + "(\n"
                    + "    SELECT TOP 5 ROUND(SUM(od.soLuong * sp.gia), 2) AS TongTien\n"
                    + "    FROM [dbo].[ChiTietHoaDonDV] od\n"
                    + "    JOIN HoaDon o ON od.maHD = o.maHD\n"
                    + "    JOIN [dbo].[MatHang] sp ON od.maMH = sp.maMH\n"
                    + "    WHERE YEAR(o.ngayLapHD) = ? \n"
                    + "    GROUP BY sp.maMH, sp.tenMH\n"
                    + "    ORDER BY SUM(od.soLuong) DESC\n"
                    + ") AS Top5;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nam);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(COLUMN_TONG_TIEN_DV_NAM);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     *
     * @param thang
     * @param nam
     * @return Top 5 sản phẩm dịch vụ bán chạy nhất tháng
     */
    public ArrayList<String[]> getTOPDVThang(String thang, String nam) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        ArrayList<String[]> list = new ArrayList<>();
        try {
            String sql = "SELECT TOP 5 sp.maMH, sp.tenMH, SUM(od.soLuong) AS SoLuong, \n"
                    + "    ROUND((SUM(od.soLuong) * 100.0 / (SELECT SUM(SoLuong) FROM (SELECT TOP 5 SUM(od2.soLuong) AS SoLuong FROM [dbo].[ChiTietHoaDonDV] od2 JOIN HoaDon o2 ON od2.maHD = o2.maHD WHERE  MONTH(o2.ngayLapHD) = ? AND YEAR(o2.ngayLapHD) = ? "
                    + "GROUP BY od2.maMH ORDER BY SoLuong DESC) AS top5)) , 2) AS TyLe, \n"
                    + "    ROUND(SUM(od.soLuong * sp.gia), 2) AS TongTien\n"
                    + "FROM [dbo].[ChiTietHoaDonDV] od\n"
                    + "JOIN HoaDon o ON od.maHD = o.maHD\n"
                    + "JOIN [dbo].[MatHang] sp ON od.maMH = sp.maMH\n"
                    + "WHERE MONTH(o.ngayLapHD) = ?  AND YEAR(o.ngayLapHD) = ?  "
                    + "GROUP BY sp.maMH, sp.tenMH\n"
                    + "ORDER BY SUM(od.soLuong) DESC";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, thang);
            stmt.setString(2, nam);
            stmt.setString(3, thang);
            stmt.setString(4, nam);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String[] arr = new String[5];
                arr[0] = rs.getString("MaMH");
                arr[1] = rs.getString("TenMH");
                arr[2] = rs.getString("SoLuong");
                arr[3] = rs.getString("TyLe");
                arr[4] = rs.getString("TongTien");
                list.add(arr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static final String COLUMN_TONG_TIEN_DV_THANG = "TongTatCaTienThang";

    /**
     *
     * @param thang
     * @param nam
     * @return Tổng tiền dịch vụ (top 5) bán chạy trong tháng
     */
    public int getTongTienThang(String thang, String nam) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "SELECT SUM(TongTien) AS TongTatCaTienThang\n"
                    + "FROM(\n"
                    + "SELECT TOP 5 ROUND(SUM(od.soLuong * sp.gia), 2) AS TongTien\n"
                    + "FROM [dbo].[ChiTietHoaDonDV] od\n"
                    + "JOIN HoaDon o ON od.maHD = o.maHD\n"
                    + "JOIN [dbo].[MatHang] sp ON od.maMH = sp.maMH\n"
                    + "WHERE MONTH(o.ngayLapHD) = ? AND YEAR(o.ngayLapHD) = ?\n"
                    + "GROUP BY sp.maMH, sp.tenMH\n"
                    + "ORDER BY SUM(od.soLuong) DESC\n"
                    + ") AS Top5;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, thang);
            stmt.setString(2, nam);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(COLUMN_TONG_TIEN_DV_THANG);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<String[]> getTOPDVNgay(Date ngay) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        ArrayList<String[]> list = new ArrayList<>();
        try {
            String sql = "SELECT TOP 5 sp.maMH, sp.tenMH, SUM(od.soLuong) AS SoLuong, \n"
                    + "    ROUND((SUM(od.soLuong) * 100.0 / (SELECT SUM(SoLuong) FROM (SELECT TOP 5 SUM(od2.soLuong) AS SoLuong FROM [dbo].[ChiTietHoaDonDV] od2 JOIN HoaDon o2 ON od2.maHD = o2.maHD WHERE (o2.ngayLapHD) = ? GROUP BY od2.maMH ORDER BY SoLuong DESC) AS top5)) , 2) AS TyLe, \n"
                    + "    ROUND(SUM(od.soLuong * sp.gia), 2) AS TongTien\n"
                    + "FROM [dbo].[ChiTietHoaDonDV] od\n"
                    + "JOIN HoaDon o ON od.maHD = o.maHD\n"
                    + "JOIN [dbo].[MatHang] sp ON od.maMH = sp.maMH\n"
                    + "WHERE (o.ngayLapHD) = ? "
                    + "GROUP BY sp.maMH, sp.tenMH\n"
                    + "ORDER BY SUM(od.soLuong) DESC";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, ngay.toString());
            stmt.setString(2, ngay.toString());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String[] arr = new String[5];
                arr[0] = rs.getString("MaMH");
                arr[1] = rs.getString("TenMH");
                arr[2] = rs.getString("SoLuong");
                arr[3] = rs.getString("TyLe");
                arr[4] = rs.getString("TongTien");
                list.add(arr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static final String COLUMN_TONG_TIEN_DV_NGAY = "TongTatCaTienNgay";

    public int getTongTienNgay(Date ngay) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "SELECT SUM(TongTien) AS TongTatCaTienNgay\n"
                    + "FROM\n"
                    + "(\n"
                    + "    SELECT TOP 5 ROUND(SUM(od.soLuong * sp.gia), 2) AS TongTien\n"
                    + "    FROM [dbo].[ChiTietHoaDonDV] od\n"
                    + "    JOIN HoaDon o ON od.maHD = o.maHD\n"
                    + "    JOIN [dbo].[MatHang] sp ON od.maMH = sp.maMH\n"
                    + "    WHERE (o.ngayLapHD) = ? \n"
                    + "    GROUP BY sp.maMH, sp.tenMH\n"
                    + "    ORDER BY SUM(od.soLuong) DESC\n"
                    + ") AS Top5;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, ngay.toString());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(COLUMN_TONG_TIEN_DV_NGAY);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Thống kê top 5 DV theo năm <Biểu đồ>
     *
     * @param nam
     * @return
     */
    public ArrayList<String[]> getTKNam(String nam) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<String[]> list = new ArrayList<>();

        try {
            con = ConnectDB.getConnection();
            String sql = "SELECT TOP 5 sp.maMH, sp.tenMH, SUM(od.soLuong) AS SoLuong, "
                    + "   ROUND((SUM(od.soLuong) * 100.0 / (SELECT SUM(SoLuong) FROM (SELECT TOP 5 SUM(od2.soLuong) AS SoLuong FROM [dbo].[ChiTietHoaDonDV] od2 JOIN HoaDon o2 ON od2.maHD = o2.maHD WHERE YEAR(o2.ngayLapHD) = ? GROUP BY od2.maMH ORDER BY SoLuong DESC) AS top5)) , 2) AS TyLe, "
                    + "   ROUND(SUM(od.soLuong * sp.gia), 2) AS TongTien "
                    + "FROM [dbo].[ChiTietHoaDonDV] od "
                    + "JOIN HoaDon o ON od.maHD = o.maHD "
                    + "JOIN [dbo].[MatHang] sp ON od.maMH = sp.maMH "
                    + "WHERE YEAR(o.ngayLapHD) = ? "
                    + "GROUP BY sp.maMH, sp.tenMH "
                    + "ORDER BY SUM(od.soLuong) DESC";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, nam);
            stmt.setString(2, nam);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String[] arr = new String[5];
                arr[0] = rs.getString("MaMH");
                arr[1] = rs.getString("TenMH");
                arr[2] = rs.getString("SoLuong");
                arr[3] = rs.getString("TyLe");
                arr[4] = rs.getString("TongTien");
                list.add(arr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Thống kê top 5 DV theo tháng <Biểu đồ>
     *
     * @param thang
     * @param nam
     * @return
     */
    public ArrayList<String[]> getTKThang(String thang, String nam) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<String[]> list = new ArrayList<>();

        try {
            con = ConnectDB.getConnection();
            String sql = "SELECT TOP 5 sp.maMH, sp.tenMH, SUM(od.soLuong) AS SoLuong, \n"
                    + "    ROUND((SUM(od.soLuong) * 100.0 / (SELECT SUM(SoLuong) FROM (SELECT TOP 5 SUM(od2.soLuong) AS SoLuong FROM [dbo].[ChiTietHoaDonDV] od2 JOIN HoaDon o2 ON od2.maHD = o2.maHD WHERE  MONTH(o2.ngayLapHD) = ? AND YEAR(o2.ngayLapHD) = ? "
                    + "GROUP BY od2.maMH ORDER BY SoLuong DESC) AS top5)) , 2) AS TyLe, \n"
                    + "    ROUND(SUM(od.soLuong * sp.gia), 2) AS TongTien\n"
                    + "FROM [dbo].[ChiTietHoaDonDV] od\n"
                    + "JOIN HoaDon o ON od.maHD = o.maHD\n"
                    + "JOIN [dbo].[MatHang] sp ON od.maMH = sp.maMH\n"
                    + "WHERE MONTH(o.ngayLapHD) = ?  AND YEAR(o.ngayLapHD) = ?  "
                    + "GROUP BY sp.maMH, sp.tenMH\n"
                    + "ORDER BY SUM(od.soLuong) DESC";
            stmt.setString(1, thang);
            stmt.setString(2, nam);
            stmt.setString(3, thang);
            stmt.setString(4, nam);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String[] arr = new String[5];
                arr[0] = rs.getString("MaMH");
                arr[1] = rs.getString("TenMH");
                arr[2] = rs.getString("SoLuong");
                arr[3] = rs.getString("TyLe");
                arr[4] = rs.getString("TongTien");
                list.add(arr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    
}
