package gui.form;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import entity.KhachHang;
import gui.swing.CustomJOptionPane;
import gui.swing.scrollbar.ScrollBarCustom;
import gui.swing.table.PanelActionCellEditor_KhachHang;
import gui.swing.table.PanelActionCellRender_KhachHang;
import gui.swing.table.TableActionEvent_KhachHang;
import gui_dialog.DL_ThongTinKhachHang;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import gui_dialog.DL_ThongTinKhachHang;
import java.lang.invoke.MethodHandles;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Form_QuanLyKhachHang extends javax.swing.JPanel {

    private KhachHang_DAO kh_dao;
    private DefaultTableModel dtmKhachHang;
    private ArrayList<KhachHang> customers;

    public Form_QuanLyKhachHang() {
        initComponents();
        TableActionEvent_KhachHang event = new TableActionEvent_KhachHang() {
            @Override
            public void Sua(int row) {
                //System.out.println("sua" +row);
                //Viết sự kiên dô đây 
                kh_dao = new KhachHang_DAO();
                if (tblDSKH.getSelectedRowCount() > 0){
                             int[] selectedRows = tblDSKH.getSelectedRows();
                for (int i = 0; i < selectedRows.length; i++) {
                    int rowIndex = selectedRows[i];
                    String maKH = tblDSKH.getValueAt(rowIndex, 0).toString();
                    String tenKH = tblDSKH.getValueAt(rowIndex, 1).toString();
                    String sdt = tblDSKH.getValueAt(rowIndex, 2).toString();
                    Boolean gioiTinh = Boolean.parseBoolean(tblDSKH.getValueAt(rowIndex, 3).toString());

                    KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh);
                    tblDSKH.setValueAt(tenKH, rowIndex, 1);
                    tblDSKH.setValueAt(sdt, rowIndex, 2);
                    tblDSKH.setValueAt(gioiTinh, rowIndex, 3);
                    if (kh_dao.editCustomer(kh)) {
                        System.out.println("Sửa thành công");
                        JOptionPane.showMessageDialog(null, "Sửa thành công");
                    } else {
                        System.out.println("Sửa thất bại");
                        JOptionPane.showMessageDialog(null, "Sửa thất bại");
                    }
                }
            }

            clearJTable();
            DocDuLieu();
                

//                System.out.println("sua" +row);
//                //Viết sự kiên dô đây
            }
        };
        tblDSKH.getColumnModel().getColumn(4).setCellRenderer(new PanelActionCellRender_KhachHang());
        tblDSKH.getColumnModel().getColumn(4).setCellEditor(new PanelActionCellEditor_KhachHang(event));

        scr.getViewport().setOpaque(false);
        scr.setVerticalScrollBar(new ScrollBarCustom());

        kh_dao = new KhachHang_DAO();
        dtmKhachHang = (DefaultTableModel) tblDSKH.getModel();
        KhachHang_DAO KH = new KhachHang_DAO();
        int tongKH = KH.getSoLuongKhachHang();
        txtTong.setText(String.valueOf(tongKH));
        DocDuLieu();

//        loadTable(kh_dao.getalltbKhachHang());
        updateTotalCustomer();

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlKhachHang = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        pnlTraCuu = new javax.swing.JPanel();
        lblTim = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        btnTim = new gui.swing.RadiusButton();
        btnThem = new gui.swing.RadiusButton();
        btnSua = new gui.swing.RadiusButton();
        btnRefesh = new gui.swing.RadiusButton();

        scr = new javax.swing.JScrollPane();
        tblDSKH = new javax.swing.JTable();
        lblTongKH = new javax.swing.JLabel();
        txtTong = new javax.swing.JTextField();

        pnlKhachHang.setBackground(new java.awt.Color(235, 249, 249));

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlTraCuu.setBackground(new java.awt.Color(255, 255, 255));

        lblTim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTim.setText("Tìm kiếm");

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-find-24.png"))); // NOI18N
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTraCuuLayout = new javax.swing.GroupLayout(pnlTraCuu);
        pnlTraCuu.setLayout(pnlTraCuuLayout);
        pnlTraCuuLayout.setHorizontalGroup(
            pnlTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTraCuuLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTim)
                .addGap(18, 18, 18)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnlTraCuuLayout.setVerticalGroup(
            pnlTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTraCuuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTim)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-customer-48.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });


        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnRefesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-refresh-48.png"))); // NOI18N
        btnRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefeshActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(pnlTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 418, Short.MAX_VALUE)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70));

        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                        .addComponent(pnlTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))

        );

        tblDSKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Giới tính", "Hành động"
            }
        ) {
            boolean[] canEdit = new boolean [] {

                false, true, true, true, true

//                true, true, true, true, false

            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSKH.setRowHeight(40);
        tblDSKH.setSelectionBackground(new java.awt.Color(0, 169, 183));
        tblDSKH.setSelectionForeground(new java.awt.Color(255, 255, 255));
        scr.setViewportView(tblDSKH);
        if (tblDSKH.getColumnModel().getColumnCount() > 0) {
            tblDSKH.getColumnModel().getColumn(4).setPreferredWidth(5);
        }

        lblTongKH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTongKH.setText("Tổng khách hàng");

        txtTong.setEditable(false);

        javax.swing.GroupLayout pnlKhachHangLayout = new javax.swing.GroupLayout(pnlKhachHang);
        pnlKhachHang.setLayout(pnlKhachHangLayout);
        pnlKhachHangLayout.setHorizontalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scr)
                .addContainerGap())
            .addGroup(pnlKhachHangLayout.createSequentialGroup()

                .addGap(64, 64, 64)
                .addComponent(lblTong)
                .addGap(18, 18, 18)
                .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlKhachHangLayout.setVerticalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachHangLayout.createSequentialGroup()

                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scr, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addGroup(pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTong)
                    .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))

        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
 public void loadTable(ArrayList<KhachHang> ds) {
        dtmKhachHang.setRowCount(0);//reset nd trong bang ve 0
        if (ds == null) {
            clearJTable();
            return;
        }
        clearJTable();
        for (KhachHang kh : ds) {
            dtmKhachHang.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.isGioitinh() ? "Nam" : "Nữ"});
        }
    }

    private void updateTotalCustomer() {
        int totalCustomer = dtmKhachHang.getRowCount();
        txtTong.setText("" + totalCustomer);
    }

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        kh_dao = new KhachHang_DAO();

        if (tblDSKH.getSelectedRowCount() > 0) {
            if (JOptionPane.showConfirmDialog(this, "Xác nhận sửa khách hàng đã chọn?", "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                int[] selectedRows = tblDSKH.getSelectedRows();
                for (int i = 0; i < selectedRows.length; i++) {
                    int rowIndex = selectedRows[i];
                    String maKH = tblDSKH.getValueAt(rowIndex, 0).toString();
                    String tenKH = tblDSKH.getValueAt(rowIndex, 1).toString();
                    String sdt = tblDSKH.getValueAt(rowIndex, 2).toString();
                    Boolean gioiTinh = Boolean.parseBoolean(tblDSKH.getValueAt(rowIndex, 3).toString());

                    KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh);
                    tblDSKH.setValueAt(tenKH, rowIndex, 1);
                    tblDSKH.setValueAt(sdt, rowIndex, 2);
                    tblDSKH.setValueAt(gioiTinh, rowIndex, 3);
                    if (kh_dao.editCustomer(kh)) {
                        System.out.println("Sửa thành công");
                        JOptionPane.showMessageDialog(this, "Sửa thành công");
                    } else {
                        System.out.println("Sửa thất bại");
                        JOptionPane.showMessageDialog(this, "Sửa thất bại");
                    }
                }
            }

            clearJTable();
            DocDuLieu();
        } else {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa!");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    public void clearJTable() {
        while (tblDSKH.getRowCount() > 0) {
            dtmKhachHang.removeRow(0);
        }
    }

    public void clearDataOnModel() {
        DefaultTableModel dtm = (DefaultTableModel) tblDSKH.getModel();
        dtm.getDataVector().removeAllElements();
    }

    public void DocDuLieu() {
        List<KhachHang> list = kh_dao.getalltbKhachHang();
        for (KhachHang kh : list) {
            dtmKhachHang.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.isGioitinh() ? "Nam" : "Nữ"});
        }
    }
    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        String sdtKH = txtTim.getText().trim();
        if (!(sdtKH.length() > 0 && sdtKH.matches("\\d{10}"))) {
            //            CustomJOptionPane.showMessageDialog("Số điện thoại phải gồm 10 số !!!");
        } else {
            String maTim = txtTim.getText();
            ArrayList<KhachHang> dsKHtim = null;

            for (KhachHang kh : kh_dao.getalltbKhachHang()) {
                if (kh.getSdt().equals(maTim)) {
                    dsKHtim = new ArrayList<KhachHang>();
                    dsKHtim.add(kh);
                }
            }

            if (dsKHtim != null) {
                clearDataOnModel();
                for (KhachHang kh : dsKHtim) {
                    dtmKhachHang.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.isGioitinh() ? "Nam" : "Nữ"});
                }
            } else if (dsKHtim == null) {
                //                CustomJOptionPane.showMessageDialog("Không tìm thấy !!!");
            }
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        new DL_ThongTinKhachHang().setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed


    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
         String sdtKH = txtTim.getText().trim();
        if (!(sdtKH.length() > 0 && sdtKH.matches("\\d{10}"))) {
           JOptionPane.showMessageDialog(this, "Số điện thoại phải gồm 10 số !!!");
        } else {
            String maTim = txtTim.getText();
            ArrayList<KhachHang> dsKHtim = null;

            for (KhachHang kh : kh_dao.getalltbKhachHang()) {
                if (kh.getSdt().equals(maTim)) {
                    dsKHtim = new ArrayList<KhachHang>();
                    dsKHtim.add(kh);
                }
            }
            if (dsKHtim != null) {
                clearDataOnModel();
                for (KhachHang kh : dsKHtim) {
                    dtmKhachHang.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.isGioitinh() ? "Nam" : "Nữ"});
                }
            } else if (dsKHtim == null) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy !!!");
            }
        }
        updateTotalCustomer();
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        //        DL_ThongTinKhachHang ttkh = new DL_ThongTinKhachHang();
        //        ttkh.setVisible(true);
        new DL_ThongTinKhachHang().setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefeshActionPerformed
        clearJTable();
        loadTable(kh_dao.getalltbKhachHang());
        updateTotalCustomer();
    }//GEN-LAST:event_btnRefeshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.swing.RadiusButton btnRefesh;
    private gui.swing.RadiusButton btnSua;
    private gui.swing.RadiusButton btnThem;
    private gui.swing.RadiusButton btnTim;
    private javax.swing.JLabel lblTim;
    private javax.swing.JLabel lblTongKH;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlTraCuu;
    private javax.swing.JScrollPane scr;
    private javax.swing.JTable tblDSKH;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTong;
    // End of variables declaration//GEN-END:variables
}
