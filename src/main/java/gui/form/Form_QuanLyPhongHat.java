package gui.form;

<<<<<<< HEAD
import dao.PhongHat_DAO;
import entity.PhongHat;
import gui_dialog.DL_ThemPhong;
import java.util.ArrayList;
=======
import dao.LoaiPhong_DAO;
import dao.PhongHat_DAO;
import entity.LoaiPhong;
import entity.LoaiPhong;
import entity.PhongHat;
import gui_dialog.DL_ThemPhongHat;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
>>>>>>> 246ca9dec2a2b44337dcf8da60474f572b04d0aa
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HO MINH HAU
 */
public class Form_QuanLyPhongHat extends javax.swing.JPanel {

    private PhongHat_DAO ph_dao;
<<<<<<< HEAD
    private DefaultTableModel dtmPhongHat;
    
  
    public Form_QuanLyPhongHat() {
        initComponents();
        ph_dao = new PhongHat_DAO();
        dtmPhongHat = (DefaultTableModel) tblDSPH.getModel();
        loadTable(ph_dao.getAllPhongHat());
        
=======
    private LoaiPhong_DAO lp_dao;
    private DefaultTableModel dtmPhongHat;
    private ArrayList<PhongHat> ds;
    double gia;

    public Form_QuanLyPhongHat() {
        initComponents();
        ph_dao = new PhongHat_DAO();
        lp_dao = new LoaiPhong_DAO();
        dtmPhongHat = (DefaultTableModel) tblDSPH.getModel();
        DocDuLieu();
    }

    public void loadTable(ArrayList<PhongHat> ds) {
        if (ds == null) {
            clearJTable();
            return;
        }
        clearJTable();
        for (PhongHat ph : ds) {
            dtmPhongHat.addRow(new Object[]{
                ph.getMaPhong(), ph.getTenPhong(), ph.getLoaiPhong().getMaLoaiPhong(), ph.getLoaiPhong().getGia(), ph.getTinhTrangPhong()
            });
        }
    }

    public void clearJTable() {
        while (tblDSPH.getRowCount() > 0) {
            dtmPhongHat.removeRow(0);
        }
    }

    public void DocDuLieu() {

        List<LoaiPhong> ls = lp_dao.getalltbLoaiPhong();
        // Duyệt qua danh sách dữ liệu loại phòng
        for (LoaiPhong lp : ls) {
            // Lấy mã và giá của loại phòng
//            String maLoaiPhong = lp.getMaLoaiPhong();
            Double gia = lp.getGia();

            // Thực hiện các thao tác cần thiết với dữ liệu
            // Ví dụ: hiển thị dữ liệu lên màn hình
            List<PhongHat> list = ph_dao.getAllPhongHat();

            for (PhongHat ph : list) {
                if (ph.getLoaiPhong().getMaLoaiPhong().equals(lp.getMaLoaiPhong())) {
                    dtmPhongHat.addRow(new Object[]{ph.getMaPhong(), ph.getTenPhong(), ph.getLoaiPhong().getMaLoaiPhong(), gia, ph.getTinhTrangPhong()});
                }
            }
        }
    }

    public void clearDataOnModel() {
        DefaultTableModel dtm = (DefaultTableModel) tblDSPH.getModel();
        dtm.getDataVector().removeAllElements();
>>>>>>> 246ca9dec2a2b44337dcf8da60474f572b04d0aa
    }

     public void loadTable(ArrayList<PhongHat> ds) {
        dtmPhongHat.setRowCount(0);//reset nd trong bang ve 0
        if (ds == null) {
            clearJTable();
            return;
        }
        clearJTable();
        for (PhongHat ph : ds) {
            dtmPhongHat.addRow(new Object[]{
                ph.getMaPhong(), ph.getTenPhong(), ph.getLoaiPhong().getMaLoaiPhong(), ph.getTinhTrangPhong()
            });
        }
    }
    
    public void clearJTable() {
        while (tblDSPH.getRowCount() > 0) {
            dtmPhongHat.removeRow(0);
        }
    }
    
    public void clearDataOnModel() {
        DefaultTableModel dtm = (DefaultTableModel) tblDSPH.getModel();
        dtm.getDataVector().removeAllElements();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPhongHat = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        pnlTim = new javax.swing.JPanel();
        lblTim = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        btnTim = new gui.swing.RadiusButton();
        btnThem = new gui.swing.RadiusButton();
        btnXoa = new gui.swing.RadiusButton();
        btnSua = new gui.swing.RadiusButton();
        lblDSPH = new javax.swing.JLabel();
        scr = new javax.swing.JScrollPane();
        tblDSPH = new javax.swing.JTable();
        lblTong = new javax.swing.JLabel();
        lblTrong = new javax.swing.JLabel();
        txtTrong = new javax.swing.JTextField();
        lblSuDung = new javax.swing.JLabel();
        txtSuDung = new javax.swing.JTextField();
        lblCho = new javax.swing.JLabel();
        txtCho = new javax.swing.JTextField();
        txtTong = new javax.swing.JTextField();

        pnlPhongHat.setBackground(new java.awt.Color(235, 249, 249));

        pnlHeader.setBackground(new java.awt.Color(235, 249, 249));
        pnlHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlTim.setBackground(new java.awt.Color(255, 255, 255));

        lblTim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTim.setText("Tìm kiếm");

        btnTim.setBackground(new java.awt.Color(166, 208, 238));
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
                .addContainerGap()
                .addComponent(lblTim)
                .addGap(28, 28, 28)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        pnlTimLayout.setVerticalGroup(
            pnlTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTimLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(pnlTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTim)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        btnThem.setBackground(new java.awt.Color(41, 173, 86));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm phòng hát");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pnlTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                        .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        lblDSPH.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblDSPH.setText("DANH SÁCH PHÒNG HÁT");

        tblDSPH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
<<<<<<< HEAD
                "Mã phòng", "Tên phòng", "Mã loại phòng", "Trạng thái", "Giá", "Hành động"
=======
                "Mã phòng", "Tên phòng", "Mã loại phòng", "Giá", "Trạng thái"
>>>>>>> 246ca9dec2a2b44337dcf8da60474f572b04d0aa
            }
        ));
        scr.setViewportView(tblDSPH);

