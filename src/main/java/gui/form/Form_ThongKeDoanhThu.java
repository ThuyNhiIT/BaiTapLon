package gui.form;

import dao.HoaDon_DAO;
import entity.HoaDon;
import gui.swing.scrollbar.ScrollBarCustom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_ThongKeDoanhThu extends javax.swing.JPanel {

    private HoaDon_DAO hd_dao;
    private DefaultTableModel dtmhd;
    private final DecimalFormat df = new DecimalFormat("#,###");
    private final SimpleDateFormat gio = new SimpleDateFormat("yyyy-MM-dd");

    public Form_ThongKeDoanhThu() {
        initComponents();
        scr.getViewport().setOpaque(false);
        scr.setVerticalScrollBar(new ScrollBarCustom());

        hd_dao = new HoaDon_DAO();
        dtmhd = (DefaultTableModel) tblTKDT.getModel();

        DocDuLieu();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date selectedDate = txtDate.getDate();
        String formattedDate = dateFormat.format(selectedDate);
        txtDate.setDateFormatString("yyyy-MM-dd");

        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date chooser = txtDate.getDate();
        String corect = simple.format(chooser);
        java.util.Date utilDate = null;
        try {
            utilDate = dateFormat.parse(corect);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println(sqlDate);
    }

    private void removeData() {
        DefaultTableModel df = (DefaultTableModel) tblTKDT.getModel();
        df.setRowCount(0);
    }

    private boolean valiData() {
        if (cmbTKTheo.getSelectedIndex() == 0 || cmbTKChiTiet.getSelectedIndex() == 0) {
            return false;
        }
        return true;
    }

    public void DocDuLieu() {
        removeData();
        List<HoaDon> dsHoaDon = hd_dao.getalltbHoaDon();
        if ((dsHoaDon.size() == 0 || dsHoaDon == null) && valiData()) {
            JOptionPane.showMessageDialog(null, "Không có hóa đơn trong tháng");
            return;
        } else if (dsHoaDon.size() == 0 || dsHoaDon == null) {
            JOptionPane.showMessageDialog(null, "Không có hóa đơn nào trong ngày ");
            return;
        }

        int stt = 1;
        for (HoaDon hd : dsHoaDon) {
            dtmhd.addRow(new Object[]{stt++ + "", hd.getMaHD(), hd.getNgayLapHD(), hd.getKhachHang().getMaKH(), hd.getNhanVien().getMaNV(), hd.getTongTien()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlTKDT = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblTKMH = new javax.swing.JLabel();
        lblNgay = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbTKTheo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbTKChiTiet = new javax.swing.JComboBox<>();
        txtDate = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        materialTabbed1 = new gui.swing.tabbed.MaterialTabbed();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        scr = new javax.swing.JScrollPane();
        tblTKDT = new javax.swing.JTable();
        lblTongSoHD = new javax.swing.JLabel();
        txtTongSoHD = new javax.swing.JTextField();
        lblTongHD = new javax.swing.JLabel();
        txtTongHD = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        jLabel1.setText("jLabel1");

        pnlTKDT.setBackground(new java.awt.Color(235, 249, 249));

        pnlHeader.setBackground(new java.awt.Color(235, 249, 249));
        pnlHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTKMH.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTKMH.setForeground(new java.awt.Color(41, 173, 86));
        lblTKMH.setText("THỐNG KÊ DOANH THU");

        lblNgay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNgay.setText("Ngày");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Thống kê theo:");

        cmbTKTheo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbTKTheo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn--", "Tháng", "Năm" }));
        cmbTKTheo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKTheoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Năm:");

        cmbTKChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbTKChiTiet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn--" }));
        cmbTKChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKChiTietActionPerformed(evt);
            }
        });

        txtDate.setDate(new Date());
        txtDate.setDateFormatString("dd-MM-yyyy hh:mm");
        txtDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDate.setOpaque(false);

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(lblNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cmbTKTheo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTKMH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(131, 131, 131)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTKChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addComponent(lblTKMH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbTKChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(cmbTKTheo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblNgay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );

        jPanel1.setBackground(new java.awt.Color(235, 249, 249));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tblTKDT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hóa đơn", "Ngày lập hóa đơn", "Nhân viên", "Khách hàng", "Tổng hóa đơn"
            }
        ));
        tblTKDT.setRowHeight(40);
        scr.setViewportView(tblTKDT);

        lblTongSoHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTongSoHD.setText("Tổng số hóa đơn");

        txtTongSoHD.setEditable(false);

        lblTongHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTongHD.setText("Tổng hóa đơn");

        txtTongHD.setEditable(false);
        txtTongHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(lblTongSoHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtTongSoHD)
                .addGap(312, 312, 312)
                .addComponent(lblTongHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongHD)
                .addGap(458, 458, 458))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(scr, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(scr, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTongSoHD)
                    .addComponent(txtTongSoHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTongHD)
                    .addComponent(txtTongHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        materialTabbed1.addTab("Bảng thống kê", jPanel4);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1236, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        materialTabbed1.addTab("Biểu đồ", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materialTabbed1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlTKDTLayout = new javax.swing.GroupLayout(pnlTKDT);
        pnlTKDT.setLayout(pnlTKDTLayout);
        pnlTKDTLayout.setHorizontalGroup(
            pnlTKDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTKDTLayout.createSequentialGroup()
                .addGroup(pnlTKDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        pnlTKDTLayout.setVerticalGroup(
            pnlTKDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTKDTLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTKDT, javax.swing.GroupLayout.PREFERRED_SIZE, 1211, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTKDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTKChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKChiTietActionPerformed

    }//GEN-LAST:event_cmbTKChiTietActionPerformed

    private void cmbTKTheoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKTheoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTKTheoActionPerformed

    private void txtTongHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongHDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> cmbTKChiTiet;
    private javax.swing.JComboBox<String> cmbTKTheo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblNgay;
    private javax.swing.JLabel lblTKMH;
    private javax.swing.JLabel lblTongHD;
    private javax.swing.JLabel lblTongSoHD;
    private gui.swing.tabbed.MaterialTabbed materialTabbed1;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlTKDT;
    private javax.swing.JScrollPane scr;
    private javax.swing.JTable tblTKDT;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtTongHD;
    private javax.swing.JTextField txtTongSoHD;
    // End of variables declaration//GEN-END:variables
}
