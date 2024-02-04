/**
 *
 * @author kenabkc
 */
package cms.Frontend.Student;

import cms.Backend.Account;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class Answer extends javax.swing.JFrame {

    Icon erIcon = new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/errorIcon.png"));
    Icon icon = new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/checkIcon.png"));

    private final int qid;
    private final int id;
    private final StudentPanel sp;

    public Answer(int qid, int id, StudentPanel sp) {
        this.qid = qid;
        this.id = id;
        this.sp = sp;
        initComponents();

    }

//submitAnsBtn1
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        answerField = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        submitAnsBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(250, 250, 250));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Question Number 1");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("What is the process of this called?");

        answerField.setColumns(20);
        answerField.setRows(5);
        jScrollPane1.setViewportView(answerField);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/question.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Your Answer :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addContainerGap(542, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitAnsBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(submitAnsBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private boolean submitAssignment() {
        String answer = answerField.getText();
        int rowsCount = Account.submitAssignment(qid, id, answer);
        if (rowsCount != 0) {
            JOptionPane.showMessageDialog(null, "Successfully submitted the assignment.", "Submit Assignment", JOptionPane.INFORMATION_MESSAGE, icon);
            dispose();
            sp.setButtonState(false);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Assignment not submitted.", "Submit Assignment", JOptionPane.INFORMATION_MESSAGE, erIcon);
            return false;
        }
    }

    private void submitAnsBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitAnsBtn1MouseClicked
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submitAnsBtn1;
    // End of variables declaration//GEN-END:variables
}
