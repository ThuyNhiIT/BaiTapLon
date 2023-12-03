package gui.form;

import connectDB.ConnectDB;
import dao.ChiTietHoaDonDichVu_DAO;
import dao.ChiTietHoaDonPhong_Dao;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.PhongHat_DAO;
import entity.ChiTietHoaDonDV;
import entity.ChiTietHoaDonPhong;
import entity.HoaDon;
import entity.KhachHang;
import gui.swing.scrollbar.ScrollBarCustom;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HO MINH HAU
 */
public class Form_QuanLiHoaDon extends javax.swing.JPanel {

    private HoaDon_DAO hd_dao;
    private DefaultTableModel dtmhd;
    private KhachHang_DAO kh_dao;
    private PhongHat_DAO ph_dao;
    private ChiTietHoaDonPhong_Dao cthdp_dao;
    private ChiTietHoaDonDichVu_DAO cthddv_dao;
    private Float gia;
    private Float thanhTien;
    private LocalDateTime gioVao;
    private static String maHDDSD;
    private Double tongTien;

    public Form_QuanLiHoaDon() {
        initComponents();
        scr.getViewport().setOpaque(false);
        scr.setVerticalScrollBar(new ScrollBarCustom());
        hd_dao = new HoaDon_DAO();
        dtmhd = (DefaultTableModel) tblKM.getModel();
        hd_dao = new HoaDon_DAO();
        cthdp_dao = new ChiTietHoaDonPhong_Dao();
        cthddv_dao = new ChiTietHoaDonDichVu_DAO();
        kh_dao = new KhachHang_DAO();
        ph_dao = new PhongHat_DAO();
        DocDuLieu();

    }

    public void clearDataOnModel() {
        DefaultTableModel dtm = (DefaultTableModel) tblKM.getModel();
        dtm.getDataVector().removeAllElements();
    }

