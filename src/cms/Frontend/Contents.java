/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.Frontend;

import Teacher.TeacherPanel;
import cms.Frontend.Student.StudentPanel;
import static cms.Frontend.Student.StudentPanel.submitBtn1;

/**
 *
 * @author kenabkc
 */
public class Contents {

    // Using this method to set the announcements when student panel class is used - Polymorphism
    public void setAnnouncement(String[][] data, StudentPanel sp) {

        sp.msg1.setText(data[0][0]);

        String fullName = data[0][1] + " " + data[0][2];

        sp.teacher1.setText("- " + fullName);
        sp.date1.setText(data[0][3]);

        if (data[1][0] == null) {
            sp.msg2.setText("There has been only one announcement for this course.");
            sp.teacher2.setVisible(false);
            sp.date2.setVisible(false);
        } else {
            sp.msg2.setText(data[1][0]);

            String fullName2 = data[1][1] + " " + data[1][2];

            sp.teacher2.setText("- " + fullName2);
            sp.date2.setText(data[1][3]);
        }

    }

    // Using this method to set the announcements when teacher panel class is used - Polymorphism
    public void setAnnouncement(String[][] data, TeacherPanel tp) {

        tp.msg1.setText(data[0][0]);

        String fullName = data[0][1] + " " + data[0][2];

        tp.teacher1.setText("- " + fullName);
        tp.date1.setText(data[0][3]);

        if (data[1][0] == null) {
            tp.msg2.setText("There has been only one announcement for this course.");
            tp.teacher2.setVisible(false);
            tp.date2.setVisible(false);
        } else {
            tp.msg2.setText(data[1][0]);

            String fullName2 = data[1][1] + " " + data[1][2];

            tp.teacher2.setText("- " + fullName2);
            tp.date2.setText(data[1][3]);
        }

    }

    public void setQuestionsDetails(String[][] data, StudentPanel sp) {

        if (data[0][0] == null) {
            sp.qsNo1.setText("No Assingments yet.");
            sp.qsLabel1.setText("Assingments yet to assign by the respected teacher.");
            sp.qsMod1.setText("Module Name");
            sp.qsDate1.setText("Date of Question Posted");
            submitBtn1.setVisible(false);

            sp.qsPanel2.setVisible(false);
            sp.qsPanel3.setVisible(false);

        } else if (data[1][0] == null) {
            sp.q1 = Integer.parseInt(data[0][0]);
            sp.qsNo1.setText("Question Number " + data[0][0]);
            sp.qsLabel1.setText(data[0][1]);
            sp.qsMod1.setText(data[0][2]);
            sp.qsDate1.setText(data[0][3]);

            sp.qsPanel2.setVisible(false);
            sp.qsPanel3.setVisible(false);

        } else if (data[1][0] != null && data[2][0] == null) {
            sp.q1 = Integer.parseInt(data[0][0]);
            sp.q2 = Integer.parseInt(data[1][0]);

            sp.qsNo1.setText("Question Number " + data[0][0]);
            sp.qsLabel1.setText(data[0][1]);
            sp.qsMod1.setText(data[0][2]);
            sp.qsDate1.setText(data[0][3]);

            sp.qsNo2.setText("Question Number " + data[1][0]);
            sp.qsLabel2.setText(data[1][1]);
            sp.qsMod2.setText(data[1][2]);
            sp.qsDate2.setText(data[1][3]);

            sp.qsPanel3.setVisible(false);

        } else {
            // Storing the question numbers in a variable for future use
            sp.q1 = Integer.parseInt(data[0][0]);
            sp.q2 = Integer.parseInt(data[1][0]);
            sp.q3 = Integer.parseInt(data[2][0]);

            // Setting all the texts
            sp.qsNo1.setText("Question Number " + data[0][0]);
            sp.qsNo2.setText("Question Number " + data[1][0]);
            sp.qsNo3.setText("Question Number " + data[2][0]);

            sp.qsLabel1.setText(data[0][1]);
            sp.qsLabel2.setText(data[1][1]);
            sp.qsLabel3.setText(data[2][1]);

            sp.qsMod1.setText(data[0][2]);
            sp.qsMod2.setText(data[1][2]);
            sp.qsMod3.setText(data[2][2]);

            sp.qsDate1.setText(data[0][3]);
            sp.qsDate2.setText(data[1][3]);
            sp.qsDate3.setText(data[2][3]);

        }

    }

    public void setQuestionsDetails(String[][] data, TeacherPanel tp) {

        if (data[0][0] == null) {
            tp.qsNo1.setText("No Assingments yet.");
            tp.qsLabel1.setText("Assingments yet to assign by the retpected teacher.");
            tp.qsMod1.setText("Module Name");
            tp.qsDate1.setText("Date of Question Posted");

            tp.qsPanel2.setVisible(false);
            tp.qsPanel3.setVisible(false);

        } else if (data[1][0] == null) {
            tp.q1 = Integer.parseInt(data[0][0]);
            tp.qsNo1.setText("Question Number " + data[0][0]);
            tp.qsLabel1.setText(data[0][1]);
            tp.qsMod1.setText(data[0][2]);
            tp.qsDate1.setText(data[0][3]);

            tp.qsPanel2.setVisible(false);
            tp.qsPanel3.setVisible(false);

        } else if (data[1][0] != null && data[2][0] == null) {

            tp.q1 = Integer.parseInt(data[0][0]);
            tp.q2 = Integer.parseInt(data[1][0]);

            tp.qsNo1.setText("Question Number " + data[0][0]);
            tp.qsLabel1.setText(data[0][1]);
            tp.qsMod1.setText(data[0][2]);
            tp.qsDate1.setText(data[0][3]);

            tp.qsNo2.setText("Question Number " + data[1][0]);
            tp.qsLabel2.setText(data[1][1]);
            tp.qsMod2.setText(data[1][2]);
            tp.qsDate2.setText(data[1][3]);

            tp.qsPanel2.setVisible(true);
            tp.qsPanel3.setVisible(false);

        } else {

            tp.qsPanel2.setVisible(true);
            tp.qsPanel3.setVisible(true);

            // Storing the question numbers in a variable for future use
            tp.q1 = Integer.parseInt(data[0][0]);
            tp.q2 = Integer.parseInt(data[1][0]);
            tp.q3 = Integer.parseInt(data[2][0]);

            // Setting all the texts
            tp.qsNo1.setText("Question Number " + data[0][0]);
            tp.qsNo2.setText("Question Number " + data[1][0]);
            tp.qsNo3.setText("Question Number " + data[2][0]);

            tp.qsLabel1.setText(data[0][1]);
            tp.qsLabel2.setText(data[1][1]);
            tp.qsLabel3.setText(data[2][1]);

            tp.qsMod1.setText(data[0][2]);
            tp.qsMod2.setText(data[1][2]);
            tp.qsMod3.setText(data[2][2]);

            tp.qsDate1.setText(data[0][3]);
            tp.qsDate2.setText(data[1][3]);
            tp.qsDate3.setText(data[2][3]);

        }

    }

}
