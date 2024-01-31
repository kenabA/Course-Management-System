/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package cms.Frontend.Button;

/**
 *
 * @author kenabkc
 */
public class PanelAction extends javax.swing.JPanel {

    public PanelAction() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        availableBtn = new cms.Frontend.Button.ActionButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        availableBtn.setBackground(new java.awt.Color(199, 235, 201));
        availableBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(199, 235, 201), 1, true));
        availableBtn.setForeground(new java.awt.Color(0, 100, 0));
        availableBtn.setText("View");
        availableBtn.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        availableBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                availableBtnMouseClicked(evt);
            }
        });
        availableBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(availableBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(availableBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void availableBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableBtnActionPerformed

    }//GEN-LAST:event_availableBtnActionPerformed

    private void availableBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availableBtnMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_availableBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cms.Frontend.Button.ActionButton availableBtn;
    // End of variables declaration//GEN-END:variables
}
