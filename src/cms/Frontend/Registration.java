/**
 * @author kenabkc
 */
package cms.Frontend;

import cms.Backend.Account;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import cms.Backend.Validation;
import java.util.ArrayList;

public class Registration extends javax.swing.JFrame {

    /*
     * Initializing the GUI Components through constructor.
     */
    ArrayList<String> coursesList;

    public Registration() {
        initComponents();

        setCourse();
    }

    private void setCourse() {
        courseSelection.setVisible(false);

        coursesList = Account.getCourses();

        if (coursesList != null) {
            courseType.removeAllItems();

            for (String mods : coursesList) {

                courseType.addItem(mods);
            }
        }

    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        registerUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        registerBtn = new javax.swing.JButton();
        backToLogin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        registerEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        registerPass = new javax.swing.JPasswordField();
        registerPh = new javax.swing.JTextField();
        registerRepass = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        registerUsertype = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        registerFname = new javax.swing.JTextField();
        registerLname = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        courseSelection = new javax.swing.JPanel();
        courseType = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CMS - Registration");
        setBackground(new java.awt.Color(108, 99, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Username");

        registerUsername.setPreferredSize(new java.awt.Dimension(64, 24));
        registerUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                registerUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                registerUsernameFocusLost(evt);
            }
        });
        registerUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerUsernameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Register Account");

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Please enter details to register.");

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Email");

        registerBtn.setBackground(new java.awt.Color(108, 99, 255));
        registerBtn.setForeground(new java.awt.Color(255, 255, 255));
        registerBtn.setText("Register");
        registerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        backToLogin.setForeground(new java.awt.Color(108, 99, 255));
        backToLogin.setText("Back to Login");
        backToLogin.setToolTipText("");
        backToLogin.setBorderPainted(false);
        backToLogin.setContentAreaFilled(false);
        backToLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backToLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backToLogin.setMargin(new java.awt.Insets(2, 0, 2, 0));
        backToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToLoginActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Phone Number");

