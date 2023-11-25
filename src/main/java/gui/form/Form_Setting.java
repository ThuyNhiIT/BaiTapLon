package gui.form;

import gui.main.Main;
import gui_dialog.DL_DoiMatKhau;
import java.awt.Desktop;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author HO MINH HAU
 */
public class Form_Setting extends javax.swing.JPanel {

    public Form_Setting() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCaiDat = new javax.swing.JPanel();
        DoiMK = new javax.swing.JButton();
        HDSD = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();

        pnlCaiDat.setBackground(new java.awt.Color(235, 249, 249));

        DoiMK.setBackground(new java.awt.Color(205, 13, 13));
        DoiMK.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        DoiMK.setForeground(new java.awt.Color(255, 255, 255));
        DoiMK.setText("Đổi mật khẩu");
        DoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoiMKActionPerformed(evt);
            }
        });

        HDSD.setBackground(new java.awt.Color(41, 173, 86));
        HDSD.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        HDSD.setForeground(new java.awt.Color(255, 255, 255));
        HDSD.setText("Hướng dẫn sử dụng");
        HDSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HDSDActionPerformed(evt);
            }
        });

        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCaiDatLayout = new javax.swing.GroupLayout(pnlCaiDat);
        pnlCaiDat.setLayout(pnlCaiDatLayout);
        pnlCaiDatLayout.setHorizontalGroup(
            pnlCaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCaiDatLayout.createSequentialGroup()
                .addGap(369, 369, 369)
                .addGroup(pnlCaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HDSD, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addComponent(DoiMK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(402, 402, 402))
        );
        pnlCaiDatLayout.setVerticalGroup(
            pnlCaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCaiDatLayout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(DoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(HDSD, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCaiDat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCaiDat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void DoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoiMKActionPerformed
        new DL_DoiMatKhau().setVisible(true);
    }//GEN-LAST:event_DoiMKActionPerformed


    private void DangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangXuatActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_DangXuatActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất không?") == 0) {
            // Đóng chương trình
            System.exit(0);

            // Tạo phiên bản mới của màn hình đăng nhập và hiển thị nó
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Form_Login().setVisible(true);
                }
            });
        }
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void HDSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HDSDActionPerformed
       try{
            Desktop.getDesktop().browse(new URL("https://wordpress.com/home/nguyenthiquynhgiang.wordpress.com?source=pwa").toURI());
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_HDSDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DoiMK;
    private javax.swing.JButton HDSD;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JPanel pnlCaiDat;
    // End of variables declaration//GEN-END:variables
}
