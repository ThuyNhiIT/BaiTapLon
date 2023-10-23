package gui.component;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 * Đây là class Header, chứa nút btnMneu để thu nhỏ hay mở rộng menu và cách thành phần khác như , dồng hồ , tên nhân viên,....
 * 
 * @author HO MINH HAU
 */
public class Header extends javax.swing.JPanel {

    private boolean isMenuOpen = false; // Ban đầu, menu chưa mở.

    /**
     * Creates new form Header
     */
    public Header() {
        initComponents();
        setOpaque(false);
    }
/**
 * sự kiện cho nút menu
 * @param evt 
 */
    public void addMenuEvent(ActionListener evt) {
        btnMenu.addActionListener(evt);

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gradient = new GradientPaint(
                0, 0, Color.decode("#00AFB9"), // Màu bắt đầu (#c471ed)
                getWidth(), 0, Color.WHITE // Màu kết thúc (trắng)
        );

        // Vẽ gradient
        g2.setPaint(gradient);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMenu = new gui.swing.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(910, 50));

        btnMenu.setBackground(new java.awt.Color(0, 173, 184));
        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/left.png"))); // NOI18N
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 869, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public gui.swing.Button btnMenu;
    // End of variables declaration//GEN-END:variables
}
