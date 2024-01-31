/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.Backend;

import java.awt.Color;
import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author kenabkc
 */
public class Logics {

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

    public static boolean showConfirmationDialog() {
        int option = JOptionPane.showConfirmDialog(
                null,
                "Do you want to make changes to your profile?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION);

        return option == JOptionPane.YES_OPTION;
    }

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
            grade = "F";
        }

        return grade;
    }

}
