/**
 *
 * @author kenabkc
 */
package Admin;

import cms.Backend.Account;
import static cms.Backend.HelperMethods.showConfirmationDialog;

public class EditStudent extends javax.swing.JFrame {

    String studentId, studentName, studentSemester, studentCourse, studentEmail;

    public EditStudent(String[] courseDetails) {
        initComponents();
        this.studentId = courseDetails[0];
        this.studentName = courseDetails[1];
        this.studentSemester = courseDetails[2];
        this.studentCourse = courseDetails[3];
        this.studentEmail = courseDetails[4];

        setDetails();
    }

    private void setDetails() {
        studentIdField.setText(studentId);
        String names[] = Account.extractFLName(Integer.parseInt(studentId), "Student");
        studentFNameField.setText(names[0]);
        studentLNameField.setText(names[1]);
        studentSemesterField.setText(studentSemester);
        studentCourseField.setText(studentCourse);
        studentEmailField.setText(studentEmail);
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
        studentIdField = new javax.swing.JLabel();
        studentSemesterField = new javax.swing.JLabel();
        studentIdLabel2 = new javax.swing.JLabel();
        studentLNameField = new javax.swing.JTextField();
        studentFNameField = new javax.swing.JTextField();
        studentCourseField = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        studentEmailField = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Student Details");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));

        quesNo2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        quesNo2.setForeground(new java.awt.Color(51, 51, 51));
        quesNo2.setText("Student");

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Edit Student's Details");

        studentIdLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        studentIdLabel.setForeground(new java.awt.Color(102, 102, 102));
        studentIdLabel.setText("First Name : ");

        studentSemesterLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        studentSemesterLabel.setForeground(new java.awt.Color(102, 102, 102));
        studentSemesterLabel.setText("Semester :");

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

        studentIdField.setForeground(new java.awt.Color(102, 102, 102));
        studentIdField.setText("12");

        studentSemesterField.setForeground(new java.awt.Color(102, 102, 102));
        studentSemesterField.setText("2nd");

        studentIdLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        studentIdLabel2.setForeground(new java.awt.Color(102, 102, 102));
        studentIdLabel2.setText("Last Name :");

        studentLNameField.setForeground(new java.awt.Color(102, 102, 102));

        studentFNameField.setForeground(new java.awt.Color(102, 102, 102));

        studentCourseField.setForeground(new java.awt.Color(102, 102, 102));
        studentCourseField.setText("BIT");

        jLabel21.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Email : ");

        studentEmailField.setForeground(new java.awt.Color(102, 102, 102));
        studentEmailField.setText("kebab.bahadur@gmail.com");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateDetailsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quesNo2)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(studentIdLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(studentIdLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(studentSemesterLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(studentIdLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(studentEmailField)
                                            .addComponent(studentIdField)
                                            .addComponent(studentSemesterField)
                                            .addComponent(studentCourseField))
                                        .addGap(97, 97, 97))
                                    .addComponent(studentFNameField)
                                    .addComponent(studentLNameField))))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(quesNo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentIdLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(studentFNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(studentIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(studentLNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(studentIdLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentSemesterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentSemesterField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentCourseField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(updateDetailsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateDetailsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateDetailsBtnMouseClicked

        if (showConfirmationDialog("Do you want to make changes to the existing data? ")) {

            String fName = studentFNameField.getText();
            String lName = studentLNameField.getText();

            String credentials[] = {fName, lName};

            if (AdminValidation.validateDetails(credentials)) {

                int uploaded = AdminAccount.editStudent(fName, lName, Integer.parseInt(studentId));

                if (uploaded <= 0) {
                    return;
                }

                inputCourseID.setText("");
                inputCourseTitle.setText("");
                inputCourseCode.setText("");

            }
        }
    }//GEN-LAST:event_updateDetailsBtnMouseClicked

    private void updateDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDetailsBtnActionPerformed

    }//GEN-LAST:event_updateDetailsBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCourseBtn;
    private javax.swing.JButton addCourseBtn1;
    private javax.swing.JTextField existingCourseCode;
    private javax.swing.JTextField existingCourseId;
    private javax.swing.JTextField existingCourseTitle;
    private javax.swing.JTextField inputCourseCode;
    private javax.swing.JTextField inputCourseCode1;
    private javax.swing.JTextField inputCourseID;
    private javax.swing.JTextField inputCourseID1;
    private javax.swing.JTextField inputCourseTitle;
    private javax.swing.JTextField inputCourseTitle1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel quesNo;
    private javax.swing.JLabel quesNo1;
    private javax.swing.JLabel quesNo2;
    private javax.swing.JLabel quesNo3;
    private javax.swing.JLabel studentCourseField;
    private javax.swing.JLabel studentEmailField;
    private javax.swing.JTextField studentFNameField;
    private javax.swing.JLabel studentIdField;
    private javax.swing.JLabel studentIdLabel;
    private javax.swing.JLabel studentIdLabel1;
    private javax.swing.JLabel studentIdLabel2;
    private javax.swing.JTextField studentLNameField;
    private javax.swing.JLabel studentSemesterField;
    private javax.swing.JLabel studentSemesterLabel;
    private javax.swing.JButton updateCourseBtn;
    private javax.swing.JButton updateDetailsBtn;
    // End of variables declaration//GEN-END:variables
}
