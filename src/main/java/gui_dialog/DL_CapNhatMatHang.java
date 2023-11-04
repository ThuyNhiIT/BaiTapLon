package gui_dialog;

/**
 *
 * @author 84343
 */
public class DL_CapNhatMatHang extends javax.swing.JFrame {

    public DL_CapNhatMatHang() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCapNhat = new javax.swing.JPanel();
        lblTiTleCN = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        lblGia = new javax.swing.JLabel();
        btnSua = new gui.swing.RadiusButton();
        btnThoat = new gui.swing.RadiusButton();
        btnXoaR = new gui.swing.RadiusButton();
        txtTenMH = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnCapNhat.setBackground(new java.awt.Color(255, 255, 255));

        lblTiTleCN.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTiTleCN.setForeground(new java.awt.Color(41, 173, 86));
        lblTiTleCN.setText("CẬP NHẬT MẶT HÀNG");

        lblTen.setText("Tên mặt hàng:");

        lblGia.setText("Giá:");

        btnSua.setBackground(new java.awt.Color(41, 173, 86));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
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

        btnXoaR.setBackground(new java.awt.Color(204, 204, 204));
        btnXoaR.setText("Xóa rỗng");

        javax.swing.GroupLayout pnCapNhatLayout = new javax.swing.GroupLayout(pnCapNhat);
        pnCapNhat.setLayout(pnCapNhatLayout);
        pnCapNhatLayout.setHorizontalGroup(
            pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCapNhatLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenMH)
                    .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                .addGap(110, 110, 110))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCapNhatLayout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addComponent(lblTiTleCN, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCapNhatLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(btnXoaR, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        pnCapNhatLayout.setVerticalGroup(
            pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCapNhatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTiTleCN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTen)
                    .addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGia)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
        return;
    }//GEN-LAST:event_btnThoatActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DL_CapNhatMatHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.swing.RadiusButton btnSua;
    private gui.swing.RadiusButton btnThoat;
    private gui.swing.RadiusButton btnXoaR;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblTiTleCN;
    private javax.swing.JPanel pnCapNhat;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtTenMH;
    // End of variables declaration//GEN-END:variables
}
