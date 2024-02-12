/**
 *
 * @author kenabkc
 */
package Admin;

import Backend.AdminAccount;
import Backend.HelperMethods;
import static Backend.HelperMethods.alignTableContents;
import static Backend.HelperMethods.setTableAppearance;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewInactiveCourse extends javax.swing.JFrame {

    DefaultTableModel model;

    public ViewInactiveCourse() {
        initComponents();
        setDetails();
    }

    private void setDetails() {

        this.model = (DefaultTableModel) inactiveCourseTable.getModel();
        AdminAccount.inactiveCourseTable(model);
        alignTableContents(inactiveCourseTable);
        setTableAppearance(inactiveCourseTable);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        quesNo2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tableScrollPanel = new javax.swing.JScrollPane();
        inactiveCourseTable = new javax.swing.JTable();
        releaseBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        refreshBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(250, 250, 250));
        setResizable(false);

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("View inactive courses");

        quesNo2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        quesNo2.setForeground(new java.awt.Color(51, 51, 51));
        quesNo2.setText("Inactive Courses");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/courseBig.png"))); // NOI18N

        tableScrollPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(241, 240, 255), null));
        tableScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        inactiveCourseTable.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        inactiveCourseTable.setForeground(new java.awt.Color(51, 51, 51));
        inactiveCourseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course ID", "Course Title", "Course Code", "Date Created"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        inactiveCourseTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        inactiveCourseTable.setGridColor(new java.awt.Color(238, 238, 238));
        inactiveCourseTable.setIgnoreRepaint(true);
        inactiveCourseTable.getTableHeader().setReorderingAllowed(false);
        tableScrollPanel.setViewportView(inactiveCourseTable);

        releaseBtn.setBackground(new java.awt.Color(250, 250, 250));
        releaseBtn.setForeground(new java.awt.Color(108, 99, 255));
        releaseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/shareBtn.png"))); // NOI18N
        releaseBtn.setText("Release Course");
        releaseBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 98, 255), 1, true));
        releaseBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        releaseBtn.setIconTextGap(0);
        releaseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                releaseBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                releaseBtnMouseEntered(evt);
            }
        });
        releaseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                releaseBtnActionPerformed(evt);
            }
        });

        refreshBtn.setBackground(new java.awt.Color(250, 250, 250));
        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/refresh.png"))); // NOI18N
        refreshBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 98, 255), 1, true));
        refreshBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(releaseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(quesNo2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(refreshBtn)
                            .addGap(13, 13, 13))
                        .addComponent(tableScrollPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(quesNo2)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel12))
                            .addComponent(refreshBtn))
                        .addGap(24, 24, 24)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(tableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(releaseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(568, 568, 568))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void releaseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_releaseBtnMouseClicked

        int selectedRow = inactiveCourseTable.getSelectedRow();

        if (selectedRow != -1) {
            if (HelperMethods.showConfirmationDialog("Do you want to release this course back to the main course? ")) {

                String id = (String) inactiveCourseTable.getValueAt(selectedRow, 0);
                AdminAccount.tempReleaseCourse(Integer.parseInt(id));

            }
        } else {
            JOptionPane.showMessageDialog(null, "No Rows Selected", "Release Course", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_releaseBtnMouseClicked

    private void releaseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_releaseBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_releaseBtnActionPerformed

    private void releaseBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_releaseBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_releaseBtnMouseEntered

    private void refreshBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshBtnMouseClicked
        model.setRowCount(0);
        AdminAccount.inactiveCourseTable(model);
    }//GEN-LAST:event_refreshBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable inactiveCourseTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel quesNo2;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton releaseBtn;
    private javax.swing.JScrollPane tableScrollPanel;
    // End of variables declaration//GEN-END:variables
}
