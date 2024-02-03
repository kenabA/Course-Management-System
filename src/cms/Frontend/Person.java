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

    public static String getName() {
        return fName + "" + lName;
    }

    public static String getRole() {
        return role;
    }

    public static int getId() {
        return id;
    }

    public static int getCourseId() {
        System.out.println("THE INNER COURSE ID :" + courseId);
        return courseId;
    }

    public static void setSemester(int sem) {
        Person.semester = sem;
    }

    public static int getSemester() {
        return Person.semester;
    }

}
