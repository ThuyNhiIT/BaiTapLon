package gui.swing.table;

import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
/**
 *
 * @author 84934
 */
public class PanelActionCellRender_KhachHang extends DefaultTableCellRenderer {
     @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSeleted, boolean bln1, int row, int column) {
        Component com = super.getTableCellRendererComponent(jtable, o, isSeleted, bln1, row, column);
        PanelAction_KhachHang action = new PanelAction_KhachHang();
        if (isSeleted == false && row % 2 == 0) {
            action.setBackground(Color.WHITE);
        } else {
            action.setBackground(com.getBackground());

        }
        return action;
    }
}
