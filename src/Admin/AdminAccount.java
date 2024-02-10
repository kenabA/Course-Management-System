/**
 *
 * @author kenabkc
 */
package Admin;

import java.sql.SQLIntegrityConstraintViolationException;

import cms.Backend.Account;
import cms.Backend.CreateConnection;
import cms.Backend.StudentAccount;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminAccount extends CreateConnection {

    static EditCourse ec;

    // ------------- STUDENT COUNT : USING COURSE -------------
    public static int getTotalStudentCount() {

        try {

            String query = "select count(*) as student_count from Student;";
            ResultSet resultSet = c.statement.executeQuery(query);
            if (resultSet.next()) {
                int totalCount = resultSet.getInt("student_count");

                return totalCount;
            } else {
                System.out.println("Cannot get the count.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    // ------------- TEACHERS COUNT : USING COURSE -------------
    public static int getTotalTeacherCount() {

        try {

            String query = "select count(*) as teacher_count from Teacher;";
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

    // ------------- MODULE COUNT : USING COURSE ID : FOR ADMININSTRATOR -------------
    public static int getModulesCount() {
        try {
            String query = "SELECT COUNT(Module.module_name) AS modules_count FROM Module ;";
            ResultSet resultSet = c.statement.executeQuery(query);
            if (resultSet.next()) {
                int modulesCount = resultSet.getInt("modules_count");
                return modulesCount;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    // ------------- MODULE COUNT : USING COURSE ID : FOR ADMININSTRATOR -------------
    public static int getCoursesCount() {
        try {
            String query = "SELECT COUNT(*) AS courses_count FROM Course ;";
            ResultSet resultSet = c.statement.executeQuery(query);
            if (resultSet.next()) {
                int coursesCount = resultSet.getInt("courses_count");
                return coursesCount;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void getActivityTableData(DefaultTableModel model) {
        try {

            String query = " SELECT act_id, activity, time FROM `Activity` ORDER BY time DESC LIMIT 100; ";

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String actId = String.valueOf(resultSet.getInt("act_id"));
                String act = resultSet.getString("activity");
                String time = resultSet.getString("time");

                String row[] = {actId, act, time};

                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getCoursesData(DefaultTableModel model) {
        try {

            String query = "  SELECT * FROM Course ORDER BY course_id ; ";

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String courseId = String.valueOf(resultSet.getInt("course_id"));
                String courseName = resultSet.getString("course_name");
                String title = resultSet.getString("course_title");
                String time = resultSet.getString("date_created");

                String row[] = {courseId, title, courseName, time};

                model.addRow(row);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int addCourse(int courseId, String courseName, String courseCode) {
        try {

            String query = "INSERT INTO `Course` (`course_id`, `course_name`, `course_title`,  `date_created`) VALUES (?,?,?, current_timestamp());";
            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setInt(1, courseId);
            preparedStatement.setString(2, courseCode);
            preparedStatement.setString(3, courseName);

            int rows = preparedStatement.executeUpdate();

            return rows;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Add Course", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }

    public static void studentsTable(DefaultTableModel model) {
        try {
            String query = """
                                SELECT Student.id, Student.f_name, Student.l_name, Student.email, Student.course FROM Student;                                                                
                                """;

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);

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
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static void teachersTable(DefaultTableModel model) {
        try {
            String query = """
                                SELECT Teacher.id, Teacher.f_name, Teacher.l_name, Teacher.email,  Teacher.course FROM Teacher;                                                                
                                """;

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int teacherNumID = resultSet.getInt("id");
                String teacherID = String.valueOf(teacherNumID);
                String name = resultSet.getString("f_name") + " " + resultSet.getString("l_name");
                String email = resultSet.getString("email");
                String cName = resultSet.getString("course");
                int moduleCount = modulesPerTeacherCount(teacherNumID);
                String row[] = {teacherID, name, cName, String.valueOf(moduleCount), email};
                model.addRow(row);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private static int modulesPerTeacherCount(int id) {
        try {
            String query = "SELECT COUNT(Teacher.id) AS module_count FROM `Module` JOIN Teacher ON Teacher.id = Module.teacher_id where Teacher.id = " + id + " ;";
            PreparedStatement st = c.connection.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("module_count");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }

    public static void modulesTable(DefaultTableModel model, int id) {
        try {
            String query = "SELECT Module.module_id, Course.course_name, Module.module_name, Module.semester FROM Module JOIN Teacher ON Teacher.id = Module.teacher_id JOIN Course ON Course.course_id = Module.course_id WHERE Teacher.id = ?;";

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String moduleId = String.valueOf(resultSet.getInt("module_id"));
                String cName = resultSet.getString("course_name");
                String name = resultSet.getString("module_name");
                String sem = String.valueOf(resultSet.getInt("semester"));

                String row[] = {moduleId, cName, name, sem};
                model.addRow(row);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteCourse(int id) {
        try {
            String query = "DELETE FROM Course WHERE Course.course_id = " + id + " ;";

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Course successfully deleted", "Delete Course", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Delete Course", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteStudent(int id) {
        try {
            String query = "DELETE FROM Student WHERE Student.id = " + id + " ;";

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Student's account successfully deleted", "Delete Student", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Delete Student", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteTeacher(int id) {
        try {
            String query = "DELETE FROM Teacher WHERE Teacher.id = " + id + " ;";

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Teacher's account successfully deleted", "Delete Teacher", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLIntegrityConstraintViolationException e) {

            JOptionPane.showMessageDialog(null, "Unable to delete teacher account: The teacher is currently assigned to one or more modules. Please find a replacement teacher for these modules before deleting the account.", "Delete Teacher", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int editCourse(String id, String courseName, String courseCode, int orgId) {

        try {

            String query = "UPDATE `Course` SET `course_id` = ?, `course_name` = ?, `course_title` = ?, `date_created` = current_timestamp() WHERE `Course`.`course_id` = ?;";

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setString(2, courseCode);
            preparedStatement.setString(3, courseName);

            preparedStatement.setInt(4, orgId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Course successfully updated", "Edit Course", JOptionPane.INFORMATION_MESSAGE);
            }

            return 1;
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Delete Course", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int editStudent(String fName, String lName, int id) {

        try {

            String query = "UPDATE `Student` SET `f_name` = ?, `l_name` = ? WHERE `Student`.`id` = ?;";

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);

            preparedStatement.setString(1, fName);
            preparedStatement.setString(2, lName);
            preparedStatement.setInt(3, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Details successfully updated", "Edit Student", JOptionPane.INFORMATION_MESSAGE);
            }

            return 1;
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Edit Student", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static int editTeacher(String fName, String lName, int id) {

        try {

            String query = "UPDATE `Teacher` SET `f_name` = ?, `l_name` = ? WHERE `Teacher`.`id` = ?;";

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);

            preparedStatement.setString(1, fName);
            preparedStatement.setString(2, lName);
            preparedStatement.setInt(3, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected == 1) {
                JOptionPane.showMessageDialog(null, "Details successfully updated", "Edit Teacher", JOptionPane.INFORMATION_MESSAGE);
            }

            return 1;
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Edit Teacher", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