    public void DocDuLieu() {
        List<HoaDon> list = hd_dao.getalltbHoaDon();
        for (HoaDon hd : list) {
            dtmhd.addRow(new Object[]{hd.getMaHD(), hd.getNgayLapHD(), hd.getKhachHang().getMaKH(), hd.getNhanVien().getMaNV(), hd.getTongTien()});
//            setThongTin();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        scr = new javax.swing.JScrollPane();
        tblKM = new javax.swing.JTable();
        pnlHeader = new javax.swing.JPanel();
        pnlTim = new javax.swing.JPanel();
        lblTim = new javax.swing.JLabel();
        btnTim = new gui.swing.RadiusButton();
        txtTim = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        scr1 = new javax.swing.JScrollPane();
        tblHD1 = new javax.swing.JTable();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(235, 249, 249));

        tblKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến mãi", "Mô tả", "Bắt đầu", "Kết thúc", "Phần trăm"
            }
        ));
        tblKM.setRowHeight(40);
        tblKM.setSelectionBackground(new java.awt.Color(0, 169, 183));
        scr.setViewportView(tblKM);
        if (tblKM.getColumnModel().getColumnCount() > 0) {
            tblKM.getColumnModel().getColumn(0).setResizable(false);
        }

        pnlHeader.setBackground(new java.awt.Color(235, 249, 249));
        pnlHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlTim.setBackground(new java.awt.Color(235, 249, 249));

        lblTim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTim.setText("Tìm kiếm");

        btnTim.setBackground(new java.awt.Color(166, 208, 238));
        btnTim.setBorder(null);
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTimLayout = new javax.swing.GroupLayout(pnlTim);
        pnlTim.setLayout(pnlTimLayout);
        pnlTimLayout.setHorizontalGroup(
            pnlTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTim)
                .addGap(27, 27, 27)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        pnlTimLayout.setVerticalGroup(
            pnlTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTimLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(pnlTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTim)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pnlTim, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(667, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(pnlTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("DANH SÁCH KHUYẾN MÃI");

        tblHD1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Ngày lập HD", "Mã khách hàng", "Mã nhân viên", "Tổng tiền"
            }
        ));
        tblHD1.setRowHeight(40);
        tblHD1.setSelectionBackground(new java.awt.Color(0, 169, 183));
        scr1.setViewportView(tblHD1);
        if (tblHD1.getColumnModel().getColumnCount() > 0) {
            tblHD1.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scr)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(508, 508, 508)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scr1)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scr, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(116, 116, 116)
                    .addComponent(scr1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(334, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
//    public void setThongTin() {
//        //check connect
//        ConnectDB db = ConnectDB.getInstance();
//        try {
//            db.connect();
//            if (db != null) {
//                System.out.println("Connect success");
//
//                HoaDon hd = hd_dao.getHoaDonTheoMaHD(maHDDSD);
//                db.connect();
//                KhachHang loadKH = kh_dao.getdataKH(hd.getKhachHang().getMaKH());
//                txtTenKH.setText(loadKH.getTenKH());
//                txtSDT.setText(loadKH.getSdt());
//                ChiTietHoaDonPhong ct = cthdp_dao.getChiTietHoaDonPhongTheoMaHD(maHDDSD);
//                ChiTietHoaDonDV ctdv = cthddv_dao.getChiTietHoaDonDVTheoMaHD(maHDDSD);
//                // Lấy giờ vào
//                int gioVao = ct.getGioVao().getHour();
//                int phutVao = ct.getGioVao().getMinute();
//                int gioRa = ct.getGioRa().getHour();
//                int phutRa = ct.getGioRa().getMinute();
//
//                txtGioVao.setText(String.format("%02d:%02d", gioVao, phutVao));
//                txtGioRa.setText(String.format("%02d:%02d", gioRa, phutRa));
//                //loaddata in table
//                cthdp_dao = new ChiTietHoaDonPhong_Dao();
//                cthddv_dao = new ChiTietHoaDonDichVu_DAO();
//                int i = 1;
//
//                DefaultTableModel model = (DefaultTableModel) tblKM.getModel();
//                model.setRowCount(0);
//                for (ChiTietHoaDonPhong cthdp : cthdp_dao.getalltbChiTietHoaDonPhong()) {
//                    if (cthdp.getHoaDon().getMaHD().equals(maHDDSD)) {
//                        int gioVaoHour = cthdp.getGioVao().getHour();
//                        int gioVaoMinute = cthdp.getGioVao().getMinute();
//                        int gioRaHour = cthdp.getGioRa().getHour();
//                        int gioRaMinute = cthdp.getGioRa().getMinute();
//
//                        // Calculate duration in minutes
//                        int durationMinutes = (gioRaHour - gioVaoHour) * 60 + (gioRaMinute - gioVaoMinute);
//
//                        // If duration is less than 1 hour, set it to 1 hour
//                        if (durationMinutes < 60) {
//                            durationMinutes = 60;
//                        }
//
//                        // Calculate hours and minutes for display
//                        int displayHours = durationMinutes / 60;
//                        int displayMinutes = durationMinutes % 60;
//
//                        String thoigian = gioVaoHour + ":" + gioVaoMinute + " - " + gioRaHour + ":" + gioRaMinute;
//                        String displayTime = displayHours + " giờ " + displayMinutes + " phút";
//
//                        model.addRow(new Object[]{
//                            i++, cthdp.getPhongHat().getMaPhong(), displayTime, cthdp.getGia()
//                        });
//                    }
//                }
//                for (ChiTietHoaDonDV cthddv : cthddv_dao.getalltbChiTietHoaDonDV()) {
//                    if (cthddv.getHoaDon().getMaHD().equals(maHDDSD)) {
//                        model.addRow(new Object[]{
//                            i++, cthddv.getMatHang().getMaMH(), cthddv.getSoLuong(), cthddv.getGia()
//                        });
//                    }
//                }
//                //tinh tong tien
//                tongTien = 0.0;
//                for (int j = 0; j < tblKM.getRowCount(); j++) {
//                    tongTien += Double.parseDouble(tblKM.getValueAt(j, 3).toString());
//                }
////                lblTongTien.setText(String.valueOf(tongTien));
////                lblTongTienThanhtoan.setText(String.valueOf(tongTien));
//
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        String maHD = txtTim.getText().trim();
        if (!(maHD.length() > 0)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hóa đơn");
        } else {
            String maTim = txtTim.getText();
            ArrayList<HoaDon> dsHDTim = null;
            for (HoaDon hd : hd_dao.getalltbHoaDon()) {
                if (hd.getMaHD().equals(maTim)) {
                    dsHDTim = new ArrayList<HoaDon>();
                    dsHDTim.add(hd);
                }
            }
            if (dsHDTim != null) {
                clearDataOnModel();
                for (HoaDon hd : dsHDTim) {
                    dtmhd.addRow(new Object[]{hd.getMaHD(), hd.getNgayLapHD(), hd.getKhachHang().getMaKH(), hd.getNhanVien().getMaNV(), hd.getTongTien()});
                }
//                setThongTin();
            } else if (dsHDTim == null) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy");
            }

        }
    }//GEN-LAST:event_btnTimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.swing.RadiusButton btnTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblTim;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlTim;
    private javax.swing.JScrollPane scr;
    private javax.swing.JScrollPane scr1;
    private javax.swing.JTable tblHD1;
    private javax.swing.JTable tblKM;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
