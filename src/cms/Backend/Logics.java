/**
 *
 * @author kenabkc
 */
package cms.Backend;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Logics {

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

}
