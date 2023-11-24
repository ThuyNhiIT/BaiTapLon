/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui.form;

import dao.LoaiPhong_DAO;
import dao.PhongHat_DAO;
import entity.LoaiPhong;
import entity.PhongHat;
import gui.swing.scrollbar.ScrollBarCustom;
import gui.swing.table.TableActionCellEditorPhongHat;
import gui.swing.table.TableActionCellRenderPhongHat;
import gui.swing.table.TableActionEventPhongHat;
import gui_dialog.DL_ThemPhongHat;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 84343
 */
public class Form_QuanLyPhongHat extends javax.swing.JPanel {

    private PhongHat_DAO ph_dao;
    private LoaiPhong_DAO lp_dao;
    private DefaultTableModel dtmPhongHat;
    private ArrayList<PhongHat> ds;
    double gia;

    public Form_QuanLyPhongHat() {
        initComponents();
        scr.getViewport().setOpaque(false);
        scr.setVerticalScrollBar(new ScrollBarCustom());

        TableActionEventPhongHat event = new TableActionEventPhongHat() {
            @Override
            public void sua(int row) {

                if (tblDSPH.getSelectedRowCount() > 0) {
                    if (JOptionPane.showConfirmDialog(null, "Xác nhận sửa mặt hàng đã chọn?", "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        int[] selectedRows = tblDSPH.getSelectedRows();
                        for (int i = 0; i < selectedRows.length; i++) {
                            int rowIndex = selectedRows[i];
                            String maPhong = tblDSPH.getValueAt(rowIndex, 0).toString();
                            String tenPhong = tblDSPH.getValueAt(rowIndex, 1).toString();
                            String maLoai = tblDSPH.getValueAt(rowIndex, 2).toString();
                            Double gia = Double.parseDouble(tblDSPH.getValueAt(rowIndex, 3).toString());
                            String trangThai = tblDSPH.getValueAt(rowIndex, 4).toString();
                            PhongHat ph = new PhongHat(maPhong, tenPhong, new LoaiPhong(maLoai), trangThai);

                            tblDSPH.setValueAt(tenPhong, rowIndex, 1);
                            tblDSPH.setValueAt(maLoai, rowIndex, 2);
                            tblDSPH.setValueAt(gia, rowIndex, 3);
                            tblDSPH.setValueAt(trangThai, rowIndex, 4);

                            if (ph_dao.editPhongHat(ph)) {
                                System.out.println("Sửa thành công");
                                JOptionPane.showMessageDialog(null, "Sửa thành công");
                            } else {
                                System.out.println("Sửa thất bại");
                                JOptionPane.showMessageDialog(null, "Sửa thất bại");
                            }
                        }
                    }

                    clearJTable();
                    DocDuLieu();
                } else {
                    JOptionPane.showMessageDialog(null, "Chọn dòng cần sửa!");
                }
            }

            @Override
            public void xoa(int row) {
                ph_dao = new PhongHat_DAO();
                if (tblDSPH.getSelectedRowCount() > 0) {
                    if (JOptionPane.showConfirmDialog(null, "Xác nhận xóa phòng hát đã chọn?", "Warring", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                        int[] selectedRows = tblDSPH.getSelectedRows();
                        for (int i = selectedRows.length - 1; i >= 0; i--) {
                            List<PhongHat> phs = ph_dao.getAllPhongHat();
                            PhongHat ph = phs.get(selectedRows[i]);
                            String maPH = ph.getMaPhong();
                            ph_dao.DeletePhongHat(maPH);
                            clearJTable();
                            DocDuLieu();
                        }
                        JOptionPane.showMessageDialog(null, "Xóa thành công");

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Chọn dòng cần xóa!");
                }
            }
        };
        tblDSPH.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRenderPhongHat());
        tblDSPH.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditorPhongHat(event));
        ph_dao = new PhongHat_DAO();
        lp_dao = new LoaiPhong_DAO();
        dtmPhongHat = (DefaultTableModel) tblDSPH.getModel();
        PhongHat_DAO KH = new PhongHat_DAO();
        int tongPH = KH.getTongSoPhong();
        txtTong.setText(String.valueOf(tongPH));
        DocDuLieu();
    }

    public void clearJTable() {
        while (tblDSPH.getRowCount() > 0) {
            dtmPhongHat.removeRow(0);
        }
    }

    public void DocDuLieu() {

        List<LoaiPhong> ls = lp_dao.getalltbLoaiPhong();
        // Duyệt qua danh sách dữ liệu loại phòng
        for (LoaiPhong lp : ls) {

            Double gia = lp.getGia();

            List<PhongHat> list = ph_dao.getAllPhongHat();

            for (PhongHat ph : list) {
                if (ph.getLoaiPhong().getMaLoaiPhong().equals(lp.getMaLoaiPhong())) {
                    dtmPhongHat.addRow(new Object[]{ph.getMaPhong(), ph.getTenPhong(), ph.getLoaiPhong().getMaLoaiPhong(), gia, ph.getTinhTrangPhong()});
                }
            }
        }
    }

    public void clearDataOnModel() {
        DefaultTableModel dtm = (DefaultTableModel) tblDSPH.getModel();
        dtm.getDataVector().removeAllElements();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPhongHat = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        pnlTim = new javax.swing.JPanel();
        lblTim = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        btnTim = new gui.swing.RadiusButton();
        btnThem = new gui.swing.RadiusButton();
        lblDSPH = new javax.swing.JLabel();
        scr = new javax.swing.JScrollPane();
        tblDSPH = new javax.swing.JTable();
        lblTong = new javax.swing.JLabel();
        txtTong = new javax.swing.JTextField();

        pnlPhongHat.setBackground(new java.awt.Color(235, 249, 249));

        pnlHeader.setBackground(new java.awt.Color(235, 249, 249));
        pnlHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlTim.setBackground(new java.awt.Color(235, 249, 249));

        lblTim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTim.setText("Tìm kiếm");

        btnTim.setBackground(new java.awt.Color(166, 208, 238));
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
                .addContainerGap()
                .addComponent(lblTim)
                .addGap(28, 28, 28)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        pnlTimLayout.setVerticalGroup(
            pnlTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTimLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(pnlTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTim)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        btnThem.setBackground(new java.awt.Color(41, 173, 86));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm phòng hát");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pnlTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 401, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        lblDSPH.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblDSPH.setText("DANH SÁCH PHÒNG HÁT");

        tblDSPH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng", "Tên phòng", "Mã loại phòng", "Giá", "Trạng thái", "Hành động"
            }
        ));
        tblDSPH.setRowHeight(40);
        tblDSPH.setSelectionBackground(new java.awt.Color(0, 169, 183));
        scr.setViewportView(tblDSPH);

