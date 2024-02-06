/**
 *
 * @author kenabkc
 */
package cms.Backend;

import static cms.Backend.CreateConnection.c;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class TeacherAccount {

    // ------------- STUDENT COUNT : USING COURSE -------------
    public static int getTotalTeacherCount(String course) {

        try {

            String query = "select count(*) as teacher_count from Teacher where course = '" + course + "';";
            ResultSet resultSet = c.statement.executeQuery(query);
            if (resultSet.next()) {
                int totalCount = resultSet.getInt("teacher_count");
                return totalCount;
            } else {
                System.out.println("Cannot get the count.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public static void getTableData(int courseId, DefaultTableModel model, String tableName) {

        if (tableName.equals("t3")) {
            studentsTable(courseId, model);
        }

    }

    public static void studentsTable(int courseId, DefaultTableModel model) {
        try {
            String query = """
                                SELECT Module.module_id, Module.module_name, Course.course_name, Module.semester, Teacher.f_name, Teacher.l_name
                                                                FROM Module
                                                                INNER JOIN Course ON Course.course_id = Module.course_id
                                                                INNER JOIN Teacher ON Teacher.id = Module.teacher_id
                                                                WHERE Course.course_id = ?
                                """;

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setInt(1, courseId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String moduleId = String.valueOf(resultSet.getInt("module_id"));
                String name = resultSet.getString("module_name");
                String cName = resultSet.getString("course_name");
                String sem = String.valueOf(resultSet.getInt("semester"));
                String tName = resultSet.getString("f_name") + " " + resultSet.getString("l_name");

                String row[] = {moduleId, name, cName, sem, tName};
                model.addRow(row);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
