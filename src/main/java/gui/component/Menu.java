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
import gui.event.EventShowPopUpMenu;
import java.awt.event.ActionListener;

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

    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEventShowPopUpMenu(EventShowPopUpMenu eventShowPopUpMenu) {
        this.eventShowPopUpMenu = eventShowPopUpMenu;
    }
    private EventMenuSelected event;
    private boolean enbleMenu = true;
    private boolean showMenu = true;
    private final MigLayout layout;
    private EventShowPopUpMenu eventShowPopUpMenu;

    public Menu() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");

        pnlItem.setLayout(layout);
        pnlSetting.setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]"));

    }

    public void initMenuItem() {
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/TrangChu1.png")), "Trang Chủ"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/choices.png")), "Quản Lí Đặt Phòng"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/QuanLyPhongHat2.png")), "Quản Lí Phòng Hát"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/add-user.png")), "Quản Lí Khách Hàng"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/add-to-basket.png")), "Quản Lí Mặt Hàng", "     Mặt Hàng", "     Dịch Vụ"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/teamwork.png")), "Quản Lí Nhân Viên "));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/bar-chart.png")), "Thống Kê", "     Thống Kê Mặt Hàng", "     Thống Kê Doanh Thu"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/icon/setting.png")), "Cài Đặt"));

    }

    private void addMenu(ModelMenu menu) {
        if (menu.getMenuName().equals("Cài Đặt")) {
            pnlSetting.add(new MenuItem(menu, getEventMenu(), event, pnlItem.getComponentCount()), "h 30!, pushy, growy");

        } else {
            pnlItem.add(new MenuItem(menu, getEventMenu(), event, pnlItem.getComponentCount()), "h 53!");
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
                       eventShowPopUpMenu.showPopUp(com);
                    }
                }
                return false;
            }
        };
    }

    public void hideallMenu() {
        for (Component com : pnlItem.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        pnlItem = new javax.swing.JPanel();
        pnlSetting = new javax.swing.JPanel();
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

        pnlItem.setBackground(new java.awt.Color(255, 255, 255));
        pnlItem.setOpaque(false);
        pnlItem.setPreferredSize(new java.awt.Dimension(190, 535));

        javax.swing.GroupLayout pnlItemLayout = new javax.swing.GroupLayout(pnlItem);
        pnlItem.setLayout(pnlItemLayout);
        pnlItemLayout.setHorizontalGroup(
            pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlItemLayout.setVerticalGroup(
            pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        pnlSetting.setBackground(new java.awt.Color(255, 255, 255));
        pnlSetting.setOpaque(false);
        pnlSetting.setPreferredSize(new java.awt.Dimension(190, 100));

        javax.swing.GroupLayout pnlSettingLayout = new javax.swing.GroupLayout(pnlSetting);
        pnlSetting.setLayout(pnlSettingLayout);
        pnlSettingLayout.setHorizontalGroup(
            pnlSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlSettingLayout.setVerticalGroup(
            pnlSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        lblTitle.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblTitle.setText("KARAOKE APLUS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlItem, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
            .addComponent(pnlSetting, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlItem, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlSetting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlItem;
    private javax.swing.JPanel pnlSetting;
    // End of variables declaration//GEN-END:variables
}
