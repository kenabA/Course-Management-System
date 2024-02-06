/**
 * @author kenabkc
 */
package cms.Backend;

import Teacher.TeacherPanel;
import cms.Frontend.AdminPanel;
import cms.Frontend.Person;
import cms.Frontend.Student.StudentPanel;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class Account extends CreateConnection {

    // Declaring the necessary assets
    StudentPanel sp;
    TeacherPanel tp;

    private static String usertype;
    private static int id;

    static String loginTime;
    static String lastLoggedInTime;

    Icon erIcon = new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/errorIcon.png"));
    Icon icon = new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/checkIcon.png"));

    // ------------- INSERTING DATA -------------
    public static void registerAccount(String[] credentials) {

        try {

            switch (credentials[7]) {
                case "Admin" -> {

                    String query1 = "INSERT INTO `" + credentials[7] + "` (`f_name`, `l_name`, `username`, `email`, `ph_num`, `password`, `date_created`) VALUES ('" + credentials[0] + "', '" + credentials[1] + "', '" + credentials[2] + "', '" + credentials[3] + "', '" + credentials[4] + "', '" + credentials[5] + "', current_timestamp());";
                    c.statement.executeUpdate(query1);
                    break;

                }
                default -> {
                    String query = "INSERT INTO `" + credentials[7] + "` (`f_name`, `l_name`, `username`, `email`, `ph_num`, `password`, `date_created`, `course`) VALUES ('" + credentials[0] + "', '" + credentials[1] + "', '" + credentials[2] + "', '" + credentials[3] + "', '" + credentials[4] + "', '" + credentials[5] + "', current_timestamp() , '" + credentials[8] + "' );";
                    c.statement.executeUpdate(query);
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

    // ------------- LOGGING ACCOUNT : OPENING NEW PANEL -------------
    public boolean loginAccount(Object usertype, String username, String password) {

        ResultSet loginValidation = getLoginDetails(usertype, username, password);

        try {
            if (loginValidation.next()) {
                UIManager.put("OptionPane.okButtonText", "OK");
                JOptionPane.showMessageDialog(null, "You have successfully logged into your account.", "Login Successful", JOptionPane.INFORMATION_MESSAGE, icon);

                Account.usertype = usertype.toString();

                // Setting the global id for futuristic use
                Account.id = loginValidation.getInt("id");

                // If the Student is logging in : 
                if (usertype.equals("Student")) {
                    sp = new StudentPanel();
                    sp.setName(username);
                    sp.updateDetails();
                    sp.setVisible(true);
                    return true;

                } // If the Teacher or Admin is logging in : 
                else if (usertype.equals("Teacher")) {
                    tp = new TeacherPanel();
                    tp.setName(username);
                    tp.updateDetails();
                    tp.setVisible(true);
                } else {
                    new AdminPanel().setVisible(true);
                }

            } else {
                JOptionPane.showMessageDialog(null, "The details do not match. Please try again.", "Incorrect Credentials", JOptionPane.INFORMATION_MESSAGE, erIcon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    // ------------- GETTING ALL USER DATA : USING USERNAME -------------
    public static ResultSet getUserData(String username) {
        try {
            String query = "select * from `" + usertype + "` where binary username = '" + username + "' ";
            ResultSet resultSet = c.statement.executeQuery(query);
            return resultSet;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
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
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Successfully updated values.", "Profile Update", JOptionPane.INFORMATION_MESSAGE);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    // ------------- FOR TABLE 1 : COURSES -------------
    public static void forTable1(int courseId, DefaultTableModel model) {
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

    // ------------- UPDATE ACTIVITY -------------
    public static void updateActivity(String act) {

        try {

            String query = "INSERT INTO `Activity` (`activity`, `role`, `role_id`, `time`) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setString(1, act);
            preparedStatement.setString(2, usertype);
            preparedStatement.setInt(3, id);

            /*
                Instead of passing the current_timestamp(), we pass our custom loginTime 
                to make sure there are no differences in time while checking for new messages.
             */
            loginTime = Logics.getCurrentTime();

            preparedStatement.setString(4, loginTime);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ------------- CHECK IF ANY NEW NOTIFICATIONS -------------
    public static boolean checkNotifications() {
        // Just to get the last logged out time.
        Account.lastLoggedInTime = getLastLoginTime();

        try {
            String query = " SELECT message FROM Message WHERE date_posted > ? AND course_id = ? ;";

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setString(1, lastLoggedInTime);
            preparedStatement.setInt(2, Person.getCourseId());
            
            System.out.println(Person.getCourseId());

            ResultSet resultSet = preparedStatement.executeQuery();
            
            return resultSet.next();

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // ------------- GETTING THE LAST LOGGED OUT  -------------
    private static String getLastLoginTime() {

        try {
            String query = """
                                 SELECT MAX(time) as last_login_time
                                                            FROM Activity
                                                            WHERE role = ? AND role_id = ? AND time < ? AND activity = 'Login';
                                                                
                                """;

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setString(1, usertype);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(3, Account.loginTime);

            ResultSet resultSet = preparedStatement.executeQuery();
            String lastLoggedinTime = null;

            while (resultSet.next()) {

                lastLoggedinTime = resultSet.getString("last_login_time");

            }
            return lastLoggedinTime;

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static String getQuesName(int qid) {
        try {
            String query = """
                           SELECT Question.question
                           FROM `Question`
                           WHERE Question.q_id = ? ;
                           """;

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setInt(1, qid);

            ResultSet resultSet = preparedStatement.executeQuery();
            String quesName = null;
            while (resultSet.next()) {
                quesName = resultSet.getString("question");
            }
            return quesName;

        } catch (Exception e) {
        }
        return null;

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

}
