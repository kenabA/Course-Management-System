package Backend;

import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author kenabkc
 */
public class AdminValidation {

    public static boolean validateDetails(String credentials[]) {
        for (String credential : credentials) {

            if (credential.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Empty feild is not allowed", "Add Course", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }

        return true;

    }

}
