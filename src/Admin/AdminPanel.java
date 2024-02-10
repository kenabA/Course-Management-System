/**
 *
 * @author kenabkc
 */
package Admin;

import static Admin.AdminAccount.ec;
import Teacher.Assignment;
import Teacher.GradeStudent;
import cms.Backend.Account;
import cms.Backend.HelperMethods;
import static cms.Backend.HelperMethods.alignTableContents;
import static cms.Backend.HelperMethods.setTableAppearance;
import cms.Backend.Validation;
import cms.Frontend.Contents;
import cms.Frontend.EditProfile;
import cms.Frontend.Login;
import cms.Frontend.Person;
import cms.Frontend.Student.Answer;
import java.awt.Color;
import java.awt.Desktop;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class AdminPanel extends javax.swing.JFrame {

    EditProfile ep;
    AddCourse ac = new AddCourse();
    private Admin ad;
    private Answer a;
    private final Contents contents = new Contents();
    private Assignment assignment;
    GradeStudent gs;
    Person p;

    private static String username;
    private static int id;
    private static String password;
    private String fName;
    private String lName;
    private static String email;
    private static String phNum;
    private String course;
    private static String date;

    public final static String role = "Admin";

    private int courseId;
    private int studentsCount;
    private int moduleCount;
    private int teachersCount;
    private int courseCount;
    private String semester;

    private String announcement[][];
    private String questionDetails[][];

    private DefaultTableModel model;
    private DefaultTableModel model2;
    private DefaultTableModel model3;
    private DefaultTableModel model4;
    public int q1;

    public int q2;
    public int q3;

    public AdminPanel() {
        initComponents();
    }

    private void setValueChanged() {

        deleteCourseBtn.setVisible(false);
        coursesTable.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                if (coursesTable.getSelectedRow() != -1) {

                    deleteCourseBtn.setVisible(true);
                } else {

                    deleteCourseBtn.setVisible(false);
                }
            }
        });
    }

    public void updateDetails() {

        // Upating the activity when we log in
        Account.updateActivity("Login");

        // Updating the dashboard panel
        stdPanelName.setText(Person.getName());
        studentCount.setText(String.valueOf(this.studentsCount));
        teacherCount.setText(String.valueOf(this.teachersCount));
        coursesCount.setText(String.valueOf(this.courseCount));
        modulesCount.setText(String.valueOf(this.moduleCount));

        // Updating the activity table
        this.model = (DefaultTableModel) activityTable.getModel();
        AdminAccount.getActivityTableData(model);
        alignTableContents(activityTable);
        setTableAppearance(activityTable);

        // Updating the Profile Panel
        profileUsername.setText(username);
        profileEmail.setText(email);
        profilePassword.setText(password);
        profileConfirmPassword.setText(password);
        profilePhone.setText(phNum);

        // Update the courses panel
        this.model2 = (DefaultTableModel) coursesTable.getModel();
        AdminAccount.getCoursesData(model2);
        alignTableContents(coursesTable);
        setTableAppearance(coursesTable);

        // Updating the students panel
        this.model3 = (DefaultTableModel) studentsTable.getModel();
        AdminAccount.studentsTable(model3);
        alignTableContents(studentsTable);
        setTableAppearance(studentsTable);

        // Updating the teachers pane;
        this.model4 = (DefaultTableModel) teachersTable.getModel();
        AdminAccount.teachersTable(model4);
        alignTableContents(teachersTable);
        setTableAppearance(teachersTable);

    }