        registerEmail.setPreferredSize(new java.awt.Dimension(64, 24));
        registerEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                registerEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                registerEmailFocusLost(evt);
            }
        });
        registerEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerEmailActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Password");

        registerPass.setPreferredSize(new java.awt.Dimension(64, 24));
        registerPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPassActionPerformed(evt);
            }
        });

        registerPh.setPreferredSize(new java.awt.Dimension(64, 24));
        registerPh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                registerPhFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                registerPhFocusLost(evt);
            }
        });
        registerPh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerPhActionPerformed(evt);
            }
        });

        registerRepass.setPreferredSize(new java.awt.Dimension(64, 24));
        registerRepass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerRepassActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Re-enter Password");

        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Select User Type");

        registerUsertype.setForeground(new java.awt.Color(51, 51, 51));
        registerUsertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select User Type", "Student", "Teacher", "Admin" }));
        registerUsertype.setPreferredSize(new java.awt.Dimension(72, 24));
        registerUsertype.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                registerUsertypeMousePressed(evt);
            }
        });
        registerUsertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerUsertypeActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/registerIcon.png"))); // NOI18N

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/usernameIcon.png"))); // NOI18N

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/passIcon.png"))); // NOI18N
        jLabel11.setMaximumSize(new java.awt.Dimension(24, 24));
        jLabel11.setMinimumSize(new java.awt.Dimension(24, 24));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/passIcon.png"))); // NOI18N
        jLabel12.setMaximumSize(new java.awt.Dimension(24, 24));
        jLabel12.setMinimumSize(new java.awt.Dimension(24, 24));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/phoneIcon.png"))); // NOI18N
        jLabel13.setMaximumSize(new java.awt.Dimension(24, 24));
        jLabel13.setMinimumSize(new java.awt.Dimension(24, 24));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/mailIcon.png"))); // NOI18N
        jLabel14.setMaximumSize(new java.awt.Dimension(24, 24));
        jLabel14.setMinimumSize(new java.awt.Dimension(24, 24));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/usertypeIcon.png"))); // NOI18N
        jLabel15.setMaximumSize(new java.awt.Dimension(24, 24));
        jLabel15.setMinimumSize(new java.awt.Dimension(24, 24));

        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("First Name");

        registerFname.setPreferredSize(new java.awt.Dimension(64, 24));
        registerFname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                registerFnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                registerFnameFocusLost(evt);
            }
        });
        registerFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerFnameActionPerformed(evt);
            }
        });
        registerFname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                registerFnameKeyTyped(evt);
            }
        });

        registerLname.setPreferredSize(new java.awt.Dimension(64, 24));
        registerLname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                registerLnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                registerLnameFocusLost(evt);
            }
        });
        registerLname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerLnameActionPerformed(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Last Name");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/userIcon.png"))); // NOI18N

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/userIcon.png"))); // NOI18N

        courseType.setForeground(new java.awt.Color(51, 51, 51));
        courseType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BIT", "BIBM" }));
        courseType.setPreferredSize(new java.awt.Dimension(72, 24));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/course.png"))); // NOI18N
        jLabel21.setMaximumSize(new java.awt.Dimension(24, 24));
        jLabel21.setMinimumSize(new java.awt.Dimension(24, 24));

        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("Select Course");

        javax.swing.GroupLayout courseSelectionLayout = new javax.swing.GroupLayout(courseSelection);
        courseSelection.setLayout(courseSelectionLayout);
        courseSelectionLayout.setHorizontalGroup(
            courseSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(courseSelectionLayout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel20)
                .addContainerGap(145, Short.MAX_VALUE))
            .addComponent(courseType, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        courseSelectionLayout.setVerticalGroup(
            courseSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(courseSelectionLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(courseSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(courseType, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(courseSelection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel8))
                    .addComponent(registerRepass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel7))
                    .addComponent(registerPass, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addComponent(registerUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(backToLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registerEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registerPh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registerUsertype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registerLname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registerFname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel9)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addGap(8, 8, 8)
                .addComponent(registerFname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19))
                .addGap(8, 8, 8)
                .addComponent(registerLname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1))
                .addGap(8, 8, 8)
                .addComponent(registerUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(8, 8, 8)
                .addComponent(registerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(8, 8, 8)
                .addComponent(registerPh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(8, 8, 8)
                .addComponent(registerPass, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(registerRepass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(registerUsertype, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(courseSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(backToLogin)
                .addGap(50, 50, 50))
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

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed

        try {

            String fName = registerFname.getText();
            String lName = registerLname.getText();
            String username = registerUsername.getText();
            String email = registerEmail.getText();
            String phNumber = registerPh.getText();
            String password = registerPass.getText();
            String rePass = registerRepass.getText();
            String usertype = registerUsertype.getSelectedItem().toString();
            String course = courseType.getSelectedItem().toString();

            String[] credentials = {fName, lName, username, email, phNumber, password, rePass, usertype, course};
            String[] credentialStr = {"First Name", "Last Name", "Username", "Email", "Phone Number", "Password", "Re-enter Password"};

            Icon erIcon = new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/errorIcon.png"));
            Icon icon = new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/checkIcon.png"));

            boolean notEmpty = Validation.validateIfEmpty(credentials);

            if (notEmpty) {

                boolean detailsValidated = Validation.validateDetails(fName, lName, username, phNumber, email, password, rePass, usertype);

                if (detailsValidated) {

                    Account.registerAccount(credentials);
                    JOptionPane.showMessageDialog(null, "Account created successfully.", "Register Account", JOptionPane.INFORMATION_MESSAGE, icon);

                } else {
                    JOptionPane.showMessageDialog(null, "Failed to create an account.", "Register Account", JOptionPane.INFORMATION_MESSAGE, erIcon);
                }

            } else {
                for (int i = 0; i < credentials.length; i++) {
                    if (credentials[i].isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Field: " + credentialStr[i] + " is missing. Please fill the form completely.", "Registration Error", JOptionPane.INFORMATION_MESSAGE, erIcon);
                        break;
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error in Registration File : " + e);
        }
    }//GEN-LAST:event_registerBtnActionPerformed
    /*
     * This function gets called when clicked on 'Back to Login' button.
     * It will dispose the current GUI.
     * Then, goes back to the login form.
     */
    private void backToLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToLoginActionPerformed

        dispose();
        new Login().setVisible(true);

    }//GEN-LAST:event_backToLoginActionPerformed

    private void registerUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerUsernameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_registerUsernameFocusGained

    private void registerUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerUsernameActionPerformed

    private void registerUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerUsernameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_registerUsernameFocusLost

    private void registerEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerEmailFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_registerEmailFocusGained

    private void registerEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerEmailFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_registerEmailFocusLost

    private void registerEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerEmailActionPerformed

    private void registerPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPassActionPerformed

    private void registerPhFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerPhFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPhFocusGained

    private void registerPhFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerPhFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPhFocusLost

    private void registerPhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerPhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerPhActionPerformed

    private void registerRepassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerRepassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerRepassActionPerformed

    private void registerFnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerFnameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_registerFnameFocusGained

    private void registerFnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerFnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_registerFnameFocusLost

    private void registerFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerFnameActionPerformed

    private void registerLnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerLnameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_registerLnameFocusGained

    private void registerLnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_registerLnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_registerLnameFocusLost

    private void registerLnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerLnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerLnameActionPerformed

    private void registerFnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registerFnameKeyTyped

    }//GEN-LAST:event_registerFnameKeyTyped

    private void registerUsertypeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerUsertypeMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerUsertypeMousePressed

    private void registerUsertypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerUsertypeActionPerformed
        // TODO add your handling code here:
        if (registerUsertype.getSelectedItem().equals("Admin")) {
            courseSelection.setVisible(false);
        } else {
            courseSelection.setVisible(true);
        }
    }//GEN-LAST:event_registerUsertypeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToLogin;
    private javax.swing.JPanel courseSelection;
    private javax.swing.JComboBox<String> courseType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField registerEmail;
    private javax.swing.JTextField registerFname;
    private javax.swing.JTextField registerLname;
    private javax.swing.JPasswordField registerPass;
    private javax.swing.JTextField registerPh;
    private javax.swing.JPasswordField registerRepass;
    private javax.swing.JTextField registerUsername;
    private javax.swing.JComboBox<String> registerUsertype;
    // End of variables declaration//GEN-END:variables
}
