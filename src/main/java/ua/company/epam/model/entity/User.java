package ua.company.epam.model.entity;

/**
 * Created by Владислав on 11.09.2017.
 */
public class User implements Identified<Integer>{

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int faculty_id;
    private boolean noted_by_admin;
    private boolean successful_entry;


    public User(int id, String firstName, String lastName, String email, int faculty_id, boolean noted_by_admin, boolean successful_entry) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.faculty_id = faculty_id;
       this.noted_by_admin = noted_by_admin;
        this.successful_entry = successful_entry;
    }

    public User(String firstName, String lastName, String email, int faculty_id, boolean noted_by_admin, boolean successful_entry) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.faculty_id = faculty_id;
        this.noted_by_admin = noted_by_admin;
        this.successful_entry = successful_entry;
    }

    public User() {
    }

    @Override
    public Integer getPK() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", faculty_id=" + faculty_id +
                ", noted_by_admin=" + noted_by_admin +
                ", successful_entry=" + successful_entry +
                '}';
    }
}
