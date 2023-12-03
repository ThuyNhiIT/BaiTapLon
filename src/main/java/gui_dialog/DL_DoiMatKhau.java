package gui_dialog;

import dao.DoiMatKhau_DAO;
import entity.NhanVien;
import gui.form.Form_Login;
import javax.swing.JOptionPane;

/**
 *
 * @author 84343
 */
public class DL_DoiMatKhau extends javax.swing.JFrame {

    public DL_DoiMatKhau() {
        initComponents();
        setLocationRelativeTo(null);
        setMaNV();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        pnlTong = new javax.swing.JPanel();
        lblDoiMK = new javax.swing.JLabel();
        lblMKcu = new javax.swing.JLabel();
        lblMKmoi = new javax.swing.JLabel();
        lblNhapLai = new javax.swing.JLabel();
        btnLuu = new gui.swing.RadiusButton();
        btnXoaR = new gui.swing.RadiusButton();
        btnThoat = new gui.swing.RadiusButton();
        lblTenDangNhap = new javax.swing.JLabel();
        txtTenDangNhap = new gui.swing.CustomJTextField();
        txtMKCu = new gui.swing.CustomJPasswordField();
        txtMKMoi = new gui.swing.CustomJPasswordField();
        txtConfirmMKMoi = new gui.swing.CustomJPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        pnlTong.setBackground(new java.awt.Color(255, 255, 255));

        lblDoiMK.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblDoiMK.setForeground(new java.awt.Color(41, 173, 86));
        lblDoiMK.setText("ĐỔI MẬT KHẨU");

        lblMKcu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMKcu.setText("Mật khẩu cũ ");

        lblMKmoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMKmoi.setText("Mật khẩu mới");

        lblNhapLai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNhapLai.setText("Nhập lại mật khẩu mới ");

        btnLuu.setBackground(new java.awt.Color(41, 173, 86));
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnXoaR.setBackground(new java.awt.Color(204, 204, 204));
        btnXoaR.setText("Xóa rỗng");
        btnXoaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaRActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(205, 13, 13));
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        lblTenDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenDangNhap.setText("Tên đăng nhập");

        txtTenDangNhap.setEditable(false);
        txtTenDangNhap.setRequestFocusEnabled(false);

        javax.swing.GroupLayout pnlTongLayout = new javax.swing.GroupLayout(pnlTong);
        pnlTong.setLayout(pnlTongLayout);
        pnlTongLayout.setHorizontalGroup(
            pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTongLayout.createSequentialGroup()
                .addContainerGap(192, Short.MAX_VALUE)
                .addComponent(lblDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
            .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlTongLayout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlTongLayout.createSequentialGroup()
                                .addComponent(lblNhapLai, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtConfirmMKMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlTongLayout.createSequentialGroup()
                                .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMKcu)
                                    .addComponent(lblMKmoi, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMKCu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenDangNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMKMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(pnlTongLayout.createSequentialGroup()
                            .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(btnXoaR, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(58, 58, 58)
                            .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(76, Short.MAX_VALUE)))
        );
        pnlTongLayout.setVerticalGroup(
            pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTongLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
            .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlTongLayout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTenDangNhap)
                        .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(23, 23, 23)
                    .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMKcu)
                        .addComponent(txtMKCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMKmoi)
                        .addComponent(txtMKMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(34, 34, 34)
                    .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNhapLai)
                        .addComponent(txtConfirmMKMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(41, 41, 41)
                    .addGroup(pnlTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoaR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(32, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaRActionPerformed
        txtMKCu.setText("");
        txtMKMoi.setText("");
        txtConfirmMKMoi.setText("");
        
        txtMKCu.requestFocus();
    }//GEN-LAST:event_btnXoaRActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        NhanVien nvDMK = Form_Login.getNhanVienDangNhap();
        String tenDangNhap = nvDMK.getMaNV();
        String matKhauCu = new String(txtMKCu.getPassword());
        String matKhauMoi = new String(txtMKMoi.getPassword());
        String confirmMatKhauMoi = new String(txtConfirmMKMoi.getPassword());

        // Add validation for empty fields or any other necessary checks
        if (!matKhauMoi.equals(confirmMatKhauMoi)) {
            // Show an error message or handle the password mismatch
            System.out.println("Mật khẩu mới không khớp.");
            return;
        }

        DoiMatKhau_DAO doiMatKhauDAO = new DoiMatKhau_DAO();
        boolean success = doiMatKhauDAO.doiMatKhau(tenDangNhap, matKhauMoi);

        if (success) {
            // Show a success message or perform any other necessary actions
            JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công !!!");
            this.dispose();
            System.out.println("Đổi mật khẩu thành công.");
            
        } else {
            // Show an error message or handle the password update failure
            JOptionPane.showMessageDialog(this, "Đổi mật khẩu thất bại ! Vui lòng thử lại !");
            System.out.println("Đổi mật khẩu thất bại.");
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void setMaNV(){
        NhanVien nvDMK = Form_Login.getNhanVienDangNhap();
        if(nvDMK != null){
            txtTenDangNhap.setText(nvDMK.getMaNV());
        }
    }
    
    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
        return;
    }//GEN-LAST:event_btnThoatActionPerformed

    
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DL_DoiMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.swing.RadiusButton btnLuu;
    private gui.swing.RadiusButton btnThoat;
    private gui.swing.RadiusButton btnXoaR;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lblDoiMK;
    private javax.swing.JLabel lblMKcu;
    private javax.swing.JLabel lblMKmoi;
    private javax.swing.JLabel lblNhapLai;
    private javax.swing.JLabel lblTenDangNhap;
    private javax.swing.JPanel pnlTong;
    private gui.swing.CustomJPasswordField txtConfirmMKMoi;
    private gui.swing.CustomJPasswordField txtMKCu;
    private gui.swing.CustomJPasswordField txtMKMoi;
    private gui.swing.CustomJTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
