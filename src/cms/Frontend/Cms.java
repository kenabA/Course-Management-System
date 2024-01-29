/*
 * @author kenabkc
 */
package cms.Frontend;

import com.formdev.flatlaf.FlatLightLaf;

public class Cms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*
         * FlatLaf is a modern look & feel for Swing applications that replaces the default look by modern and cleaner user interface.
         */
        try {
            FlatLightLaf.setup();
        } catch (Exception e) {
            System.out.println("Error in Flatlaf: " + e);
        }

        new Login().setVisible(true);

    }

}