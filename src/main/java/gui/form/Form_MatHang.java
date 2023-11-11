package gui.form;

import dao.MatHang_DAO;
import entity.MatHang;
import gui_dialog.DL_CapNhatMatHang;
import gui_dialog.DL_ThemMatHang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HO MINH HAU
 */
public class Form_MatHang extends javax.swing.JPanel {

    private MatHang_DAO mh_dao;
    private DefaultTableModel dtmMatHang;

    public Form_MatHang() {
        initComponents();
        mh_dao = new MatHang_DAO();
        dtmMatHang = (DefaultTableModel) tblMatHang.getModel();
        DocDuLieu();
        System.out.println("BBBB");
    }

    public void DocDuLieu() {
        List<MatHang> list = mh_dao.getalltbMatHang();
        for (MatHang mh : list) {
            dtmMatHang.addRow(new Object[]{mh.getMaMH(), mh.getTenMH(), mh.getGia(), mh.isTrangThai() ? "Còn hàng" : "Hết hàng"});
        }
    }

    public void clearJTable() {
        while (tblMatHang.getRowCount() > 0) {
            dtmMatHang.removeRow(0);
        }
    }

    public void loadTable(ArrayList<MatHang> ds) {
        dtmMatHang.setRowCount(0);
        if (ds == null) {
            clearJTable();
            return;
        }
        clearJTable();
        for (MatHang mh : ds) {
            dtmMatHang.addRow(new Object[]{mh.getMaMH(), mh.getTenMH(), mh.getGia()});
        }
    }

    public void clearDataOnModel() {
        DefaultTableModel dtm = (DefaultTableModel) tblMatHang.getModel();
        dtm.getDataVector().removeAllElements();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMatHang = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        pnlTim = new javax.swing.JPanel();
        lblTim = new javax.swing.JLabel();
        btnTim = new gui.swing.RadiusButton();
        txtTim = new javax.swing.JTextField();
        btnThem = new gui.swing.RadiusButton();
        btnSua = new gui.swing.RadiusButton();
        btnXoa = new gui.swing.RadiusButton();
        scr = new javax.swing.JScrollPane();
        tblMatHang = new javax.swing.JTable();

        pnlMatHang.setBackground(new java.awt.Color(235, 249, 249));

        pnlHeader.setBackground(new java.awt.Color(235, 249, 249));
        pnlHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlTim.setBackground(new java.awt.Color(255, 255, 255));

        lblTim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTim.setText("Tìm kiếm");

        btnTim.setBackground(new java.awt.Color(166, 208, 238));
        btnTim.setBorder(null);
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTimLayout = new javax.swing.GroupLayout(pnlTim);
        pnlTim.setLayout(pnlTimLayout);
        pnlTimLayout.setHorizontalGroup(
            pnlTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTim)
                .addGap(27, 27, 27)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        pnlTimLayout.setVerticalGroup(
            pnlTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTimLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(pnlTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTim)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        btnThem.setBackground(new java.awt.Color(41, 173, 86));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm mặt hàng");
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

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pnlTim, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(pnlTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tblMatHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã mặt hàng", "Tên mặt hàng", "Giá", "Trạng thái"
            }
        ));
        scr.setViewportView(tblMatHang);
        tblMatHang.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout pnlMatHangLayout = new javax.swing.GroupLayout(pnlMatHang);
        pnlMatHang.setLayout(pnlMatHangLayout);
        pnlMatHangLayout.setHorizontalGroup(
            pnlMatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMatHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scr)
                .addContainerGap())
        );
        pnlMatHangLayout.setVerticalGroup(
            pnlMatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMatHangLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(scr, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addGap(110, 110, 110))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMatHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMatHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        new DL_ThemMatHang().setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        mh_dao = new MatHang_DAO();
        if (tblMatHang.getSelectedRowCount() > 0) {
            if (JOptionPane.showConfirmDialog(this, "Xác nhận sửa mặt hàng đã chọn?", "Warring", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                int[] selectedRows = tblMatHang.getSelectedRows();
                System.out.println("Chọn xong");
                new DL_CapNhatMatHang().setVisible(true);
//                for (int i = selectedRows.length - 1; i >= 0; i--) {
//                    List<MatHang> mhs = mh_dao.getalltbMatHang();
//                    MatHang mh = mhs.get(selectedRows[i]);
//                    mh_dao.editMatHang(mh);
//                }

                clearJTable();
                DocDuLieu();
                System.out.println("Load xong");
                JOptionPane.showMessageDialog(this, "Sửa thành công");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa!");

        }

//                DL_KiemTravsAddKH kiemTraVsAddKH = new DL_KiemTravsAddKH((java.awt.Frame) SwingUtilities.getWindowAncestor((Component) e.getSource()), true);
//                kiemTraVsAddKH.setLocationRelativeTo(Form_QuanLyDatPhong.this);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        mh_dao = new MatHang_DAO();
        if (tblMatHang.getSelectedRowCount() > 0) {
            if (JOptionPane.showConfirmDialog(this, "Xác nhận xóa mặt hàng đã chọn?", "Warring", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                int[] selectedRows = tblMatHang.getSelectedRows();
                for (int i = selectedRows.length - 1; i >= 0; i--) {
                    List<MatHang> mhs = mh_dao.getalltbMatHang();
                    MatHang mh = mhs.get(selectedRows[i]);
                    String maMH = mh.getMaMH();
                    mh_dao.DeleteMatHang(maMH);
                }
                clearJTable();
                DocDuLieu();
                JOptionPane.showMessageDialog(this, "Xóa thành công");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa!");
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
          String maMH = txtTim.getText().trim();
        if(!(maMH.length() > 0)){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã mặt hàng");
        }else{
            String maTim = txtTim.getText();
            ArrayList<MatHang> dsMHTim = null;
            for(MatHang mh : mh_dao.getalltbMatHang()){
                if(mh.getMaMH().equals(maTim)){
                    dsMHTim = new ArrayList<MatHang>();
                    dsMHTim.add(mh);
                }
            }
            if(dsMHTim != null){
                clearDataOnModel();
                for(MatHang mh : dsMHTim){
                    dtmMatHang.addRow(new Object[]{mh.getMaMH(), mh.getTenMH(), mh.getGia(), mh.isTrangThai() ? "Còn hàng" : "Hết hàng"});
                }
            }else if(dsMHTim == null){
                JOptionPane.showMessageDialog(this, "Không tìm thấy");
            }
        }
    }//GEN-LAST:event_btnTimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.swing.RadiusButton btnSua;
    private gui.swing.RadiusButton btnThem;
    private gui.swing.RadiusButton btnTim;
    private gui.swing.RadiusButton btnXoa;
    private javax.swing.JLabel lblTim;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMatHang;
    private javax.swing.JPanel pnlTim;
    private javax.swing.JScrollPane scr;
    private javax.swing.JTable tblMatHang;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
