package ua.company.model.entity;

/**
 * Created by Владислав on 28.10.2017.
 */
public class User {
    private int id;
    private String firstName;
    private String secondName;
    private String email;
    private int faciltetId;
    private boolean markedByAdmin;
    private boolean successfulEntry;
    private int role;

    public User(int id, String firstName, String secondName, String email, int faciltetId, boolean markedByAdmin, boolean successfulEntry, int role) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.faciltetId = faciltetId;
        this.markedByAdmin = markedByAdmin;
        this.successfulEntry = successfulEntry;
        this.role = role;
    }

    public User() {
    }

    public User(int id, String firstName, String secondName, String email, int faciltetId, boolean markedByAdmin, boolean successfulEntry) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.faciltetId = faciltetId;
        this.markedByAdmin = markedByAdmin;
        this.successfulEntry = successfulEntry;
    }

    public User(String firstName, String secondName, String email, int faciltetId, boolean markedByAdmin, boolean successfulEntry) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.faciltetId = faciltetId;
        this.markedByAdmin = markedByAdmin;
        this.successfulEntry = successfulEntry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFaciltetId() {
        return faciltetId;
    }

    public void setFaciltetId(int faciltetId) {
        this.faciltetId = faciltetId;
    }

    public boolean isMarkedByAdmin() {
        return markedByAdmin;
    }

    public void setMarkedByAdmin(boolean markedByAdmin) {
        this.markedByAdmin = markedByAdmin;
    }

    public boolean isSuccessfulEntry() {
        return successfulEntry;
    }

    public void setSuccessfulEntry(boolean successfulEntry) {
        this.successfulEntry = successfulEntry;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", faciltetId=" + faciltetId +
                ", markedByAdmin=" + markedByAdmin +
                ", successfulEntry=" + successfulEntry +
                ", role=" + role +
                '}';
    }
}
