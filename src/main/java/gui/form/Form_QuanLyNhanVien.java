package gui.form;

import dao.LoaiNV_DAO;
import dao.NhanVien_DAO;
import entity.LoaiNhanVien;
import entity.NhanVien;
import gui.swing.CustomJOptionPane;
import gui_dialog.DL_SuaNV;
import gui_dialog.DL_ThemNV;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author HO MINH HAU
 */
public class Form_QuanLyNhanVien extends javax.swing.JPanel {

    private NhanVien_DAO nv_dao;
    private DefaultTableModel dtmNhanVien;
    private LoaiNV_DAO loainv_dao = new LoaiNV_DAO();
//    private DefaultComboBoxModel<LoaiNhanVien>;

    public Form_QuanLyNhanVien() {
        initComponents();
        nv_dao = new NhanVien_DAO();
        dtmNhanVien = (DefaultTableModel) tblDSNV.getModel();
        loadTable(nv_dao.getalltbNhanVien());
    }
//    

    public void loadTable(ArrayList<NhanVien> ds) {
        if (ds == null) {
            clearJTable();
            return;
        }
        clearJTable();
        for (NhanVien nhanVien : ds) {
            dtmNhanVien.addRow(new Object[]{nhanVien.getMaNV(), nhanVien.getTenNV(), nhanVien.isGioiTinh() ? "Nam" : "Nữ",
                nhanVien.getCCCD(), nhanVien.getSDT(), nhanVien.getDiaChi(), nhanVien.getCaLam(), nhanVien.getLoaiNV().getMaLoai()});
        }
    }

    public void clearJTable() {
        while (tblDSNV.getRowCount() > 0) {
            dtmNhanVien.removeRow(0);
        }
    }

