package gui_dialog;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import entity.KhachHang;
import java.awt.List;
import java.util.ArrayList;
import gui.form.Form_QuanLyKhachHang;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 84343
 */
public class DL_ThongTinKhachHang extends javax.swing.JFrame {

    private KhachHang_DAO kh_dao;
    private JTable tblDSKH;
    private DefaultTableModel dtmKhachHang;
    
    public DL_ThongTinKhachHang() {
        initComponents();
        setLocationRelativeTo(null);
        
    }

//    public  String phatSinhMaKH(){
//        List<KhachHang> khs = kh_dao.docTuBang();
//        String temp = null;
//        for(KhachHang kh : khs){
//            temp = kh.getMaKH();
//        }
//        int count = 
//    }
    
   public boolean validData(){
       String maKH = txtMaKH.getText();
       String tenKH = txtTenKH.getText();
       String SDT = txtSDT.getText();
       return true;
   }
   
   public KhachHang revertKhachHang(){
       String maKH = txtMaKH.getText().trim();
       String tenKH = txtTenKH.getText().trim();
       String SDT = txtSDT.getText().trim();
       Boolean gioiTinh = radNam.isSelected();
       
       return new KhachHang(maKH, tenKH, SDT, gioiTinh);
   }
   
//   public void DocDuLieu() {
//        java.util.List<KhachHang> list = kh_dao.getalltbKhachHang();
//        for (KhachHang kh : list) {
//            dtmKhachHang.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.isGioitinh() ? "Nam" : "Nữ"});
//        }
//    }
    
    public void loadTable(ArrayList<KhachHang> ds){
        if(ds == null){
            clearJTable();
            return;
        }
        clearJTable();
        for(KhachHang khachHang : ds){
            dtmKhachHang.addRow(khachHang.getObject());
        }
    }

    public void clearJTable(){
        while(tblDSKH.getRowCount() > 0){
            dtmKhachHang.removeRow(0);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnXoaR = new gui.swing.RadiusButton();
        btnThem = new gui.swing.RadiusButton();
        lblThongTinKH = new javax.swing.JLabel();
        lblMaKH = new javax.swing.JLabel();
        lblTenKH = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        radNam = new javax.swing.JRadioButton();
        radNu = new javax.swing.JRadioButton();
        btnThoat = new gui.swing.RadiusButton();
        txtMaKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnXoaR.setBackground(new java.awt.Color(204, 204, 204));
        btnXoaR.setText("Xóa rỗng");
        btnXoaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaRActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(65, 194, 33));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        lblThongTinKH.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblThongTinKH.setForeground(new java.awt.Color(65, 194, 33));
        lblThongTinKH.setText("THÔNG TIN KHÁCH HÀNG");

        lblMaKH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMaKH.setText("Mã khách hàng:");

        lblTenKH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenKH.setText("Tên khách hàng:");

        lblSDT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSDT.setText("Số điện thoại:");

        lblGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGioiTinh.setText("Giới tính:");

        radNam.setText("Nam");
        radNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNamActionPerformed(evt);
            }
        });

        radNu.setText("Nữ");

        btnThoat.setBackground(new java.awt.Color(205, 13, 13));
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        txtMaKH.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(256, Short.MAX_VALUE)
                .addComponent(lblThongTinKH, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(333, 333, 333)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(70, 70, 70)
                                    .addComponent(btnXoaR, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(76, 76, 76)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSDT)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(radNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(1, 1, 1)
                                    .addComponent(radNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(61, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblThongTinKH, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMaKH)
                        .addComponent(lblSDT)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(50, 50, 50)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTenKH)
                        .addComponent(lblGioiTinh)
                        .addComponent(radNam)
                        .addComponent(radNu)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoaR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(32, 32, 32)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radNamActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        if(validData()){
            KhachHang kh = revertKhachHang();
            if(!kh_dao.addCustomer(kh)){
                JOptionPane.showMessageDialog(this, "Thêm không thành công !" );
            }
            else{
//                loadTable(kh_dao.getalltbKhachHang());
                  new Form_QuanLyKhachHang().loadTable(kh_dao.getalltbKhachHang());
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    ConnectDB db = ConnectDB.getInstance();
//    db.connect
    
    private void btnXoaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaRActionPerformed
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtSDT.setText("");
        radNu.setSelected(false);
        radNam.setSelected(false);
        txtTenKH.requestFocus();

    }//GEN-LAST:event_btnXoaRActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
        return;
    }//GEN-LAST:event_btnThoatActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DL_ThongTinKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.swing.RadiusButton btnThem;
    private gui.swing.RadiusButton btnThoat;
    private gui.swing.RadiusButton btnXoaR;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblThongTinKH;
    private javax.swing.JRadioButton radNam;
    private javax.swing.JRadioButton radNu;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
