package cms.Frontend.Button;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author kenabkc
 */
public class SuccessActionCellRender extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSelected, boolean bln1, int i, int i1) {
        PanelAction action = new PanelAction();
        action.setBackground(Color.WHITE);
        if (isSelected) {
            action.setBackground(new Color(241, 240, 255));
        }

        int thickness = 1;
        Color borderColor = new Color(230, 230, 230);
        MatteBorder bottomBorder = BorderFactory.createMatteBorder(0, 0, thickness, 0, borderColor);
        action.setBorder(bottomBorder);
        return action;

    }
}