//    @Override
//    public void setContents() {
//        contents.setAnnouncement(announcement, this);
//        contents.setQuestionsDetails(questionDetails, this);
//
//    }
    public void extractDetails() {
        try {
            ResultSet result = Account.getUserData(AdminPanel.username);
            if (result.next()) {

                AdminPanel.id = result.getInt("id");
                fName = result.getString("f_name");
                lName = result.getString("l_name");
                AdminPanel.email = result.getString("email");
                AdminPanel.phNum = result.getString("ph_num");
                AdminPanel.password = result.getString("password");
                AdminPanel.date = result.getString("date_created");

                this.studentsCount = AdminAccount.getTotalStudentCount();
                this.teachersCount = AdminAccount.getTotalTeacherCount();
                this.moduleCount = AdminAccount.getModulesCount();
                this.courseCount = AdminAccount.getCoursesCount();

                this.p = new Person(this.fName, this.lName, id, this.course, role, this.courseId);

            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setName(String username) {
        AdminPanel.username = username;
        extractDetails();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tab1 = new javax.swing.JPanel();
        tabBtn1 = new javax.swing.JLabel();
        tab2 = new javax.swing.JPanel();
        tabBtn2 = new javax.swing.JLabel();
        tab3 = new javax.swing.JPanel();
        tabBtn3 = new javax.swing.JLabel();
        tab4 = new javax.swing.JPanel();
        tabBtn4 = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        tab5 = new javax.swing.JPanel();
        tabBtn5 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        stdPanelName = new javax.swing.JLabel();
        usertypeShow = new javax.swing.JLabel();
        tabName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        directEmail = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        mainBody = new javax.swing.JTabbedPane();
        panelFirst = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        coursesCount = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        studentCount = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        teacherCount = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        modulesCount = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tableScrollPanel1 = new javax.swing.JScrollPane();
        activityTable = new javax.swing.JTable();
        panelSecond = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        tableScrollPanel = new javax.swing.JScrollPane();
        coursesTable = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        searchCourses = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        deleteCourseBtn = new javax.swing.JButton();
        editCourseButton = new javax.swing.JButton();
        addCourse = new javax.swing.JButton();
        courseReloadBtn = new javax.swing.JButton();
        panelThird = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        tableScrollPanel2 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        searchStudents = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        studentAddBtn = new javax.swing.JButton();
        studentReloadBtn = new javax.swing.JButton();
        studentDeleteBtn = new javax.swing.JButton();
        studentEditBtn = new javax.swing.JButton();
        teachersTablePanel = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        tableScrollPanel3 = new javax.swing.JScrollPane();
        teachersTable = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        searchTeachers = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        teacherAddBtn = new javax.swing.JButton();
        teacherReloadBtn = new javax.swing.JButton();
        teacherDeleteBtn = new javax.swing.JButton();
        teacherEditBtn = new javax.swing.JButton();
        panelFifth = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        profileUsername = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        profilePassword = new javax.swing.JPasswordField();
        jPanel20 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        profilePhone = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        profileEmail = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        saveBtn = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        profileConfirmPassword = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(108, 99, 255));
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(245, 246, 250));
        mainPanel.setForeground(new java.awt.Color(108, 99, 255));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/schoolIconSmall.png"))); // NOI18N
        jLabel5.setText(" CMS");

        tab1.setBackground(new java.awt.Color(108, 99, 255));
        tab1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab1MouseClicked(evt);
            }
        });

        tabBtn1.setForeground(new java.awt.Color(255, 255, 255));
        tabBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tabBtn1.setText("Dashboard");

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(tabBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addComponent(tabBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        tab2.setBackground(new java.awt.Color(255, 255, 255));
        tab2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tab2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab2MouseClicked(evt);
            }
        });

        tabBtn2.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tabBtn2.setText("Courses");

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(tabBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tabBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tab3.setBackground(new java.awt.Color(255, 255, 255));
        tab3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tab3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab3MouseClicked(evt);
            }
        });

        tabBtn3.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tabBtn3.setText("Students");

        javax.swing.GroupLayout tab3Layout = new javax.swing.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(tabBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabBtn3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        tab4.setBackground(new java.awt.Color(255, 255, 255));
        tab4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tab4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab4MouseClicked(evt);
            }
        });

        tabBtn4.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tabBtn4.setText("Teachers");

        javax.swing.GroupLayout tab4Layout = new javax.swing.GroupLayout(tab4);
        tab4.setLayout(tab4Layout);
        tab4Layout.setHorizontalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(tabBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab4Layout.setVerticalGroup(
            tab4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabBtn4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        logoutBtn.setForeground(new java.awt.Color(108, 99, 255));
        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/logout.png"))); // NOI18N
        logoutBtn.setText(" Logout");
        logoutBtn.setToolTipText("Logout from the account.");
        logoutBtn.setBorderPainted(false);
        logoutBtn.setContentAreaFilled(false);
        logoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logoutBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        logoutBtn.setMargin(new java.awt.Insets(2, 0, 2, 0));
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBtnMouseClicked(evt);
            }
        });
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        tab5.setBackground(new java.awt.Color(255, 255, 255));
        tab5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tab5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab5MouseClicked(evt);
            }
        });

        tabBtn5.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn5.setText("Profile");

        javax.swing.GroupLayout tab5Layout = new javax.swing.GroupLayout(tab5);
        tab5.setLayout(tab5Layout);
        tab5Layout.setHorizontalGroup(
            tab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(tabBtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab5Layout.setVerticalGroup(
            tab5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabBtn5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(menuLayout.createSequentialGroup()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tab3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tab2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tab1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tab5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tab4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(tab1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tab5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        mainPanel.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 690));

        header.setBackground(new java.awt.Color(255, 255, 255));

        stdPanelName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        stdPanelName.setText("Kenab Kushal K.C.");

        usertypeShow.setForeground(new java.awt.Color(194, 196, 202));
        usertypeShow.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        usertypeShow.setText("Administrator");

        tabName.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        tabName.setText("Dashboard");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/whiteUser.png"))); // NOI18N

        directEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/mainMail.png"))); // NOI18N
        directEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        directEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                directEmailMouseClicked(evt);
            }
        });

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(tabName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 513, Short.MAX_VALUE)
                .addComponent(directEmail)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stdPanelName)
                    .addComponent(usertypeShow))
                .addGap(32, 32, 32))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabName, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator4)
                    .addComponent(directEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addComponent(stdPanelName)
                        .addGap(2, 2, 2)
                        .addComponent(usertypeShow))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        mainPanel.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 900, 70));

        jPanel9.setBackground(new java.awt.Color(250, 250, 250));

        jPanel8.setBackground(new java.awt.Color(241, 240, 255));

        jLabel1.setForeground(new java.awt.Color(158, 160, 170));
        jLabel1.setText("Courses");

        coursesCount.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        coursesCount.setText("BIT");

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/courseBig.png"))); // NOI18N
        jLabel21.setMaximumSize(new java.awt.Dimension(24, 24));
        jLabel21.setMinimumSize(new java.awt.Dimension(24, 24));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coursesCount)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(coursesCount)
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(241, 240, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel11.setForeground(new java.awt.Color(158, 160, 170));
        jLabel11.setText("Total Students");

        studentCount.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        studentCount.setText("32");

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/student.png"))); // NOI18N
        jLabel23.setMaximumSize(new java.awt.Dimension(24, 24));
        jLabel23.setMinimumSize(new java.awt.Dimension(24, 24));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentCount)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(studentCount)
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(241, 240, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel13.setForeground(new java.awt.Color(158, 160, 170));
        jLabel13.setText("Total Teachers");

        teacherCount.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        teacherCount.setText("9");

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/teacher.png"))); // NOI18N
        jLabel24.setMaximumSize(new java.awt.Dimension(24, 24));
        jLabel24.setMinimumSize(new java.awt.Dimension(24, 24));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(teacherCount)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(teacherCount)
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(241, 240, 255));

        jLabel8.setForeground(new java.awt.Color(158, 160, 170));
        jLabel8.setText("Modules");

        modulesCount.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        modulesCount.setText("1");

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/monitor.png"))); // NOI18N
        jLabel22.setMaximumSize(new java.awt.Dimension(24, 24));
        jLabel22.setMinimumSize(new java.awt.Dimension(24, 24));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modulesCount)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modulesCount)
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableScrollPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(241, 240, 255), null));
        tableScrollPanel1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        activityTable.setForeground(new java.awt.Color(51, 51, 51));
        activityTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Activity", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        activityTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        activityTable.setGridColor(new java.awt.Color(238, 238, 238));
        activityTable.setIgnoreRepaint(true);
        activityTable.getTableHeader().setReorderingAllowed(false);
        activityTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activityTableMouseClicked(evt);
            }
        });
        tableScrollPanel1.setViewportView(activityTable);
        if (activityTable.getColumnModel().getColumnCount() > 0) {
            activityTable.getColumnModel().getColumn(0).setMinWidth(50);
            activityTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            activityTable.getColumnModel().getColumn(0).setMaxWidth(100);
            activityTable.getColumnModel().getColumn(1).setResizable(false);
            activityTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            activityTable.getColumnModel().getColumn(2).setMinWidth(100);
            activityTable.getColumnModel().getColumn(2).setPreferredWidth(200);
            activityTable.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(tableScrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(tableScrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelFirstLayout = new javax.swing.GroupLayout(panelFirst);
        panelFirst.setLayout(panelFirstLayout);
        panelFirstLayout.setHorizontalGroup(
            panelFirstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFirstLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelFirstLayout.setVerticalGroup(
            panelFirstLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFirstLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainBody.addTab("tab1", panelFirst);

        jPanel4.setBackground(new java.awt.Color(250, 250, 250));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        tableScrollPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(241, 240, 255), null));
        tableScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        coursesTable.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        coursesTable.setForeground(new java.awt.Color(51, 51, 51));
        coursesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        coursesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        coursesTable.setGridColor(new java.awt.Color(238, 238, 238));
        coursesTable.setIgnoreRepaint(true);
        coursesTable.getTableHeader().setReorderingAllowed(false);
        coursesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coursesTableMouseClicked(evt);
            }
        });
        tableScrollPanel.setViewportView(coursesTable);
        if (coursesTable.getColumnModel().getColumnCount() > 0) {
            coursesTable.getColumnModel().getColumn(0).setMinWidth(100);
            coursesTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            coursesTable.getColumnModel().getColumn(0).setMaxWidth(100);
            coursesTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            coursesTable.getColumnModel().getColumn(2).setMinWidth(150);
            coursesTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            coursesTable.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(241, 240, 255), null));

        searchCourses.setForeground(new java.awt.Color(158, 160, 170));
        searchCourses.setText("Search courses...");
        searchCourses.setBorder(null);
        searchCourses.setName(""); // NOI18N
        searchCourses.setPreferredSize(new java.awt.Dimension(64, 24));
        searchCourses.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchCoursesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchCoursesFocusLost(evt);
            }
        });
        searchCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchCoursesMouseClicked(evt);
            }
        });
        searchCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCoursesActionPerformed(evt);
            }
        });
        searchCourses.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchCoursesKeyReleased(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(searchCourses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        deleteCourseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/delete.png"))); // NOI18N
        deleteCourseBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 98, 255), 1, true));
        deleteCourseBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteCourseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteCourseBtnMouseClicked(evt);
            }
        });
        deleteCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCourseBtnActionPerformed(evt);
            }
        });

        editCourseButton.setBackground(new java.awt.Color(250, 250, 250));
        editCourseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/pencil.png"))); // NOI18N
        editCourseButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 98, 255), 1, true));
        editCourseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editCourseButton.setIconTextGap(8);
        editCourseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editCourseButtonMouseClicked(evt);
            }
        });
        editCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCourseButtonActionPerformed(evt);
            }
        });

        addCourse.setBackground(new java.awt.Color(250, 250, 250));
        addCourse.setForeground(new java.awt.Color(108, 99, 255));
        addCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/plus1.png"))); // NOI18N
        addCourse.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 98, 255), 1, true));
        addCourse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addCourse.setIconTextGap(0);
        addCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCourseMouseClicked(evt);
            }
        });
        addCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseActionPerformed(evt);
            }
        });

        courseReloadBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/refresh.png"))); // NOI18N
        courseReloadBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 98, 255), 1, true));
        courseReloadBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        courseReloadBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseReloadBtnMouseClicked(evt);
            }
        });
        courseReloadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseReloadBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(courseReloadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(deleteCourseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editCourseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(addCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(deleteCourseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCourseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseReloadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(tableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout panelSecondLayout = new javax.swing.GroupLayout(panelSecond);
        panelSecond.setLayout(panelSecondLayout);
        panelSecondLayout.setHorizontalGroup(
            panelSecondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelSecondLayout.setVerticalGroup(
            panelSecondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSecondLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainBody.addTab("tab2", panelSecond);

        jPanel5.setBackground(new java.awt.Color(250, 250, 250));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        tableScrollPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(241, 240, 255), null));
        tableScrollPanel2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        studentsTable.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        studentsTable.setForeground(new java.awt.Color(51, 51, 51));
        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Semester", "Course", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        studentsTable.setGridColor(new java.awt.Color(238, 238, 238));
        studentsTable.setIgnoreRepaint(true);
        studentsTable.getTableHeader().setReorderingAllowed(false);
        studentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentsTableMouseClicked(evt);
            }
        });
        tableScrollPanel2.setViewportView(studentsTable);

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(241, 240, 255), null));

        searchStudents.setForeground(new java.awt.Color(158, 160, 170));
        searchStudents.setText("Search student...");
        searchStudents.setBorder(null);
        searchStudents.setName(""); // NOI18N
        searchStudents.setPreferredSize(new java.awt.Dimension(64, 24));
        searchStudents.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchStudentsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchStudentsFocusLost(evt);
            }
        });
        searchStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchStudentsMouseClicked(evt);
            }
        });
        searchStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchStudentsActionPerformed(evt);
            }
        });
        searchStudents.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchStudentsKeyReleased(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(searchStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        studentAddBtn.setBackground(new java.awt.Color(250, 250, 250));
        studentAddBtn.setForeground(new java.awt.Color(108, 99, 255));
        studentAddBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/plus1.png"))); // NOI18N
        studentAddBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 98, 255), 1, true));
        studentAddBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentAddBtn.setIconTextGap(0);
        studentAddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentAddBtnMouseClicked(evt);
            }
        });
        studentAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentAddBtnActionPerformed(evt);
            }
        });

        studentReloadBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/refresh.png"))); // NOI18N
        studentReloadBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 98, 255), 1, true));
        studentReloadBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentReloadBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentReloadBtnMouseClicked(evt);
            }
        });
        studentReloadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentReloadBtnActionPerformed(evt);
            }
        });

        studentDeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/delete.png"))); // NOI18N
        studentDeleteBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 98, 255), 1, true));
        studentDeleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentDeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentDeleteBtnMouseClicked(evt);
            }
        });
        studentDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentDeleteBtnActionPerformed(evt);
            }
        });

        studentEditBtn.setBackground(new java.awt.Color(250, 250, 250));
        studentEditBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/pencil.png"))); // NOI18N
        studentEditBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 98, 255), 1, true));
        studentEditBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentEditBtn.setIconTextGap(8);
        studentEditBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentEditBtnMouseClicked(evt);
            }
        });
        studentEditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentEditBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tableScrollPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(studentReloadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(studentDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(studentEditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(studentAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(studentAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentEditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentReloadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(tableScrollPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout panelThirdLayout = new javax.swing.GroupLayout(panelThird);
        panelThird.setLayout(panelThirdLayout);
        panelThirdLayout.setHorizontalGroup(
            panelThirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelThirdLayout.setVerticalGroup(
            panelThirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelThirdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainBody.addTab("tab3", panelThird);

        jPanel10.setBackground(new java.awt.Color(250, 250, 250));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        tableScrollPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(241, 240, 255), null));
        tableScrollPanel3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        teachersTable.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        teachersTable.setForeground(new java.awt.Color(51, 51, 51));
        teachersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher ID", "Teacher Name", "Course", "Modules Involved", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        teachersTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        teachersTable.setGridColor(new java.awt.Color(238, 238, 238));
        teachersTable.setIgnoreRepaint(true);
        teachersTable.getTableHeader().setReorderingAllowed(false);
        teachersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teachersTableMouseClicked(evt);
            }
        });
        tableScrollPanel3.setViewportView(teachersTable);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(241, 240, 255), null));

        searchTeachers.setForeground(new java.awt.Color(158, 160, 170));
        searchTeachers.setText("Search teacher...");
        searchTeachers.setBorder(null);
        searchTeachers.setName(""); // NOI18N
        searchTeachers.setPreferredSize(new java.awt.Dimension(64, 24));
        searchTeachers.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTeachersFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchTeachersFocusLost(evt);
            }
        });
        searchTeachers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTeachersMouseClicked(evt);
            }
        });
        searchTeachers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTeachersActionPerformed(evt);
            }
        });
        searchTeachers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTeachersKeyReleased(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchTeachers, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(searchTeachers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        teacherAddBtn.setBackground(new java.awt.Color(250, 250, 250));
        teacherAddBtn.setForeground(new java.awt.Color(108, 99, 255));
        teacherAddBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/plus1.png"))); // NOI18N
        teacherAddBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 98, 255), 1, true));
        teacherAddBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        teacherAddBtn.setIconTextGap(0);
        teacherAddBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherAddBtnMouseClicked(evt);
            }
        });
        teacherAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherAddBtnActionPerformed(evt);
            }
        });

        teacherReloadBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/refresh.png"))); // NOI18N
        teacherReloadBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 98, 255), 1, true));
        teacherReloadBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        teacherReloadBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherReloadBtnMouseClicked(evt);
            }
        });
        teacherReloadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherReloadBtnActionPerformed(evt);
            }
        });

        teacherDeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/delete.png"))); // NOI18N
        teacherDeleteBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 98, 255), 1, true));
        teacherDeleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        teacherDeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherDeleteBtnMouseClicked(evt);
            }
        });
        teacherDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherDeleteBtnActionPerformed(evt);
            }
        });

        teacherEditBtn.setBackground(new java.awt.Color(250, 250, 250));
        teacherEditBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/pencil.png"))); // NOI18N
        teacherEditBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 98, 255), 1, true));
        teacherEditBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        teacherEditBtn.setIconTextGap(8);
        teacherEditBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherEditBtnMouseClicked(evt);
            }
        });
        teacherEditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherEditBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tableScrollPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(teacherReloadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(teacherDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(teacherEditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(teacherAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(teacherAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherEditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherDeleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherReloadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(tableScrollPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout teachersTablePanelLayout = new javax.swing.GroupLayout(teachersTablePanel);
        teachersTablePanel.setLayout(teachersTablePanelLayout);
        teachersTablePanelLayout.setHorizontalGroup(
            teachersTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        teachersTablePanelLayout.setVerticalGroup(
            teachersTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, teachersTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainBody.addTab("tab4", teachersTablePanel);

        jPanel7.setBackground(new java.awt.Color(250, 250, 250));

        jPanel15.setBackground(new java.awt.Color(250, 250, 250));

        jPanel16.setBackground(new java.awt.Color(250, 250, 250));

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Username");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/userIcon.png"))); // NOI18N

        profileUsername.setForeground(new java.awt.Color(158, 160, 170));
        profileUsername.setText("kenabeyy");
        profileUsername.setPreferredSize(new java.awt.Dimension(64, 32));
        profileUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                profileUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                profileUsernameFocusLost(evt);
            }
        });
        profileUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileUsernameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addGap(8, 8, 8)
                .addComponent(profileUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel17.setBackground(new java.awt.Color(250, 250, 250));

        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("New Password");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/passIcon.png"))); // NOI18N

        profilePassword.setPreferredSize(new java.awt.Dimension(64, 32));
        profilePassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                profilePasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                profilePasswordFocusLost(evt);
            }
        });
        profilePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profilePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profilePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel20.setBackground(new java.awt.Color(250, 250, 250));

        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Phone Number");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/phoneIcon.png"))); // NOI18N

        profilePhone.setForeground(new java.awt.Color(158, 160, 170));
        profilePhone.setText("9841321674");
        profilePhone.setPreferredSize(new java.awt.Dimension(64, 32));
        profilePhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                profilePhoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                profilePhoneFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profilePhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel18)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addGap(8, 8, 8)
                .addComponent(profilePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel22.setBackground(new java.awt.Color(250, 250, 250));

        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("Email");

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/mailIcon.png"))); // NOI18N

        profileEmail.setForeground(new java.awt.Color(158, 160, 170));
        profileEmail.setText("kebab.bahadur@gmail.com");
        profileEmail.setPreferredSize(new java.awt.Dimension(64, 32));
        profileEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                profileEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                profileEmailFocusLost(evt);
            }
        });
        profileEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel25)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addGap(8, 8, 8)
                .addComponent(profileEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        saveBtn.setBackground(new java.awt.Color(241, 240, 255));
        saveBtn.setForeground(new java.awt.Color(102, 102, 255));
        saveBtn.setText("Save Changes");
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBtnMouseClicked(evt);
            }
        });
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel21.setBackground(new java.awt.Color(250, 250, 250));

        jLabel27.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel27.setText("Edit Profile");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/whiteUser.png"))); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel20)
                .addGap(12, 12, 12)
                .addComponent(jLabel27)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel27)
                    .addComponent(jLabel20))
                .addContainerGap())
        );

        jPanel19.setBackground(new java.awt.Color(250, 250, 250));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/man.png"))); // NOI18N

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/el1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(2, 2, 2)
                .addComponent(jLabel16)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16))
                    .addComponent(jLabel17))
                .addContainerGap())
        );

        jPanel23.setBackground(new java.awt.Color(250, 250, 250));

        jLabel28.setForeground(new java.awt.Color(51, 51, 51));
        jLabel28.setText("Confirm Password");

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/passIcon.png"))); // NOI18N

        profileConfirmPassword.setPreferredSize(new java.awt.Dimension(64, 32));
        profileConfirmPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                profileConfirmPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                profileConfirmPasswordFocusLost(evt);
            }
        });
        profileConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileConfirmPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profileConfirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel28)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profileConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelFifthLayout = new javax.swing.GroupLayout(panelFifth);
        panelFifth.setLayout(panelFifthLayout);
        panelFifthLayout.setHorizontalGroup(
            panelFifthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelFifthLayout.setVerticalGroup(
            panelFifthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainBody.addTab("tab5", panelFifth);

        mainPanel.add(mainBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 900, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1072, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab1MouseClicked

        mainBody.setSelectedIndex(0);

        tabBtn1.setForeground(new java.awt.Color(255, 255, 255));
        tabBtn1.setFont(new java.awt.Font("Helvetica Neue", 0, 13));

        tabName.setText(tabBtn1.getText());

        tabBtn3.setFont(new java.awt.Font("Helvetica Neue", 0, 13));
        tabBtn5.setFont(new java.awt.Font("Helvetica Neue", 0, 13));
        tabBtn4.setFont(new java.awt.Font("Helvetica Neue", 0, 13));
        tabBtn2.setFont(new java.awt.Font("Helvetica Neue", 0, 13));

        tabBtn3.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn5.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn4.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn2.setForeground(new java.awt.Color(158, 160, 170));

        tab1.setBackground(new java.awt.Color(102, 102, 255));
        tab2.setBackground(new java.awt.Color(255, 255, 255));
        tab5.setBackground(new java.awt.Color(255, 255, 255));
        tab3.setBackground(new java.awt.Color(255, 255, 255));
        tab4.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_tab1MouseClicked

    private void tab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab2MouseClicked

        mainBody.setSelectedIndex(1);

        tabBtn2.setForeground(new java.awt.Color(255, 255, 255));
        tabBtn2.setFont(new java.awt.Font("Helvetica Neue", 0, 13));

        tabName.setText(tabBtn2.getText());

        tabBtn3.setFont(new java.awt.Font("Helvetica Neue", 0, 13));
        tabBtn5.setFont(new java.awt.Font("Helvetica Neue", 0, 13));
        tabBtn4.setFont(new java.awt.Font("Helvetica Neue", 0, 13));
        tabBtn1.setFont(new java.awt.Font("Helvetica Neue", 0, 13));

        tabBtn3.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn5.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn4.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn1.setForeground(new java.awt.Color(158, 160, 170));

        tab2.setBackground(new java.awt.Color(102, 102, 255));
        tab1.setBackground(new java.awt.Color(255, 255, 255));
        tab5.setBackground(new java.awt.Color(255, 255, 255));
        tab3.setBackground(new java.awt.Color(255, 255, 255));
        tab4.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_tab2MouseClicked

    private void tab3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab3MouseClicked

        mainBody.setSelectedIndex(2);

        tabBtn3.setForeground(new java.awt.Color(255, 255, 255));
        tabBtn3.setFont(new java.awt.Font("Helvetica Neue", 0, 13));

        tabName.setText(tabBtn3.getText());

        tabBtn2.setFont(new java.awt.Font("Helvetica Neue", 0, 13));
        tabBtn5.setFont(new java.awt.Font("Helvetica Neue", 0, 13));
        tabBtn4.setFont(new java.awt.Font("Helvetica Neue", 0, 13));
        tabBtn1.setFont(new java.awt.Font("Helvetica Neue", 0, 13));

        tabBtn2.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn5.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn4.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn1.setForeground(new java.awt.Color(158, 160, 170));

        tab3.setBackground(new java.awt.Color(102, 102, 255));
        tab1.setBackground(new java.awt.Color(255, 255, 255));
        tab5.setBackground(new java.awt.Color(255, 255, 255));
        tab2.setBackground(new java.awt.Color(255, 255, 255));
        tab4.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_tab3MouseClicked

    private void tab4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab4MouseClicked

        mainBody.setSelectedIndex(3);

        tabBtn4.setForeground(new java.awt.Color(255, 255, 255));
        tabBtn4.setFont(new java.awt.Font("Helvetica Neue", 0, 13));

        tabName.setText(tabBtn4.getText());

        tabBtn3.setFont(new java.awt.Font("Helvetica Neue", 0, 13));
        tabBtn5.setFont(new java.awt.Font("Helvetica Neue", 0, 13));
        tabBtn1.setFont(new java.awt.Font("Helvetica Neue", 0, 13));
        tabBtn2.setFont(new java.awt.Font("Helvetica Neue", 0, 13));

        tabBtn3.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn5.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn2.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn1.setForeground(new java.awt.Color(158, 160, 170));

        tab4.setBackground(new java.awt.Color(102, 102, 255));
        tab1.setBackground(new java.awt.Color(255, 255, 255));
        tab3.setBackground(new java.awt.Color(255, 255, 255));
        tab5.setBackground(new java.awt.Color(255, 255, 255));
        tab2.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_tab4MouseClicked

    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
        if (HelperMethods.showConfirmationDialog("Do you want to logout from your account? ")) {
            // Setting the logout time
            Account.updateActivity("Logout");
            dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_logoutBtnMouseClicked

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed

    }//GEN-LAST:event_logoutBtnActionPerformed

    private void tab5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab5MouseClicked

        mainBody.setSelectedIndex(4);

        tabBtn5.setForeground(new java.awt.Color(255, 255, 255));
        tabBtn5.setFont(new java.awt.Font("Helvetica Neue", 0, 13));

        tabName.setText(tabBtn5.getText());

        tabBtn3.setFont(new java.awt.Font("Helvetica Neue", 0, 13));
        tabBtn2.setFont(new java.awt.Font("Helvetica Neue", 0, 13));
        tabBtn4.setFont(new java.awt.Font("Helvetica Neue", 0, 13));
        tabBtn1.setFont(new java.awt.Font("Helvetica Neue", 0, 13));

        tabBtn3.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn2.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn4.setForeground(new java.awt.Color(158, 160, 170));
        tabBtn1.setForeground(new java.awt.Color(158, 160, 170));

        tab5.setBackground(new java.awt.Color(102, 102, 255));
        tab2.setBackground(new java.awt.Color(255, 255, 255));
        tab1.setBackground(new java.awt.Color(255, 255, 255));
        tab3.setBackground(new java.awt.Color(255, 255, 255));
        tab4.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_tab5MouseClicked

    private void directEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_directEmailMouseClicked

        try {
            Desktop.getDesktop().browse(new URL("https://mail.google.com/mail/u/0/#inbox").toURI());
        } catch (Exception e) {
            System.out.println("Error opening the url.");
        }
    }//GEN-LAST:event_directEmailMouseClicked

    private void coursesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coursesTableMouseClicked

    }//GEN-LAST:event_coursesTableMouseClicked

    private void searchCoursesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchCoursesFocusGained

        if (searchCourses.getText().equals("Search courses...")) {
            searchCourses.setText("");
            searchCourses.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_searchCoursesFocusGained

    private void searchCoursesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchCoursesFocusLost

        if (searchCourses.getText().isEmpty()) {
            searchCourses.setText("Search courses...");
            searchCourses.setForeground(new Color(158, 160, 170));
        }
    }//GEN-LAST:event_searchCoursesFocusLost

    private void searchCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchCoursesMouseClicked

    }//GEN-LAST:event_searchCoursesMouseClicked

    private void searchCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCoursesActionPerformed

    }//GEN-LAST:event_searchCoursesActionPerformed

    private void searchCoursesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchCoursesKeyReleased

        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(this.model2);
        coursesTable.setRowSorter(obj1);
        RowFilter filterRow = RowFilter.regexFilter(searchCourses.getText());
        obj1.setRowFilter(filterRow);
    }//GEN-LAST:event_searchCoursesKeyReleased

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked

    }//GEN-LAST:event_jPanel4MouseClicked

    private void profileUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profileUsernameFocusGained

        HelperMethods.handleFocusGainedLost(profileUsername, username, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profileUsernameFocusGained

    private void profileUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profileUsernameFocusLost

        HelperMethods.handleFocusGainedLost(profileUsername, username, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profileUsernameFocusLost

    private void profileUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileUsernameActionPerformed

    }//GEN-LAST:event_profileUsernameActionPerformed

    private void profilePasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profilePasswordFocusGained

        HelperMethods.handleFocusGainedLost(profilePassword, password, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profilePasswordFocusGained

    private void profilePasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profilePasswordFocusLost

        HelperMethods.handleFocusGainedLost(profilePassword, password, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profilePasswordFocusLost

    private void profilePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilePasswordActionPerformed

    }//GEN-LAST:event_profilePasswordActionPerformed

    private void profilePhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profilePhoneFocusGained

        HelperMethods.handleFocusGainedLost(profilePhone, phNum, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profilePhoneFocusGained

    private void profilePhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profilePhoneFocusLost
        HelperMethods.handleFocusGainedLost(profilePhone, phNum, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profilePhoneFocusLost

    private void profileEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profileEmailFocusGained

        HelperMethods.handleFocusGainedLost(profileEmail, email, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profileEmailFocusGained

    private void profileEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profileEmailFocusLost

        HelperMethods.handleFocusGainedLost(profileEmail, email, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profileEmailFocusLost

    private void profileEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileEmailActionPerformed

    }//GEN-LAST:event_profileEmailActionPerformed

    private void saveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseClicked

        if (HelperMethods.showConfirmationDialog("Do you want to make changes to your profile? ")) {

            String tempUsername = profileUsername.getText();
            String tempEmail = profileEmail.getText();
            String tempPassword = profilePassword.getText();
            String tempPhNum = profilePhone.getText();
            String tempConfirmPassword = profileConfirmPassword.getText();

            String details[] = {tempUsername, tempEmail, tempPassword, tempPhNum};

            if (tempUsername.equals(username) && tempEmail.equals(email) && tempPassword.equals(password) && tempPhNum.equals(phNum)) {

                JOptionPane.showMessageDialog(null, "No values were updated", "Profile Update Error", JOptionPane.INFORMATION_MESSAGE);

            } else {

                // Validating the details that the user wants to change
                if (Validation.validateDetails(details, tempConfirmPassword, role)) {

                    // UPDATING THE DATA INTO THE DATABASE
                    Account.updateProfile(details, id);

                    // this.data gets initialized to the changed data
                    AdminPanel.username = tempUsername;
                    AdminPanel.email = tempEmail;
                    AdminPanel.password = tempPassword;
                    AdminPanel.phNum = tempPhNum;
                }

            }

        }
    }//GEN-LAST:event_saveBtnMouseClicked

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed

    }//GEN-LAST:event_saveBtnActionPerformed

    private void profileConfirmPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profileConfirmPasswordFocusGained

        HelperMethods.handleFocusGainedLost(profileConfirmPassword, password, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profileConfirmPasswordFocusGained

    private void profileConfirmPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profileConfirmPasswordFocusLost

        HelperMethods.handleFocusGainedLost(profileConfirmPassword, password, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profileConfirmPasswordFocusLost

    private void profileConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileConfirmPasswordActionPerformed

    }//GEN-LAST:event_profileConfirmPasswordActionPerformed

    private void activityTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activityTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_activityTableMouseClicked

    private void deleteCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCourseBtnActionPerformed

    }//GEN-LAST:event_deleteCourseBtnActionPerformed

    private void deleteCourseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteCourseBtnMouseClicked

        int selectedRow = coursesTable.getSelectedRow();

        if (selectedRow != -1) {
            if (HelperMethods.showConfirmationDialog("Do you really want to delete this course? ")) {
                // Getting the selected row
                String id = (String) coursesTable.getValueAt(selectedRow, 0);

                AdminAccount.deleteCourse(Integer.parseInt(id));
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No Rows Selected", "Delete Course", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_deleteCourseBtnMouseClicked

    private void editCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCourseButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editCourseButtonActionPerformed

    private void editCourseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editCourseButtonMouseClicked
        int selectedRow = coursesTable.getSelectedRow();

        if (selectedRow != -1) {

            // Getting the selected row's details
            String id = (String) coursesTable.getValueAt(selectedRow, 0);
            String courseTitle = (String) coursesTable.getValueAt(selectedRow, 1);
            String courseCode = (String) coursesTable.getValueAt(selectedRow, 2);

            String courseDetails[] = {id, courseTitle, courseCode};

            ec = new EditCourse(courseDetails);
            ec.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "No Rows Selected", "Edit Course", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_editCourseButtonMouseClicked

    private void addCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_addCourseActionPerformed

    private void addCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addCourseMouseClicked
        // TODO add your handling code here:

        ac.setVisible(true);
    }//GEN-LAST:event_addCourseMouseClicked

    private void courseReloadBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseReloadBtnMouseClicked
        // TODO add your handling code here:
        model2.setRowCount(0);
        AdminAccount.getCoursesData(model2);

    }//GEN-LAST:event_courseReloadBtnMouseClicked

    private void courseReloadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseReloadBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseReloadBtnActionPerformed

    private void studentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsTableMouseClicked

    }//GEN-LAST:event_studentsTableMouseClicked

    private void searchStudentsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchStudentsFocusGained

        if (searchStudents.getText().equals("Search student...")) {
            searchStudents.setText("");
            searchStudents.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_searchStudentsFocusGained

    private void searchStudentsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchStudentsFocusLost

        if (searchStudents.getText().isEmpty()) {
            searchStudents.setText("Search student...");
            searchStudents.setForeground(new Color(158, 160, 170));
        }
    }//GEN-LAST:event_searchStudentsFocusLost

    private void searchStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchStudentsMouseClicked

    }//GEN-LAST:event_searchStudentsMouseClicked

    private void searchStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchStudentsActionPerformed

    }//GEN-LAST:event_searchStudentsActionPerformed

    private void searchStudentsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchStudentsKeyReleased

        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(this.model3);
        studentsTable.setRowSorter(obj1);
        RowFilter filterRow = RowFilter.regexFilter(searchStudents.getText());
        obj1.setRowFilter(filterRow);
    }//GEN-LAST:event_searchStudentsKeyReleased

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked

    }//GEN-LAST:event_jPanel5MouseClicked
    AddStudent as = new AddStudent();
    private void studentAddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentAddBtnMouseClicked

        as.setVisible(true);
    }//GEN-LAST:event_studentAddBtnMouseClicked

    private void studentAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentAddBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentAddBtnActionPerformed

    private void studentReloadBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentReloadBtnMouseClicked
        // TODO add your handling code here:
        model3.setRowCount(0);
        AdminAccount.studentsTable(model3);
    }//GEN-LAST:event_studentReloadBtnMouseClicked

    private void studentReloadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentReloadBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentReloadBtnActionPerformed

    private void studentDeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentDeleteBtnMouseClicked

        int selectedRow = studentsTable.getSelectedRow();

        if (selectedRow != -1) {
            if (HelperMethods.showConfirmationDialog("Do you really want to delete this student's account? All data corresponding to this student will be lost. ")) {
                // Getting the selected row
                String id = (String) studentsTable.getValueAt(selectedRow, 0);
                AdminAccount.deleteStudent(Integer.parseInt(id));

            }
        } else {
            JOptionPane.showMessageDialog(null, "No Rows Selected", "Delete Student", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_studentDeleteBtnMouseClicked

    private void studentDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentDeleteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentDeleteBtnActionPerformed
    EditStudent es;
    private void studentEditBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentEditBtnMouseClicked
        int selectedRow = studentsTable.getSelectedRow();

        if (selectedRow != -1) {

            // Getting the selected row's details
            String id = (String) studentsTable.getValueAt(selectedRow, 0);
            String studentName = (String) studentsTable.getValueAt(selectedRow, 1);
            String semester = (String) studentsTable.getValueAt(selectedRow, 2);
            String course = (String) studentsTable.getValueAt(selectedRow, 3);
            String email = (String) studentsTable.getValueAt(selectedRow, 4);

            String studentDetails[] = {id, studentName, semester, course, email};

            es = new EditStudent(studentDetails);
            es.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "No Rows Selected", "Edit Course", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_studentEditBtnMouseClicked

    private void studentEditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentEditBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentEditBtnActionPerformed

    private void teachersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teachersTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_teachersTableMouseClicked

    private void searchTeachersFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTeachersFocusGained
        if (searchTeachers.getText().equals("Search teacher...")) {
            searchTeachers.setText("");
            searchTeachers.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_searchTeachersFocusGained

    private void searchTeachersFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTeachersFocusLost
        if (searchTeachers.getText().isEmpty()) {
            searchTeachers.setText("Search teacher...");
            searchTeachers.setForeground(new Color(158, 160, 170));
        }
    }//GEN-LAST:event_searchTeachersFocusLost

    private void searchTeachersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTeachersMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTeachersMouseClicked

    private void searchTeachersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTeachersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTeachersActionPerformed

    private void searchTeachersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTeachersKeyReleased
        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(this.model4);
        teachersTable.setRowSorter(obj1);
        RowFilter filterRow = RowFilter.regexFilter(searchTeachers.getText());
        obj1.setRowFilter(filterRow);
    }//GEN-LAST:event_searchTeachersKeyReleased
    AddTeacher at = new AddTeacher();
    private void teacherAddBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherAddBtnMouseClicked
        // TODO add your handling code here:
        at.setVisible(true);
    }//GEN-LAST:event_teacherAddBtnMouseClicked

    private void teacherAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherAddBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacherAddBtnActionPerformed

    private void teacherReloadBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherReloadBtnMouseClicked
        // TODO add your handling code here:
        model4.setRowCount(0);
        AdminAccount.teachersTable(model4);
    }//GEN-LAST:event_teacherReloadBtnMouseClicked

    private void teacherReloadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherReloadBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacherReloadBtnActionPerformed

    private void teacherDeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherDeleteBtnMouseClicked
        int selectedRow = teachersTable.getSelectedRow();

        if (selectedRow != -1) {
            if (HelperMethods.showConfirmationDialog("Do you really want to delete this teacher's account? All data corresponding to this teacher will be lost. ")) {
                // Getting the selected row
                String id = (String) teachersTable.getValueAt(selectedRow, 0);
                AdminAccount.deleteTeacher(Integer.parseInt(id));
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No Rows Selected", "Delete Teacher", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_teacherDeleteBtnMouseClicked

    private void teacherDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherDeleteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacherDeleteBtnActionPerformed
    EditTeacher et;
    private void teacherEditBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherEditBtnMouseClicked

        int selectedRow = teachersTable.getSelectedRow();

        if (selectedRow != -1) {

            // Getting the selected row's details
            String id = (String) teachersTable.getValueAt(selectedRow, 0);
            String teacherName = (String) teachersTable.getValueAt(selectedRow, 1);
            String course = (String) teachersTable.getValueAt(selectedRow, 2);
            String modulesCount = (String) teachersTable.getValueAt(selectedRow, 3);
            String email = (String) teachersTable.getValueAt(selectedRow, 4);

            String studentDetails[] = {id, teacherName, course, modulesCount, email};

            et = new EditTeacher(studentDetails);
            et.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "No Rows Selected", "Edit Course", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_teacherEditBtnMouseClicked

    private void teacherEditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherEditBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacherEditBtnActionPerformed

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable activityTable;
    private javax.swing.JButton addCourse;
    private javax.swing.JButton courseReloadBtn;
    private javax.swing.JLabel coursesCount;
    private javax.swing.JTable coursesTable;
    private javax.swing.JButton deleteCourseBtn;
    private javax.swing.JLabel directEmail;
    private javax.swing.JButton editCourseButton;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JTabbedPane mainBody;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel modulesCount;
    private javax.swing.JPanel panelFifth;
    private javax.swing.JPanel panelFirst;
    private javax.swing.JPanel panelSecond;
    private javax.swing.JPanel panelThird;
    private javax.swing.JPasswordField profileConfirmPassword;
    private javax.swing.JTextField profileEmail;
    private javax.swing.JPasswordField profilePassword;
    private javax.swing.JTextField profilePhone;
    private javax.swing.JTextField profileUsername;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField searchCourses;
    private javax.swing.JTextField searchStudents;
    private javax.swing.JTextField searchTeachers;
    private javax.swing.JLabel stdPanelName;
    private javax.swing.JButton studentAddBtn;
    private javax.swing.JLabel studentCount;
    private javax.swing.JButton studentDeleteBtn;
    private javax.swing.JButton studentEditBtn;
    private javax.swing.JButton studentReloadBtn;
    private javax.swing.JTable studentsTable;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    private javax.swing.JPanel tab5;
    private javax.swing.JLabel tabBtn1;
    private javax.swing.JLabel tabBtn2;
    private javax.swing.JLabel tabBtn3;
    private javax.swing.JLabel tabBtn4;
    private javax.swing.JLabel tabBtn5;
    private javax.swing.JLabel tabName;
    private javax.swing.JScrollPane tableScrollPanel;
    private javax.swing.JScrollPane tableScrollPanel1;
    private javax.swing.JScrollPane tableScrollPanel2;
    private javax.swing.JScrollPane tableScrollPanel3;
    private javax.swing.JButton teacherAddBtn;
    private javax.swing.JLabel teacherCount;
    private javax.swing.JButton teacherDeleteBtn;
    private javax.swing.JButton teacherEditBtn;
    private javax.swing.JButton teacherReloadBtn;
    private javax.swing.JTable teachersTable;
    private javax.swing.JPanel teachersTablePanel;
    private javax.swing.JLabel usertypeShow;
    // End of variables declaration//GEN-END:variables
}
