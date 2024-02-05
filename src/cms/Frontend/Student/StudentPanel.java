/*
 * @author kenabkc
 */
package cms.Frontend.Student;

import cms.Frontend.Person;
import cms.Backend.Account;
import cms.Backend.Logics;
import cms.Backend.StudentAccount;
import cms.Backend.Validation;
import static cms.Backend.Validation.namingConvention;
import cms.Frontend.CellRenderer.GradeCellRenderer;
import cms.Frontend.Login;
import static cms.Frontend.Student.StudentCourse.alignTableContents;
import static cms.Frontend.Student.StudentCourse.setTableAppearance;
import java.sql.ResultSet;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Desktop;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class StudentPanel extends javax.swing.JFrame {

    Answer a;

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

    public final static String role = "Student";

    private int courseId;
    private int students;
    private String semester;
    private String announcement[][];
    String questionDetails[][];

    DefaultTableModel model;
    DefaultTableModel model2;
    public int q1;

    public int q2;
    public int q3;

    /**
     * Creates new form StudentPanel
     */
    private Person p;

    public StudentPanel() {

        initComponents();

        newText.setVisible(false);
    }

    // GETTER METHODS ECAPSULATION
    public static String[] getterDetails() {
        String details[] = {StudentPanel.username, StudentPanel.email, StudentPanel.password, StudentPanel.phNum, String.valueOf(StudentPanel.id), StudentPanel.role};
        return details;
    }

    public void updateDetails() {

        // Updating the dashboard panel
        stdPanelName.setText(Person.getName());
        courseName.setText(this.course);
        studentCount.setText(String.valueOf(this.students));
        modulesCount.setText(this.modules);
        currentSemester.setText(this.semester);

        setAnnouncement(this.announcement);

        // Updating the course panel
        this.model = (DefaultTableModel) coursesTable.getModel();
        StudentCourse.updateDetails(courseId, coursesTable, "t1");
        alignTableContents(coursesTable);
        setTableAppearance(coursesTable);

        // Updating the Profile Panel
        profileUsername.setText(StudentPanel.username);
        profileEmail.setText(StudentPanel.email);
        profilePassword.setText(StudentPanel.password);
        profileConfirmPassword.setText(StudentPanel.password);
        profilePhone.setText(StudentPanel.phNum);

        // Updating the Grades Tables
        StudentCourse.updateDetails(StudentPanel.id, gradesTable, "t2");
        alignTableContents(gradesTable);
        setTableAppearance(gradesTable);
        gradesTable.getColumnModel().getColumn(4).setCellRenderer(new GradeCellRenderer());

        // UPating the activity when we log in
        Account.updateActivity("Login");
        boolean newNotifications = Account.checkNotifications();

        if (newNotifications) {

            newText.setVisible(true);
        }

        // Updating the Assignments Section
        setQuestionDetails(this.questionDetails);
        checkIfSubmitted();

    }

    private void checkIfSubmitted() {
        // Checks wether the assignments are submitted or not
        StudentAccount.checkStatus1(this);
        StudentAccount.checkStatus2(this);
        StudentAccount.checkStatus3(this);

    }

    public void setAnnouncement(String[][] data) {

        msg1.setText(data[0][0]);

        String fullName = data[0][1] + " " + data[0][2];

        teacher1.setText("- " + fullName);
        date1.setText(data[0][3]);

        if (data[1][0] == null) {
            msg2.setText("There has been only one announcement for this course.");
            teacher2.setVisible(false);
            date2.setVisible(false);
        } else {
            msg2.setText(data[1][0]);

            String fullName2 = data[1][1] + " " + data[1][2];

            teacher2.setText("- " + fullName2);
            date2.setText(data[1][3]);
        }

    }

    public void setQuestionDetails(String[][] data) {

        if (data[0][0] == null) {
            qsNo1.setText("No Assingments yet.");
            qsLabel1.setText("Assingments yet to assign by the respected teacher.");
            qsMod1.setText("Module Name");
            qsDate1.setText("Date of Question Posted");
            submitBtn1.setVisible(false);

            qsPanel2.setVisible(false);
            qsPanel3.setVisible(false);

        } else if (data[1][0] == null) {
            q1 = Integer.parseInt(data[0][0]);
            qsNo1.setText("Question Number " + data[0][0]);
            qsLabel1.setText(data[0][1]);
            qsMod1.setText(data[0][2]);
            qsDate1.setText(data[0][3]);

            qsPanel2.setVisible(false);
            qsPanel3.setVisible(false);

        } else if (data[1][0] != null && data[2][0] == null) {
            q1 = Integer.parseInt(data[0][0]);
            q2 = Integer.parseInt(data[1][0]);

            qsNo1.setText("Question Number " + data[0][0]);
            qsLabel1.setText(data[0][1]);
            qsMod1.setText(data[0][2]);
            qsDate1.setText(data[0][3]);

            qsNo2.setText("Question Number " + data[1][0]);
            qsLabel2.setText(data[1][1]);
            qsMod2.setText(data[1][2]);
            qsDate2.setText(data[1][3]);

            qsPanel3.setVisible(false);

        } else {
            // Storing the question numbers in a variable for future use
            q1 = Integer.parseInt(data[0][0]);
            q2 = Integer.parseInt(data[1][0]);
            q3 = Integer.parseInt(data[2][0]);

            // Setting all the texts
            qsNo1.setText("Question Number " + data[0][0]);
            qsNo2.setText("Question Number " + data[1][0]);
            qsNo3.setText("Question Number " + data[2][0]);

            qsLabel1.setText(data[0][1]);
            qsLabel2.setText(data[1][1]);
            qsLabel3.setText(data[2][1]);

            qsMod1.setText(data[0][2]);
            qsMod2.setText(data[1][2]);
            qsMod3.setText(data[2][2]);

            qsDate1.setText(data[0][3]);
            qsDate2.setText(data[1][3]);
            qsDate3.setText(data[2][3]);

        }

    }

    public void extractDetails() {
        try {
            ResultSet result = Account.getUserData(StudentPanel.username);
            if (result.next()) {
                StudentPanel.id = result.getInt("id");
                this.fName = result.getString("f_name");
                this.lName = result.getString("l_name");
                StudentPanel.email = result.getString("email");
                StudentPanel.phNum = result.getString("ph_num");
                StudentPanel.password = result.getString("password");
                this.course = result.getString("course");
                StudentPanel.date = result.getString("date_created");
                this.students = StudentAccount.getStudentCount(course);
                this.courseId = StudentAccount.getCourseId(course);
                this.modules = String.valueOf(Account.getModulesCount(courseId));
                this.announcement = StudentAccount.getAnnouncementData(courseId);
                this.semester = StudentAccount.getSemester(StudentPanel.date);

                this.p = new Person(this.fName, this.lName, id, this.course, role, this.courseId);

                this.questionDetails = StudentAccount.getQuestions();

            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
     * @param username
     */
    @Override
    public void setName(String username) {
        StudentPanel.username = username;
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
        modulesCount = new javax.swing.JLabel();
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
        currentSemester = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        panelSecond = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        tableScrollPanel = new javax.swing.JScrollPane();
        coursesTable = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        searchCourses = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        panelThird = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        tableScrollPanel1 = new javax.swing.JScrollPane();
        gradesTable = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        searchGrades = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        panelFourth = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        questionsPanel = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        qsPanel2 = new javax.swing.JPanel();
        qsMod2 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        qsDate2 = new javax.swing.JLabel();
        qsNo2 = new javax.swing.JLabel();
        qsLabel2 = new javax.swing.JLabel();
        submitBtn2 = new javax.swing.JButton();
        qsPanel1 = new javax.swing.JPanel();
        qsMod1 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        qsDate1 = new javax.swing.JLabel();
        qsNo1 = new javax.swing.JLabel();
        qsLabel1 = new javax.swing.JLabel();
        submitBtn1 = new javax.swing.JButton();
        qsPanel3 = new javax.swing.JPanel();
        qsMod3 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        qsDate3 = new javax.swing.JLabel();
        qsNo3 = new javax.swing.JLabel();
        qsLabel3 = new javax.swing.JLabel();
        submitBtn3 = new javax.swing.JButton();
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
        setTitle("CMS - Student Panel");
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
        tabBtn3.setText("Grades");

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
        usertypeShow.setText("Student");

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
        jLabel13.setText("Modules");

        modulesCount.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        modulesCount.setText("9");

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/monitor.png"))); // NOI18N
        jLabel24.setMaximumSize(new java.awt.Dimension(24, 24));
        jLabel24.setMinimumSize(new java.awt.Dimension(24, 24));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modulesCount)
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
                .addComponent(modulesCount)
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
        jLabel8.setText("Current Semester");

        currentSemester.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        currentSemester.setText("2nd");

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/courseBig.png"))); // NOI18N
        jLabel22.setMaximumSize(new java.awt.Dimension(24, 24));
        jLabel22.setMinimumSize(new java.awt.Dimension(24, 24));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentSemester)
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
                .addComponent(currentSemester)
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

        tableScrollPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(241, 240, 255), null));
        tableScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        coursesTable.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        coursesTable.setForeground(new java.awt.Color(51, 51, 51));
        coursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Module", "Courses", "Semester", "Instructor"
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
        coursesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        coursesTable.setGridColor(new java.awt.Color(238, 238, 238));
        coursesTable.setIgnoreRepaint(true);
        coursesTable.getTableHeader().setReorderingAllowed(false);
        tableScrollPanel.setViewportView(coursesTable);
        if (coursesTable.getColumnModel().getColumnCount() > 0) {
            coursesTable.getColumnModel().getColumn(0).setResizable(false);
            coursesTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            coursesTable.getColumnModel().getColumn(1).setResizable(false);
            coursesTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            coursesTable.getColumnModel().getColumn(2).setResizable(false);
            coursesTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            coursesTable.getColumnModel().getColumn(3).setResizable(false);
            coursesTable.getColumnModel().getColumn(3).setPreferredWidth(30);
            coursesTable.getColumnModel().getColumn(4).setResizable(false);
            coursesTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(241, 240, 255), null));

        searchCourses.setForeground(new java.awt.Color(158, 160, 170));
        searchCourses.setText("Search course...");
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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

        tableScrollPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(241, 240, 255), null));
        tableScrollPanel1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        gradesTable.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        gradesTable.setForeground(new java.awt.Color(51, 51, 51));
        gradesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Module ID", "Module", "Semester", "Percentage", "Grade"
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
        gradesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gradesTable.setGridColor(new java.awt.Color(238, 238, 238));
        gradesTable.setIgnoreRepaint(true);
        gradesTable.setRowHeight(25);
        gradesTable.getTableHeader().setReorderingAllowed(false);
        tableScrollPanel1.setViewportView(gradesTable);
        if (gradesTable.getColumnModel().getColumnCount() > 0) {
            gradesTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            gradesTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            gradesTable.getColumnModel().getColumn(2).setPreferredWidth(30);
            gradesTable.getColumnModel().getColumn(3).setPreferredWidth(30);
            gradesTable.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(241, 240, 255), null));

        searchGrades.setForeground(new java.awt.Color(158, 160, 170));
        searchGrades.setText("Search course...");
        searchGrades.setBorder(null);
        searchGrades.setName(""); // NOI18N
        searchGrades.setPreferredSize(new java.awt.Dimension(64, 24));
        searchGrades.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchGradesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchGradesFocusLost(evt);
            }
        });
        searchGrades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchGradesMouseClicked(evt);
            }
        });
        searchGrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchGradesActionPerformed(evt);
            }
        });
        searchGrades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchGradesKeyReleased(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cms/Icons/search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchGrades, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(searchGrades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tableScrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tableScrollPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelThirdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainBody.addTab("tab3", panelThird);

        jPanel6.setBackground(new java.awt.Color(250, 250, 250));

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

        submitBtn2.setBackground(new java.awt.Color(241, 240, 255));
        submitBtn2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        submitBtn2.setForeground(new java.awt.Color(108, 99, 255));
        submitBtn2.setText("Submit Assignment");
        submitBtn2.setBorder(null);
        submitBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitBtn2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout qsPanel2Layout = new javax.swing.GroupLayout(qsPanel2);
        qsPanel2.setLayout(qsPanel2Layout);
        qsPanel2Layout.setHorizontalGroup(
            qsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qsPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(qsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(qsPanel2Layout.createSequentialGroup()
                        .addGroup(qsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qsPanel2Layout.createSequentialGroup()
                                .addComponent(qsMod2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(submitBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(qsPanel2Layout.createSequentialGroup()
                                .addGroup(qsPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(qsNo2)
                                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(32, 32, 32))
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
                    .addComponent(submitBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qsMod2))
                .addGap(24, 24, 24)
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

        submitBtn1.setBackground(new java.awt.Color(241, 240, 255));
        submitBtn1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        submitBtn1.setForeground(new java.awt.Color(108, 99, 255));
        submitBtn1.setText("Submit Assignment");
        submitBtn1.setBorder(null);
        submitBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitBtn1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout qsPanel1Layout = new javax.swing.GroupLayout(qsPanel1);
        qsPanel1.setLayout(qsPanel1Layout);
        qsPanel1Layout.setHorizontalGroup(
            qsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qsPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(qsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(qsPanel1Layout.createSequentialGroup()
                        .addGroup(qsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qsPanel1Layout.createSequentialGroup()
                                .addComponent(qsMod1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(submitBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(qsPanel1Layout.createSequentialGroup()
                                .addGroup(qsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(qsNo1)
                                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(32, 32, 32))
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
                    .addComponent(submitBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qsMod1))
                .addGap(24, 24, 24)
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

        submitBtn3.setBackground(new java.awt.Color(241, 240, 255));
        submitBtn3.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        submitBtn3.setForeground(new java.awt.Color(108, 99, 255));
        submitBtn3.setText("Submit Assignment");
        submitBtn3.setBorder(null);
        submitBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitBtn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitBtn3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout qsPanel3Layout = new javax.swing.GroupLayout(qsPanel3);
        qsPanel3.setLayout(qsPanel3Layout);
        qsPanel3Layout.setHorizontalGroup(
            qsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qsPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(qsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(qsPanel3Layout.createSequentialGroup()
                        .addGroup(qsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qsPanel3Layout.createSequentialGroup()
                                .addComponent(qsMod3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(submitBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(qsPanel3Layout.createSequentialGroup()
                                .addGroup(qsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(qsNo3)
                                    .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(32, 32, 32))
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
                    .addComponent(submitBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qsMod3))
                .addGap(24, 24, 24)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(qsPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qsPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(44, 44, 44))
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(questionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addComponent(questionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelFourthLayout = new javax.swing.GroupLayout(panelFourth);
        panelFourth.setLayout(panelFourthLayout);
        panelFourthLayout.setHorizontalGroup(
            panelFourthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelFourthLayout.setVerticalGroup(
            panelFourthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
        if (Logics.showConfirmationDialog()) {
            // Setting the logout time
            Account.updateActivity("Logout");
            dispose();
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_logoutBtnMouseClicked

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed


    }//GEN-LAST:event_logoutBtnActionPerformed

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

    private void searchCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCoursesActionPerformed

    }//GEN-LAST:event_searchCoursesActionPerformed

    private void searchCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchCoursesMouseClicked


    }//GEN-LAST:event_searchCoursesMouseClicked

    private void searchCoursesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchCoursesFocusGained

        if (searchCourses.getText().equals("Search course...")) {
            searchCourses.setText("");
            searchCourses.setForeground(Color.BLACK);
        }

    }//GEN-LAST:event_searchCoursesFocusGained

    private void searchCoursesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchCoursesFocusLost

        if (searchCourses.getText().isEmpty()) {
            searchCourses.setText("Search course...");
            searchCourses.setForeground(new Color(158, 160, 170));
        }
    }//GEN-LAST:event_searchCoursesFocusLost

    private void searchCoursesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchCoursesKeyReleased

        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(this.model);
        coursesTable.setRowSorter(obj1);
        RowFilter filterRow = RowFilter.regexFilter(searchCourses.getText());
        obj1.setRowFilter(filterRow);

    }//GEN-LAST:event_searchCoursesKeyReleased

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed

    }//GEN-LAST:event_saveBtnActionPerformed

    private void profileUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileUsernameActionPerformed

    }//GEN-LAST:event_profileUsernameActionPerformed

    private void saveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseClicked

        if (Logics.showConfirmationDialog()) {

            String tempUsername = profileUsername.getText();
            String tempEmail = profileEmail.getText();
            String tempPassword = profilePassword.getText();
            String tempPhNum = profilePhone.getText();
            String tempConfirmPassword = profileConfirmPassword.getText();

            String details[] = {tempUsername, tempEmail, tempPassword, tempPhNum};

            if (tempUsername.equals(StudentPanel.username) && tempEmail.equals(StudentPanel.email) && tempPassword.equals(StudentPanel.password) && tempPhNum.equals(StudentPanel.phNum)) {

                JOptionPane.showMessageDialog(null, namingConvention("blankValue"), "Profile Update Error", JOptionPane.INFORMATION_MESSAGE);

            } else {

                // Validating the details that the user wants to change
                if (Validation.validateDetails(details, tempConfirmPassword, role)) {

                    // UPDATING THE DATA INTO THE DATABASE
                    Account.updateProfile(details, StudentPanel.id);

                    // this.data gets initialized to the changed data
                    StudentPanel.username = tempUsername;
                    StudentPanel.email = tempEmail;
                    StudentPanel.password = tempPassword;
                    StudentPanel.phNum = tempPhNum;
                }

            }

        }

    }//GEN-LAST:event_saveBtnMouseClicked

    private void profileEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileEmailActionPerformed

    }//GEN-LAST:event_profileEmailActionPerformed

    private void profileConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileConfirmPasswordActionPerformed

    }//GEN-LAST:event_profileConfirmPasswordActionPerformed

    private void profileUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profileUsernameFocusGained

        Logics.handleFocusGainedLost(profileUsername, StudentPanel.username, new Color(158, 160, 170), evt);

    }//GEN-LAST:event_profileUsernameFocusGained

    private void profileUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profileUsernameFocusLost

        Logics.handleFocusGainedLost(profileUsername, StudentPanel.username, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profileUsernameFocusLost

    private void profileEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profileEmailFocusGained

        Logics.handleFocusGainedLost(profileEmail, StudentPanel.email, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profileEmailFocusGained

    private void profileEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profileEmailFocusLost

        Logics.handleFocusGainedLost(profileEmail, StudentPanel.email, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profileEmailFocusLost

    private void profilePasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profilePasswordFocusGained

        Logics.handleFocusGainedLost(profilePassword, StudentPanel.password, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profilePasswordFocusGained

    private void profilePasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profilePasswordFocusLost

        Logics.handleFocusGainedLost(profilePassword, StudentPanel.password, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profilePasswordFocusLost

    private void profileConfirmPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profileConfirmPasswordFocusGained

        Logics.handleFocusGainedLost(profileConfirmPassword, StudentPanel.password, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profileConfirmPasswordFocusGained

    private void profileConfirmPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profileConfirmPasswordFocusLost

        Logics.handleFocusGainedLost(profileConfirmPassword, StudentPanel.password, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profileConfirmPasswordFocusLost

    private void profilePhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profilePhoneFocusGained

        Logics.handleFocusGainedLost(profilePhone, StudentPanel.phNum, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profilePhoneFocusGained

    private void profilePhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_profilePhoneFocusLost
        Logics.handleFocusGainedLost(profilePhone, StudentPanel.phNum, new Color(158, 160, 170), evt);
    }//GEN-LAST:event_profilePhoneFocusLost

    private void profilePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilePasswordActionPerformed

    }//GEN-LAST:event_profilePasswordActionPerformed

    private void directEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_directEmailMouseClicked

        try {
            Desktop.getDesktop().browse(new URL("https://mail.google.com/mail/u/0/#inbox").toURI());
        } catch (Exception e) {
            System.out.println("Error opening the url.");
        }
    }//GEN-LAST:event_directEmailMouseClicked

    private void searchGradesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchGradesFocusGained
        // TODO add your handling code here:
        if (searchGrades.getText().equals("Search course...")) {
            searchGrades.setText("");
            searchGrades.setForeground(Color.BLACK);
        }

    }//GEN-LAST:event_searchGradesFocusGained

    private void searchGradesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchGradesFocusLost
        // TODO add your handling code here:
        if (searchGrades.getText().isEmpty()) {
            searchGrades.setText("Search course...");
            searchGrades.setForeground(new Color(158, 160, 170));
        }
    }//GEN-LAST:event_searchGradesFocusLost

    private void searchGradesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchGradesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchGradesMouseClicked

    private void searchGradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchGradesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchGradesActionPerformed

    private void searchGradesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchGradesKeyReleased
        // TODO add your handling code here:

        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(this.model2);
        gradesTable.setRowSorter(obj1);
        RowFilter filterRow = RowFilter.regexFilter(searchGrades.getText());
        obj1.setRowFilter(filterRow);
    }//GEN-LAST:event_searchGradesKeyReleased

    private void notificationBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationBtnMouseClicked
        // TODO add your handling code here:
        System.out.println("OK");

        if (newText.isShowing()) {
            Notification n1 = new Notification();
            n1.setVisible(true);
            newText.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(null, "No new announcements yet.", "No Announcements", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_notificationBtnMouseClicked

    private void submitBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtn1MouseClicked

        // If the assignment is already submitted: Returns and does not do anything
        if (submitBtn1.getText().equals("Submitted")) {
            return;
        } // Else ,a new Answer class is called to submit the answer : we pass the current object
        a = new Answer(q1, StudentPanel.id, 1, this);
        a.setVisible(true);
    }//GEN-LAST:event_submitBtn1MouseClicked

    private void submitBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtn2MouseClicked

        if (submitBtn2.getText().equals("Submitted")) {
            return;
        }
        a = new Answer(q2, StudentPanel.id, 2, this);
        a.setVisible(true);
    }//GEN-LAST:event_submitBtn2MouseClicked

    private void submitBtn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtn3MouseClicked

        // TODO add your handling code here:
        if (submitBtn3.getText().equals("Submitted")) {
            return;
        }
        a = new Answer(q3, StudentPanel.id, 3, this);
        a.setVisible(true);
    }//GEN-LAST:event_submitBtn3MouseClicked
    public void setButtonState(boolean enabled) {

        submitBtn1.setText("Submitted");
        submitBtn1.setBackground(Color.red);
        submitBtn1.setEnabled(false);

    }

    public void setButtonState2(boolean enabled) {
        submitBtn2.setText("Submitted");
        submitBtn2.setEnabled(false);

    }

    public void setButtonState3(boolean enabled) {
        submitBtn3.setText("Submitted");
        submitBtn3.setEnabled(false);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        try {
            FlatLightLaf.setup();
        } catch (Exception e) {
            System.out.println("Error in Flatlaf: " + e);
        }

        StudentPanel s = new StudentPanel();
        s.setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel announcementPanel;
    private javax.swing.JLabel announcementTitle;
    private javax.swing.JLabel courseName;
    private javax.swing.JTable coursesTable;
    private javax.swing.JLabel currentSemester;
    private javax.swing.JLabel date1;
    private javax.swing.JLabel date2;
    private javax.swing.JLabel directEmail;
    private javax.swing.JTable gradesTable;
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
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JTabbedPane mainBody;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel modulesCount;
    private javax.swing.JTextArea msg1;
    private javax.swing.JTextArea msg2;
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
    private javax.swing.JLabel qsDate1;
    private javax.swing.JLabel qsDate2;
    private javax.swing.JLabel qsDate3;
    private javax.swing.JLabel qsLabel1;
    private javax.swing.JLabel qsLabel2;
    private javax.swing.JLabel qsLabel3;
    private javax.swing.JLabel qsMod1;
    private javax.swing.JLabel qsMod2;
    private javax.swing.JLabel qsMod3;
    private javax.swing.JLabel qsNo1;
    private javax.swing.JLabel qsNo2;
    private javax.swing.JLabel qsNo3;
    private javax.swing.JPanel qsPanel1;
    private javax.swing.JPanel qsPanel2;
    private javax.swing.JPanel qsPanel3;
    private javax.swing.JPanel questionsPanel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField searchCourses;
    private javax.swing.JTextField searchGrades;
    private javax.swing.JPanel secondAnnouncementPanel;
    private javax.swing.JLabel stdPanelName;
    private javax.swing.JLabel studentCount;
    public static javax.swing.JButton submitBtn1;
    private javax.swing.JButton submitBtn2;
    private javax.swing.JButton submitBtn3;
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
    private javax.swing.JLabel teacher1;
    private javax.swing.JLabel teacher2;
    private javax.swing.JLabel usertypeShow;
    // End of variables declaration//GEN-END:variables

}
