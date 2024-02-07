/**
 *
 * @author kenabkc
 */
package cms.Frontend;

public class Person {

    private static String fName;
    private static String lName;
    private static int id;
    private static String course;
    private static String role;
    private static int courseId;
    private static int semester;
    private static int overallPerformance;

    // FOR ADMIN 
    public Person(String fName, String lName, int id) {
        Person.fName = fName;
        Person.lName = lName;
        Person.id = id;
    }

    // FOR STUDENT & TEACHERS
    public Person(String fName, String lName, int id, String course, String role, int courseId) {
        Person.fName = fName;
        Person.lName = lName;
        Person.id = id;
        Person.course = course;
        Person.role = role;
        Person.courseId = courseId;
    }

    // Gets the name of the person
    public static String getName() {
        return fName + " " + lName;
    }

    // Gets the role of the person
    public static String getRole() {
        return role;
    }

    // Gets the id of the person
    public static int getId() {
        return id;
    }

    public static String getCourseName() {
        return course;
    }

    // Gets the course id of the person if std and teacher
    public static int getCourseId() {
        return courseId;
    }

    // ---------------- + ENCAPSULATION + ----------------
    // Sets the semester of the student
    public static void setSemester(int sem) {
        Person.semester = sem;
    }

    public static int getSemester() {
        return Person.semester;
    }

    public static void setOverallPerformance(int overall) {
        overallPerformance = overall;
    }

    public static int getOverallPerformance() {
        return overallPerformance;
    }

}
