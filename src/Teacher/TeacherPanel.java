package Teacher;

import cms.Backend.Account;
import cms.Backend.HelperMethods;
import static cms.Backend.HelperMethods.alignTableContents;
import static cms.Backend.HelperMethods.setTableAppearance;
import static cms.Backend.HelperMethods.showConfirmationDialog;
import cms.Backend.StudentAccount;
import cms.Backend.TeacherAccount;
import cms.Backend.Validation;
import static cms.Backend.Validation.namingConvention;
import cms.Frontend.Contents;
import cms.Frontend.Login;
import cms.Frontend.Person;
import cms.Frontend.Student.Answer;
import cms.Frontend.Student.Notification;
import cms.Frontend.StudentTeacher;

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

/**
 *
 * @author kenabkc
 */
public class TeacherPanel extends javax.swing.JFrame implements StudentTeacher {

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
    private String modules;

    public final static String role = "Teacher";

    private int courseId;
    private int studentsCount;
    private int teachersCount;
    private String semester;

    private String announcement[][];
    private String questionDetails[][];

    private DefaultTableModel model;
    private DefaultTableModel model2;
    public int q1;

    public int q2;
    public int q3;

    /**
     * Creates new form TeacherPanel
     */
    public TeacherPanel() {
        initComponents();
        setValueChanged();
        newText.setVisible(false);

    }

