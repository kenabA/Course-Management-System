/**
 *
 * @author kenabkc
 */
package Admin;

import cms.Backend.Account;
import static cms.Backend.HelperMethods.showConfirmationDialog;

public class EditTeacher extends javax.swing.JFrame {

    String teacherId, teacherName, course, modulesCount, teacherEmail;

    public EditTeacher(String[] courseDetails) {
        initComponents();
        this.teacherId = courseDetails[0];
        this.teacherName = courseDetails[1];
        this.course = courseDetails[2];
        this.modulesCount = courseDetails[3];
        this.teacherEmail = courseDetails[4];

        setDetails();
    }

    private void setDetails() {
        teacherIdField.setText(teacherId);
        String names[] = Account.extractFLName(Integer.parseInt(teacherId), "Teacher");
        teacherFNameField.setText(names[0]);
        teacherLNameField.setText(names[1]);
        teacherCourseField.setText(course);

        teacherEmailField.setText(teacherEmail);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        quesNo2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        studentIdLabel = new javax.swing.JLabel();
        studentSemesterLabel = new javax.swing.JLabel();
        updateDetailsBtn = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        studentIdLabel1 = new javax.swing.JLabel();
        teacherIdField = new javax.swing.JLabel();
        studentIdLabel2 = new javax.swing.JLabel();
        teacherLNameField = new javax.swing.JTextField();
        teacherFNameField = new javax.swing.JTextField();
        teacherCourseField = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        teacherEmailField = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        viewModulesBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        quesNo2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        quesNo2.setForeground(new java.awt.Color(51, 51, 51));
        quesNo2.setText("Teacher");

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Edit Teacher's Details");

        studentIdLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        studentIdLabel.setForeground(new java.awt.Color(102, 102, 102));
        studentIdLabel.setText("First Name : ");

        studentSemesterLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        studentSemesterLabel.setForeground(new java.awt.Color(102, 102, 102));
        studentSemesterLabel.setText("Modules");

        updateDetailsBtn.setBackground(new java.awt.Color(108, 99, 255));
        updateDetailsBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateDetailsBtn.setText("Update Details");
        updateDetailsBtn.setBorder(null);
        updateDetailsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateDetailsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateDetailsBtnMouseClicked(evt);
            }
        });
        updateDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDetailsBtnActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Course : ");

        studentIdLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        studentIdLabel1.setForeground(new java.awt.Color(102, 102, 102));
        studentIdLabel1.setText("ID :");

        teacherIdField.setForeground(new java.awt.Color(102, 102, 102));
        teacherIdField.setText("12");

        studentIdLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        studentIdLabel2.setForeground(new java.awt.Color(102, 102, 102));
        studentIdLabel2.setText("Last Name :");

        teacherLNameField.setForeground(new java.awt.Color(102, 102, 102));

        teacherFNameField.setForeground(new java.awt.Color(102, 102, 102));

        teacherCourseField.setForeground(new java.awt.Color(102, 102, 102));
        teacherCourseField.setText("BIT");

        jLabel21.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Email : ");

        teacherEmailField.setForeground(new java.awt.Color(102, 102, 102));
        teacherEmailField.setText("kebab.bahadur@gmail.com");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/teacher.png"))); // NOI18N

        viewModulesBtn.setForeground(new java.awt.Color(108, 99, 255));
        viewModulesBtn.setText("View Modules");
        viewModulesBtn.setBorder(null);
        viewModulesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewModulesBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateDetailsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator4)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(quesNo2)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(studentSemesterLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(studentIdLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(studentIdLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(studentIdLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(48, 48, 48)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(teacherFNameField)
                                            .addComponent(teacherLNameField)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(teacherEmailField)
                                                    .addComponent(teacherIdField)
                                                    .addComponent(teacherCourseField)
                                                    .addComponent(viewModulesBtn))
                                                .addGap(97, 97, 97)))))
                                .addGap(0, 0, 0)))))
                .addGap(48, 48, 48))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(quesNo2)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel12)))
                .addGap(24, 24, 24)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentIdLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(teacherFNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(studentIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(teacherLNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(studentIdLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentSemesterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewModulesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherCourseField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(updateDetailsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateDetailsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateDetailsBtnMouseClicked

        if (showConfirmationDialog("Do you want to make changes to the existing data? ")) {

            String fName = teacherFNameField.getText();
            String lName = teacherLNameField.getText();

            String credentials[] = {fName, lName};

            if (AdminValidation.validateDetails(credentials)) {

                int uploaded = AdminAccount.editTeacher(fName, lName, Integer.parseInt(teacherId));

            }
        }
    }//GEN-LAST:event_updateDetailsBtnMouseClicked

    private void updateDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDetailsBtnActionPerformed

    }//GEN-LAST:event_updateDetailsBtnActionPerformed
    ViewModules vm;
    private void viewModulesBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewModulesBtnMouseClicked
        vm = new ViewModules(Integer.parseInt(teacherId));
        vm.setVisible(true);
    }//GEN-LAST:event_viewModulesBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel quesNo2;
    private javax.swing.JLabel studentIdLabel;
    private javax.swing.JLabel studentIdLabel1;
    private javax.swing.JLabel studentIdLabel2;
    private javax.swing.JLabel studentSemesterLabel;
    private javax.swing.JLabel teacherCourseField;
    private javax.swing.JLabel teacherEmailField;
    private javax.swing.JTextField teacherFNameField;
    private javax.swing.JLabel teacherIdField;
    private javax.swing.JTextField teacherLNameField;
    private javax.swing.JButton updateDetailsBtn;
    private javax.swing.JButton viewModulesBtn;
    // End of variables declaration//GEN-END:variables
}