        lblTong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTong.setText("Tổng số phòng");

        txtTong.setEditable(false);

        javax.swing.GroupLayout pnlPhongHatLayout = new javax.swing.GroupLayout(pnlPhongHat);
        pnlPhongHat.setLayout(pnlPhongHatLayout);
        pnlPhongHatLayout.setHorizontalGroup(
            pnlPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlPhongHatLayout.createSequentialGroup()
                .addGroup(pnlPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPhongHatLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scr))
                    .addGroup(pnlPhongHatLayout.createSequentialGroup()
                        .addGroup(pnlPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPhongHatLayout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(lblTong)
                                .addGap(40, 40, 40)
                                .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPhongHatLayout.createSequentialGroup()
                                .addGap(410, 410, 410)
                                .addComponent(lblDSPH)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlPhongHatLayout.setVerticalGroup(
            pnlPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhongHatLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDSPH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scr, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTong)
                    .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPhongHat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPhongHat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        String maP = txtTim.getText().trim();
        if (!(maP.length() > 0)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã mặt hàng");
        } else {
            String maTim = txtTim.getText();
            ArrayList<PhongHat> dsPhongTim = null;
            //            ArrayList<LoaiPhong> dsLPhongTim = null;
            for (PhongHat ph : ph_dao.getAllPhongHat()) {
                if (ph.getMaPhong().equals(maTim)) {
                    dsPhongTim = new ArrayList<PhongHat>();
                    dsPhongTim.add(ph);
                }
            }
            for (PhongHat ph : ph_dao.FindTheoMaLoai(maTim)) {
                dsPhongTim = new ArrayList<PhongHat>();
                dsPhongTim.add(ph);
            }
            if (dsPhongTim != null) {
                clearDataOnModel();
                for (PhongHat ph : dsPhongTim) {
                    dtmPhongHat.addRow(new Object[]{
                        ph.getMaPhong(), ph.getTenPhong(), ph.getLoaiPhong().getMaLoaiPhong(), ph.getLoaiPhong().getGia(), ph.getTinhTrangPhong()
                    });

                }
            } else if (dsPhongTim == null) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy");
            } else if (dsPhongTim == null) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy");
            }

        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        DL_ThemPhongHat themPH = new DL_ThemPhongHat((java.awt.Frame) SwingUtilities.getWindowAncestor((Component) evt.getSource()), true);
        themPH.setLocationRelativeTo(Form_QuanLyPhongHat.this);
        themPH.setVisible(true);
        clearJTable();
        DocDuLieu();
    }//GEN-LAST:event_btnThemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.swing.RadiusButton btnThem;
    private gui.swing.RadiusButton btnTim;
    private javax.swing.JLabel lblDSPH;
    private javax.swing.JLabel lblTim;
    private javax.swing.JLabel lblTong;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlPhongHat;
    private javax.swing.JPanel pnlTim;
    private javax.swing.JScrollPane scr;
    private javax.swing.JTable tblDSPH;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTong;
    // End of variables declaration//GEN-END:variables
}
