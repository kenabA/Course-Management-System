/**
 *
 * @author kenabkc
 */
package Backend;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import javax.swing.JOptionPane;

// Creating class Con for the connection with the database.
public class Con {

    protected Connection connection;
    protected Statement statement;

    public Con() {
        try {
            final String url = "jdbc:mysql://localhost:3306/CMS";
            final String password = "hello123";
            final String username = "root";
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Could not connect with the database.", "Database Connection", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Connection Failed with the Database: Con.java " + e);
        }
    }

}
