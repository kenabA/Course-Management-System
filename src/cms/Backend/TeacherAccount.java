/**
 *
 * @author kenabkc
 */
package cms.Backend;

import static cms.Backend.CreateConnection.c;
import cms.Frontend.Person;
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
                String row[] = {studentId, name, sem, cName, email};
                model.addRow(row);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int uploadGrades(int id, int percentage, int stdPerformanceSlider, int moduleId) {
        try {
            // Inserts the assingments and inserts the status to 1.
            String query = "INSERT INTO `Grade` (`grade`, `overall`, `student_id`, `module_id`) VALUES (?,?,?,?);";
            PreparedStatement preparedStatement = c.connection.prepareStatement(query);

            preparedStatement.setInt(1, percentage);
            preparedStatement.setInt(2, stdPerformanceSlider);
            preparedStatement.setInt(3, id);
            preparedStatement.setInt(4, moduleId);

            int rows = preparedStatement.executeUpdate();

            return rows;

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public static int uploadAssignment(String qs, int semester, int moduleId) {
        try {
            // Inserts the assingments and inserts the status to 1.
            String query = "INSERT INTO `Question` (`question`, `semester`, `module_id`) VALUES (?,?,?);";
            PreparedStatement preparedStatement = c.connection.prepareStatement(query);

            preparedStatement.setString(1, qs);
            preparedStatement.setInt(2, semester);
            preparedStatement.setInt(3, moduleId);

            int rows = preparedStatement.executeUpdate();

            return rows;

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    // ------------- TO GET THE QUESTIONS DATA -------------
    public static String[][] getQuestions() {

        try {
            String query = """
                            SELECT Module.module_name, Question.date_posted, Question.question, Question.q_id FROM `Question`                   
                            INNER JOIN Module ON Module.module_id = Question.module_id
                             INNER JOIN Course ON Course.course_id = Module.course_id
                             WHERE Course.course_id = ? ORDER BY Question.date_posted DESC LIMIT 3;
                           """;

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);

            preparedStatement.setInt(1, Person.getCourseId());

            ResultSet resultSet = preparedStatement.executeQuery();
            String questionDetails[][] = new String[3][4];
            int i = 0;

            while (resultSet.next()) {
                int questionId = resultSet.getInt("q_id");
                String questionName = resultSet.getString("question");
                String moduleName = resultSet.getString("module_name");
                String time = resultSet.getString("date_posted");

                questionDetails[i][0] = String.valueOf(questionId);
                questionDetails[i][1] = questionName;
                questionDetails[i][2] = moduleName;
                questionDetails[i][3] = time;

                System.out.println("FOR " + i);
                System.out.println(questionDetails[i][0]);
                System.out.println(questionDetails[i][1]);
                System.out.println(questionDetails[i][2]);
                System.out.println(questionDetails[i][3]);
                System.out.println("s");

                i++;

            }
            return questionDetails;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
