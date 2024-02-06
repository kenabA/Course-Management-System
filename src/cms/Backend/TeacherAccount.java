/**
 *
 * @author kenabkc
 */
package cms.Backend;

import static cms.Backend.CreateConnection.c;
import cms.Frontend.Person;
import cms.Frontend.Student.StudentPanel;
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
                                SELECT Student.id, Student.f_name, Student.l_name, Student.email, Student.course FROM Student WHERE Student.course = ?;                                                                
                                """;

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setString(1, Person.getCourseName());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String studentId = String.valueOf(resultSet.getInt("id"));
                String name = resultSet.getString("f_name") + " " + resultSet.getString("l_name");
                String email = resultSet.getString("email");
                String cName = resultSet.getString("course");
                String accCreationDate = StudentAccount.getAccountCreatedDate(studentId);
                String sem = StudentAccount.getSemester(accCreationDate);
                System.out.println(sem);
                String row[] = {studentId, name, cName, sem, email};
                model.addRow(row);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
