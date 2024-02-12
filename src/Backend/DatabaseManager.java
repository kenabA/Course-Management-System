/**
 *
 * @author kenabkc
 */
package Backend;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class DatabaseManager extends CreateConnection {

    private final String databaseName = "CMS";

    public DatabaseManager() throws SQLException {
        verifyDatabase(databaseName);
        verifyDatabaseUse(databaseName);
        verifyTables();
        System.out.println("Done Checking!");
    }

    // Verifying the database
    private void verifyDatabase(String dbName) throws SQLException {
        try {

            System.out.println("Checking if database exists...");

            // Check if the database already exists & getting the database names
            ResultSet resultSet = c.connection.getMetaData().getCatalogs();
            boolean databaseExists = false;
            while (resultSet.next()) {

                String databaseName = resultSet.getString(1);
                System.out.println(databaseName);
                if (databaseName.equals(dbName)) {

                    databaseExists = true;

                    break;
                }
            }
            resultSet.close();

            // If the database doesn't exist, create it
            if (!databaseExists) {
                System.out.println("Creating database...");
                String query = "CREATE DATABASE " + dbName;
                PreparedStatement preparedStatement = c.connection.prepareStatement(query);
                preparedStatement.executeUpdate();
                System.out.println("Database created successfully.");
            } else {
                System.out.println("Database already exists.");
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    // Verifying the use of database
    private void verifyDatabaseUse(String dbName) throws SQLException {
        try {
            String query = "USE " + dbName;
            PreparedStatement preparedStatement = c.connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            System.out.println("Using Database " + dbName);
        } catch (SQLException ex) {
            System.out.println("Cannot use the database.");
        }
    }

    // Verifying the tables
    private void verifyTables() throws SQLException {

        verifyTableTeacher();
        verifyTableStudent();
        verifyTableAdmin();
        verifyTableQuestion();
        verifyTableModule();
        verifyTableMessage();
        verifyTableGrade();
        verifyTableCourse();
        verifyTableAnswer();
        verifyTableActivity();

    }

    // Veriyfing the student table
    private void verifyTableStudent() throws SQLException {

        try {
            String createStudentTable = """
                                                    CREATE TABLE `student` (
                                                          `id` int(10) NOT NULL AUTO_INCREMENT,
                                                          `f_name` varchar(50) NOT NULL,
                                                          `l_name` varchar(50) NOT NULL,
                                                          `username` varchar(15) NOT NULL,
                                                          `password` varchar(50) NOT NULL,
                                                          `email` varchar(50) NOT NULL,
                                                          `ph_num` varchar(10) NOT NULL,
                                                          `date_created` date NOT NULL DEFAULT current_timestamp(),
                                                          `course` varchar(50) DEFAULT NULL,
                                                          PRIMARY KEY (`id`)
                                                        ) 
                                                    """;
            PreparedStatement preparedStatement = c.connection.prepareStatement(createStudentTable);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1050) {
                System.out.println("Student table exits already");
            } else {
                throw ex;
            }
        }

    }

    // Veriyfing the Teacher table
    private void verifyTableTeacher() throws SQLException {

        try {
            String createTeacherTable = """
                                             CREATE TABLE `Teacher` (
                                                     `id` int(10) NOT NULL AUTO_INCREMENT,
                                                     `f_name` varchar(50) NOT NULL,
                                                     `l_name` varchar(50) NOT NULL,
                                                     `course` varchar(10) NOT NULL,
                                                     `username` varchar(15) NOT NULL,
                                                     `password` varchar(50) NOT NULL,
                                                     `email` varchar(50) NOT NULL,
                                                     `ph_num` varchar(10) NOT NULL,
                                                     `date_created` date NOT NULL,
                                                     PRIMARY KEY (`id`)
                                                   )
                                                         
                                                    """;
            PreparedStatement preparedStatement = c.connection.prepareStatement(createTeacherTable);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1050) {
                System.out.println("Teacher table exits already");
            } else {
                throw ex;
            }
        }

    }

    // Veriyfing the admin table
    private void verifyTableAdmin() throws SQLException {

        try {
            String createAdminTable = """
                                                   CREATE TABLE `Admin` (
                                                     `id` int(10) NOT NULL AUTO_INCREMENT,
                                                     `f_name` varchar(50) NOT NULL,
                                                     `l_name` varchar(50) NOT NULL,
                                                     `username` varchar(15) NOT NULL,
                                                     `password` varchar(50) NOT NULL,
                                                     `email` varchar(50) NOT NULL,
                                                     `ph_num` varchar(10) NOT NULL,
                                                     `date_created` date NOT NULL,
                                                     PRIMARY KEY (`id`)
                                                   )
                                                         
                                                    """;
            PreparedStatement preparedStatement = c.connection.prepareStatement(createAdminTable);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1050) {
                System.out.println("Admin table exits already");
            } else {
                throw ex;
            }
        }

    }

    // Veriyfing the Question table
    private void verifyTableQuestion() throws SQLException {

        try {
            String createQuestionTable = """
                                                CREATE TABLE `question` (
                                                    `q_id` int(11) NOT NULL AUTO_INCREMENT,
                                                    `question` varchar(255) NOT NULL,
                                                    `semester` int(11) NOT NULL,
                                                    `module_id` int(11) NOT NULL,
                                                    `date_posted` datetime NOT NULL DEFAULT current_timestamp(),
                                                    PRIMARY KEY (`q_id`),
                                                    KEY `fk_module_cascade_delete` (`module_id`),
                                                    CONSTRAINT `fk_module_cascade_delete` FOREIGN KEY (`module_id`) REFERENCES `Module` (`module_id`) ON DELETE CASCADE ON UPDATE CASCADE
                                                  )  
                                                         
                                                    """;
            PreparedStatement preparedStatement = c.connection.prepareStatement(createQuestionTable);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1050) {
                System.out.println("Question table exits already");
            } else {
                throw ex;
            }
        }

    }

    // Veriyfing the Module table
    private void verifyTableModule() throws SQLException {

        try {
            String createModuleTable = """
                                                CREATE TABLE `Module` (
                                                 `module_id` int(11) NOT NULL AUTO_INCREMENT,
                                                 `module_name` varchar(50) NOT NULL,
                                                 `semester` int(11) NOT NULL,
                                                 `course_id` int(11) NOT NULL,
                                                 `teacher_id` int(11) DEFAULT NULL,
                                                 PRIMARY KEY (`module_id`),
                                                 KEY `fk_course_id` (`course_id`),
                                                 KEY `fk_t_id` (`teacher_id`),
                                                 CONSTRAINT `fk_course_id` FOREIGN KEY (`course_id`) REFERENCES `Course` (`course_id`),
                                                 CONSTRAINT `fk_t_id` FOREIGN KEY (`teacher_id`) REFERENCES `Teacher` (`id`) ON DELETE SET NULL,
                                                 CONSTRAINT `fk_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `Teacher` (`id`),
                                                 CONSTRAINT `fk_teacher_id_module` FOREIGN KEY (`teacher_id`) REFERENCES `Teacher` (`id`) ON DELETE SET NULL
                                               )                       
                                                         
                                                    """;
            PreparedStatement preparedStatement = c.connection.prepareStatement(createModuleTable);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1050) {
                System.out.println("Module table exits already");
            } else {
                throw ex;
            }
        }

    }

    // Veriyfing the Message table
    private void verifyTableMessage() throws SQLException {

        try {
            String createMessageTable = """
                                                CREATE TABLE `Message` (
                                                 `module_id` int(11) NOT NULL AUTO_INCREMENT,
                                                 `module_name` varchar(50) NOT NULL,
                                                 `semester` int(11) NOT NULL,
                                                 `course_id` int(11) NOT NULL,
                                                 `teacher_id` int(11) DEFAULT NULL,
                                                 PRIMARY KEY (`module_id`),
                                                 KEY `fk_course_id` (`course_id`),
                                                 KEY `fk_t_id` (`teacher_id`),
                                                 CONSTRAINT `fk_course_id` FOREIGN KEY (`course_id`) REFERENCES `Course` (`course_id`),
                                                 CONSTRAINT `fk_t_id` FOREIGN KEY (`teacher_id`) REFERENCES `Teacher` (`id`) ON DELETE SET NULL,
                                                 CONSTRAINT `fk_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `Teacher` (`id`),
                                                 CONSTRAINT `fk_teacher_id_module` FOREIGN KEY (`teacher_id`) REFERENCES `Teacher` (`id`) ON DELETE SET NULL
                                               )                       
                                                         
                                                    """;
            PreparedStatement preparedStatement = c.connection.prepareStatement(createMessageTable);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1050) {
                System.out.println("Message table exits already");
            } else {
                throw ex;
            }
        }

    }

    // Veriyfing the Grade table
    private void verifyTableGrade() throws SQLException {

        try {
            String createGradeTable = """
                                  CREATE TABLE `grade` (
                                                  `grade_id` int(11) NOT NULL AUTO_INCREMENT,
                                                  `grade` int(11) NOT NULL,
                                                  `overall` int(11) NOT NULL,
                                                  `student_id` int(11) NOT NULL,
                                                  `module_id` int(11) NOT NULL,
                                                  PRIMARY KEY (`grade_id`),
                                                  KEY `fk_student_id_grade` (`student_id`),
                                                  KEY `modules_id_update_cascade` (`module_id`),
                                                  CONSTRAINT `fk_student_id_grade` FOREIGN KEY (`student_id`) REFERENCES `Student` (`id`) ON DELETE CASCADE,
                                                  CONSTRAINT `modules_id_update_cascade` FOREIGN KEY (`module_id`) REFERENCES `Module` (`module_id`) ON DELETE CASCADE ON UPDATE CASCADE
                                                )              
                                                    """;
            PreparedStatement preparedStatement = c.connection.prepareStatement(createGradeTable);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1050) {
                System.out.println("Grade table exits already");
            } else {
                throw ex;
            }
        }

    }

    // Veriyfing the Course table
    private void verifyTableCourse() throws SQLException {

        try {
            String createCourseTable = """
                                  CREATE TABLE `course` (
                                                  `course_id` int(11) NOT NULL AUTO_INCREMENT,
                                                  `course_name` varchar(30) NOT NULL,
                                                  `course_title` varchar(255) NOT NULL,
                                                  `date_created` datetime NOT NULL DEFAULT current_timestamp(),
                                                  PRIMARY KEY (`course_id`),
                                                  UNIQUE KEY `unique_constraint_name` (`course_name`),
                                                  UNIQUE KEY `unique_constraint_title` (`course_title`)
                                                )          
                                                    """;
            PreparedStatement preparedStatement = c.connection.prepareStatement(createCourseTable);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1050) {
                System.out.println("Course table exits already");
            } else {
                throw ex;
            }
        }

    }

    // Veriyfing the Answer table
    private void verifyTableAnswer() throws SQLException {

        try {
            String createAnswerTable = """
                                  CREATE TABLE `answer` (
                                                  `a_id` int(11) NOT NULL AUTO_INCREMENT,
                                                  `Answers` varchar(255) NOT NULL,
                                                  `q_id` int(11) NOT NULL,
                                                  `s_id` int(11) NOT NULL,
                                                  `status` tinyint(1) NOT NULL,
                                                  `date_submitted` date NOT NULL DEFAULT current_timestamp(),
                                                  PRIMARY KEY (`a_id`),
                                                  KEY `fk_student_id_answer` (`s_id`),
                                                  KEY `question_fk_id` (`q_id`),
                                                  CONSTRAINT `fk_student_id_answer` FOREIGN KEY (`s_id`) REFERENCES `Student` (`id`) ON DELETE CASCADE,
                                                  CONSTRAINT `question_fk_id` FOREIGN KEY (`q_id`) REFERENCES `Question` (`q_id`) ON DELETE CASCADE
                                                )        
                                                    """;
            PreparedStatement preparedStatement = c.connection.prepareStatement(createAnswerTable);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1050) {
                System.out.println("Answer table exits already");
            } else {
                throw ex;
            }
        }

    }

    // Veriyfing the Activity table
    private void verifyTableActivity() throws SQLException {

        try {
            String createActivityTable = """
                                 CREATE TABLE `activity` (
                                                  `act_id` int(11) NOT NULL AUTO_INCREMENT,
                                                  `activity` varchar(255) NOT NULL,
                                                  `activity_name` varchar(255) NOT NULL,
                                                  `role` varchar(20) NOT NULL,
                                                  `role_id` int(11) NOT NULL,
                                                  `time` datetime NOT NULL,
                                                  PRIMARY KEY (`act_id`)
                                                )         
                                                    """;
            PreparedStatement preparedStatement = c.connection.prepareStatement(createActivityTable);
            int result = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1050) {
                System.out.println("Activity table exits already");
            } else {
                throw ex;
            }
        }

    }

}
