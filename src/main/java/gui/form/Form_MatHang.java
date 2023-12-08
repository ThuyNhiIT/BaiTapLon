package gui.form;

import dao.MatHang_DAO;
import dao.PhongHat_DAO;
import entity.MatHang;
import entity.PhongHat;
import gui.swing.scrollbar.ScrollBarCustom;
import gui.swing.table.TableActionCellEditorMatHang;
import gui.swing.table.TableActionCellRenderMatHang;
import gui.swing.table.TableActionEventMatHang;
import gui_dialog.DL_ThemMatHang;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author HO MINH HAU
 */
public class Form_MatHang extends javax.swing.JPanel  {

    private MatHang_DAO mh_dao;
    private DefaultTableModel dtmMatHang;

    public Form_MatHang() {
        initComponents();
        scr.getViewport().setOpaque(false);
        scr.setVerticalScrollBar(new ScrollBarCustom());
        mh_dao = new MatHang_DAO();
        dtmMatHang = (DefaultTableModel) tblMatHang.getModel();

        TableActionEventMatHang event = new TableActionEventMatHang() {
            @Override
            public void sua(int row) {
                mh_dao = new MatHang_DAO();

                if (tblMatHang.getSelectedRowCount() > 0) {
                    if (JOptionPane.showConfirmDialog(null, "Xác nhận sửa mặt hàng đã chọn?", "Warning", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        int[] selectedRows = tblMatHang.getSelectedRows();
                        for (int i = 0; i < selectedRows.length; i++) {
                            int rowIndex = selectedRows[i];
                            String maHang = tblMatHang.getValueAt(rowIndex, 0).toString();
                            String tenHang = tblMatHang.getValueAt(rowIndex, 1).toString();
                            Double gia = Double.parseDouble(tblMatHang.getValueAt(rowIndex, 2).toString());
                            Boolean trangThai = Boolean.parseBoolean(tblMatHang.getValueAt(rowIndex, 3).toString());

                            MatHang mh = new MatHang(maHang, tenHang, gia, trangThai);

                            if (mh_dao.editMatHang(mh)) {
                                tblMatHang.setValueAt(tenHang, rowIndex, 1);
                                tblMatHang.setValueAt(gia, rowIndex, 2);
                                tblMatHang.setValueAt(trangThai, rowIndex, 3);
                                JOptionPane.showMessageDialog(null, "Sửa thành công");
                            } else {
                                JOptionPane.showMessageDialog(null, "Sửa thất bại");
                            }
                        }
                    }

                    clearJTable();
                    DocDuLieu();
                } else {
                    JOptionPane.showMessageDialog(null, "Chọn dòng cần sửa!");
                }
            }

            @Override
            public void xoa(int row) {
                mh_dao = new MatHang_DAO();
                if (tblMatHang.getSelectedRowCount() > 0) {
                    if (JOptionPane.showConfirmDialog(null, "Xác nhận xóa mặt hàng đã chọn?", "Warring", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                        int[] selectedRows = tblMatHang.getSelectedRows();
                        for (int i = selectedRows.length - 1; i >= 0; i--) {
                            List<MatHang> mhs = mh_dao.getalltbMatHang();
                            MatHang mh = mhs.get(selectedRows[i]);
                            String maMH = mh.getMaMH();
                            mh_dao.DeleteMatHang(maMH);
                            clearJTable();
                            DocDuLieu();
                        }

                        JOptionPane.showMessageDialog(null, "Xóa thành công");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Chọn dòng cần xóa!");
                }
            }

        };
        tblMatHang.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRenderMatHang());
        tblMatHang.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditorMatHang(event));

        MatHang_DAO MH = new MatHang_DAO();
        int tongPH = MH.getTongSoMH();
        lblTong.setText(String.valueOf(tongPH));
        DocDuLieu();
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
        btnRefesh = new gui.swing.RadiusButton();
        scr = new javax.swing.JScrollPane();
        tblMatHang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblTong = new javax.swing.JLabel();
        btnExcel = new gui.swing.RadiusButton();

        pnlMatHang.setBackground(new java.awt.Color(235, 249, 249));

        pnlHeader.setBackground(new java.awt.Color(235, 249, 249));
        pnlHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlTim.setBackground(new java.awt.Color(235, 249, 249));

        lblTim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTim.setText("Tìm kiếm");

        btnTim.setBorder(null);
        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/magnifying-glass.png"))); // NOI18N
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
                .addGap(18, 18, 18)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
        );
        pnlTimLayout.setVerticalGroup(
            pnlTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(pnlTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTimLayout.createSequentialGroup()
                        .addGroup(pnlTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTim)
                            .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTimLayout.createSequentialGroup()
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        btnThem.setBackground(new java.awt.Color(235, 249, 249));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add-to-basket.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnRefesh.setBackground(new java.awt.Color(235, 249, 249));
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
                .addGap(40, 40, 40)
                .addComponent(pnlTim, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 473, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnRefesh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(pnlTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRefesh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        tblMatHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã mặt hàng", "Tên mặt hàng", "Giá", "Trạng thái", "Hành động"
            }
        ));
        tblMatHang.setRowHeight(40);
        tblMatHang.setSelectionBackground(new java.awt.Color(0, 169, 183));
        scr.setViewportView(tblMatHang);
        tblMatHang.getAccessibleContext().setAccessibleName("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Tổng mặt hàng");

        lblTong.setText("jLabel2");

        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Excel32.png"))); // NOI18N
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMatHangLayout = new javax.swing.GroupLayout(pnlMatHang);
        pnlMatHang.setLayout(pnlMatHangLayout);
        pnlMatHangLayout.setHorizontalGroup(
            pnlMatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMatHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scr)
                .addContainerGap())
            .addGroup(pnlMatHangLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(lblTong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        pnlMatHangLayout.setVerticalGroup(
            pnlMatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMatHangLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(scr, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addGroup(pnlMatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMatHangLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(pnlMatHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTong)
                            .addComponent(jLabel1)))
                    .addGroup(pnlMatHangLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
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

        DL_ThemMatHang themMH = new DL_ThemMatHang((java.awt.Frame) SwingUtilities.getWindowAncestor((Component) evt.getSource()), true);
        themMH.setLocationRelativeTo(Form_MatHang.this);
        themMH.setVisible(true);
        clearJTable();
        DocDuLieu();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        String maMH = txtTim.getText().trim();
        if (!(maMH.length() > 0)) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã mặt hàng");
        } else {
            String maTim = txtTim.getText();
            ArrayList<MatHang> dsMHTim = null;
            for (MatHang mh : mh_dao.getalltbMatHang()) {
                if (mh.getMaMH().equals(maTim)) {
                    dsMHTim = new ArrayList<MatHang>();
                    dsMHTim.add(mh);
                }
            }
            if (dsMHTim != null) {
                clearDataOnModel();
                for (MatHang mh : dsMHTim) {
                    dtmMatHang.addRow(new Object[]{mh.getMaMH(), mh.getTenMH(), mh.getGia(), mh.isTrangThai() ? "Còn hàng" : "Hết hàng"});
                }
            } else if (dsMHTim == null) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy");
            }
        }

    }//GEN-LAST:event_btnTimActionPerformed

    private void btnRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefeshActionPerformed
        clearDataOnModel();
        DocDuLieu();
    }//GEN-LAST:event_btnRefeshActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        try {
            writeFileExcell();
            JOptionPane.showMessageDialog(null, "Xuất thành công!");
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "Lỗi hệ thống");

        }        // TODO add your handling code he
    }//GEN-LAST:event_btnExcelActionPerformed
    public void writeFileExcell() throws IOException {
        FileOutputStream file = new FileOutputStream("DSMatHang.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("name");
        XSSFRow row;
        XSSFCell cellA; // 0
        XSSFCell cellB; // 1
        XSSFCell cellC; // 2
        XSSFCell cellD; // 3
        XSSFCell cellE; // 4
        int j = 0;
        mh_dao = new MatHang_DAO();
        List<MatHang> list = new ArrayList<MatHang>();
        list = mh_dao.getalltbMatHang();
        row = sheet.createRow(j++);
        String[] headers = {"Mã phòng", "Tên phòng", "Giá", "Trạng thái"};
        for (int i = 0; i <= 3; i++) {
            cellA = row.createCell(i);
            cellA.setCellValue(headers[i]);
        }
        for (MatHang c : list) {
            row = sheet.createRow(j++);

            cellA = row.createCell(0);
            cellA.setCellValue(c.getMaMH());

            cellB = row.createCell(1);
            cellB.setCellValue(c.getTenMH());

            cellC = row.createCell(2);
            Double gia = c.getGia();
            if (gia != null) {
                cellC.setCellValue(gia);
            } else {
                cellC.setCellValue("");
            }
            cellD = row.createCell(3);
            String tinhTrang = c.isTrangThai() ? "Còn hàng" : "Hết hàng";
            cellD.setCellValue(tinhTrang);

        }
        workbook.write(file);
        workbook.close();
        file.close();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.swing.RadiusButton btnExcel;
    private gui.swing.RadiusButton btnRefesh;
    private gui.swing.RadiusButton btnThem;
    private gui.swing.RadiusButton btnTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTim;
    private javax.swing.JLabel lblTong;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMatHang;
    private javax.swing.JPanel pnlTim;
    private javax.swing.JScrollPane scr;
    private javax.swing.JTable tblMatHang;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables

}