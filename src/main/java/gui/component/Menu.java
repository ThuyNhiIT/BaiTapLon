package gui.component;

import gui.event.EventMenu;
import gui.model.ModelMenu;
import gui.swing.MenuAnimation;
import gui.swing.MenuItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import gui.event.EventMenuSelected;

/**
 *
 * @author HO MINH HAU
 */
public class Menu extends javax.swing.JPanel {

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnbleMenu(boolean enbleMenu) {
        this.enbleMenu = enbleMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    private EventMenuSelected event;
    private boolean enbleMenu = true;
    private boolean showMenu = true;
    private final MigLayout layout;

    public Menu() {
        initComponents();
        setOpaque(false);
                layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");

        panelItem.setLayout(layout);
        panelSetting.setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]"));
        
    }

    public void initMenuItem() {
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/TrangChu1.png")), "Trang Chủ"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/choices.png")), "Quản Lí Đặt Phòng"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/QuanLyPhongHat2.png")), "Quản Lí Phòng Hát"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/add-user.png")), "Quản Lí Khách Hàng"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/add-to-basket.png")), "Quản Lí Mặt Hàng", "     Mặt Hàng", "     Dịch Vụ"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/teamwork.png")), "Quản Lí Nhân Viên "));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/bar-chart.png")), "Thống Kê","     Thống Kê Mặt Hàng","     Thống Kê Doanh Thu"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/setting.png")), "Cài Đặt"));
        
    }

    private void addMenu(ModelMenu menu) {
        if (menu.getMenuName().equals("Cài Đặt")) {
            panelSetting.add(new MenuItem(menu, getEventMenu(), event, panelItem.getComponentCount()), "h 30!, pushy, growy");
            
        } else {
            panelItem.add(new MenuItem(menu, getEventMenu(), event, panelItem.getComponentCount()), "h 53!");
        }
    }

    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enbleMenu) {
                    if (showMenu) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        System.out.println("show pupup menu(close)");
                    }
                }
                return false;
            }
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        panelItem = new javax.swing.JPanel();
        panelSetting = new javax.swing.JPanel();
        panelPopUpMenu = new javax.swing.JPanel();
        btnMenu = new gui.swing.Button();
        lblTitle = new javax.swing.JLabel();

        Menu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(190, 680));

        panelItem.setBackground(new java.awt.Color(255, 255, 255));
        panelItem.setOpaque(false);
        panelItem.setPreferredSize(new java.awt.Dimension(190, 535));

        javax.swing.GroupLayout panelItemLayout = new javax.swing.GroupLayout(panelItem);
        panelItem.setLayout(panelItemLayout);
        panelItemLayout.setHorizontalGroup(
            panelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelItemLayout.setVerticalGroup(
            panelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        panelSetting.setBackground(new java.awt.Color(255, 255, 255));
        panelSetting.setOpaque(false);
        panelSetting.setPreferredSize(new java.awt.Dimension(190, 100));

        javax.swing.GroupLayout panelSettingLayout = new javax.swing.GroupLayout(panelSetting);
        panelSetting.setLayout(panelSettingLayout);
        panelSettingLayout.setHorizontalGroup(
            panelSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelSettingLayout.setVerticalGroup(
            panelSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelPopUpMenu.setOpaque(false);

        btnMenu.setBackground(new java.awt.Color(0, 136, 169));
        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Menu_1.png"))); // NOI18N
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Segoe UI", 3, 17)); // NOI18N
        lblTitle.setText("KARAOKE APLUS");

        javax.swing.GroupLayout panelPopUpMenuLayout = new javax.swing.GroupLayout(panelPopUpMenu);
        panelPopUpMenu.setLayout(panelPopUpMenuLayout);
        panelPopUpMenuLayout.setHorizontalGroup(
            panelPopUpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPopUpMenuLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPopUpMenuLayout.setVerticalGroup(
            panelPopUpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPopUpMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPopUpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelItem, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
            .addComponent(panelSetting, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
            .addComponent(panelPopUpMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelPopUpMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelItem, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelSetting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        btnMenu.addActionListener(evt);
    }//GEN-LAST:event_btnMenuActionPerformed

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(
                0, 0, Color.decode("#0081A7"), // Màu bắt đầu
                getWidth(), 0, Color.decode("#00AFB9") // Màu kết thúc
        );
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menu;
    private gui.swing.Button btnMenu;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelItem;
    private javax.swing.JPanel panelPopUpMenu;
    private javax.swing.JPanel panelSetting;
    // End of variables declaration//GEN-END:variables
}