    private void setValueChanged() {

        gradeBtn.setVisible(false);
        studentsTable.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                if (studentsTable.getSelectedRow() != -1) {

                    gradeBtn.setVisible(true);
                } else {

                    gradeBtn.setVisible(false);
                }
            }
        });
    }

    public void updateDetails() {

        // Upating the activity when we log in
        Account.updateActivity("Login");

        boolean newNotifications = TeacherAccount.checkNotifications();

        // Checking if any new notifications is present
        if (newNotifications) {
            newText.setVisible(true);
        }

        // Updating the dashboard panel
        stdPanelName.setText(Person.getName());
        courseName.setText(this.course);
        studentCount.setText(String.valueOf(this.studentsCount));
        teacherCount.setText(String.valueOf(this.teachersCount));

        modulesCount.setText(this.modules);

        // Updating the Profile Panel
        profileUsername.setText(username);
        profileEmail.setText(email);
        profilePassword.setText(password);
        profileConfirmPassword.setText(password);
        profilePhone.setText(phNum);

        setContents();

        // Updating the students panel
        this.model = (DefaultTableModel) studentsTable.getModel();

        TeacherAccount.getTableData(courseId, model, "t3");
        alignTableContents(studentsTable);
        setTableAppearance(studentsTable);

    }

    @Override
    public void setContents() {
        contents.setAnnouncement(announcement, this);
        contents.setQuestionsDetails(questionDetails, this);

    }

    public void extractDetails() {
        try {
            ResultSet result = Account.getUserData(TeacherPanel.username);
            if (result.next()) {

                TeacherPanel.id = result.getInt("id");
                this.fName = result.getString("f_name");
                this.lName = result.getString("l_name");
                TeacherPanel.email = result.getString("email");
                TeacherPanel.phNum = result.getString("ph_num");
                TeacherPanel.password = result.getString("password");
                this.course = result.getString("course");
                TeacherPanel.date = result.getString("date_created");
                this.studentsCount = StudentAccount.getTotalStudentCount(course);
                this.teachersCount = TeacherAccount.getTotalTeacherCount(course);
                this.courseId = Account.getCourseId(course);
                this.modules = String.valueOf(Account.getModulesCount(courseId));

                this.announcement = TeacherAccount.getAnnouncementData(courseId);

                this.p = new Person(this.fName, this.lName, id, this.course, role, this.courseId);

                this.questionDetails = TeacherAccount.getQuestions();
            }

        } catch (SQLException ex) {
            Logger.getLogger(TeacherPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
     * @param username
     */
    @Override
    public void setName(String username) {
        TeacherPanel.username = username;
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
        notificationBtn = new javax.swing.JLabel();
        newText = new javax.swing.JLabel();
        mainBody = new javax.swing.JTabbedPane();
        panelFirst = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        courseName = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        studentCount = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        teacherCount = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        announcementPanel = new javax.swing.JPanel();
        announcementTitle = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg1 = new javax.swing.JTextArea();
        teacher1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        date1 = new javax.swing.JLabel();
        secondAnnouncementPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        msg2 = new javax.swing.JTextArea();
        teacher2 = new javax.swing.JLabel();
        date2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel14 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        modulesCount = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        panelSecond = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        tableScrollPanel = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        searchCourses = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        gradeBtn = new javax.swing.JButton();
        panelThird = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        addAnnouncementText = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        assignmentSubText = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        uploadAnnouncementBtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        fullMessage = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        semesterCount = new javax.swing.JSlider();
        jSeparator5 = new javax.swing.JSeparator();
        panelFourth = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        addAssignmentBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        questionsPanel = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        qsPanel2 = new javax.swing.JPanel();
        qsMod2 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        qsDate2 = new javax.swing.JLabel();
        qsNo2 = new javax.swing.JLabel();
        qsLabel2 = new javax.swing.JLabel();
        qsLabel5 = new javax.swing.JLabel();
        qsPanel1 = new javax.swing.JPanel();
        qsMod1 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        qsDate1 = new javax.swing.JLabel();
        qsNo1 = new javax.swing.JLabel();
        qsLabel1 = new javax.swing.JLabel();
        qsLabel4 = new javax.swing.JLabel();
        qsPanel3 = new javax.swing.JPanel();
        qsMod3 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        qsDate3 = new javax.swing.JLabel();
        qsNo3 = new javax.swing.JLabel();
        qsLabel3 = new javax.swing.JLabel();
        qsLabel6 = new javax.swing.JLabel();
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
        tabBtn2.setText("Students");

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
        tabBtn3.setText("Announcements");

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
        tabBtn4.setText("Assignments");

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
        usertypeShow.setText("Teacher");

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

        notificationBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/notification.png"))); // NOI18N
        notificationBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        notificationBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationBtnMouseClicked(evt);
            }
        });

        newText.setFont(new java.awt.Font("Helvetica Neue", 1, 8)); // NOI18N
        newText.setForeground(new java.awt.Color(255, 51, 51));
        newText.setText("NEW!");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(tabName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 439, Short.MAX_VALUE)
                .addComponent(newText)
                .addGap(0, 0, 0)
                .addComponent(notificationBtn)
                .addGap(18, 18, 18)
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
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newText)
                    .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator4)
                        .addComponent(directEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                            .addComponent(stdPanelName)
                            .addGap(2, 2, 2)
                            .addComponent(usertypeShow))
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(notificationBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        mainPanel.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 900, 70));

        jPanel9.setBackground(new java.awt.Color(250, 250, 250));

        jPanel8.setBackground(new java.awt.Color(241, 240, 255));

        jLabel1.setForeground(new java.awt.Color(158, 160, 170));
        jLabel1.setText("Course");

        courseName.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        courseName.setText("BIT");

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
                    .addComponent(courseName)
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
                .addComponent(courseName)
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

        announcementPanel.setBackground(new java.awt.Color(241, 240, 255));

        announcementTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        announcementTitle.setText("Latest Announcements");

        jPanel10.setBackground(new java.awt.Color(241, 240, 255));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        msg1.setEditable(false);
        msg1.setBackground(new java.awt.Color(241, 240, 255));
        msg1.setColumns(20);
        msg1.setForeground(new java.awt.Color(103, 103, 103));
        msg1.setLineWrap(true);
        msg1.setRows(5);
        msg1.setText("The deadline has been pushed to February 1st, and I want to let you know there won't be any more extensions for the final prototype. Unfortunately, we can't extend the final prototype submission because of the university deadline. The deadline has been pushed to February 1st, and I want to let you know there won't be any more extensions for the final prototype. Unfortunately, we can't extend the final prototype submission because of the university deadline. nfortunately, we can't ");
        msg1.setWrapStyleWord(true);
        msg1.setBorder(null);
        msg1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(msg1);

        teacher1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        teacher1.setForeground(new java.awt.Color(102, 102, 102));
        teacher1.setText("-Ronit Shrestha");

        date1.setForeground(new java.awt.Color(159, 160, 170));
        date1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        date1.setText("2024-01-26 22:18:02");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addComponent(teacher1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(date1))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(20, 20, 20))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teacher1)
                    .addComponent(date1))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        secondAnnouncementPanel.setBackground(new java.awt.Color(241, 240, 255));

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        msg2.setEditable(false);
        msg2.setBackground(new java.awt.Color(241, 240, 255));
        msg2.setColumns(20);
        msg2.setForeground(new java.awt.Color(103, 103, 103));
        msg2.setLineWrap(true);
        msg2.setRows(5);
        msg2.setText("The deadline has been pushed to February 1st, and I want to let you know there won't be any more extensions for the final prototype. Unfortunately, we can't extend the final prototype submission because of the university deadline. The deadline has been pushed to February 1st, and I want to let you know there won't be any more extensions for the final prototype. Unfortunately, we can't extend the final prototype submission because of the university deadline. nfortunately, we can't ");
        msg2.setWrapStyleWord(true);
        msg2.setBorder(null);
        msg2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(msg2);

        teacher2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        teacher2.setForeground(new java.awt.Color(102, 102, 102));
        teacher2.setText("-Ronit Shrestha");

        date2.setForeground(new java.awt.Color(159, 160, 170));
        date2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        date2.setText("2024-01-26 22:18:02");

        javax.swing.GroupLayout secondAnnouncementPanelLayout = new javax.swing.GroupLayout(secondAnnouncementPanel);
        secondAnnouncementPanel.setLayout(secondAnnouncementPanelLayout);
        secondAnnouncementPanelLayout.setHorizontalGroup(
            secondAnnouncementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, secondAnnouncementPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(secondAnnouncementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, secondAnnouncementPanelLayout.createSequentialGroup()
                        .addComponent(teacher2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(date2))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(20, 20, 20))
        );
        secondAnnouncementPanelLayout.setVerticalGroup(
            secondAnnouncementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(secondAnnouncementPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(secondAnnouncementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teacher2)
                    .addComponent(date2))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout announcementPanelLayout = new javax.swing.GroupLayout(announcementPanel);
        announcementPanel.setLayout(announcementPanelLayout);
        announcementPanelLayout.setHorizontalGroup(
            announcementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(announcementPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(announcementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(announcementPanelLayout.createSequentialGroup()
                        .addComponent(announcementTitle)
                        .addGap(618, 618, 618))
                    .addComponent(secondAnnouncementPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        announcementPanelLayout.setVerticalGroup(
            announcementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(announcementPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(announcementTitle)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(secondAnnouncementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(announcementPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
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
                .addGap(32, 32, 32)
                .addComponent(announcementPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        tableScrollPanel.setViewportView(studentsTable);
        if (studentsTable.getColumnModel().getColumnCount() > 0) {
            studentsTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            studentsTable.getColumnModel().getColumn(0).setMaxWidth(100);
            studentsTable.getColumnModel().getColumn(1).setPreferredWidth(500);
            studentsTable.getColumnModel().getColumn(1).setMaxWidth(500);
            studentsTable.getColumnModel().getColumn(2).setResizable(false);
            studentsTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            studentsTable.getColumnModel().getColumn(4).setPreferredWidth(300);
            studentsTable.getColumnModel().getColumn(4).setMaxWidth(300);
        }

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(241, 240, 255), null));

        searchCourses.setForeground(new java.awt.Color(158, 160, 170));
        searchCourses.setText("Search student...");
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
                .addComponent(searchCourses, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
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

        gradeBtn.setBackground(new java.awt.Color(241, 240, 255));
        gradeBtn.setForeground(new java.awt.Color(108, 99, 255));
        gradeBtn.setText("Grade");
        gradeBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(108, 99, 255)));
        gradeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gradeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradeBtnMouseClicked(evt);
            }
        });
        gradeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeBtnActionPerformed(evt);
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
                        .addComponent(gradeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(gradeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jPanel18.setBackground(new java.awt.Color(250, 250, 250));

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        addAnnouncementText.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        addAnnouncementText.setForeground(new java.awt.Color(51, 51, 51));
        addAnnouncementText.setText("Add announcement");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/course.png"))); // NOI18N

        assignmentSubText.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        assignmentSubText.setForeground(new java.awt.Color(102, 102, 102));
        assignmentSubText.setText("Upload a new announcement");

        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Your message : ");

        uploadAnnouncementBtn.setBackground(new java.awt.Color(108, 99, 255));
        uploadAnnouncementBtn.setForeground(new java.awt.Color(255, 255, 255));
        uploadAnnouncementBtn.setText("Upload Announcement");
        uploadAnnouncementBtn.setBorder(null);
        uploadAnnouncementBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadAnnouncementBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uploadAnnouncementBtnMouseClicked(evt);
            }
        });
        uploadAnnouncementBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadAnnouncementBtnActionPerformed(evt);
            }
        });

        fullMessage.setColumns(20);
        fullMessage.setForeground(new java.awt.Color(51, 51, 51));
        fullMessage.setLineWrap(true);
        fullMessage.setRows(5);
        fullMessage.setWrapStyleWord(true);
        jScrollPane4.setViewportView(fullMessage);

        jLabel30.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setText("Semester : ");

        semesterCount.setForeground(new java.awt.Color(108, 92, 255));
        semesterCount.setMajorTickSpacing(1);
        semesterCount.setMaximum(6);
        semesterCount.setMinimum(1);
        semesterCount.setPaintLabels(true);
        semesterCount.setPaintTicks(true);
        semesterCount.setSnapToTicks(true);
        semesterCount.setToolTipText("");
        semesterCount.setValue(1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(uploadAnnouncementBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                                .addGap(353, 353, 353))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addAnnouncementText)
                                    .addComponent(assignmentSubText, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(semesterCount, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator5))))
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addAnnouncementText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(assignmentSubText))
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addComponent(jLabel14)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel30)
                .addGap(12, 12, 12)
                .addComponent(semesterCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(uploadAnnouncementBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelThirdLayout = new javax.swing.GroupLayout(panelThird);
        panelThird.setLayout(panelThirdLayout);
        panelThirdLayout.setHorizontalGroup(
            panelThirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThirdLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelThirdLayout.setVerticalGroup(
            panelThirdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThirdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainBody.addTab("tab3", panelThird);

        jPanel6.setBackground(new java.awt.Color(250, 250, 250));

        addAssignmentBtn.setBackground(new java.awt.Color(108, 99, 255));
        addAssignmentBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        addAssignmentBtn.setForeground(new java.awt.Color(241, 240, 255));
        addAssignmentBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/plus.png"))); // NOI18N
        addAssignmentBtn.setMnemonic('[');
        addAssignmentBtn.setText("Add Assignment");
        addAssignmentBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 99, 255), 1, true));
        addAssignmentBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addAssignmentBtn.setIconTextGap(8);
        addAssignmentBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addAssignmentBtnMouseClicked(evt);
            }
        });
        addAssignmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAssignmentBtnActionPerformed(evt);
            }
        });

        refreshBtn.setBackground(new java.awt.Color(250, 250, 250));
        refreshBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        refreshBtn.setForeground(new java.awt.Color(108, 99, 255));
        refreshBtn.setMnemonic('[');
        refreshBtn.setText("Refresh");
        refreshBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(108, 99, 255), 1, true));
        refreshBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        questionsPanel.setBackground(new java.awt.Color(241, 240, 255));

        jPanel26.setBackground(new java.awt.Color(241, 240, 255));

        qsPanel2.setBackground(new java.awt.Color(241, 240, 255));

        qsMod2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        qsMod2.setForeground(new java.awt.Color(102, 102, 102));
        qsMod2.setText("Internet Software Architecture");

        qsDate2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        qsDate2.setForeground(new java.awt.Color(159, 160, 170));
        qsDate2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        qsDate2.setText("2024-01-26 22:18:02");

        qsNo2.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        qsNo2.setText("Question Number 1");

        qsLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        qsLabel2.setForeground(new java.awt.Color(102, 102, 102));
        qsLabel2.setText("What is the process of Encapsulation in Java? ");

        qsLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        qsLabel5.setForeground(new java.awt.Color(108, 95, 255));
        qsLabel5.setText("Assigned");

        javax.swing.GroupLayout qsPanel2Layout = new javax.swing.GroupLayout(qsPanel2);
        qsPanel2.setLayout(qsPanel2Layout);
        qsPanel2Layout.setHorizontalGroup(
            qsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qsPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(qsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(qsPanel2Layout.createSequentialGroup()
                        .addGroup(qsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qsNo2)
                            .addGroup(qsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, qsPanel2Layout.createSequentialGroup()
                                    .addComponent(qsMod2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(qsLabel5))
                                .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(qsPanel2Layout.createSequentialGroup()
                        .addGroup(qsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qsDate2)
                            .addComponent(qsLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        qsPanel2Layout.setVerticalGroup(
            qsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qsPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(qsNo2)
                .addGap(6, 6, 6)
                .addComponent(qsDate2)
                .addGap(18, 18, 18)
                .addComponent(qsLabel2)
                .addGap(18, 18, 18)
                .addGroup(qsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qsMod2)
                    .addComponent(qsLabel5))
                .addGap(27, 27, 27)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        qsPanel1.setBackground(new java.awt.Color(241, 240, 255));

        qsMod1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        qsMod1.setForeground(new java.awt.Color(102, 102, 102));
        qsMod1.setText("Internet Software Architecture");

        qsDate1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        qsDate1.setForeground(new java.awt.Color(159, 160, 170));
        qsDate1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        qsDate1.setText("2024-01-26 22:18:02");

        qsNo1.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        qsNo1.setText("Question Number 1");

        qsLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        qsLabel1.setForeground(new java.awt.Color(102, 102, 102));
        qsLabel1.setText("What is the process of Encapsulation in Java? ");

        qsLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        qsLabel4.setForeground(new java.awt.Color(108, 95, 255));
        qsLabel4.setText("Assigned");

        javax.swing.GroupLayout qsPanel1Layout = new javax.swing.GroupLayout(qsPanel1);
        qsPanel1.setLayout(qsPanel1Layout);
        qsPanel1Layout.setHorizontalGroup(
            qsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qsPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(qsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(qsPanel1Layout.createSequentialGroup()
                        .addGroup(qsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qsNo1)
                            .addGroup(qsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, qsPanel1Layout.createSequentialGroup()
                                    .addComponent(qsMod1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(qsLabel4))
                                .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, Short.MAX_VALUE))
                    .addGroup(qsPanel1Layout.createSequentialGroup()
                        .addGroup(qsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qsDate1)
                            .addComponent(qsLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        qsPanel1Layout.setVerticalGroup(
            qsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qsPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(qsNo1)
                .addGap(6, 6, 6)
                .addComponent(qsDate1)
                .addGap(18, 18, 18)
                .addComponent(qsLabel1)
                .addGap(18, 18, 18)
                .addGroup(qsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qsMod1)
                    .addComponent(qsLabel4))
                .addGap(27, 27, 27)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        qsPanel3.setBackground(new java.awt.Color(241, 240, 255));

        qsMod3.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        qsMod3.setForeground(new java.awt.Color(102, 102, 102));
        qsMod3.setText("Internet Software Architecture");

        qsDate3.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        qsDate3.setForeground(new java.awt.Color(159, 160, 170));
        qsDate3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        qsDate3.setText("2024-01-26 22:18:02");

        qsNo3.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        qsNo3.setText("Question Number 1");

        qsLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        qsLabel3.setForeground(new java.awt.Color(102, 102, 102));
        qsLabel3.setText("What is the process of Encapsulation in Java? ");

        qsLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        qsLabel6.setForeground(new java.awt.Color(108, 95, 255));
        qsLabel6.setText("Assigned");

        javax.swing.GroupLayout qsPanel3Layout = new javax.swing.GroupLayout(qsPanel3);
        qsPanel3.setLayout(qsPanel3Layout);
        qsPanel3Layout.setHorizontalGroup(
            qsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qsPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(qsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(qsPanel3Layout.createSequentialGroup()
                        .addGroup(qsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qsNo3)
                            .addGroup(qsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, qsPanel3Layout.createSequentialGroup()
                                    .addComponent(qsMod3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(qsLabel6))
                                .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(qsPanel3Layout.createSequentialGroup()
                        .addGroup(qsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qsDate3)
                            .addComponent(qsLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        qsPanel3Layout.setVerticalGroup(
            qsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qsPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(qsNo3)
                .addGap(6, 6, 6)
                .addComponent(qsDate3)
                .addGap(18, 18, 18)
                .addComponent(qsLabel3)
                .addGap(18, 18, 18)
                .addGroup(qsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qsMod3)
                    .addComponent(qsLabel6))
                .addGap(27, 27, 27)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(qsPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(qsPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(qsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap(187, Short.MAX_VALUE)
                .addComponent(qsPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qsPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(qsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(394, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout questionsPanelLayout = new javax.swing.GroupLayout(questionsPanel);
        questionsPanel.setLayout(questionsPanelLayout);
        questionsPanelLayout.setHorizontalGroup(
            questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 839, Short.MAX_VALUE)
        );
        questionsPanelLayout.setVerticalGroup(
            questionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jScrollPane3.setViewportView(questionsPanel);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addAssignmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addAssignmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        javax.swing.GroupLayout panelFourthLayout = new javax.swing.GroupLayout(panelFourth);
        panelFourth.setLayout(panelFourthLayout);
        panelFourthLayout.setHorizontalGroup(
            panelFourthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
            .addGroup(panelFourthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFourthLayout.setVerticalGroup(
            panelFourthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
            .addGroup(panelFourthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFourthLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        mainBody.addTab("tab4", panelFourth);

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

    private void notificationBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationBtnMouseClicked
        // TODO add your handling code here:

        if (newText.isShowing()) {
            Notification n1 = new Notification();
            n1.setVisible(true);
            newText.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(null, "No new announcements yet.", "No Announcements", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_notificationBtnMouseClicked

    private void searchCoursesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchCoursesFocusGained

        if (searchCourses.getText().equals("Search student...")) {
            searchCourses.setText("");
            searchCourses.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_searchCoursesFocusGained

    private void searchCoursesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchCoursesFocusLost

        if (searchCourses.getText().isEmpty()) {
            searchCourses.setText("Search student...");
            searchCourses.setForeground(new Color(158, 160, 170));
        }
    }//GEN-LAST:event_searchCoursesFocusLost

    private void searchCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchCoursesMouseClicked

    }//GEN-LAST:event_searchCoursesMouseClicked

    private void searchCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCoursesActionPerformed

    }//GEN-LAST:event_searchCoursesActionPerformed

    private void searchCoursesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchCoursesKeyReleased

        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(this.model);
        studentsTable.setRowSorter(obj1);
        RowFilter filterRow = RowFilter.regexFilter(searchCourses.getText());
        obj1.setRowFilter(filterRow);
    }//GEN-LAST:event_searchCoursesKeyReleased

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

                JOptionPane.showMessageDialog(null, namingConvention("blankValue"), "Profile Update Error", JOptionPane.INFORMATION_MESSAGE);

            } else {

                // Validating the details that the user wants to change
                if (Validation.validateDetails(details, tempConfirmPassword, role)) {

                    // UPDATING THE DATA INTO THE DATABASE
                    Account.updateProfile(details, id);

                    // this.data gets initialized to the changed data
                    username = tempUsername;
                    email = tempEmail;
                    password = tempPassword;
                    phNum = tempPhNum;
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

    private void gradeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeBtnActionPerformed

    }//GEN-LAST:event_gradeBtnActionPerformed

    private void studentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsTableMouseClicked


    }//GEN-LAST:event_studentsTableMouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked

    }//GEN-LAST:event_jPanel4MouseClicked

    private void gradeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeBtnMouseClicked
        // TODO add your handling code here:

        int selectedRow = studentsTable.getSelectedRow();

        if (selectedRow != -1) {

            // Getting the selected row
            int id = Integer.parseInt((String) studentsTable.getValueAt(selectedRow, 0));
            String name = (String) studentsTable.getValueAt(selectedRow, 1);
            String semester = (String) studentsTable.getValueAt(selectedRow, 2);
            String course = (String) studentsTable.getValueAt(selectedRow, 3);
            String email = (String) studentsTable.getValueAt(selectedRow, 4);

            gs = new GradeStudent(id, name, semester, course, email);
            gs.setVisible(true);
        }

    }//GEN-LAST:event_gradeBtnMouseClicked

    private void addAssignmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAssignmentBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addAssignmentBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
        this.questionDetails = TeacherAccount.getQuestions();
        contents.setQuestionsDetails(this.questionDetails, this);
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void addAssignmentBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addAssignmentBtnMouseClicked
        // TODO add your handling code here:
        assignment = new Assignment();
        assignment.setVisible(true);
    }//GEN-LAST:event_addAssignmentBtnMouseClicked

    private void uploadAnnouncementBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadAnnouncementBtnMouseClicked

        if (showConfirmationDialog("Do you want to upload the announcement? ")) {

            if (Validation.validateQuestionField(fullMessage.getText())) {

                String qs = fullMessage.getText();
                int semester = semesterCount.getValue();

                int uploaded = TeacherAccount.uploadAnnouncement(qs, semester);

                if (uploaded <= 0) {
                    JOptionPane.showMessageDialog(null, "Error uploading announcement.", "Add Announcement", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(null, "Successfully updated the Announcement.", "Add Announcement", JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }//GEN-LAST:event_uploadAnnouncementBtnMouseClicked

    private void uploadAnnouncementBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadAnnouncementBtnActionPerformed

    }//GEN-LAST:event_uploadAnnouncementBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addAnnouncementText;
    private javax.swing.JButton addAssignmentBtn;
    private javax.swing.JPanel announcementPanel;
    private javax.swing.JLabel announcementTitle;
    private javax.swing.JLabel assignmentSubText;
    private javax.swing.JLabel courseName;
    public javax.swing.JLabel date1;
    public javax.swing.JLabel date2;
    private javax.swing.JLabel directEmail;
    private javax.swing.JTextArea fullMessage;
    private javax.swing.JButton gradeBtn;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JTabbedPane mainBody;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel modulesCount;
    public javax.swing.JTextArea msg1;
    public javax.swing.JTextArea msg2;
    private javax.swing.JLabel newText;
    private javax.swing.JLabel notificationBtn;
    private javax.swing.JPanel panelFifth;
    private javax.swing.JPanel panelFirst;
    private javax.swing.JPanel panelFourth;
    private javax.swing.JPanel panelSecond;
    private javax.swing.JPanel panelThird;
    private javax.swing.JPasswordField profileConfirmPassword;
    private javax.swing.JTextField profileEmail;
    private javax.swing.JPasswordField profilePassword;
    private javax.swing.JTextField profilePhone;
    private javax.swing.JTextField profileUsername;
    public javax.swing.JLabel qsDate1;
    public javax.swing.JLabel qsDate2;
    public javax.swing.JLabel qsDate3;
    public javax.swing.JLabel qsLabel1;
    public javax.swing.JLabel qsLabel2;
    public javax.swing.JLabel qsLabel3;
    public javax.swing.JLabel qsLabel4;
    public javax.swing.JLabel qsLabel5;
    public javax.swing.JLabel qsLabel6;
    public javax.swing.JLabel qsMod1;
    public javax.swing.JLabel qsMod2;
    public javax.swing.JLabel qsMod3;
    public javax.swing.JLabel qsNo1;
    public javax.swing.JLabel qsNo2;
    public javax.swing.JLabel qsNo3;
    public javax.swing.JPanel qsPanel1;
    public javax.swing.JPanel qsPanel2;
    public javax.swing.JPanel qsPanel3;
    private javax.swing.JPanel questionsPanel;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField searchCourses;
    private javax.swing.JPanel secondAnnouncementPanel;
    private javax.swing.JSlider semesterCount;
    private javax.swing.JLabel stdPanelName;
    private javax.swing.JLabel studentCount;
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
    public javax.swing.JLabel teacher1;
    public javax.swing.JLabel teacher2;
    private javax.swing.JLabel teacherCount;
    private javax.swing.JButton uploadAnnouncementBtn;
    private javax.swing.JLabel usertypeShow;
    // End of variables declaration//GEN-END:variables
}
