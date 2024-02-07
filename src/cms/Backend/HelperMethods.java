/**
 *
 * @author kenabkc
 */
package cms.Backend;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class HelperMethods {

    // Gets the current time
    public static String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String loginTime = dateFormat.format(new Date());
        return loginTime;
    }

    // Converts the number to ordinal such as 1st , 2nd and returns it as a string
    public static String convertToOrdinal(int number) {
        if (number >= 11 && number <= 13) {
            return number + "th";
        }

        return switch (number % 10) {
            case 1 ->
                number + "st";
            case 2 ->
                number + "nd";
            case 3 ->
                number + "rd";
            default ->
                number + "th";
        };
    }

    // This is used when we need to handle the click events on the text fields
    public static void handleFocusGainedLost(JTextField textField, String defaultValue, Color defaultColor, FocusEvent evt) {
        if (evt.getID() == FocusEvent.FOCUS_GAINED) {
            if (textField.getText().equals(defaultValue)) {
                textField.setText("");
                textField.setForeground(Color.BLACK);
            }
        } else if (evt.getID() == FocusEvent.FOCUS_LOST) {
            if (textField.getText().isEmpty()) {
                textField.setText(defaultValue);
                textField.setForeground(defaultColor);
            }
        }
    }

    public static boolean allCharactersAreDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // This is used to show the confirmation dialog
    public static boolean showConfirmationDialog() {
        int option = JOptionPane.showConfirmDialog(
                null,
                "Do you want to make changes to your profile?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION);

        return option == JOptionPane.YES_OPTION;
    }

    // Used to convert percentange into grades
    public static String getGrades(int percentage) {
        String grade;

        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "E";
        }

        return grade;
    }

    public static void alignTableContents(JTable table) {
        DefaultTableCellRenderer alignRenderer = new DefaultTableCellRenderer();
        alignRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(alignRenderer);
        }
    }

    public static void setTableAppearance(JTable table) {

        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        headerRenderer.setBorder(new EmptyBorder(10, 20, 10, 20));

        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setSelectionBackground(new Color(241, 240, 255));
        table.setSelectionForeground(new Color(108, 99, 255));
        int margin = 20;
        table.setRowHeight(table.getRowHeight() + margin);
        JTableHeader header = table.getTableHeader();
        Font originalFont = header.getFont();
        Font boldFont = new Font(originalFont.getFontName(), Font.BOLD, originalFont.getSize());
        header.setFont(boldFont);
        header.setForeground(new Color(102, 102, 102));

    }

}
