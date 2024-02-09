/**
 *
 * @author kenabkc
 */
package Teacher;

import cms.Backend.Account;
import cms.Backend.HelperMethods;
import static cms.Backend.HelperMethods.showConfirmationDialog;
import cms.Backend.TeacherAccount;
import cms.Backend.Validation;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GradeStudent extends javax.swing.JFrame {

    private int id;
    private String name;
    private String course;
    private static int semester;
    private String email;
    private static ArrayList<String> modules;

    public GradeStudent(int id, String name, String semester, String course, String email) {

        initComponents();
        this.id = id;
        this.name = name;
        this.course = course;
        this.semester = Integer.parseInt(semester.substring(0, semester.length() - 2));
        this.email = email;

        setFields();
    }

    public static void setModules() {

        modules = Account.getModuleNames(semester);

        if (modules != null) {
            moduleName.removeAllItems();

            for (String mods : modules) {
                moduleName.addItem(mods);
            }
        }
    }

    private void setFields() {
        stdName.setText(name);
        setModules();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        quesNo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        stdName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        moduleName = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        stdPerformanceSlider = new javax.swing.JSlider();
        uploadGradeBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        percentage = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(108, 99, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        quesNo.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        quesNo.setForeground(new java.awt.Color(51, 51, 51));
        quesNo.setText("Grade Student");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/star.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Enter Grades and Feedback ");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Student Name :");

        stdName.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        stdName.setForeground(new java.awt.Color(51, 51, 51));
        stdName.setText("Kenab Kushal K.C.");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Module Name :");

        moduleName.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        moduleName.setForeground(new java.awt.Color(51, 51, 51));
        moduleName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Internet Software Architecture", "Fundamentals of Computing", "Concepts & Technologies of Artificial Intelligence", "Object Oriented Design & Programming", "Principle of Business", "Business Math" }));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Overall Performance :");

        stdPerformanceSlider.setMajorTickSpacing(10);

        uploadGradeBtn.setBackground(new java.awt.Color(108, 99, 255));
        uploadGradeBtn.setForeground(new java.awt.Color(255, 255, 255));
        uploadGradeBtn.setText("Upload Grade");
        uploadGradeBtn.setBorder(null);
        uploadGradeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadGradeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uploadGradeBtnMouseClicked(evt);
            }
        });
        uploadGradeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadGradeBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Percentage : ");

        percentage.setForeground(new java.awt.Color(204, 204, 204));
        percentage.setText("Enter Percentage");
        percentage.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                percentageFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                percentageFocusLost(evt);
            }
        });
        percentage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                percentageMouseClicked(evt);
            }
        });
        percentage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                percentageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(uploadGradeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(97, 97, 97)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(stdPerformanceSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(percentage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(moduleName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(stdName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(quesNo)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(48, 377, Short.MAX_VALUE)))))))
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(quesNo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(stdName))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(moduleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(percentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(stdPerformanceSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(uploadGradeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void uploadGradeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadGradeBtnMouseClicked

        if (showConfirmationDialog("Do you want to upload the grades? ")) {

            if (Validation.validatePercentageField(percentage.getText())) {

                int totalPercentage = Integer.parseInt(percentage.getText());
                String modName = (String) moduleName.getSelectedItem();

                int moduleId = Account.getModuleId(modName);

                int uploaded = TeacherAccount.uploadGrades(id, totalPercentage, stdPerformanceSlider.getValue(), moduleId);

                if (uploaded <= 0) {
                    JOptionPane.showMessageDialog(null, "Error uploading grades.", "Grade Students", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(null, "Successfully updated the grades.", "Grade Students", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }//GEN-LAST:event_uploadGradeBtnMouseClicked

    private void uploadGradeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadGradeBtnActionPerformed

    }//GEN-LAST:event_uploadGradeBtnActionPerformed

    private void percentageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_percentageActionPerformed

    }//GEN-LAST:event_percentageActionPerformed

    private void percentageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_percentageMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_percentageMouseClicked

    private void percentageFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_percentageFocusGained
        // TODO add your handling code here:
        HelperMethods.handleFocusGainedLost(percentage, "Enter Percentage", new Color(158, 160, 170), evt);
    }//GEN-LAST:event_percentageFocusGained

    private void percentageFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_percentageFocusLost
        // TODO add your handling code here:
        HelperMethods.handleFocusGainedLost(percentage, "Enter Percentage", new Color(158, 160, 170), evt);
    }//GEN-LAST:event_percentageFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            FlatLightLaf.setup();
        } catch (Exception e) {
            System.out.println("Error in Flatlaf: " + e);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private static javax.swing.JComboBox<String> moduleName;
    private javax.swing.JTextField percentage;
    private javax.swing.JLabel quesNo;
    private javax.swing.JLabel stdName;
    private javax.swing.JSlider stdPerformanceSlider;
    private javax.swing.JButton uploadGradeBtn;
    // End of variables declaration//GEN-END:variables
}
