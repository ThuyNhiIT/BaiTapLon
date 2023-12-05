package gui.form;

import com.raven.chart.Chart;
import com.raven.chart.LegendItem;
import com.raven.chart.ModelChart;
import dao.HoaDon_DAO;
import entity.HoaDon;
import gui.swing.scrollbar.ScrollBarCustom;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.LegendItemCollection;

public class Form_ThongKeDoanhThu extends javax.swing.JPanel {

    private HoaDon_DAO hd_dao;
    private DefaultTableModel dtmhd;
    private final DecimalFormat df = new DecimalFormat("#,###");
    private final SimpleDateFormat gio = new SimpleDateFormat("yyyy-MM-dd");
    private DefaultCategoryDataset dataset;
    private ChartPanel chartPanel;
    private List<ModelChart> data;
    private CategoryPlot categoryPlot;

    public Form_ThongKeDoanhThu() {
        initComponents();
        scr.getViewport().setOpaque(false);
        scr.setVerticalScrollBar(new ScrollBarCustom());

        hd_dao = new HoaDon_DAO();
        dtmhd = (DefaultTableModel) tblTKDT.getModel();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date selectedDate = txtDate.getDate();
        String formattedDate = dateFormat.format(selectedDate);
        txtDate.setDateFormatString("yyyy-MM-dd");

        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date chooser = txtDate.getDate();
        String corect = simple.format(chooser);
        java.util.Date utilDate = null;
        try {
            utilDate = dateFormat.parse(corect);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        DocDuLieu();

    }

    private void removeData() {
        DefaultTableModel df = (DefaultTableModel) tblTKDT.getModel();
        df.setRowCount(0);
    }

    private boolean valiData() {
        if (cmbTKTheo.getSelectedIndex() == 0 || cmbTKChiTiet.getSelectedIndex() == 0) {
            return false;
        }
        return true;
    }

    public void DocDuLieu() {
        removeData();
        List<HoaDon> dsHoaDon = hd_dao.getalltbHoaDon();
        int stt = 1;
        for (HoaDon hd : dsHoaDon) {
            dtmhd.addRow(new Object[]{stt++ + "", hd.getMaHD(), hd.getNgayLapHD(), hd.getKhachHang().getMaKH(), hd.getNhanVien().getMaNV(), hd.getMaKM().getMaKM(), hd.getTongTien()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTKDT = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblTKMH = new javax.swing.JLabel();
        lblNgay = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbTKTheo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbTKChiTiet = new javax.swing.JComboBox<>();
        txtDate = new com.toedter.calendar.JDateChooser();
        materialTabbed1 = new gui.swing.tabbed.MaterialTabbed();
        jPanel4 = new javax.swing.JPanel();
        pnlBottom = new javax.swing.JPanel();
        scr = new javax.swing.JScrollPane();
        tblTKDT = new javax.swing.JTable();
        lblTongSoHD = new javax.swing.JLabel();
        lblTong = new javax.swing.JLabel();
        lblTongHD = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        pnlBieuDo = new javax.swing.JPanel();
        pnlChart = new javax.swing.JPanel();
        chart = new com.raven.chart.Chart();

        pnlTKDT.setBackground(new java.awt.Color(235, 249, 249));

        pnlHeader.setBackground(new java.awt.Color(235, 249, 249));
        pnlHeader.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlHeader.setPreferredSize(new java.awt.Dimension(1000, 103));

        lblTKMH.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTKMH.setForeground(new java.awt.Color(41, 173, 86));
        lblTKMH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTKMH.setText("THỐNG KÊ DOANH THU");

        lblNgay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNgay.setText("Ngày");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tháng");

        cmbTKTheo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbTKTheo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        cmbTKTheo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKTheoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Năm:");

        cmbTKChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbTKChiTiet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023" }));
        cmbTKChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTKChiTietActionPerformed(evt);
            }
        });

        txtDate.setDate(new Date());
        txtDate.setDateFormatString("dd-MM-yyyy hh:mm");
        txtDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDate.setOpaque(false);
        txtDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtDatePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(cmbTKTheo, 0, 146, Short.MAX_VALUE)
                .addGap(191, 191, 191)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbTKChiTiet, 0, 145, Short.MAX_VALUE)
                .addGap(100, 100, 100))
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(lblTKMH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(290, 290, 290))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addComponent(lblTKMH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbTKChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(cmbTKTheo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        materialTabbed1.setPreferredSize(new java.awt.Dimension(1220, 635));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        pnlBottom.setBackground(new java.awt.Color(255, 255, 255));
        pnlBottom.setPreferredSize(new java.awt.Dimension(1000, 521));

        tblTKDT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hóa đơn", "Ngày lập hóa đơn", "Nhân viên", "Khách hàng", "Khuyến mãi", "Tổng hóa đơn"
            }
        ));
        tblTKDT.setRowHeight(40);
        tblTKDT.setSelectionBackground(new java.awt.Color(0, 169, 183));
        scr.setViewportView(tblTKDT);

        lblTongSoHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTongSoHD.setText("Tổng số hóa đơn");
        lblTongSoHD.setPreferredSize(new java.awt.Dimension(20, 16));

        lblTong.setText("jLabel2");

        lblTongHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTongHD.setText("Tổng hóa đơn");

        lblTongTien.setText("jLabel2");

        javax.swing.GroupLayout pnlBottomLayout = new javax.swing.GroupLayout(pnlBottom);
        pnlBottom.setLayout(pnlBottomLayout);
        pnlBottomLayout.setHorizontalGroup(
            pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(lblTongSoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTong, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addGap(285, 285, 285)
                .addComponent(lblTongHD, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addGap(153, 153, 153))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scr)
                .addContainerGap())
        );
        pnlBottomLayout.setVerticalGroup(
            pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(scr, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addGroup(pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTongSoHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTong, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTongHD)
                    .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBottom, javax.swing.GroupLayout.DEFAULT_SIZE, 1078, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(pnlBottom, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        materialTabbed1.addTab("Bảng thống kê", jPanel4);

        pnlBieuDo.setPreferredSize(new java.awt.Dimension(1000, 588));

        pnlChart.setBackground(new java.awt.Color(255, 255, 255));
        pnlChart.setPreferredSize(new java.awt.Dimension(1000, 512));

        javax.swing.GroupLayout pnlChartLayout = new javax.swing.GroupLayout(pnlChart);
        pnlChart.setLayout(pnlChartLayout);
        pnlChartLayout.setHorizontalGroup(
            pnlChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChartLayout.createSequentialGroup()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 1072, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlChartLayout.setVerticalGroup(
            pnlChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBieuDoLayout = new javax.swing.GroupLayout(pnlBieuDo);
        pnlBieuDo.setLayout(pnlBieuDoLayout);
        pnlBieuDoLayout.setHorizontalGroup(
            pnlBieuDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlChart, javax.swing.GroupLayout.DEFAULT_SIZE, 1078, Short.MAX_VALUE)
        );
        pnlBieuDoLayout.setVerticalGroup(
            pnlBieuDoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlChart, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
        );

        materialTabbed1.addTab("Biểu đồ", pnlBieuDo);

        javax.swing.GroupLayout pnlTKDTLayout = new javax.swing.GroupLayout(pnlTKDT);
        pnlTKDT.setLayout(pnlTKDTLayout);
        pnlTKDTLayout.setHorizontalGroup(
            pnlTKDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materialTabbed1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
        );
        pnlTKDTLayout.setVerticalGroup(
            pnlTKDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTKDTLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTKDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTKDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTKTheoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKTheoActionPerformed
        String thang = cmbTKTheo.getSelectedItem().toString();
        String nam = cmbTKChiTiet.getSelectedItem().toString();

        List<HoaDon> dsHoaDon = null;

        dsHoaDon = hd_dao.getDoanhThuThang(thang, nam);
        removeData();
        int stt = 1;
        for (HoaDon hd : dsHoaDon) {
            if (dsHoaDon.isEmpty() || dsHoaDon == null) {
                JOptionPane.showMessageDialog(null, "Không có hóa đơn trong tháng");
                removeData();
            } else {
                dtmhd.addRow(new Object[]{stt++ + "", hd.getMaHD(), hd.getNgayLapHD(), hd.getKhachHang().getMaKH(), hd.getNhanVien().getMaNV(), hd.getMaKM().getMaKM(), hd.getTongTien()});
            }
        }
        HoaDon_DAO HD = new HoaDon_DAO();
        int tongHD = HD.getSoLuongHoaDonThang(thang, nam);
        lblTong.setText(String.valueOf(tongHD));
        double tongTien = HD.getTongTienThang(thang, nam);
        lblTongTien.setText(String.valueOf(tongTien));    }//GEN-LAST:event_cmbTKTheoActionPerformed

    private void cmbTKChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTKChiTietActionPerformed

        String nam = cmbTKChiTiet.getSelectedItem().toString();
        String thang = cmbTKTheo.getSelectedItem().toString();
        List<HoaDon> dsHoaDon = null;
        dsHoaDon = hd_dao.getDoanhThuNam(nam);
        removeData();
        int stt = 1;
        for (HoaDon hd : dsHoaDon) {
            if (dsHoaDon.isEmpty() || dsHoaDon == null) {
                JOptionPane.showMessageDialog(null, "Không có hóa đơn trong tháng");
                removeData();
            } else {
                dtmhd.addRow(new Object[]{stt++ + "", hd.getMaHD(), hd.getNgayLapHD(), hd.getKhachHang().getMaKH(), hd.getNhanVien().getMaNV(), hd.getMaKM().getMaKM(), hd.getTongTien()});
            }
        }

        BieuDo(new ArrayList<>(), nam);
        /**
         * Load tiền
         */
        HoaDon_DAO HD = new HoaDon_DAO();
        int tongHD = HD.getSoLuongHoaDonNam(nam);
        lblTong.setText(String.valueOf(tongHD));
        double tongTien = HD.getTongTienNam(nam);
        lblTongTien.setText(String.valueOf(tongTien));
    }//GEN-LAST:event_cmbTKChiTietActionPerformed

    private void BieuDo(ArrayList<String[]> list, String nam) {
        chart.removeAllData();
        System.out.println("1,2");

        chart.clear();
        System.out.println("1,3");
        pnlChart.removeAll();

        list = hd_dao.getDoanhThuTungThangNam(nam);
        chart.addLegend("Tổng tiền", new Color(189, 135, 245));
        for (String[] arr : list) {
            String month = arr[0];
            double total = Double.parseDouble(arr[1]);
            chart.addData(new ModelChart(month, new double[]{total}));
        }
        pnlChart.add(chart);
    }

    private void txtDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtDatePropertyChange
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date selectedDate = txtDate.getDate();
        String formattedDate = dateFormat.format(selectedDate);
        txtDate.setDateFormatString("yyyy-MM-dd");

        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date chooser = txtDate.getDate();
        String corect = simple.format(chooser);
        java.util.Date utilDate = null;
        try {
            utilDate = dateFormat.parse(corect);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        List<HoaDon> dsHoaDon = null;

        dsHoaDon = hd_dao.getDoanhThuNgay(sqlDate);

        removeData();
        int stt = 1;
        for (HoaDon hd : dsHoaDon) {
            if (dsHoaDon.isEmpty() || dsHoaDon == null) {
                JOptionPane.showMessageDialog(null, "Không có hóa đơn trong ngày");
                removeData();
            } else {
                dtmhd.addRow(new Object[]{stt++ + "", hd.getMaHD(), hd.getNgayLapHD(), hd.getKhachHang().getMaKH(), hd.getNhanVien().getMaNV(), hd.getMaKM().getMaKM(), hd.getTongTien()});
            }

        }
        HoaDon_DAO HD = new HoaDon_DAO();
        int tongHD = HD.getSoLuongHoaDonNgay(sqlDate);
        lblTong.setText(String.valueOf(tongHD));
        double tongTien = HD.getTongTienNgay(sqlDate);
        lblTongTien.setText(String.valueOf(tongTien));
    }//GEN-LAST:event_txtDatePropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.chart.Chart chart;
    private javax.swing.JComboBox<Object> cmbTKChiTiet;
    private javax.swing.JComboBox<String> cmbTKTheo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblNgay;
    private javax.swing.JLabel lblTKMH;
    private javax.swing.JLabel lblTong;
    private javax.swing.JLabel lblTongHD;
    private javax.swing.JLabel lblTongSoHD;
    private javax.swing.JLabel lblTongTien;
    private gui.swing.tabbed.MaterialTabbed materialTabbed1;
    private javax.swing.JPanel pnlBieuDo;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlChart;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlTKDT;
    private javax.swing.JScrollPane scr;
    private javax.swing.JTable tblTKDT;
    private com.toedter.calendar.JDateChooser txtDate;
    // End of variables declaration//GEN-END:variables
}
