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

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tblDSNV.getColumnCount(); i++) {
            tblDSNV.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

//        DefaultComboBoxModel<LoaiNhanVien> dataModelLop = new DefaultComboBoxModel<LoaiNhanVien>();
//        cmbLoaiNhanVien.setModel(dataModelLop);
//        DocDuLieu();
//        loadLoaiNhanVien();
        loadTable(nv_dao.getalltbNhanVien());
    }
//    
    public void loadTable(ArrayList<NhanVien> ds){
        if(ds == null){
            clearJTable();
            return;
        }
        clearJTable();
        for(NhanVien nhanVien : ds){
            dtmNhanVien.addRow(new Object[] {nhanVien.getMaNV(), nhanVien.getTenNV(), nhanVien.isGioiTinh() ? "Nam" : "Nữ",
                        nhanVien.getCCCD(), nhanVien.getSDT(), nhanVien.getDiaChi(), nhanVien.getCaLam(), nhanVien.getLoaiNV().getMaLoai()});
        }
    }
    
    
    public void clearJTable(){
        while(tblDSNV.getRowCount() > 0){
           dtmNhanVien.removeRow(0);
        }
    }
    public void DocDuLieu(){
        List<NhanVien> list = nv_dao.getalltbNhanVien();
        for(NhanVien nv : list){
            dtmNhanVien.addRow(new Object[] {
                nv.getMaNV(), nv.getTenNV(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getSDT(), nv.getCCCD(), nv.getSDT(),
                nv.getDiaChi(), nv.getCaLam(), nv.getLoaiNV().getMaLoai()
            });
        }

    }
    
//    public void loadLoaiNhanVien(){
//        ArrayList<LoaiNhanVien> ds = loainv_dao.getAllLoaiNhanVien();
//        if(ds == null){
//            return;
//        }
//        for(LoaiNhanVien loaiNhanVien : ds){
//            cmbLoaiNhanVien.addItem(loaiNhanVien);
//        }
//    }

    public void clearDataOnModel(){
        DefaultTableModel dtm = (DefaultTableModel) tblDSNV.getModel();
        dtm.getDataVector().removeAllElements();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNhanVien = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        txtTim = new javax.swing.JTextField();
        lblDSNV = new javax.swing.JLabel();
        scr = new javax.swing.JScrollPane();
        tblDSNV = new javax.swing.JTable();
        lblTong = new javax.swing.JLabel();
        txtTong = new javax.swing.JTextField();

        pnlNhanVien.setBackground(new java.awt.Color(235, 249, 249));
        pnlNhanVien.setFocusCycleRoot(true);

        pnlHeader.setBackground(new java.awt.Color(235, 249, 249));
        pnlHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        lblDSNV.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblDSNV.setText("DANH SÁCH NHÂN VIÊN");

        tblDSNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Địa chỉ", "CCCD", "Số điện thoại", "Loại nhân viên", "Ca", "Giới tính"
            }
        ));
        scr.setViewportView(tblDSNV);

        lblTong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTong.setText("Tổng số nhân viên:");

        txtTong.setEditable(false);
        txtTong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongActionPerformed(evt);
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
                        .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(27, 27, 27)
                .addGroup(pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTong)
                    .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
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
        new DL_SuaNV().setVisible(true);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtTongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        new DL_ThemNV().setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        String maNhanVien =  txtTim.getText().trim();
        if(!(maNhanVien.length() > 0 && maNhanVien.matches("(NV)\\d{3}"))){
            CustomJOptionPane.showMessageDialog("Mã nhân viên không hợp lệ !!!");
        }
        else{
            String maTim = txtTim.getText();
            ArrayList<NhanVien> dsNVtim = null;
            
            for(NhanVien nv : nv_dao.getalltbNhanVien()){
                if(nv.getMaNV().equals(maTim)){
                    dsNVtim = new ArrayList<NhanVien>();
                    dsNVtim.add(nv);
                }
            }
            if(dsNVtim != null){
                clearDataOnModel();
                for(NhanVien nv : dsNVtim){
                    dtmNhanVien.addRow(new Object[]{
                      nv.getMaNV(), nv.getTenNV(), nv.isGioiTinh() ? "Nam" : "Nữ", nv.getSDT(), nv.getCCCD(), nv.getSDT(),
                      nv.getDiaChi(), nv.getCaLam(), nv.getLoaiNV().getMaLoai()
                    });
                }
            }
            else if(dsNVtim == null){
                CustomJOptionPane.showMessageDialog("Không tìm thấy nhân viên !!!");
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDSNV;
    private javax.swing.JLabel lblTong;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JScrollPane scr;
    private javax.swing.JTable tblDSNV;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTong;
    // End of variables declaration//GEN-END:variables
}