        lblTong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTong.setText("Tổng phòng hát");

        lblTrong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTrong.setText("Phòng trống");

        txtTrong.setEditable(false);

        lblSuDung.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSuDung.setText("Phòng đang sử dụng");

        txtSuDung.setEditable(false);

        lblCho.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCho.setText("Phòng chờ");

        txtCho.setEditable(false);

        txtTong.setEditable(false);

        javax.swing.GroupLayout pnlPhongHatLayout = new javax.swing.GroupLayout(pnlPhongHat);
        pnlPhongHat.setLayout(pnlPhongHatLayout);
        pnlPhongHatLayout.setHorizontalGroup(
            pnlPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlPhongHatLayout.createSequentialGroup()
                .addGroup(pnlPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPhongHatLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scr))
                    .addGroup(pnlPhongHatLayout.createSequentialGroup()
                        .addGroup(pnlPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPhongHatLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(lblTong)
                                .addGap(18, 18, 18)
                                .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(120, 120, 120)
                                .addComponent(lblTrong)
                                .addGap(18, 18, 18)
                                .addComponent(txtTrong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(155, 155, 155)
                                .addComponent(lblSuDung)
                                .addGap(54, 54, 54)
                                .addComponent(txtSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152)
                                .addComponent(lblCho)
                                .addGap(18, 18, 18)
                                .addComponent(txtCho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPhongHatLayout.createSequentialGroup()
                                .addGap(474, 474, 474)
                                .addComponent(lblDSPH)))
                        .addGap(0, 42, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlPhongHatLayout.setVerticalGroup(
            pnlPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPhongHatLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDSPH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scr, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(pnlPhongHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTong)
                    .addComponent(lblTrong)
                    .addComponent(txtTrong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSuDung)
                    .addComponent(txtSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCho)
                    .addComponent(txtCho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPhongHat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPhongHat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
<<<<<<< HEAD
        new DL_ThemPhong().setVisible(true);
=======
        DL_ThemPhongHat themPH = new DL_ThemPhongHat((java.awt.Frame) SwingUtilities.getWindowAncestor((Component) evt.getSource()), true);
        themPH.setLocationRelativeTo(Form_QuanLyPhongHat.this);
        themPH.setVisible(true);
>>>>>>> 246ca9dec2a2b44337dcf8da60474f572b04d0aa
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        ph_dao = new PhongHat_DAO();
        if (tblDSPH.getSelectedRowCount() > 0) {
            if (JOptionPane.showConfirmDialog(this, "Xác nhận xóa phòng hát đã chọn?", "Warring", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                int[] selectedRows = tblDSPH.getSelectedRows();
                for (int i = selectedRows.length - 1; i >= 0; i--) {
                    List<PhongHat> phs = ph_dao.getAllPhongHat();
                    PhongHat ph = phs.get(selectedRows[i]);
                    String maPH = ph.getMaPhong();
                    ph_dao.DeletePhongHat(maPH);
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
        String maP = txtTim.getText().trim();
        if (!(maP.length() > 0)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã mặt hàng");
        } else {
            String maTim = txtTim.getText();
            ArrayList<PhongHat> dsPhongTim = null;
//            ArrayList<LoaiPhong> dsLPhongTim = null;
            for (PhongHat ph : ph_dao.getAllPhongHat()) {
                if (ph.getMaPhong().equals(maTim)) {
                    dsPhongTim = new ArrayList<PhongHat>();
                    dsPhongTim.add(ph);
                }
            }
            for (PhongHat ph : ph_dao.FindTheoMaLoai(maTim)) {
                dsPhongTim = new ArrayList<PhongHat>();
                dsPhongTim.add(ph);
            }
            if (dsPhongTim != null) {
                clearDataOnModel();
                for (PhongHat ph : dsPhongTim) {
                    dtmPhongHat.addRow(new Object[]{
                        ph.getMaPhong(), ph.getTenPhong(), ph.getLoaiPhong().getMaLoaiPhong(), ph.getLoaiPhong().getGia(), ph.getTinhTrangPhong()
                    });

                }
            } else if (dsPhongTim == null) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy");
            } else if (dsPhongTim == null) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy");
            }

        }

    }//GEN-LAST:event_btnTimActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        //        ph_dao = new PhongHat_DAO();
        //        if (tblDSPH.getSelectedRowCount() > 0) {
        //            if (JOptionPane.showConfirmDialog(this, "Xác nhận sửa mặt hàng đã chọn?", "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        //                int[] selectedRows = tblDSPH.getSelectedRows();
        //                for (int i = 0; i < selectedRows.length; i++) {
        //                    int rowIndex = selectedRows[i];
        //                    // Lấy dữ liệu từ bảng
        //                    String MaPhong = tblDSPH.getValueAt(rowIndex, 0).toString();
        //                    String tenPhong = tblDSPH.getValueAt(rowIndex, 1).toString();
        //                    String maLoai = tblDSPH.getValueAt(rowIndex, 2).toString();
        ////                    Double gia = Double.parseDouble(tblDSPH.getValueAt(rowIndex, 3).toString());
        //                    String tinhTrang = tblDSPH.getValueAt(rowIndex, 3).toString();
        //                    // Tạo đối tượng PhongHat từ dữ liệu đã lấy
        //                    PhongHat ph = new PhongHat(MaPhong, tenPhong, new LoaiPhong(maLoai), tinhTrang);
        //                    // Thực hiện việc sửa mặt hàng trong cơ sở dữ liệu
        //                    boolean isSuccess = ph_dao.editPhongHat(ph);
        //                    if (isSuccess) {
        //                        JOptionPane.showMessageDialog(this, "Sửa thành công");
        //                    } else {
        //                        JOptionPane.showMessageDialog(this, "Sửa thất bại");
        //                    }
        //                }
        //                // Xóa nội dung hiện tại của bảng
        //                clearJTable();
        //                // Tải lại dữ liệu từ cơ sở dữ liệu
        //                DocDuLieu();
        //            }
        //        } else {
        //            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa!");
        //        }
    }//GEN-LAST:event_btnSuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.swing.RadiusButton btnSua;
    private gui.swing.RadiusButton btnThem;
    private gui.swing.RadiusButton btnTim;
    private gui.swing.RadiusButton btnXoa;
    private javax.swing.JLabel lblCho;
    private javax.swing.JLabel lblDSPH;
    private javax.swing.JLabel lblSuDung;
    private javax.swing.JLabel lblTim;
    private javax.swing.JLabel lblTong;
    private javax.swing.JLabel lblTrong;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlPhongHat;
    private javax.swing.JPanel pnlTim;
    private javax.swing.JScrollPane scr;
    private javax.swing.JTable tblDSPH;
    private javax.swing.JTextField txtCho;
    private javax.swing.JTextField txtSuDung;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTong;
    private javax.swing.JTextField txtTrong;
    // End of variables declaration//GEN-END:variables
}
