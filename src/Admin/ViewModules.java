/**
 *
 * @author kenabkc
 */
package Admin;

import Backend.AdminAccount;
import static Backend.HelperMethods.alignTableContents;
import static Backend.HelperMethods.setTableAppearance;
import javax.swing.table.DefaultTableModel;

public class ViewModules extends javax.swing.JFrame {

    DefaultTableModel model;
    int id;

    public ViewModules(int id) {
        this.id = id;
        initComponents();
        setDetails();
    }

    private void setDetails() {

        this.model = (DefaultTableModel) viewTeachersModules.getModel();
        AdminAccount.modulesTable(model, id);
        alignTableContents(viewTeachersModules);
        setTableAppearance(viewTeachersModules);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableScrollPanel = new javax.swing.JScrollPane();
        viewTeachersModules = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        quesNo2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tableScrollPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(241, 240, 255), null));
        tableScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        viewTeachersModules.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        viewTeachersModules.setForeground(new java.awt.Color(51, 51, 51));
        viewTeachersModules.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Module ID", "Course", "Module Name", "Semester"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        viewTeachersModules.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        viewTeachersModules.setGridColor(new java.awt.Color(238, 238, 238));
        viewTeachersModules.setIgnoreRepaint(true);
        viewTeachersModules.getTableHeader().setReorderingAllowed(false);
        viewTeachersModules.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewTeachersModulesMouseClicked(evt);
            }
        });
        tableScrollPanel.setViewportView(viewTeachersModules);
        if (viewTeachersModules.getColumnModel().getColumnCount() > 0) {
            viewTeachersModules.getColumnModel().getColumn(0).setMinWidth(100);
            viewTeachersModules.getColumnModel().getColumn(0).setPreferredWidth(100);
            viewTeachersModules.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("View Module Details");

        quesNo2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        quesNo2.setForeground(new java.awt.Color(51, 51, 51));
        quesNo2.setText("Module");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/courseBig.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quesNo2)))
                    .addComponent(tableScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(quesNo2)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel12))
                    .addComponent(jLabel1))
                .addGap(24, 24, 24)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(tableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void viewTeachersModulesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewTeachersModulesMouseClicked

    }//GEN-LAST:event_viewTeachersModulesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel quesNo2;
    private javax.swing.JScrollPane tableScrollPanel;
    private javax.swing.JTable viewTeachersModules;
    // End of variables declaration//GEN-END:variables
}
