/*
 * @author kenabkc
 */
package Frontend;

import Backend.DatabaseManager;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.SQLException;

public class Cms {

    public static void main(String[] args) throws SQLException {

        /*
         * FlatLaf is a modern look & feel for Swing applications that replaces the default look by modern and cleaner user interface.
         */
        try {
            FlatLightLaf.setup();
        } catch (Exception e) {
            System.out.println("Error in Flatlaf: " + e);
        }

        DatabaseManager dm = new DatabaseManager();
        new Login().setVisible(true);

    }

}
