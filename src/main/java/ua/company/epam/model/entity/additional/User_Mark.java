package ua.company.epam.model.entity.additional;

import ua.company.epam.model.entity.Identified;

/**
 * Created by Владислав on 04.10.2017.
 */
public class User_Mark implements Identified<Integer>{

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int faculty_id;
    private boolean noted_by_admin;
    private boolean successful_entry;

    private int mark_1;
    private int mark_2;
    private int mark_3;

    public User_Mark(int id, String firstName, String lastName, String email, int faculty_id, boolean noted_by_admin, boolean successful_entry, int mark_1, int mark_2, int mark_3) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.faculty_id = faculty_id;
        this.noted_by_admin = noted_by_admin;
        this.successful_entry = successful_entry;
        this.mark_1 = mark_1;
        this.mark_2 = mark_2;
        this.mark_3 = mark_3;
    }

    public User_Mark(String firstName, String lastName, String email, int faculty_id, boolean noted_by_admin, boolean successful_entry, int mark_1, int mark_2, int mark_3) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.faculty_id = faculty_id;
        this.noted_by_admin = noted_by_admin;
        this.successful_entry = successful_entry;
        this.mark_1 = mark_1;
        this.mark_2 = mark_2;
        this.mark_3 = mark_3;
    }

    public User_Mark() {
    }

    @Override
    public Integer getPK() {
        return null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(int faculty_id) {
        this.faculty_id = faculty_id;
    }

    public boolean isNoted_by_admin() {
        return noted_by_admin;
    }

    public void setNoted_by_admin(boolean noted_by_admin) {
        this.noted_by_admin = noted_by_admin;
    }

    public boolean isSuccessful_entry() {
        return successful_entry;
    }

    public void setSuccessful_entry(boolean successful_entry) {
        this.successful_entry = successful_entry;
    }

    public int getMark_1() {
        return mark_1;
    }

    public void setMark_1(int mark_1) {
        this.mark_1 = mark_1;
    }

    public int getMark_2() {
        return mark_2;
    }

    public void setMark_2(int mark_2) {
        this.mark_2 = mark_2;
    }

    public int getMark_3() {
        return mark_3;
    }

    public void setMark_3(int mark_3) {
        this.mark_3 = mark_3;
    }

    @Override
    public String toString() {
        return "User_Mark{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", faculty_id=" + faculty_id +
                ", noted_by_admin=" + noted_by_admin +
                ", successful_entry=" + successful_entry +
                ", mark_1=" + mark_1 +
                ", mark_2=" + mark_2 +
                ", mark_3=" + mark_3 +
                '}';
    }
}
