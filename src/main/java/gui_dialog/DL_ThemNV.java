package gui_dialog;

import connectDB.ConnectDB;
import dao.LoaiNV_DAO;
import dao.NhanVien_DAO;
import entity.LoaiNhanVien;
import entity.NhanVien;
import gui.form.Form_QuanLyNhanVien;
import gui.swing.CustomJOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author 84343
 */
public class DL_ThemNV extends javax.swing.JFrame {


    private NhanVien_DAO nv_dao;
    private LoaiNV_DAO loainv_dao;
    private Form_QuanLyNhanVien qlnv;
  
    public DL_ThemNV() {
        initComponents();
//        loadLoaiNhanVien();
        setLocationRelativeTo(null);
        nv_dao = new NhanVien_DAO();
        
        DefaultComboBoxModel<LoaiNhanVien> dataModelLop = new DefaultComboBoxModel<LoaiNhanVien>();
        cmbLNV.setModel(dataModelLop);
       
    }

   
    public String phatSinhMaNV(){
        List<NhanVien> nvs = nv_dao.getalltbNhanVien();
        String temp = null;
        for(NhanVien nv : nvs){
            temp = nv.getMaNV();
        }
        int count = laySoDuoi(temp);
        count++;
        
        String maNVien = String.format("NV%03d", count);
        return maNVien;
    }
    
    public int laySoDuoi(String str){
        if(str == null){
            return 0;
        }else{
            String numberStr = str.substring(2);//loại bỏ ký tự "NV"
            int number = Integer.parseInt(numberStr);//chuyển đổi chuỗi thành số nguyên
            return number;
        }
    }
    
//    public void loadLoaiNhanVien(){
//        ArrayList<LoaiNhanVien> ds = loainv_dao.getAllLoaiNhanVien();
//        if(ds == null){
//            return;
//        }
//        for(LoaiNhanVien loaiNhanVien : ds){
//            cmbLNV.addItem(loaiNhanVien);
//        }
//    }
    
    public NhanVien revertNhanVien(){
        String maNV = phatSinhMaNV();
        String tenNV = txtTenNV.getText();
        Boolean gioiTinh =  radNam.isSelected();
        String CCCD = txtCCCD.getText();
        String SDT = txtSDT.getText();
        String diaChi = txtDiaChi.getText();
        String caLam = "";
        if(radCa1.isSelected()){
           caLam = "Ca 1";
        }
        else if(radCa2.isSelected()){
           caLam = "Ca 2";
        }
        else if(radCa3.isSelected()){
           caLam = "Ca 3";
        }
        LoaiNhanVien loaiNV = (LoaiNhanVien) cmbLNV.getSelectedItem();
        
        return new NhanVien(maNV, tenNV, gioiTinh, CCCD, SDT, diaChi, caLam, loaiNV);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnThemNV = new javax.swing.JPanel();
        lblThemNV = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        lblTenNV = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        lblCCCD = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        lblLoaiNV = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        lblCa = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtCCCD = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        radNam = new javax.swing.JRadioButton();
        radNu = new javax.swing.JRadioButton();
        radCa1 = new javax.swing.JRadioButton();
        radCa2 = new javax.swing.JRadioButton();
        radCa3 = new javax.swing.JRadioButton();
        cmbLNV = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnThemNV.setBackground(new java.awt.Color(255, 255, 255));

        lblThemNV.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblThemNV.setForeground(new java.awt.Color(41, 173, 86));
        lblThemNV.setText("THÊM NHÂN VIÊN");

        lblMaNV.setText("Mã nhân viên:");

        lblTenNV.setText("Tên nhân viên:");

        lblDiaChi.setText("Địa chỉ:");

        lblCCCD.setText("CCCD");

        lblSDT.setText("Số điện thoại:");

        lblLoaiNV.setText("Loại nhân viên:");

        lblGioiTinh.setText("Giới tính:");

        lblCa.setText("Ca làm:");

        txtMaNV.setEditable(false);

        radNam.setText("Nam");

        radNu.setText("Nữ");

        radCa1.setText("Ca 1");

        radCa2.setText("Ca 2");

        radCa3.setText("Ca 3");

        javax.swing.GroupLayout pnThemNVLayout = new javax.swing.GroupLayout(pnThemNV);
        pnThemNV.setLayout(pnThemNVLayout);
        pnThemNVLayout.setHorizontalGroup(
            pnThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThemNVLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(pnThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCCCD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLoaiNV, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(lblGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThemNVLayout.createSequentialGroup()
                        .addGroup(pnThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(txtTenNV)
                            .addComponent(txtDiaChi)
                            .addComponent(txtCCCD)
                            .addComponent(txtSDT))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnThemNVLayout.createSequentialGroup()
                        .addGroup(pnThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radCa1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(pnThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(radNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radCa2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(radCa3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(pnThemNVLayout.createSequentialGroup()
                        .addComponent(cmbLNV, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThemNVLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
        );
        pnThemNVLayout.setVerticalGroup(
            pnThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThemNVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaNV)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiaChi)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCCCD)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSDT)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoaiNV)
                    .addComponent(cmbLNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGioiTinh)
                    .addComponent(radNam)
                    .addComponent(radNu))
                .addGap(18, 18, 18)
                .addGroup(pnThemNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCa)
                    .addComponent(radCa1)
                    .addComponent(radCa2)
                    .addComponent(radCa3))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnThemNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnThemNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
        return;
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        ConnectDB db = ConnectDB.getInstance();
        try {
            db.connect();
            NhanVien addNV = revertNhanVien();
            System.err.println(addNV);
            Boolean isSuccess = nv_dao.addStaff(addNV);
            if(isSuccess){
                CustomJOptionPane.showMessageDialog("Thêm nhân viên thành công !");
                this.dispose();
            }
            else{
                CustomJOptionPane.showMessageDialog("Thêm nhân viên không thành công !");
            }
//       qlnv.DocDuLieu();
        } catch (SQLException ex) {
            Logger.getLogger(DL_ThemNV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void cmbLNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLoaiNVActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cmbLoaiNVActionPerformed

 
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DL_ThemNV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<LoaiNhanVien> cmbLNV;
    private javax.swing.JLabel lblCCCD;
    private javax.swing.JLabel lblCa;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblLoaiNV;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTenNV;
    private javax.swing.JLabel lblThemNV;
    private javax.swing.JPanel pnThemNV;
    private javax.swing.JRadioButton radCa1;
    private javax.swing.JRadioButton radCa2;
    private javax.swing.JRadioButton radCa3;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
