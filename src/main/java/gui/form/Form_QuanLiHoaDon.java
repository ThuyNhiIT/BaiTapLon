package gui.form;

import connectDB.ConnectDB;
import dao.ChiTietHoaDonDichVu_DAO;
import dao.ChiTietHoaDonPhong_Dao;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.KhuyenMai_DAO;
import dao.PhongHat_DAO;
import entity.ChiTietHoaDonDV;
import entity.ChiTietHoaDonPhong;
import entity.HoaDon;
import entity.KhachHang;
import entity.KhuyenMai;
import gui.swing.scrollbar.ScrollBarCustom;
import gui.swing.table.TableActionCellEditorKhuyenMai;
import gui.swing.table.TableActionCellRenderKhuyenMai;
import gui.swing.table.TableActionEvent_KhuyenMai;
import gui_dialog.DL_ThemKhuyenMai;
import java.awt.Component;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HO MINH HAU
 */
public class Form_QuanLiHoaDon extends javax.swing.JPanel {

    private HoaDon_DAO hd_dao;
    private DefaultTableModel dtmhd;
    private DefaultTableModel dtmkm;
    private KhachHang_DAO kh_dao;
    private PhongHat_DAO ph_dao;
    private ChiTietHoaDonPhong_Dao cthdp_dao;
    private ChiTietHoaDonDichVu_DAO cthddv_dao;
    private KhuyenMai_DAO km_dao;
    private Float gia;
    private Float thanhTien;
    private LocalDateTime gioVao;
    private static String maHDDSD;
    private Double tongTien;

    public Form_QuanLiHoaDon() {
        initComponents();
        scr.getViewport().setOpaque(false);
        scr.setVerticalScrollBar(new ScrollBarCustom());
        scr1.getViewport().setOpaque(false);
        scr1.setVerticalScrollBar(new ScrollBarCustom());
        hd_dao = new HoaDon_DAO();
        km_dao = new KhuyenMai_DAO();
        dtmhd = (DefaultTableModel) tblHD.getModel();
        dtmkm = (DefaultTableModel) tblKM.getModel();
        hd_dao = new HoaDon_DAO();
        cthdp_dao = new ChiTietHoaDonPhong_Dao();
        cthddv_dao = new ChiTietHoaDonDichVu_DAO();
        kh_dao = new KhachHang_DAO();
        ph_dao = new PhongHat_DAO();
        DocDuLieu();
        DocDuLieuKM();

        TableActionEvent_KhuyenMai event = new TableActionEvent_KhuyenMai() {
            @Override
            public void Sua(int row) {
                km_dao = new KhuyenMai_DAO();
                if (tblKM.getSelectedRowCount() > 0) {
                    if (JOptionPane.showConfirmDialog(null, "Xác nhận sửa mặt hàng đã chọn?", "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        int[] selectedRows = tblKM.getSelectedRows();
                        for (int i = 0; i < selectedRows.length; i++) {
                            int rowIndex = selectedRows[i];
                            String maKM = tblKM.getValueAt(rowIndex, 0).toString();
                            String moTa = tblKM.getValueAt(rowIndex, 1).toString();
                            String batDauString = tblKM.getValueAt(rowIndex, 2).toString();
                            String ketThucString = tblKM.getValueAt(rowIndex, 3).toString();
                            LocalDate batDau = LocalDate.parse(batDauString);
                            LocalDate ketThuc = LocalDate.parse(ketThucString);
                            Double phanTram = Double.parseDouble(tblKM.getValueAt(rowIndex, 4).toString());
                            KhuyenMai km = new KhuyenMai(maKM, moTa, batDau, ketThuc, phanTram);

                            tblKM.setValueAt(moTa, rowIndex, 1);
                            tblKM.setValueAt(batDau, rowIndex, 2);
                            tblKM.setValueAt(ketThuc, rowIndex, 3);
                            tblKM.setValueAt(phanTram, rowIndex, 3);
                            if (km_dao.editKhuyenMai(km)) {

                                JOptionPane.showMessageDialog(null, "Sửa thành công");
                            } else {

                                JOptionPane.showMessageDialog(null, "Sửa thất bại");
                            }
                        }
                    }

                    clearJTable();
                    DocDuLieuKM();
                } else {
                    JOptionPane.showMessageDialog(null, "Chọn dòng cần sửa!");
                }
            }

            @Override
            public void xoa(int xoa) {
                km_dao = new KhuyenMai_DAO();
                if (tblKM.getSelectedRowCount() > 0) {
                    if (JOptionPane.showConfirmDialog(null, "Xác nhận xóa khuyến mãi đã chọn?", "Warring", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                        int[] selectedRows = tblKM.getSelectedRows();
                        for (int i = selectedRows.length - 1; i >= 0; i--) {
                            List<KhuyenMai> kms = km_dao.getAllKhuyenMai();
                            KhuyenMai km = kms.get(selectedRows[i]);
                            String maKM = km.getMaKM();
                            km_dao.DeleteKhuyenMai(maKM);
                            clearJTable();
                            DocDuLieuKM();
                        }

                        JOptionPane.showMessageDialog(null, "Xóa thành công");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Chọn dòng cần xóa!");
                }
            }
        };

        tblKM.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRenderKhuyenMai());
        tblKM.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditorKhuyenMai(event));
    }

    public void clearDataOnModel() {
        DefaultTableModel dtHD = (DefaultTableModel) tblHD.getModel();
        dtHD.getDataVector().removeAllElements();
        DefaultTableModel dtKM = (DefaultTableModel) tblKM.getModel();
        dtKM.getDataVector().removeAllElements();
    }

    public void clearJTable() {
        while (tblKM.getRowCount() > 0) {
            dtmkm.removeRow(0);
        }
    }

    public void DocDuLieu() {
        List<HoaDon> list = hd_dao.getalltbHoaDon();
        for (HoaDon hd : list) {
            dtmhd.addRow(new Object[]{hd.getMaHD(), hd.getNgayLapHD(), hd.getKhachHang().getMaKH(), hd.getNhanVien().getMaNV(), hd.getMaKM().getMaKM(), hd.getTongTien()});
        }

    }

    public void DocDuLieuKM() {
        List<KhuyenMai> list = km_dao.getAllKhuyenMai();
        for (KhuyenMai km : list) {
            dtmkm.addRow(new Object[]{km.getMaKM(), km.getMoTa(), km.getGioBatDau(), km.getGioKetThuc(), km.getPhanTram()});
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
        btnRefesh = new gui.swing.RadiusButton();
        jLabel1 = new javax.swing.JLabel();
        scr1 = new javax.swing.JScrollPane();
        tblHD = new javax.swing.JTable();
        btnThemMH = new gui.swing.RadiusButton();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(235, 249, 249));

        tblKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến mãi", "Mô tả", "Bắt đầu", "Kết thúc", "Phần trăm", "Hành động"
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

        btnRefesh.setBackground(new java.awt.Color(235, 249, 249));
        btnRefesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-refresh-48.png"))); // NOI18N
        btnRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefeshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pnlTim, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefesh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addComponent(pnlTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("DANH SÁCH KHUYẾN MÃI");

        tblHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Ngày lập HD", "Mã khách hàng", "Mã nhân viên", "Khuyến mãi", "Tổng tiền"
            }
        ));
        tblHD.setRowHeight(40);
        tblHD.setSelectionBackground(new java.awt.Color(0, 169, 183));
        scr1.setViewportView(tblHD);
        if (tblHD.getColumnModel().getColumnCount() > 0) {
            tblHD.getColumnModel().getColumn(0).setResizable(false);
        }

