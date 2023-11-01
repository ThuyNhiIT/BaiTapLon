package gui_dialog;

/**
 *
 * @author 84343
 */
public class DL_ThemPhong extends javax.swing.JFrame {

    public DL_ThemPhong() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnThemPhong = new javax.swing.JPanel();
        lblThemPhong = new javax.swing.JLabel();
        lblMaPhong = new javax.swing.JLabel();
        lblTenPhong = new javax.swing.JLabel();
        lblLoaiPhong = new javax.swing.JLabel();
        lblMaLoaiPhong = new javax.swing.JLabel();
        lblGia = new javax.swing.JLabel();
        lblTrangThai = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        txtTenPhong = new javax.swing.JTextField();
        txtMaLoaiPhong = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        radVIP = new javax.swing.JRadioButton();
        radThuong = new javax.swing.JRadioButton();
        radTrong = new javax.swing.JRadioButton();
        radSuDung = new javax.swing.JRadioButton();
        radCho = new javax.swing.JRadioButton();
        btnThem = new gui.swing.RadiusButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnThemPhong.setBackground(new java.awt.Color(255, 255, 255));

        lblThemPhong.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblThemPhong.setForeground(new java.awt.Color(41, 173, 86));
        lblThemPhong.setText("THÊM PHÒNG HÁT");

        lblMaPhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMaPhong.setText("Mã phòng:");

        lblTenPhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenPhong.setText("Tên phòng:");

        lblLoaiPhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblLoaiPhong.setText("Loại phòng:");

        lblMaLoaiPhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMaLoaiPhong.setText("Mã loại phòng:");

        lblGia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGia.setText("Giá:");

        lblTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTrangThai.setText("Trạng thái:");

        txtMaPhong.setEditable(false);
        txtMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhongActionPerformed(evt);
            }
        });

        txtTenPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenPhongActionPerformed(evt);
            }
        });

        txtMaLoaiPhong.setEditable(false);

        txtGia.setEditable(false);

        radVIP.setText("Phòng VIP");
        radVIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radVIPActionPerformed(evt);
            }
        });

        radThuong.setText("Phòng thường");

        radTrong.setText("Phòng trống");

        radSuDung.setText("Phòng đang sử dụng");

        radCho.setText("Phòng chờ");
        radCho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radChoActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(41, 173, 86));
        btnThem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");

        javax.swing.GroupLayout pnThemPhongLayout = new javax.swing.GroupLayout(pnThemPhong);
        pnThemPhong.setLayout(pnThemPhongLayout);
        pnThemPhongLayout.setHorizontalGroup(
            pnThemPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThemPhongLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnThemPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThemPhongLayout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(217, 217, 217))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThemPhongLayout.createSequentialGroup()
                        .addComponent(lblThemPhong)
                        .addGap(176, 176, 176))))
            .addGroup(pnThemPhongLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(pnThemPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThemPhongLayout.createSequentialGroup()
                        .addComponent(lblMaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(pnThemPhongLayout.createSequentialGroup()
                        .addGroup(pnThemPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGia, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnThemPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnThemPhongLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnThemPhongLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnThemPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnThemPhongLayout.createSequentialGroup()
                                        .addComponent(radVIP, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62)
                                        .addComponent(radThuong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(radTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(radSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(radCho, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnThemPhongLayout.setVerticalGroup(
            pnThemPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThemPhongLayout.createSequentialGroup()
                .addComponent(lblThemPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(pnThemPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaPhong)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThemPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenPhong)
                    .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThemPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoaiPhong)
                    .addComponent(radVIP)
                    .addComponent(radThuong))
                .addGap(18, 18, 18)
                .addGroup(pnThemPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaLoaiPhong)
                    .addComponent(txtMaLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThemPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGia))
                .addGap(18, 18, 18)
                .addGroup(pnThemPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radTrong)
                    .addComponent(lblTrangThai))
                .addGap(18, 18, 18)
                .addComponent(radSuDung)
                .addGap(18, 18, 18)
                .addComponent(radCho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnThemPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnThemPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenPhongActionPerformed

    private void radVIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radVIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radVIPActionPerformed

    private void radChoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radChoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radChoActionPerformed

    private void txtMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhongActionPerformed

  
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DL_ThemPhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.swing.RadiusButton btnThem;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblLoaiPhong;
    private javax.swing.JLabel lblMaLoaiPhong;
    private javax.swing.JLabel lblMaPhong;
    private javax.swing.JLabel lblTenPhong;
    private javax.swing.JLabel lblThemPhong;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JPanel pnThemPhong;
    private javax.swing.JRadioButton radCho;
    private javax.swing.JRadioButton radSuDung;
    private javax.swing.JRadioButton radThuong;
    private javax.swing.JRadioButton radTrong;
    private javax.swing.JRadioButton radVIP;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaLoaiPhong;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtTenPhong;
    // End of variables declaration//GEN-END:variables
}
