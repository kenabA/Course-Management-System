/**
 *
 * @author kenabkc
 */
package Frontend;

import Backend.Account;
import javax.swing.Icon;

import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    private Account a;
    private String username;
    private String password;

    private Object usertype;


    /*
     * Initializing the GUI Components through constructor.
     */
    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        loginUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        registerNow = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        loginUsertype = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        loginPassword = new javax.swing.JPasswordField();
        eyeBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CMS - Login");
        setBackground(new java.awt.Color(108, 99, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Username");

        loginUsername.setPreferredSize(new java.awt.Dimension(64, 24));
        loginUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                loginUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                loginUsernameFocusLost(evt);
            }
        });
        loginUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginUsernameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Welcome Back!");

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Please log into your account.");

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Password");

        loginBtn.setBackground(new java.awt.Color(108, 99, 255));
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setText("Login");
        loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Don't have an account?");

        registerNow.setForeground(new java.awt.Color(108, 99, 255));
        registerNow.setText("Register Now.");
        registerNow.setToolTipText("");
        registerNow.setBorderPainted(false);
        registerNow.setContentAreaFilled(false);
        registerNow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerNow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        registerNow.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        registerNow.setMargin(new java.awt.Insets(2, 0, 2, 0));
        registerNow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerNowMouseClicked(evt);
            }
        });
        registerNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerNowActionPerformed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/schoolIcon.png"))); // NOI18N

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/userIcon.png"))); // NOI18N

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/passIcon.png"))); // NOI18N
        jLabel9.setMaximumSize(new java.awt.Dimension(24, 24));
        jLabel9.setMinimumSize(new java.awt.Dimension(24, 24));

        loginUsertype.setForeground(new java.awt.Color(51, 51, 51));
        loginUsertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Teacher", "Admin" }));
        loginUsertype.setPreferredSize(new java.awt.Dimension(72, 24));

        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Select User Type");

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/usertypeIcon.png"))); // NOI18N
        jLabel15.setMaximumSize(new java.awt.Dimension(24, 24));
        jLabel15.setMinimumSize(new java.awt.Dimension(24, 24));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        loginPassword.setBorder(null);
        loginPassword.setPreferredSize(new java.awt.Dimension(64, 24));
        loginPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginPasswordActionPerformed(evt);
            }
        });

        eyeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/eye.png"))); // NOI18N
        eyeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eyeBtnMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eyeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eyeBtn))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginUsertype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(registerNow))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel8)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1))
                .addGap(8, 8, 8)
                .addComponent(loginUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(loginUsertype, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(registerNow)
                    .addComponent(jLabel5))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginPasswordActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed

        try {

            username = loginUsername.getText();
            password = loginPassword.getText();

            usertype = loginUsertype.getSelectedItem();

            Icon erIcon = new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/errorIcon.png"));

            if (!username.isEmpty() && !password.isEmpty()) {
                a = new Account();
                boolean logged = a.loginAccount(usertype, username, password);

                if (logged) {
                    dispose();
                }

            } else {

                String[] credentials = {username, password};
                String[] credentialStr = {"Username", "Password"};
                for (int i = 0; i < credentials.length; i++) {
                    if (credentials[i].isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field: " + credentialStr[i] + " is missing. Please fill the form completely.", "Registration Error", JOptionPane.INFORMATION_MESSAGE, erIcon);
                        break;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error in Login file: " + e);
        }
    }//GEN-LAST:event_loginBtnActionPerformed
    /*
     * This function gets called when clicked on 'Register Now' button.
     * It will dispose the current GUI.
     * Then, opens up a registration form.
     */
    private void registerNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerNowActionPerformed

        dispose();
        new Registration().setVisible(true);

    }//GEN-LAST:event_registerNowActionPerformed

    private void loginUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginUsernameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUsernameFocusGained

    private void loginUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUsernameActionPerformed

    private void loginUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginUsernameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUsernameFocusLost

    private void registerNowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerNowMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_registerNowMouseClicked

    private void eyeBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyeBtnMousePressed
        char echoChar = loginPassword.getEchoChar();
        boolean checkEcho = (echoChar == (char) 0);
        if (checkEcho) {
            loginPassword.setEchoChar('•');
        } else {
            loginPassword.setEchoChar((char) 0);
        }

    }//GEN-LAST:event_eyeBtnMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel eyeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField loginPassword;
    private javax.swing.JTextField loginUsername;
    private javax.swing.JComboBox<String> loginUsertype;
    private javax.swing.JButton registerNow;
    // End of variables declaration//GEN-END:variables
}
