package Admin;

import cms.Backend.Account;
import static cms.Backend.HelperMethods.showConfirmationDialog;
import java.util.Map;
import javax.swing.JOptionPane;

public class AddModule extends javax.swing.JFrame {

    public AddModule() {

        initComponents();
        setCourse();

    }

    private static Map<Integer, String> coursesList;
    private static Map<Integer, String> teachers;

    private void setCourse() {

        coursesList = Account.getAllCourses();

        if (coursesList != null) {
            courseNameField.removeAllItems();
            for (String value : coursesList.values()) {

                courseNameField.addItem(value);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        quesNo2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        studentIdLabel = new javax.swing.JLabel();
        addModuleBtn = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        studentIdLabel1 = new javax.swing.JLabel();
        studentIdLabel2 = new javax.swing.JLabel();
        moduleNameField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        teacherField = new javax.swing.JComboBox<>();
        semesterField = new javax.swing.JSlider();
        moduleIDField = new javax.swing.JTextField();
        courseNameField = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        quesNo2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        quesNo2.setForeground(new java.awt.Color(51, 51, 51));
        quesNo2.setText("Module");

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Add Module Details");

        studentIdLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        studentIdLabel.setForeground(new java.awt.Color(102, 102, 102));
        studentIdLabel.setText("Module Name :");

        addModuleBtn.setBackground(new java.awt.Color(108, 99, 255));
        addModuleBtn.setForeground(new java.awt.Color(255, 255, 255));
        addModuleBtn.setText("Add Module");
        addModuleBtn.setBorder(null);
        addModuleBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addModuleBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addModuleBtnMouseClicked(evt);
            }
        });
        addModuleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addModuleBtnActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Course : ");

        studentIdLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        studentIdLabel1.setForeground(new java.awt.Color(102, 102, 102));
        studentIdLabel1.setText("Module ID :");

        studentIdLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        studentIdLabel2.setForeground(new java.awt.Color(102, 102, 102));
        studentIdLabel2.setText("Semester :");

        moduleNameField.setForeground(new java.awt.Color(102, 102, 102));

        jLabel21.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Teacher :");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/courseBig.png"))); // NOI18N

        teacherField.setForeground(new java.awt.Color(102, 102, 102));
        teacherField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please select a course" }));

        semesterField.setForeground(new java.awt.Color(108, 99, 255));
        semesterField.setMajorTickSpacing(1);
        semesterField.setMaximum(8);
        semesterField.setMinimum(1);
        semesterField.setPaintLabels(true);
        semesterField.setPaintTicks(true);
        semesterField.setSnapToTicks(true);
        semesterField.setValue(1);

        moduleIDField.setForeground(new java.awt.Color(102, 102, 102));

        courseNameField.setForeground(new java.awt.Color(102, 102, 102));
        courseNameField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a course", " " }));
        courseNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseNameFieldActionPerformed(evt);
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
                        .addComponent(addModuleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(studentIdLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(studentIdLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(studentIdLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(moduleNameField)
                                    .addComponent(teacherField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(semesterField, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                    .addComponent(moduleIDField)
                                    .addComponent(courseNameField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jSeparator4)
                            .addComponent(jSeparator3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quesNo2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(48, 48, 48))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(quesNo2)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel12))
                    .addComponent(jLabel1))
                .addGap(24, 24, 24)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentIdLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moduleIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moduleNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentIdLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(studentIdLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semesterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(addModuleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 private int findTeacherID(String name) {

        int foundKey = 0;
        for (Map.Entry<Integer, String> entry : teachers.entrySet()) {
            if (entry.getValue().equals(name)) {
                foundKey = entry.getKey();
                return foundKey;
            }
        }
        return foundKey;
    }

    private int findCourseID(String name) {

        int foundKey = 0;
        for (Map.Entry<Integer, String> entry : coursesList.entrySet()) {
            if (entry.getValue().equals(name)) {
                foundKey = entry.getKey();
                return foundKey;
            }
        }
        return foundKey;
    }
    private void addModuleBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addModuleBtnMouseClicked

        if (showConfirmationDialog("Do you want to add a new course? ")) {

            String teacherName = (String) teacherField.getSelectedItem();

            if (teacherName == null) {

                JOptionPane.showMessageDialog(null, "No teachers for the respective course. Please add a teacher first.", "Add Module", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            String moduleId = moduleIDField.getText();

            String moduleName = moduleNameField.getText();
            int sem = semesterField.getValue();
            String courseName = (String) courseNameField.getSelectedItem();
            int courseId = findCourseID(courseName);

            String selectedTeacherName = (String) teacherField.getSelectedItem();
            int teacherId = findTeacherID(selectedTeacherName);

            String credentials[] = {moduleId, moduleName};

            if (AdminValidation.validateDetails(credentials)) {

                int uploaded = AdminAccount.addModule(Integer.parseInt(moduleId), moduleName, sem, courseId, teacherId);
            }

        }
    }//GEN-LAST:event_addModuleBtnMouseClicked

    private void addModuleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addModuleBtnActionPerformed

    }//GEN-LAST:event_addModuleBtnActionPerformed

    private void courseNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseNameFieldActionPerformed

        String selectedOption = (String) courseNameField.getSelectedItem();

        teachers = Account.getTeacherNames(selectedOption);

        if (teachers != null) {
            teacherField.removeAllItems();
            for (String teachers : teachers.values()) {
                teacherField.addItem(teachers);
            }
        }

    }//GEN-LAST:event_courseNameFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addModuleBtn;
    private javax.swing.JComboBox<String> courseNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField moduleIDField;
    private javax.swing.JTextField moduleNameField;
    private javax.swing.JLabel quesNo2;
    private javax.swing.JSlider semesterField;
    private javax.swing.JLabel studentIdLabel;
    private javax.swing.JLabel studentIdLabel1;
    private javax.swing.JLabel studentIdLabel2;
    private javax.swing.JComboBox<String> teacherField;
    // End of variables declaration//GEN-END:variables
}
