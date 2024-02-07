/**
 *
 * @author kenabkc
 */
package cms.Frontend.Student;

import cms.Backend.Account;
import cms.Backend.StudentAccount;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class Answer extends javax.swing.JFrame {

    Icon erIcon = new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/errorIcon.png"));
    Icon icon = new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/checkIcon.png"));

    private final int qid;
    private final int id;
    private final StudentPanel sp;
    private final int btn;

    public Answer(int qid, int id, int btn, StudentPanel sp) {
        // All the variables get initialized
        this.qid = qid;
        this.id = id;
        this.btn = btn;
        this.sp = sp;

        initComponents();

        setDetails();

    }

    private void setDetails() {
        quesNo.setText("Question Number " + this.qid);
        String questionName = Account.getQuesName(qid);
        quesName.setText(questionName);

        quesName.setEditable(false);
    }

//submitAnsBtn1
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        quesNo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        answerField = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        quesName = new javax.swing.JTextArea();
        submitAnsBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(108, 99, 255));
        setResizable(false);

        quesNo.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        quesNo.setForeground(new java.awt.Color(51, 51, 51));
        quesNo.setText("Question Number 1");

        answerField.setColumns(20);
        answerField.setRows(5);
        jScrollPane1.setViewportView(answerField);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/question.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Your Answer :");

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        quesName.setBackground(new java.awt.Color(242, 242, 242));
        quesName.setColumns(20);
        quesName.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        quesName.setForeground(new java.awt.Color(102, 102, 102));
        quesName.setLineWrap(true);
        quesName.setRows(5);
        quesName.setText("What is the name of the what? ");
        quesName.setBorder(null);
        jScrollPane2.setViewportView(quesName);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(quesNo))
                        .addContainerGap(545, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(quesNo)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        submitAnsBtn1.setBackground(new java.awt.Color(108, 99, 255));
        submitAnsBtn1.setForeground(new java.awt.Color(255, 255, 255));
        submitAnsBtn1.setText("Submit");
        submitAnsBtn1.setBorder(null);
        submitAnsBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitAnsBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitAnsBtn1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(submitAnsBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(submitAnsBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitAssignment() {

        // It first gets what the user has written 
        String answer = answerField.getText();

        // Cannot send an empty assignment, can you ? 
        if (answer.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Empty Assignment can't be submitted.", "Submit Assignment", JOptionPane.INFORMATION_MESSAGE, erIcon);
            return;
        }

        // If not empty, we submit it from Account class from backend.
        int rowsCount = StudentAccount.submitAssignment(this.qid, answer);

        // If rows count is not 0, 
        if (rowsCount != 0) {
            JOptionPane.showMessageDialog(null, "Successfully submitted the assignment.", "Submit Assignment", JOptionPane.INFORMATION_MESSAGE, icon);
            dispose();
            // Now checks which button to disclose and remove the action listerner from.
            if (btn == 1) {
                sp.setButtonState(false);
            }
            if (btn == 2) {
                sp.setButtonState2(false);
            }
            if (btn == 3) {
                sp.setButtonState3(false);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Assignment not submitted.", "Submit Assignment", JOptionPane.INFORMATION_MESSAGE, erIcon);

        }
    }

    private void submitAnsBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitAnsBtn1MouseClicked
        // If again the submit assignment is clicked, 
        submitAssignment();
    }//GEN-LAST:event_submitAnsBtn1MouseClicked

    public static void main(String args[]) {

        try {
            FlatLightLaf.setup();
        } catch (Exception e) {
            System.out.println("Error in Flatlaf: " + e);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea answerField;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea quesName;
    private javax.swing.JLabel quesNo;
    private javax.swing.JButton submitAnsBtn1;
    // End of variables declaration//GEN-END:variables
}
