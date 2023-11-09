package gui.form;

import dao.NhanVien_DAO;
import entity.NhanVien;
import gui.swing.CustomJOptionPane;
import gui_dialog.DL_SuaNV;
import gui_dialog.DL_ThemNV;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author HO MINH HAU
 */
public class Form_QuanLyNhanVien extends javax.swing.JPanel {

    private NhanVien_DAO nv_dao;
    private DefaultTableModel dtmNhanVien;


    public Form_QuanLyNhanVien() {
        initComponents();
        nv_dao = new NhanVien_DAO();
        dtmNhanVien = (DefaultTableModel) tblDSNV.getModel();

//        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
//        for (int i = 0; i < tblDSNV.getColumnCount(); i++) {
//            tblDSNV.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
//        }

//        DocDuLieu();
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

    public void clearDataOnModel(){
        DefaultTableModel dtm = (DefaultTableModel) tblDSNV.getModel();
        dtm.getDataVector().removeAllElements();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNhanVien = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        btnTim = new gui.swing.RadiusButton();
        btnThem = new gui.swing.RadiusButton();
        btnSua = new gui.swing.RadiusButton();
        txtTim = new javax.swing.JTextField();
        cmb = new javax.swing.JComboBox<>();
        lblDSNV = new javax.swing.JLabel();
        scr = new javax.swing.JScrollPane();
        tblDSNV = new javax.swing.JTable();
        lblTong = new javax.swing.JLabel();
        txtTong = new javax.swing.JTextField();

        pnlNhanVien.setBackground(new java.awt.Color(235, 249, 249));
        pnlNhanVien.setFocusCycleRoot(true);

        pnlHeader.setBackground(new java.awt.Color(235, 249, 249));
        pnlHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnTim.setBackground(new java.awt.Color(166, 208, 238));
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(41, 173, 86));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(205, 13, 13));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(cmb, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(532, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblDSNV.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblDSNV.setText("DANH SÁCH NHÂN VIÊN");

        tblDSNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Giới tính", "CCCD", "Số điện thoại", "Địa chỉ", "Ca", "Loại NV"
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.swing.RadiusButton btnSua;
    private gui.swing.RadiusButton btnThem;
    private gui.swing.RadiusButton btnTim;
    private javax.swing.JComboBox<String> cmb;
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
