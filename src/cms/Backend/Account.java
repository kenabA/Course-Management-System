/**
 *
 * @author kenabkc
 */
package cms.Backend;

import cms.Frontend.AdminPanel;
import cms.Frontend.Student.StudentPanel;
import cms.Frontend.TeacherPanel;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Account {

    private static final Con c = new Con();
    StudentPanel sp;

    private static String usertype;
    private static int id;

    Icon erIcon = new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/errorIcon.png"));
    Icon icon = new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/checkIcon.png"));

    // ------------- INSERTING DATA -------------
    public static void registerAccount(String[] credentials) {

        try {

            switch (credentials[7]) {
                case "Student" -> {
                    String query = "INSERT INTO `" + credentials[7] + "` (`f_name`, `l_name`, `username`, `email`, `ph_num`, `password`, `date_created`, `course`) VALUES ('" + credentials[0] + "', '" + credentials[1] + "', '" + credentials[2] + "', '" + credentials[3] + "', '" + credentials[4] + "', '" + credentials[5] + "', current_timestamp() , '" + credentials[8] + "' );";
                    c.statement.executeUpdate(query);
                    break;
                }
                default -> {
                    String query1 = "INSERT INTO `" + credentials[7] + "` (`f_name`, `l_name`, `username`, `email`, `ph_num`, `password`, `date_created`) VALUES ('" + credentials[0] + "', '" + credentials[1] + "', '" + credentials[2] + "', '" + credentials[3] + "', '" + credentials[4] + "', '" + credentials[5] + "', current_timestamp());";
                    c.statement.executeUpdate(query1);
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error Inserting data to the database: User " + e);
        }

    }

    // ------------- CHECKING DUPLICATE -------------
    public static boolean checkDuplicate(String username, String email, String usertype) {

        try {

            String getUsername = "select * from " + usertype + " where binary username = '" + username + "' ";

            ResultSet userName = c.statement.executeQuery(getUsername);

            if (userName.next()) {
                JOptionPane.showMessageDialog(null, "Username already exists. Please try again with another input.", "Registration Error", JOptionPane.INFORMATION_MESSAGE);
                UIManager.put("JOptionPane.okButtonText", "OK");
                return false;
            }

            String getEmail = "select * from " + usertype + " where binary email = '" + email + "' ";

            ResultSet eMail = c.statement.executeQuery(getEmail);

            if (eMail.next()) {
                JOptionPane.showMessageDialog(null, "Email already exists. Please try again with another input.", "Registration Error", JOptionPane.INFORMATION_MESSAGE);
                UIManager.put("JOptionPane.okButtonText", "OK");
                return false;
            }

            return true;

        } catch (Exception e) {

            System.out.println("Error while checking duplicate: User " + e);
        }
        return true;
    }

    // ------------- READING FILES : LOGIN -------------
    public static ResultSet getLoginDetails(Object usertype, String username, String password) {
        try {
            String query = "select * from " + usertype + " where binary username = '" + username + "' and binary password = '" + password + "' ";
            ResultSet resultSet = c.statement.executeQuery(query);
            return resultSet;
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // ------------- LOGGIN ACCOUNT : OPENING NEW PANEL -------------
    public void loginAccount(Object usertype, String username, String password) {

        ResultSet loginValidation = getLoginDetails(usertype, username, password);

        try {
            if (loginValidation.next()) {
                UIManager.put("OptionPane.okButtonText", "OK");
                JOptionPane.showMessageDialog(null, "You have successfully logged into your account.", "Login Successful", JOptionPane.INFORMATION_MESSAGE, icon);
                UIManager.put("JOptionPane.okButtonText", "OK");
                Account.usertype = usertype.toString();
                Account.id = loginValidation.getInt("id");
                if (usertype.equals("Student")) {
                    sp = new StudentPanel();
                    sp.setVisible(true);
                    sp.setName(username);
                    sp.updateDetails();

                } else if (usertype.equals("Teacher")) {
                    new TeacherPanel().setVisible(true);
                } else {
                    new AdminPanel().setVisible(true);
                }

            } else {
                JOptionPane.showMessageDialog(null, "The details do not match. Please try again.", "Incorrect Credentials", JOptionPane.INFORMATION_MESSAGE, erIcon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // ------------- GETTING ALL USER DATA : USING USERNAME -------------
    public static ResultSet getUserData(String username) {
        try {
            String query = "select * from Student where binary username = '" + username + "' ";
            ResultSet resultSet = c.statement.executeQuery(query);
            return resultSet;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // ------------- STUDENT COUNT : USING COURSE -------------
    public static int getStudentCount(String course) {
        try {
            String query = "select count(*) as student_count from Student where course = '" + course + "';";
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

    // ------------- COURSE ID : USING COURSE -------------
    public static int getCourseId(String course) {
        try {
            String query = "SELECT course_id FROM `Course` WHERE course_name = '" + course + "';";
            ResultSet resultSet = c.statement.executeQuery(query);
            if (resultSet.next()) {
                int courseId = resultSet.getInt("course_id");
                return courseId;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    // ------------- MODULE COUNT : USING COURSE ID -------------
    public static int getModulesCount(int courseId) {
        try {
            String query = "SELECT COUNT(Module.module_name) AS modules_count FROM Module INNER JOIN Course ON Course.course_id = Module.course_id WHERE Course.course_id = " + courseId + ";";
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

    // ------------- ANNOUNCEMENTS : USING COURSE ID -------------
    public static String[][] getAnnouncementData(int courseId) {

        String announcementDetails[][] = new String[2][4];

        try {

            String query = """
                                SELECT Message.message, Teacher.f_name, Teacher.l_name, Message.date_posted
                                FROM Message
                                INNER JOIN Course ON Course.course_id = Message.course_id
                                INNER JOIN Teacher ON Teacher.id = Message.teacher_id
                                WHERE Course.course_id = ?
                                ORDER BY Message.date_posted DESC LIMIT 2;
                                """;

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setInt(1, courseId);

            ResultSet resultSet = preparedStatement.executeQuery();

            int i = 0;

            while (resultSet.next()) {

                String message = resultSet.getString("message");
                String fName = resultSet.getString("f_name");
                String lName = resultSet.getString("l_name");
                String date = resultSet.getString("date_posted");

                announcementDetails[i][0] = message;
                announcementDetails[i][1] = fName;
                announcementDetails[i][2] = lName;
                announcementDetails[i][3] = date;

                i++;

            }

            return announcementDetails;

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    // ------------- SEMESTER : USING DATE : ACCOUNT CREATION DATE  -------------
    public static String getSemester(String date) {

        LocalDate startDate = LocalDate.parse(date);
        LocalDate endDate = LocalDate.now();
        Period period = Period.between(startDate, endDate);
        int months = period.getYears() * 12 + period.getMonths();
        System.out.println(months);
        int semester = 1;

        for (int i = 2; i < months; i += 2) {
            semester++;
        }

        return Logics.convertToOrdinal(semester);
    }

    // ------------- UPDATING DATA : USING NECESSARY DATA : PROFILE SECTION -------------
    public static boolean updateProfile(String[] updatingDetails, int id) {

        String query;
        query = "UPDATE " + Account.usertype
                + " SET username = ?, email = ?, password = ?, ph_num = ?  WHERE id = ? ;";

        try {

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setString(1, updatingDetails[0]);
            preparedStatement.setString(2, updatingDetails[1]);
            preparedStatement.setString(3, updatingDetails[2]);
            preparedStatement.setString(4, updatingDetails[3]);
            preparedStatement.setInt(5,id);

            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Successfully updated values.", "Profile Update", JOptionPane.INFORMATION_MESSAGE);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
