/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cms.Frontend;

import Teacher.TeacherPanel;
import cms.Frontend.Student.StudentPanel;

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

}
