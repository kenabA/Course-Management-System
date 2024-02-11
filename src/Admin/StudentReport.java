/**
 *
 * @author kenabkc
 */
package Admin;

import java.sql.ResultSet;
import cms.Backend.Account;
import cms.Backend.HelperMethods;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class StudentReport extends javax.swing.JFrame {

    ResultSet result;

    String studentId, studentName, studentNum, studentSemester, studentCourse, studentEmail, studentDesc, studentStatus;
    int studentPerformance, studentPercentage;

    public StudentReport(String[] courseDetails) {
        try {
            initComponents();
            this.studentId = courseDetails[0];
            this.studentName = courseDetails[1];
            this.studentSemester = courseDetails[2];
            this.studentCourse = courseDetails[3];
            this.studentEmail = courseDetails[4];

            result = Account.getSpecificDetails(Integer.parseInt(studentId), ordinalToNumeric(studentSemester), "Student");

            int grades = 0;
            int performance = 0;
            int count = 0;

            while (result.next()) {

                this.studentNum = result.getString("ph_num");
                grades += result.getInt("grade");
                performance += result.getInt("overall");

                count++;

            }

            if (count != 0) {
                this.studentPercentage = grades / count;
                this.studentPerformance = performance / count;
            } else {
                this.studentPercentage = 0;
                this.studentPerformance = 0;
            }

            setDetails();
        } catch (SQLException ex) {
            Logger.getLogger(StudentReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void verifyOverallPer(int studentPercentage, int studentPerformance) {
        if (studentPercentage == 0 & studentPerformance == 0) {
            stdOverallPercentage.setText("Yet To Grade");
            stdOverallPerformance.setValue(0);

            return;
        }

        stdOverallPercentage.setText(studentPercentage + "%");
        stdOverallPerformance.setValue(studentPerformance);
    }

    private void verifyStatus(int studentPercentage) {

        if (studentPercentage == 0) {
            stdStatus.setText("Yet To Grade");
            stdDesc.setText("Yet To Grade");
        } else if (studentPercentage >= 40) {

            stdStatus.setText("Passed");
            stdDesc.setText("May Proceed to the next Semester");

        } else {
            stdStatus.setText("Failed");
            stdDesc.setText("Must Resit for the required modules");
        }

    }

    private int ordinalToNumeric(String sem) {
        String semStr = sem;
        String numericString = semStr.replaceAll("[^0-9]", "");
        int semester = Integer.parseInt(numericString);
        return semester;
    }

    private void setDetails() {
        studentIDField.setText(studentId);
        stdFullName.setText(studentName);
        stdEmail.setText(studentEmail);
        stdRole.setText("Student");
        stdNum.setText(studentNum);
        verifyOverallPer(studentPercentage, studentPerformance);
        int semester = ordinalToNumeric(studentSemester);
        stdSem.setText(HelperMethods.convertToOrdinal(semester));
        verifyLevelYear(semester);

        verifyStatus(studentPercentage);

        if (semester == 1) {
            stdOverallPercentage.setText("Yet to pass the first semester");
            stdOverallPerformance.setValue(0);
            stdStatus.setText("Yet to pass the first semester");
            stdDesc.setText("Yet to pass the first semester");

        }

    }

    private void verifyLevelYear(int sem) {
        if (sem <= 2) {
            stdYear.setText(String.valueOf(1));
            stdLevel.setText(String.valueOf(4));
        } else if (sem > 2 && sem <= 4) {
            stdYear.setText(String.valueOf(2));
            stdLevel.setText(String.valueOf(5));
        } else if (sem > 4 && sem <= 6) {
            stdYear.setText(String.valueOf(3));
            stdLevel.setText(String.valueOf(6));
        } else {
            stdYear.setText(String.valueOf("Final Year"));
            stdLevel.setText(String.valueOf("Final Level"));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        upperProfile = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        stdFullName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        stdEmail = new javax.swing.JLabel();
        stdNum = new javax.swing.JLabel();
        stdRole = new javax.swing.JLabel();
        studentIDField = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        stdOverallPercentage = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        stdOverallPerformance = new javax.swing.JProgressBar();
        jLabel13 = new javax.swing.JLabel();
        stdStatus = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        stdDesc = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        stdSem = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        stdYear = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        stdLevel = new javax.swing.JLabel();
        printReport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(250, 250, 250));

        upperProfile.setBackground(new java.awt.Color(250, 250, 250));
        upperProfile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 225, 225), 1, true));

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(98, 98, 98));
        jLabel3.setText("Email :");

        stdFullName.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        stdFullName.setForeground(new java.awt.Color(51, 51, 51));
        stdFullName.setText("Kenab Kushal K.C.");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(98, 98, 98));
        jLabel4.setText("Mobile :");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(98, 98, 98));
        jLabel5.setText("Role :");

        stdEmail.setForeground(new java.awt.Color(102, 102, 102));
        stdEmail.setText("kebab@heraldcollege.edu.np");

        stdNum.setForeground(new java.awt.Color(102, 102, 102));
        stdNum.setText("9841321674");

        stdRole.setForeground(new java.awt.Color(102, 102, 102));
        stdRole.setText("Student");

        studentIDField.setForeground(new java.awt.Color(102, 102, 102));
        studentIDField.setText("12");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(98, 98, 98));
        jLabel6.setText("ID :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(studentIDField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stdEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)))
                    .addComponent(stdFullName)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stdNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stdRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(stdFullName)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentIDField)
                    .addComponent(jLabel6))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(stdEmail))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(stdNum))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(stdRole)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setBackground(new java.awt.Color(250, 250, 250));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/kenab.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout upperProfileLayout = new javax.swing.GroupLayout(upperProfile);
        upperProfile.setLayout(upperProfileLayout);
        upperProfileLayout.setHorizontalGroup(
            upperProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(upperProfileLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        upperProfileLayout.setVerticalGroup(
            upperProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(upperProfileLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(upperProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(225, 225, 225), 1, true));

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Student Report");

        stdOverallPercentage.setForeground(new java.awt.Color(102, 102, 102));
        stdOverallPercentage.setText("89%");

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(98, 98, 98));
        jLabel10.setText("Overall Percentage :");

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(98, 98, 98));
        jLabel12.setText("Performance : ");

        stdOverallPerformance.setForeground(new java.awt.Color(109, 99, 255));

        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(98, 98, 98));
        jLabel13.setText("Status");

        stdStatus.setForeground(new java.awt.Color(102, 102, 102));
        stdStatus.setText("Passed");

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(98, 98, 98));
        jLabel15.setText("Description");

        stdDesc.setForeground(new java.awt.Color(102, 102, 102));
        stdDesc.setText("May proceed to further semester");

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(98, 98, 98));
        jLabel11.setText("Semester :");

        stdSem.setForeground(new java.awt.Color(102, 102, 102));
        stdSem.setText("2");

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(98, 98, 98));
        jLabel14.setText("Year :");

        stdYear.setForeground(new java.awt.Color(102, 102, 102));
        stdYear.setText("1");

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(98, 98, 98));
        jLabel16.setText("Level :");

        stdLevel.setForeground(new java.awt.Color(102, 102, 102));
        stdLevel.setText("1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(6, 6, 6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)))
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stdLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stdYear, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stdSem, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(stdDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stdStatus)
                        .addComponent(stdOverallPercentage)
                        .addComponent(stdOverallPerformance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(148, 148, 148))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(stdSem))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(stdYear))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(stdLevel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stdOverallPerformance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(stdOverallPercentage)
                            .addComponent(jLabel10))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(stdStatus))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(stdDesc))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        printReport.setBackground(new java.awt.Color(250, 250, 250));
        printReport.setForeground(new java.awt.Color(108, 99, 255));
        printReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/printer.png"))); // NOI18N
        printReport.setText("Print Report");
        printReport.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(108, 99, 255)));
        printReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        printReport.setIconTextGap(12);
        printReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printReportMouseClicked(evt);
            }
        });
        printReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(upperProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(printReport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(upperProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(printReport, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void printReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printReportMouseClicked

        JOptionPane.showMessageDialog(null, "Feature under construction.", "Print Result Slip", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_printReportMouseClicked

    private void printReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printReportActionPerformed

    }//GEN-LAST:event_printReportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton printReport;
    private javax.swing.JLabel stdDesc;
    private javax.swing.JLabel stdEmail;
    private javax.swing.JLabel stdFullName;
    private javax.swing.JLabel stdLevel;
    private javax.swing.JLabel stdNum;
    private javax.swing.JLabel stdOverallPercentage;
    private javax.swing.JProgressBar stdOverallPerformance;
    private javax.swing.JLabel stdRole;
    private javax.swing.JLabel stdSem;
    private javax.swing.JLabel stdStatus;
    private javax.swing.JLabel stdYear;
    private javax.swing.JLabel studentIDField;
    private javax.swing.JPanel upperProfile;
    // End of variables declaration//GEN-END:variables
}
