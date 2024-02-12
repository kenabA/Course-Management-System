/**
 *
 * @author kenabkc
 */
package Admin;

import Backend.AdminValidation;
import Backend.AdminAccount;
import static Backend.HelperMethods.showConfirmationDialog;
import javax.swing.JOptionPane;

public class EditCourse extends javax.swing.JFrame {

    String courseId, courseName, courseCode;

    public EditCourse(String courseDetails[]) {
        initComponents();
        this.courseId = courseDetails[0];
        this.courseName = courseDetails[1];
        this.courseCode = courseDetails[2];

        setDetails();
    }

    private void setDetails() {
        existingCourseId.setText(courseId);
        existingCourseTitle.setText(courseName);
        existingCourseCode.setText(courseCode);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        quesNo3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        updateCourseBtn = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        existingCourseCode = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        existingCourseId = new javax.swing.JTextField();
        existingCourseTitle = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(250, 250, 250));

        quesNo3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        quesNo3.setForeground(new java.awt.Color(51, 51, 51));
        quesNo3.setText("Course");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/courseBig.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Edit Course");

        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Course ID : ");

        jLabel19.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Course Title : ");

        updateCourseBtn.setBackground(new java.awt.Color(108, 99, 255));
        updateCourseBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateCourseBtn.setText("Update Course");
        updateCourseBtn.setBorder(null);
        updateCourseBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateCourseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateCourseBtnMouseClicked(evt);
            }
        });
        updateCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCourseBtnActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Course Code : ");

        existingCourseCode.setForeground(new java.awt.Color(51, 51, 51));
        existingCourseCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                existingCourseCodeActionPerformed(evt);
            }
        });

        existingCourseId.setForeground(new java.awt.Color(51, 51, 51));
        existingCourseId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                existingCourseIdActionPerformed(evt);
            }
        });

        existingCourseTitle.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateCourseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(97, 97, 97)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(existingCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(existingCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(existingCourseTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quesNo3))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(48, 48, 48))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(quesNo3)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel17))
                    .addComponent(jLabel16))
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(existingCourseId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(existingCourseTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(existingCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(updateCourseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 763, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateCourseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateCourseBtnMouseClicked

        if (showConfirmationDialog("Do you want to make changes to your current selected course? ")) {

            String tempCourseId = existingCourseId.getText();
            String courseName = existingCourseTitle.getText();
            String courseCode = existingCourseCode.getText();

            String credentials[] = {tempCourseId, courseName, courseCode};

            if (AdminValidation.validateDetails(credentials)) {
                int courseID;
                try {
                    courseID = Integer.parseInt(existingCourseId.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, e, "Add Course", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                int updated = AdminAccount.editCourse(String.valueOf(courseID), courseName, courseCode, Integer.parseInt(courseId));

                if (updated <= 0) {
                    return;
                }

            }
        }
    }//GEN-LAST:event_updateCourseBtnMouseClicked

    private void updateCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateCourseBtnActionPerformed

    }//GEN-LAST:event_updateCourseBtnActionPerformed

    private void existingCourseCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_existingCourseCodeActionPerformed

    }//GEN-LAST:event_existingCourseCodeActionPerformed

    private void existingCourseIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_existingCourseIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_existingCourseIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField existingCourseCode;
    private javax.swing.JTextField existingCourseId;
    private javax.swing.JTextField existingCourseTitle;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel quesNo3;
    private javax.swing.JButton updateCourseBtn;
    // End of variables declaration//GEN-END:variables
}