        btnThemMH.setBackground(new java.awt.Color(41, 173, 86));
        btnThemMH.setForeground(new java.awt.Color(255, 255, 255));
        btnThemMH.setText("Khuyến mãi mới");
        btnThemMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(510, 510, 510)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThemMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scr)
                .addContainerGap())
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
                .addGap(236, 236, 236)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(scr, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(116, 116, 116)
                    .addComponent(scr1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(390, Short.MAX_VALUE)))
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
                    dtmhd.addRow(new Object[]{hd.getMaHD(), hd.getNgayLapHD(), hd.getKhachHang().getMaKH(), hd.getNhanVien().getMaNV(),hd.getMaKM().getMaKM(), hd.getTongTien()});
                }
//                setThongTin();
            } else if (dsHDTim == null) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy");
            }

        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnThemMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMHActionPerformed
        DL_ThemKhuyenMai themKM = new DL_ThemKhuyenMai((java.awt.Frame) SwingUtilities.getWindowAncestor((Component) evt.getSource()), true);
        themKM.setLocationRelativeTo(Form_QuanLiHoaDon.this);
        themKM.setVisible(true);
        clearJTable();
        DocDuLieu();
    }//GEN-LAST:event_btnThemMHActionPerformed

    private void btnRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefeshActionPerformed
        clearDataOnModel();
        DocDuLieu();
    }//GEN-LAST:event_btnRefeshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.swing.RadiusButton btnRefesh;
    private gui.swing.RadiusButton btnThemMH;
    private gui.swing.RadiusButton btnTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblTim;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlTim;
    private javax.swing.JScrollPane scr;
    private javax.swing.JScrollPane scr1;
    private javax.swing.JTable tblHD;
    private javax.swing.JTable tblKM;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
