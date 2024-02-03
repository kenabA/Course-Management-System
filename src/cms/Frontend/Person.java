package cms.Frontend;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author kenabkc
 */
public class Person {

    private String fName;
    private String lName;
    private int id;
    private String course;
    private String role;

    // FOR ADMIN 
    public Person(String fName, String lName, int id) {
        this.fName = fName;
        this.lName = lName;
        this.id = id;
    }

    public String getName() {
        return this.fName + " " + this.lName;
    }

    public String getRole() {
        return this.role;
    }

    public int getId() {
        return this.id;
    }

    // FOR STUDENT & TEACHERS
    public Person(String fName, String lName, int id, String course, String role) {
        this.fName = fName;
        this.lName = lName;
        this.id = id;
        this.course = course;
        this.role = role;
    }
}