    public void DocDuLieu() {
        List<NhanVien> list = nv_dao.getalltbNhanVien();
        for (NhanVien nv : list) {
            dtmNhanVien.addRow(new Object[]{
                nv.getMaNV(), nv.getTenNV(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getSDT(), nv.getCCCD(), nv.getSDT(),
                nv.getDiaChi(), nv.getCaLam(), nv.getLoaiNV().getMaLoai()
            });
        }

    }

    public void clearDataOnModel() {
        DefaultTableModel dtm = (DefaultTableModel) tblDSNV.getModel();
        dtm.getDataVector().removeAllElements();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNhanVien = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        pnlTraCuu = new javax.swing.JPanel();
        lblTim = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        btnTim = new gui.swing.RadiusButton();
        btnThem = new gui.swing.RadiusButton();
        btnSua = new gui.swing.RadiusButton();
        lblDSNV = new javax.swing.JLabel();
        scr = new javax.swing.JScrollPane();
        tblDSNV = new javax.swing.JTable();
        lblTong = new javax.swing.JLabel();
        txtTong = new javax.swing.JTextField();
        btnCapNhatTotalNV = new gui.swing.RadiusButton();

        pnlNhanVien.setBackground(new java.awt.Color(235, 249, 249));
        pnlNhanVien.setFocusCycleRoot(true);

        pnlHeader.setBackground(new java.awt.Color(235, 249, 249));
        pnlHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlTraCuu.setBackground(new java.awt.Color(235, 249, 249));

        lblTim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTim.setText("Tìm kiếm");

        btnTim.setBackground(new java.awt.Color(166, 208, 238));
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTraCuuLayout = new javax.swing.GroupLayout(pnlTraCuu);
        pnlTraCuu.setLayout(pnlTraCuuLayout);
        pnlTraCuuLayout.setHorizontalGroup(
            pnlTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTraCuuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTim)
                .addGap(28, 28, 28)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        pnlTraCuuLayout.setVerticalGroup(
            pnlTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTraCuuLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(pnlTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTim)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        btnThem.setBackground(new java.awt.Color(41, 173, 86));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm nhân viên");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(pnlTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        lblDSNV.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblDSNV.setText("DANH SÁCH NHÂN VIÊN");

        tblDSNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Giới tính", "CCCD", "Số điện thoại", "Địa chỉ", "Ca", "Loại nhân viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNV.setRowHeight(40);
        scr.setViewportView(tblDSNV);

        lblTong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTong.setText("Tổng số nhân viên:");

        txtTong.setEditable(false);

        btnCapNhatTotalNV.setBackground(new java.awt.Color(166, 208, 238));
        btnCapNhatTotalNV.setText("Cập nhật");
        btnCapNhatTotalNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatTotalNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNhanVienLayout = new javax.swing.GroupLayout(pnlNhanVien);
        pnlNhanVien.setLayout(pnlNhanVienLayout);
        pnlNhanVienLayout.setHorizontalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scr, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(lblTong)
                        .addGap(18, 18, 18)
                        .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapNhatTotalNV, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlNhanVienLayout.createSequentialGroup()
                        .addGap(416, 416, 416)
                        .addComponent(lblDSNV, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(610, Short.MAX_VALUE))
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhanVienLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDSNV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scr, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTong)
                    .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhatTotalNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        nv_dao = new NhanVien_DAO();

        if (tblDSNV.getSelectedRowCount() > 0) {
            if (JOptionPane.showConfirmDialog(this, "Xác nhận sửa khách hàng đã chọn?", "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                int[] selectedRows = tblDSNV.getSelectedRows();
                for (int i = 0; i < selectedRows.length; i++) {
                    int rowIndex = selectedRows[i];
                    String maNV = tblDSNV.getValueAt(rowIndex, 0).toString();
                    String tenNV = tblDSNV.getValueAt(rowIndex, 1).toString();
                    Boolean gioiTinh = Boolean.parseBoolean(tblDSNV.getValueAt(rowIndex, 2).toString());
                    String CCCD = tblDSNV.getValueAt(rowIndex, 3).toString();
                    String SDT = tblDSNV.getValueAt(rowIndex, 4).toString();
                    String diaChi = tblDSNV.getValueAt(rowIndex, 5).toString();
                    String caLam = tblDSNV.getValueAt(rowIndex, 6).toString();
                    String loaiNV = tblDSNV.getValueAt(rowIndex, 7).toString();

                    tblDSNV.setValueAt(tenNV, rowIndex, 1);
                    tblDSNV.setValueAt(gioiTinh, rowIndex, 2);
                    tblDSNV.setValueAt(CCCD, rowIndex, 3);
                    tblDSNV.setValueAt(SDT, rowIndex, 4);
                    tblDSNV.setValueAt(diaChi, rowIndex, 5);
                    tblDSNV.setValueAt(caLam, rowIndex, 6);
                    tblDSNV.setValueAt(loaiNV, rowIndex, 7);
                    NhanVien nv = new NhanVien(maNV, tenNV, gioiTinh, CCCD, SDT, diaChi, caLam, new LoaiNhanVien(loaiNV));
                    if (nv_dao.editStaff(nv)) {
                        System.out.println("Sửa thành công");
                        JOptionPane.showMessageDialog(this, "Sửa thành công");
                    } else {
                        System.out.println("Sửa thất bại");
                        JOptionPane.showMessageDialog(this, "Sửa thất bại");
                    }
                }
            }

            clearJTable();
            DocDuLieu();
        } else {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa!");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        new DL_ThemNV().setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        String sdtNV = txtTim.getText().trim();
        if (!(sdtNV.length() > 0 && sdtNV.matches("\\d{10}"))) {
            CustomJOptionPane.showMessageDialog("Số điện thoại phải gồm 10 số !!!");
        } else {
            String maTim = txtTim.getText();
            ArrayList<NhanVien> dsNVTim = null;

            for (NhanVien nv : nv_dao.getalltbNhanVien()) {
                if (nv.getSDT().equals(maTim)) {
                    dsNVTim = new ArrayList<NhanVien>();
                    dsNVTim.add(nv);
                }
            }
            if (dsNVTim != null) {
                clearDataOnModel();
                for (NhanVien nv : dsNVTim) {
                    dtmNhanVien.addRow(new Object[]{
                        nv.getMaNV(), nv.getTenNV(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getCCCD(), nv.getSDT(),
                        nv.getDiaChi(), nv.getCaLam(), nv.getLoaiNV().getMaLoai()
                    });
                }
            } else if (dsNVTim == null) {
                CustomJOptionPane.showMessageDialog("Không tìm thấy !!!");
            }
        }


    }//GEN-LAST:event_btnTimActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        // TODO add your handling code here:
//        ArrayList<NhanVien> ds = nv_dao.getNVTheoLoai((LoaiNhanVien) cmbLoaiNhanVien.getSelectedItem());
//        if(ds.size() > 0){
//            clearJTable();
//            loadTable(ds);
//            return;
//        }else{
//            clearJTable();
//            JOptionPane.showMessageDialog(this, "Không tìm thấy !!!");
//        }
    }//GEN-LAST:event_btnLocActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_formMouseClicked

    private void updateTotalEmployees() {
        int totalEmployees = dtmNhanVien.getRowCount();
        txtTong.setText("" + totalEmployees);
    }

    private void btnCapNhatTotalNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatTotalNVActionPerformed
        // TODO add your handling code here:
        updateTotalEmployees();
    }//GEN-LAST:event_btnCapNhatTotalNVActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.swing.RadiusButton btnCapNhatTotalNV;
    private gui.swing.RadiusButton btnSua;
    private gui.swing.RadiusButton btnThem;
    private gui.swing.RadiusButton btnTim;
    private javax.swing.JLabel lblDSNV;
    private javax.swing.JLabel lblTim;
    private javax.swing.JLabel lblTong;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnlTraCuu;
    private javax.swing.JScrollPane scr;
    private javax.swing.JTable tblDSNV;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTong;
    // End of variables declaration//GEN-END:variables
}
