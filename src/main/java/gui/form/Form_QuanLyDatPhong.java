package gui.form;

/**
 *
 * @author HO MINH HAU
 */
public class Form_QuanLyDatPhong extends javax.swing.JPanel {


    public Form_QuanLyDatPhong() {
        initComponents();
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCover = new javax.swing.JPanel();
        materialTabbed2 = new gui.swing.tabbed.MaterialTabbed();
        pnlPhongTrong = new javax.swing.JPanel();
        pnlPhongDangSuDung = new javax.swing.JPanel();
        pnlPhongCho = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        pnlCover.setBackground(new java.awt.Color(255, 255, 255));

        materialTabbed2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        pnlPhongTrong.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlPhongTrongLayout = new javax.swing.GroupLayout(pnlPhongTrong);
        pnlPhongTrong.setLayout(pnlPhongTrongLayout);
        pnlPhongTrongLayout.setHorizontalGroup(
            pnlPhongTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1041, Short.MAX_VALUE)
        );
        pnlPhongTrongLayout.setVerticalGroup(
            pnlPhongTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        materialTabbed2.addTab("Phòng trống", pnlPhongTrong);

        pnlPhongDangSuDung.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlPhongDangSuDungLayout = new javax.swing.GroupLayout(pnlPhongDangSuDung);
        pnlPhongDangSuDung.setLayout(pnlPhongDangSuDungLayout);
        pnlPhongDangSuDungLayout.setHorizontalGroup(
            pnlPhongDangSuDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1041, Short.MAX_VALUE)
        );
        pnlPhongDangSuDungLayout.setVerticalGroup(
            pnlPhongDangSuDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        materialTabbed2.addTab("Phòng đang sử dụng", pnlPhongDangSuDung);

        pnlPhongCho.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlPhongChoLayout = new javax.swing.GroupLayout(pnlPhongCho);
        pnlPhongCho.setLayout(pnlPhongChoLayout);
        pnlPhongChoLayout.setHorizontalGroup(
            pnlPhongChoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1041, Short.MAX_VALUE)
        );
        pnlPhongChoLayout.setVerticalGroup(
            pnlPhongChoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        materialTabbed2.addTab("Phòng chờ", pnlPhongCho);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1041, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        materialTabbed2.addTab("Phòng tạm ngưng", jPanel1);

        javax.swing.GroupLayout pnlCoverLayout = new javax.swing.GroupLayout(pnlCover);
        pnlCover.setLayout(pnlCoverLayout);
        pnlCoverLayout.setHorizontalGroup(
            pnlCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCoverLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(materialTabbed2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCoverLayout.setVerticalGroup(
            pnlCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCoverLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(materialTabbed2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private gui.swing.tabbed.MaterialTabbed materialTabbed2;
    private javax.swing.JPanel pnlCover;
    private javax.swing.JPanel pnlPhongCho;
    private javax.swing.JPanel pnlPhongDangSuDung;
    private javax.swing.JPanel pnlPhongTrong;
    // End of variables declaration//GEN-END:variables
}
