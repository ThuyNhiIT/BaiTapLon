package gui.form;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import dao.PhongHat_DAO;
import entity.KhachHang;
import entity.PhongHat;
import gui.component.Room;
import gui.model.ModelRoom;
import gui.swing.scrollbar.ScrollBarCustom;
import gui_dialog.DL_ChonDichVu;
import gui_dialog.DL_KiemTravsAddKH;
import gui_dialog.DL_PhongDangSuDung;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author HO MINH HAU
 */
public final class Form_QuanLyDatPhong extends javax.swing.JPanel {

    private PhongHat_DAO ph_dao;

    private static String selectedRoom;
    private static String selectedRoomName;

    public Form_QuanLyDatPhong() {

        initComponents();
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane2.getViewport().setOpaque(false);
        jScrollPane2.setVerticalScrollBar(new ScrollBarCustom());
        jScrollPane3.getViewport().setOpaque(false);
        jScrollPane3.setVerticalScrollBar(new ScrollBarCustom());
        ph_dao = new PhongHat_DAO();
        phongTrong();
        phongDangSuDung();
        phongCho();
        refreshRooms();
    }

    public static void setRoomSelected(String roomID) {
        selectedRoom = roomID;
    }

    public static String getRoomSelected() {
        return selectedRoom;
    }

    public static void setRoomSelectedName(String roomName) {
        selectedRoomName = roomName;
    }

    public static String getRoomSelectedName() {
        return selectedRoomName;
    }

