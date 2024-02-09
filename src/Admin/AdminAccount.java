/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

import cms.Backend.Account;
import cms.Backend.CreateConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

}
