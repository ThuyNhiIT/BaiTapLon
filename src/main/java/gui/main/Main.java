package gui.main;

import gui.component.Header;
import gui.component.Menu;
import gui.form.MainForm;
import net.miginfocom.swing.MigLayout;
import gui.event.EventMenuSelected;
import gui.form.Form_DichVu;
import gui.form.Form_Home;
import gui.form.Form_MatHang;
import gui.form.Form_QuanLyDatPhong;
import gui.form.Form_QuanLyKhachHang;
import gui.form.Form_QuanLyNhanVien;
import gui.form.Form_QuanLyPhongHat;
import gui.form.Form_Setting;
import gui.form.Form_ThongKeDoanhThu;
import gui.form.Form_ThongKeMatHang;
import java.lang.annotation.Target;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author HO MINH HAU
 */
public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;

    public Main() {
        initComponents();
        init();
    }

    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        header = new Header();
        main = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelect(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index:" + menuIndex + "SubMenuIndex:" + subMenuIndex);
                if (menuIndex == 0) {
                    if (subMenuIndex == -1) {
                        main.showForm(new Form_Home());
                    }
                } else if (menuIndex == 1) {
                    if (subMenuIndex == -1) {
                        main.showForm(new Form_QuanLyDatPhong());
                    }
                } else if (menuIndex == 2) {
                    if (subMenuIndex == -1) {
                        main.showForm(new Form_QuanLyPhongHat());
                    }
                } else if (menuIndex == 3) {
                    if (subMenuIndex == -1) {
                        main.showForm(new Form_QuanLyKhachHang());
                    }
                } else if (menuIndex == 4) {
                    if (subMenuIndex == -1 || subMenuIndex == 0) {
                        main.showForm(new Form_MatHang());
                    } else if (subMenuIndex == 1) {
                        main.showForm(new Form_DichVu());
                    }
                } else if (menuIndex == 5) {
                    if (subMenuIndex == -1) {
                        main.showForm(new Form_QuanLyNhanVien());
                    }
                } else if (menuIndex == 6) {
                    if (subMenuIndex == -1 || subMenuIndex == 0) {
                        main.showForm(new Form_ThongKeMatHang());
                    } else if (subMenuIndex == 1) {
                        main.showForm(new Form_ThongKeDoanhThu());
                    }

                } else if (menuIndex == 7) {
                    if (subMenuIndex == -1) {
                        main.showForm(new Form_Setting());
                    }
                }

            }
        }
        );
        menu.initMenuItem();

        bg.add(menu,
                "w 200!, spany2");
        bg.add(header,
                "h 40!, wrap");
        bg.add(main,
                "w 100% , h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {

            }

            @Override
            public void end() {
                
            }
            
            
            
        };
        animator = new Animator(500,target);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Karaoke APLUS");

        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1220, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
