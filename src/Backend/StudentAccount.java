/**
 *
 * @author kenabkc
 */
package Backend;

import static Backend.CreateConnection.c;
import Frontend.Person;
import Student.StudentPanel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class StudentAccount extends CreateConnection implements StudentTeacherUtils {

    private static String lastLoggedInTime;

    // ------------- STUDENT COUNT : USING COURSE -------------
    public static int getTotalStudentCount(String course) {

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

    // ------------- SEMESTER : USING DATE : ACCOUNT CREATION DATE  -------------
    public static String getSemester(String date) {

        LocalDate startDate = LocalDate.parse(date);
        LocalDate endDate = LocalDate.now();
        Period period = Period.between(startDate, endDate);
        int months = period.getYears() * 12 + period.getMonths();
        int semester = 1;

        for (int i = 2; i < months; i += 2) {
            semester++;
        }
        Person.setSemester(semester);
        return HelperMethods.convertToOrdinal(semester);
    }

    // ------------- TO GET THE QUESTIONS DATA -------------
    public static String[][] getQuestions() {

        try {
            String query = """
                            SELECT Module.module_name, Question.date_posted, Question.question, Question.semester, Question.q_id FROM `Question`                   
                            INNER JOIN Module ON Module.module_id = Question.module_id
                             INNER JOIN Course ON Course.course_id = Module.course_id
                             WHERE Question.semester = ? AND Course.course_id = ? ORDER BY Question.date_posted DESC LIMIT 3;
                           """;

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setInt(1, Person.getSemester());
            preparedStatement.setInt(2, Person.getCourseId());

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

                i++;

            }
            return questionDetails;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // ------------- To Submit the assignment -------------
    public static int submitAssignment(int qid, String answer) {
        try {
            // Inserts the assingments and inserts the status to 1.
            String query = "INSERT INTO `Answer` (`Answers`, `q_id`, `s_id`,`status`,`date_submitted`) VALUES (?, ?, ?, ?,current_timestamp());";
            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setString(1, answer);
            preparedStatement.setInt(2, qid);
            preparedStatement.setInt(3, Person.getId());
            preparedStatement.setInt(4, 1);
            int rows = preparedStatement.executeUpdate();
            return rows;

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;

    }

    // ------------- Checking the submitted status of a specific student  -------------
    public static void checkStatus1(StudentPanel p) {
        try {

            String query = """
                           SELECT Answer.status
                           FROM `Answer`
                           WHERE Answer.s_id = ? AND Answer.q_id = ? ;
                           """;

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setInt(1, Person.getId());
            preparedStatement.setInt(2, p.q1);

            ResultSet resultSet = preparedStatement.executeQuery();
            int status = 0;
            while (resultSet.next()) {
                status = resultSet.getInt("status");
            }
            if (status == 1) {
                // If the assignment is submitted, the button will be set to unclickable
                p.setButtonState(false);
            }

        } catch (Exception e) {
        }

    }

    public static void checkStatus2(StudentPanel p) {

        try {
            String query = """
                           SELECT Answer.q_id, Answer.status
                           FROM `Answer`
                           WHERE Answer.s_id = ? AND Answer.q_id = ? ;
                           """;

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setInt(1, Person.getId());
            preparedStatement.setInt(2, p.q2);

            ResultSet resultSet = preparedStatement.executeQuery();
            int status = 0;
            while (resultSet.next()) {
                status = resultSet.getInt("status");
            }
            if (status == 1) {
                p.setButtonState2(false);
            }

        } catch (Exception e) {
        }
    }

    public static void checkStatus3(StudentPanel p) {

        try {
            String query = """
                           SELECT Answer.q_id, Answer.status
                           FROM `Answer`
                           WHERE Answer.s_id = ? AND Answer.q_id = ? ;
                           """;

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setInt(1, Person.getId());
            preparedStatement.setInt(2, p.q3);

            ResultSet resultSet = preparedStatement.executeQuery();
            int status = 0;
            while (resultSet.next()) {
                status = resultSet.getInt("status");
            }
            if (status == 1) {
                p.setButtonState3(false);
            }
        } catch (Exception e) {
        }
    }

    public static void getTableData(int courseId, DefaultTableModel model, String tableName) {
        if (tableName.equals("t1")) {
            coursesTable(courseId, model);

        }
        if (tableName.equals("t2")) {
            gradesTable(courseId, model);
        }
    }

    // ------------- FOR TABLE 1 : COURSES -------------
    public static void coursesTable(int courseId, DefaultTableModel model) {
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

    // ------------- FOR TABLE 2 : GRADES TABLE -------------
    public static void gradesTable(int courseId, DefaultTableModel model) {
        try {
            String query = """
                                SELECT
                                                                    Module.module_id,
                                                                    Module.module_name,
                                                                    Module.semester,
                                                                    Grade.grade,
                           Grade.overall
                                                                
                                                                FROM
                                                                	Grade
                                                                INNER JOIN Module ON Module.module_id = Grade.module_id
                                                                INNER JOIN Student ON Student.id = Grade.student_id
                                                                WHERE
                                                                    Student.id = ?;
                                """;

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setInt(1, courseId);

            ResultSet resultSet = preparedStatement.executeQuery();

            int totalPerformance = 0;
            int count = 0;

            while (resultSet.next()) {

                String moduleId = String.valueOf(resultSet.getInt("module_id"));
                String name = resultSet.getString("module_name");
                String sem = String.valueOf(resultSet.getInt("semester"));
                String percentage = String.valueOf(resultSet.getInt("grade")) + "%";
                int percentageCount = resultSet.getInt("grade");
                String grade = HelperMethods.getGrades(percentageCount);
                int overall = resultSet.getInt("overall");

                String row[] = {moduleId, name, sem, percentage, grade};

                model.addRow(row);

                totalPerformance = totalPerformance + overall;
                count++;

            }
            if (count != 0) {
                Person.setOverallPerformance(totalPerformance / count);
                return;
            }
            Person.setOverallPerformance(0);

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getAccountCreatedDate(String id) {

        try {
            String query = """
                               SELECT date_created FROM student WHERE id = ?;
                                """;

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(id));

            ResultSet resultSet = preparedStatement.executeQuery();

            String date = null;

            while (resultSet.next()) {
                date = resultSet.getString("date_created");
            }

            return date;
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
                                WHERE Course.course_id = ? and Message.semester = ?
                                ORDER BY Message.date_posted DESC LIMIT 2;
                                """;

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setInt(1, courseId);
            preparedStatement.setInt(2, Person.getSemester());

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

    // ------------- CHECK IF ANY NEW NOTIFICATIONS -------------
    public static boolean checkNotifications() {

        // Just to get the last logged out time.
        lastLoggedInTime = Account.getLastLoginTime();

        try {
            String query = " SELECT message FROM Message WHERE date_posted > ? AND course_id = ? AND Message.semester = ?  ;";

            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.setString(1, lastLoggedInTime);
            preparedStatement.setInt(2, Person.getCourseId());
            preparedStatement.setInt(3, Person.getSemester());

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();

        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
