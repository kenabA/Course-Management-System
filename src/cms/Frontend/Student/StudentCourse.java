/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.Frontend.Student;

import cms.Backend.Account;
import cms.Backend.StudentAccount;
import java.awt.Color;
import java.awt.Font;
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

    public static JTable table;

    public static void updateDetails(int courseId, JTable table, String tableName) {
        StudentCourse.table = table;
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        getModuleData(courseId, model, tableName);

    }

    public static void getModuleData(int courseId, DefaultTableModel model, String tableName) {
        if (tableName.equals("t1")) {
            Account.forTable1(courseId, model);

        } else if (tableName.equals("t2")) {
            StudentAccount.forTable2(courseId, model);
        }
    }

    public static void alignTableContents(JTable table) {
        DefaultTableCellRenderer alignRenderer = new DefaultTableCellRenderer();
        alignRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(alignRenderer);
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
