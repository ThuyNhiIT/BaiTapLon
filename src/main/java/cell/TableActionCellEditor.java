/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cell;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author 84343
 */
public class TableActionCellEditor extends DefaultCellEditor {

//    private TableActionEvent event;

    public TableActionCellEditor() {
        super(new JCheckBox());
//        this.event = event;
    }

   
//    @Override
//    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int il) {
//        PanelAction action = new PanelAction();
//        action.initEvent(event, row);
//        action.setBackground(jtable.getSelectionBackground());
//        return action;
//    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
       PanelAction action = new PanelAction();
       action.setBackground(table.getSelectionBackground());
       return action;
    }

}
