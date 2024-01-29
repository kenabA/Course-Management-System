/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.Frontend.Student;

import cms.Backend.Account;
import cms.Backend.Con;
import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author kenabkc
 */
public class StudentCourse {

    private static final Con c = new Con();

    public static void updateDetails(int courseId, DefaultTableModel model) {

        getModuleData(courseId, model);

    }

    public static void getModuleData(int courseId, DefaultTableModel model) {

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

    public static void centerTableContents(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    public static void setTableAppearance(JTable table) {

        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        headerRenderer.setBorder(new EmptyBorder(10, 20, 10, 20));

        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setSelectionBackground(new Color(241, 240, 255));
        table.setSelectionForeground(new Color(108, 99, 255));
        int margin = 20;
        table.setRowHeight(table.getRowHeight() + margin);
        JTableHeader header = table.getTableHeader();
        Font originalFont = header.getFont();
        Font boldFont = new Font(originalFont.getFontName(), Font.BOLD, originalFont.getSize());
        header.setFont(boldFont);
        header.setForeground(new Color(102, 102, 102));
    }
}
