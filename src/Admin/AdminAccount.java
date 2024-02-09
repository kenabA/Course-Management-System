/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

import cms.Backend.Account;
import cms.Backend.CreateConnection;
import cms.Backend.StudentAccount;
import cms.Frontend.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kenabkc
 */
public class AdminAccount extends CreateConnection {

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

            String query = " SELECT act_id, activity, time FROM `Activity` ORDER BY time DESC; ";

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

}
