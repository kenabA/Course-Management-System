/**
 * @author kenabkc
 */
package cms.Backend;

import Admin.AdminPanel;
import Teacher.TeacherPanel;

import cms.Frontend.Person;
import cms.Frontend.Student.StudentPanel;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class Account extends CreateConnection {

    // Declaring the necessary assets
    StudentPanel sp;
    TeacherPanel tp;
    AdminPanel ap;

    private static String usertype;
    private static int id;

    static String loginTime;
    static String lastLoggedInTime;

    Icon erIcon = new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/errorIcon.png"));
    Icon icon = new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/checkIcon.png"));

    public static JTable table;

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
            System.out.println(usertype);
            String getUsername = "select * from " + usertype + " where binary username = '" + username + "' and not id = " + id + " ";

            ResultSet userName = c.statement.executeQuery(getUsername);

            if (userName.next()) {
                JOptionPane.showMessageDialog(null, "Username already exists. Please try again with another input.", "Registration Error", JOptionPane.INFORMATION_MESSAGE);
                UIManager.put("JOptionPane.okButtonText", "OK");
                return false;
            }

            String getEmail = "select * from " + usertype + " where binary email = '" + email + "' and not id = " + id + " ";

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
                    ap = new AdminPanel();
                    ap.setName(username);
                    ap.updateDetails();
                    ap.setVisible(true);

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
            System.out.println("Error in the Account file : " + e);
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

    // ------------- MODULE COUNT : USING COURSE ID -------------
    public static int getModuleId(String moduleName) {
        try {
            String query = "SELECT module_id FROM Module WHERE module_name = '" + moduleName + "';";
            ResultSet resultSet = c.statement.executeQuery(query);
            if (resultSet.next()) {
                int modulesId = resultSet.getInt("module_id");
                return modulesId;
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

    // ------------- UPDATE ACTIVITY -------------
    public static void updateActivity(String act) {

        String activity;

        switch (act) {

            case "Login":
                activity = usertype + " : " + Person.getName() + " has Logged in";

                break;

            case "Logout":
                activity = usertype + " : " + Person.getName() + " has Logged out";

                break;

            default:
                activity = usertype + " : " + Person.getName() + " has deleted a user";
                break;
        }

        try {

            String query = "INSERT INTO `Activity` (`activity`, `role`, `role_id`,`activity_name` ,`time`) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setString(1, activity);
            preparedStatement.setString(2, usertype);
            preparedStatement.setInt(3, id);
            preparedStatement.setString(4, act);

            /*
                Instead of passing the current_timestamp(), we pass our custom loginTime 
                to make sure there are no differences in time while checking for new messages.
             */
            loginTime = HelperMethods.getCurrentTime();

            preparedStatement.setString(5, loginTime);

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // ------------- GETTING THE LAST LOGGED OUT  -------------

    public static String getLastLoginTime() {

        try {
            String query = """
                                 SELECT MAX(time) as last_login_time
                                                            FROM Activity
                                                            WHERE role = ? AND role_id = ? AND time < ? AND activity_name = 'Login';
                                                                
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

    public static ArrayList<String> getModuleNames(int semester) {

        ArrayList<String> modules = new ArrayList<>();

        try {
            String query = " SELECT Module.module_name FROM `Module` INNER JOIN Teacher ON Module.teacher_id = Teacher.id WHERE Module.teacher_id = ? and semester = ?;";
            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setInt(1, Person.getId());
            preparedStatement.setInt(2, semester);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String moduleName = resultSet.getString("module_name");

                modules.add(moduleName);
            }

            return modules;
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<String> getModuleNames() {

        ArrayList<String> modules = new ArrayList<>();

        try {
            String query = " SELECT Module.module_name FROM `Module` INNER JOIN Teacher ON Module.teacher_id = Teacher.id WHERE Module.teacher_id = ?;";
            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setInt(1, Person.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String moduleName = resultSet.getString("module_name");

                modules.add(moduleName);
            }

            return modules;
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static int getSemesterFromModuleId(int modId) {
        try {
            String query = " SELECT Module.semester FROM `Module` WHERE Module.module_id = ?;";
            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setInt(1, modId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return resultSet.getInt("semester");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static ArrayList<String> getCourses() {
        try {
            ArrayList<String> courses = new ArrayList<>();

            String query = " SELECT Course.course_name, COUNT(Module.module_id) AS module_count FROM `Course` JOIN Module ON Course.course_id = Module.course_id GROUP BY Course.course_id, Course.course_name HAVING module_count >= 4;";
            PreparedStatement preparedStatement = c.connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                courses.add(resultSet.getString("course_name"));

            }
            return courses;

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] extractFLName(int id, String role) {
        try {

            String query = " SELECT f_name, l_name FROM `Student` where Student.id = " + id + " ;";

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            String names[] = new String[2];

            while (resultSet.next()) {
                names[0] = resultSet.getString("f_name");
                names[1] = resultSet.getString("l_name");
            }
            return names;

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
