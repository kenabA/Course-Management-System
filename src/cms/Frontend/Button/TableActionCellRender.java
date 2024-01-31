package cms.Frontend.Button;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author kenabkc
 */
public class TableActionCellRender extends DefaultTableCellRenderer {
    
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSelected, boolean bln1, int i, int i1) {
        PanelAction action = new PanelAction();
        action.setBackground(Color.WHITE);
        if (isSelected) {
            action.setBackground(new Color(241, 240, 255));
        }
        return action;
    }
    
}