    public void addPhongTrong(ModelRoom data) {
        Room room = new Room();
        room.setData(data);
        room.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setRoomSelected(data.getRoomId());
                DL_KiemTravsAddKH kiemTraVsAddKH = new DL_KiemTravsAddKH((java.awt.Frame) SwingUtilities.getWindowAncestor((Component) e.getSource()), true);
                if (SwingUtilities.isLeftMouseButton(e)) {
                    kiemTraVsAddKH.setLocationRelativeTo(Form_QuanLyDatPhong.this);
                    kiemTraVsAddKH.setVisible(true);
                }
                DL_ChonDichVu cDV = new DL_ChonDichVu((java.awt.Frame) SwingUtilities.getWindowAncestor((Component) e.getSource()), true);
                cDV.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {

                        refreshRooms();
                    }

                });
            }
        });
        MigLayout migLayout = new MigLayout("wrap 4, gapx 100, gapy 80", "[grow, fill]");
        pnlPhongTrong.setLayout(migLayout);
        pnlPhongTrong.add(room);
        pnlPhongTrong.revalidate();
        pnlPhongTrong.repaint();
    }

    public void phongTrong() {
        // Xóa tất cả phòng trên giao diện trước khi thêm mới
        pnlPhongTrong.removeAll();
        ConnectDB db = ConnectDB.getInstance();
        try {
            db.connect();
        } catch (SQLException ex) {
            Logger.getLogger(Form_QuanLyDatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Lấy danh sách phòng có trạng thái "Trong" từ cơ sở dữ liệu
        ArrayList<PhongHat> phongTrongList = ph_dao.getPhongByTinhTrang("Trong");
        Icon icon;
        Icon iconPhongThuong = new ImageIcon(getClass().getResource("/icon/microphone.png"));
        Icon iconPhongVip = new ImageIcon(getClass().getResource("/icon/microphonevip.png"));

        // Thêm từng phòng có trạng thái "Trong" vào giao diện
        for (PhongHat phong : phongTrongList) {
            String loaiPhong = phong.getLoaiPhong().getMaLoaiPhong();
            if ("LP002".equals(loaiPhong)) {
                icon = iconPhongThuong;
            } else {
                icon = iconPhongVip;
            }
            addPhongTrong(new ModelRoom(phong.getMaPhong(), phong.getTenPhong(), icon));

        }

    }

    public void refreshRooms() {
        phongTrong();
        phongDangSuDung();
        phongCho();
    }

    public void addPhongDangSuDung(ModelRoom data) {
        Room room = new Room();
        room.setData(data);

        // Add a MouseListener if needed
        room.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println(data);
                setRoomSelected(data.getRoomId());
                setRoomSelectedName(data.getRoomName());
                DL_PhongDangSuDung pdsd = new DL_PhongDangSuDung((java.awt.Frame) SwingUtilities.getWindowAncestor((Component) e.getSource()), true);
                if (SwingUtilities.isLeftMouseButton(e)) {
                    pdsd.setLocationRelativeTo(Form_QuanLyDatPhong.this);
                    pdsd.setVisible(true);
                }
//                pdsd.addWindowListener(new WindowAdapter() {
//                    @Override
//                    public void windowClosed(WindowEvent e) {
//                        // khi đống thì tao cho nó refresh lại mấy cái room
//                        System.out.println("DL_KiemTravsAddKH closed");
//                        SwingUtilities.invokeLater(new Runnable() {
//                            @Override
//                            public void run() {
//                                refreshRooms();
//                            }
//                        });
//                    }
//                });
            }
        });
        MigLayout migLayout = new MigLayout("wrap 4, gapx 80, gapy 80, inset 20", "[grow, fill]");
        pnlPhongDangSuDung.setLayout(migLayout);
        pnlPhongDangSuDung.add(room);
        pnlPhongDangSuDung.revalidate();
        pnlPhongDangSuDung.repaint();
    }

    private void phongDangSuDung() {
        // Xóa tất cả phòng trên giao diện trước khi thêm mới
        pnlPhongDangSuDung.removeAll();
        ConnectDB db = ConnectDB.getInstance();
        try {
            db.connect();
        } catch (SQLException ex) {
            Logger.getLogger(Form_QuanLyDatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Lấy danh sách phòng có trạng thái "Dang su dung" từ cơ sở dữ liệu
        ArrayList<PhongHat> phongTrongList = ph_dao.getPhongByTinhTrang("Dang su dung");
        Icon icon;
        Icon iconPhongThuong = new ImageIcon(getClass().getResource("/icon/microphone.png"));
        Icon iconPhongVip = new ImageIcon(getClass().getResource("/icon/microphonevip.png"));

        // Thêm từng phòng có trạng thái "Trong" vào giao diện
        for (PhongHat phong : phongTrongList) {
            String loaiPhong = phong.getLoaiPhong().getMaLoaiPhong();
            if ("LP002".equals(loaiPhong)) {
                icon = iconPhongThuong;
            } else {
                icon = iconPhongVip;
            }
            addPhongDangSuDung(new ModelRoom(phong.getMaPhong(), phong.getTenPhong(), icon));
        }
    }
    ////Get the invoice for the room being used

    public void addPhongCho(ModelRoom data) {
        Room room = new Room();
        room.setData(data);
        String selectedRoom = data.getRoomId();

        // Add a MouseListener if needed
        room.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    // Handle mouse click here if necessary
                }
            }
        });
        MigLayout migLayout = new MigLayout("wrap 4, gapx 100, gapy 80", "[grow, fill]");
        pnlPhongCho.setLayout(migLayout);
        pnlPhongCho.add(room);
        pnlPhongCho.revalidate();
        pnlPhongCho.repaint();
    }

    private void phongCho() {
        // Xóa tất cả phòng trên giao diện trước khi thêm mới
        pnlPhongCho.removeAll();
        ConnectDB db = ConnectDB.getInstance();
        try {
            db.connect();
        } catch (SQLException ex) {
            Logger.getLogger(Form_QuanLyDatPhong.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Lấy danh sách phòng có trạng thái "Cho" từ cơ sở dữ liệu
        ArrayList<PhongHat> phongTrongList = ph_dao.getPhongByTinhTrang("Cho");
        Icon icon;
        Icon iconPhongThuong = new ImageIcon(getClass().getResource("/icon/microphone.png"));
        Icon iconPhongVip = new ImageIcon(getClass().getResource("/icon/microphonevip.png"));

        // Thêm từng phòng có trạng thái "Trong" vào giao diện
        for (PhongHat phong : phongTrongList) {
            String loaiPhong = phong.getLoaiPhong().getMaLoaiPhong();
            if ("LP002".equals(loaiPhong)) {
                icon = iconPhongThuong;
            } else {
                icon = iconPhongVip;
            }
            addPhongCho(new ModelRoom(phong.getMaPhong(), phong.getTenPhong(), icon));
        }
    }

    //Open DL_ChonDichVu in frame Form_QuanLyDatPhong
      public void openDL_ChonDichVu() {
        DL_ChonDichVu chonDV = new DL_ChonDichVu((java.awt.Frame) SwingUtilities.getWindowAncestor(this), true);
        chonDV.setLocationRelativeTo(Form_QuanLyDatPhong.this);
        chonDV.setVisible(true);
        chonDV.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println(".windowClosed()");
                refreshRooms();

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCover = new javax.swing.JPanel();
        tabbed = new gui.swing.tabbed.MaterialTabbed();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlPhongTrong = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlPhongDangSuDung = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pnlPhongCho = new javax.swing.JPanel();

        pnlCover.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        pnlPhongTrong.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlPhongTrongLayout = new javax.swing.GroupLayout(pnlPhongTrong);
        pnlPhongTrong.setLayout(pnlPhongTrongLayout);
        pnlPhongTrongLayout.setHorizontalGroup(
            pnlPhongTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1043, Short.MAX_VALUE)
        );
        pnlPhongTrongLayout.setVerticalGroup(
            pnlPhongTrongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 697, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pnlPhongTrong);

        tabbed.addTab("Phòng trống", jScrollPane1);

        jScrollPane2.setBorder(null);

        pnlPhongDangSuDung.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlPhongDangSuDungLayout = new javax.swing.GroupLayout(pnlPhongDangSuDung);
        pnlPhongDangSuDung.setLayout(pnlPhongDangSuDungLayout);
        pnlPhongDangSuDungLayout.setHorizontalGroup(
            pnlPhongDangSuDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1041, Short.MAX_VALUE)
        );
        pnlPhongDangSuDungLayout.setVerticalGroup(
            pnlPhongDangSuDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(pnlPhongDangSuDung);

        tabbed.addTab("Phòng đang sử dụng", jScrollPane2);

        jScrollPane3.setBorder(null);

        pnlPhongCho.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlPhongChoLayout = new javax.swing.GroupLayout(pnlPhongCho);
        pnlPhongCho.setLayout(pnlPhongChoLayout);
        pnlPhongChoLayout.setHorizontalGroup(
            pnlPhongChoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1041, Short.MAX_VALUE)
        );
        pnlPhongChoLayout.setVerticalGroup(
            pnlPhongChoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(pnlPhongCho);

        tabbed.addTab("Phòng chờ", jScrollPane3);

        javax.swing.GroupLayout pnlCoverLayout = new javax.swing.GroupLayout(pnlCover);
        pnlCover.setLayout(pnlCoverLayout);
        pnlCoverLayout.setHorizontalGroup(
            pnlCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCoverLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCoverLayout.setVerticalGroup(
            pnlCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCoverLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(tabbed, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnlCover;
    private javax.swing.JPanel pnlPhongCho;
    private javax.swing.JPanel pnlPhongDangSuDung;
    private javax.swing.JPanel pnlPhongTrong;
    private gui.swing.tabbed.MaterialTabbed tabbed;
    // End of variables declaration//GEN-END:variables
}
