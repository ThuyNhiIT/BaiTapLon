package gui.form;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import entity.KhachHang;
import gui.swing.CustomJOptionPane;
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

/**
 *
 * @author HO MINH HAU
 */
public class Form_QuanLyKhachHang extends javax.swing.JPanel {
    
    private KhachHang_DAO kh_dao;
    private DefaultTableModel dtmKhachHang;
    private ArrayList<KhachHang> customers;
    
    public Form_QuanLyKhachHang() {
        initComponents();
        kh_dao = new KhachHang_DAO();
        dtmKhachHang = (DefaultTableModel) tblDSKH.getModel();
//        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
//        
//        for (int i = 0; i < tblDSKH.getColumnCount(); i++) {
//            tblDSKH.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
//        }
        DocDuLieu();
//        loadTable(kh_dao.getalltbKhachHang());

    }

//    public void DocDuLieu() {
//        List<KhachHang> lists = kh_dao.getalltbKhachHang();
//        for (KhachHang kh : lists) {
//            dtmKhachHang.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.isGioitinh() ? "Nam" : "Nữ"});
//        }
//    }
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
    
    public String phatSinhMaKH(){
        List<KhachHang> khs = kh_dao.getalltbKhachHang();
        String temp = null;

        for(KhachHang kh : khs){
            temp = kh.getMaKH();
        }
        int count = laySoDuoi(temp);
        count++;

        String maKHang = String.format("KH%03d", count);
        return maKHang;
    }

    public int laySoDuoi(String str){
        if(str == null){
            return 0;
        }else{
            String numberStr = str.substring(2);//Loại bỏ kí tự "KH"
            int number = Integer.parseInt(numberStr);
            return number;
        }
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
        scr = new javax.swing.JScrollPane();
        tblDSKH = new javax.swing.JTable();
        lblTong = new javax.swing.JLabel();
        txtTong = new javax.swing.JTextField();
        btnCapNhatTotalKH = new gui.swing.RadiusButton();

        pnlKhachHang.setBackground(new java.awt.Color(235, 249, 249));

        pnlHeader.setBackground(new java.awt.Color(235, 249, 249));
        pnlHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlTraCuu.setBackground(new java.awt.Color(255, 255, 255));

        lblTim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTim.setText("Tìm kiếm");

        btnTim.setBackground(new java.awt.Color(166, 208, 238));
        btnTim.setText("Tìm");
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
                .addContainerGap()
                .addComponent(lblTim)
                .addGap(28, 28, 28)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        pnlTraCuuLayout.setVerticalGroup(
            pnlTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTraCuuLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(pnlTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTim)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        btnThem.setBackground(new java.awt.Color(41, 173, 86));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm khách hàng");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(41, 173, 86));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa khách hàng");
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
                .addComponent(pnlTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 402, Short.MAX_VALUE)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        tblDSKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Giới tính", "Hành động"
            }
        ));
        tblDSKH.setSelectionForeground(new java.awt.Color(255, 255, 255));
        scr.setViewportView(tblDSKH);

        lblTong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTong.setText("Tổng số khách hàng");

        btnCapNhatTotalKH.setBackground(new java.awt.Color(166, 208, 238));
        btnCapNhatTotalKH.setText("Cập nhật");
        btnCapNhatTotalKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatTotalKHActionPerformed(evt);
            }
        });

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
                .addGap(40, 40, 40)
                .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnCapNhatTotalKH, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlKhachHangLayout.setVerticalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhachHangLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(scr, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTong)
                    .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhatTotalKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
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

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
//        DL_ThongTinKhachHang ttkh = new DL_ThongTinKhachHang();
//        ttkh.setVisible(true);
        new DL_ThongTinKhachHang().setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        String sdtKH = txtTim.getText().trim();
        if (!(sdtKH.length() > 0 && sdtKH.matches("\\d{10}"))) {
            CustomJOptionPane.showMessageDialog("Số điện thoại phải gồm 10 số !!!");
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
                CustomJOptionPane.showMessageDialog("Không tìm thấy !!!");
            }
        }
    }//GEN-LAST:event_btnTimActionPerformed

   
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void updateTotalCustomer(){
        int totalCustomer = dtmKhachHang.getRowCount();
        txtTong.setText("" +totalCustomer);
    }
    
    private void btnCapNhatTotalKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatTotalKHActionPerformed
        // TODO add your handling code here:
       updateTotalCustomer();
    }//GEN-LAST:event_btnCapNhatTotalKHActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.swing.RadiusButton btnCapNhatTotalKH;
    private gui.swing.RadiusButton btnSua;
    private gui.swing.RadiusButton btnThem;
    private gui.swing.RadiusButton btnTim;
    private javax.swing.JLabel lblTim;
    private javax.swing.JLabel lblTong;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlTraCuu;
    private javax.swing.JScrollPane scr;
    private javax.swing.JTable tblDSKH;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTong;
    // End of variables declaration//GEN-END:variables
}
