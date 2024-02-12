package Frontend;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class GradeCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        String grade = value.toString();
        Color textColor;
        textColor = switch (grade) {
            case "A+" ->
                new Color(0x199900); // Dark Green
            case "A" ->
                new Color(0x199500); // Dark Green
            case "B" ->
                new Color(0x006400); // // Light Green
            case "C" ->
                new Color(0x908900); // Green-Yellow
            case "D" ->
                new Color(0x992300);
            case "E" ->
                new Color(0xcf0000); // Red
            default ->
                table.getForeground();
        };

        // Default color
        cellComponent.setForeground(textColor);

        return cellComponent;

    }

}
