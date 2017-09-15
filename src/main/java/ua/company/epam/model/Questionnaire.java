package ua.company.epam.model;

/**
 * Created by Владислав on 11.09.2017.
 */
public class Questionnaire {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Faculty faculty;
    private int mathScope;
    private int ukrainianLangScope;

    public Questionnaire(String firstName, String lastName, String email, Faculty faculty, int mathScope, int ukrainianLangScope) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.faculty = faculty;
        this.mathScope = mathScope;
        this.ukrainianLangScope = ukrainianLangScope;
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

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getMathScope() {
        return mathScope;
    }

    public void setMathScope(int mathScope) {
        this.mathScope = mathScope;
    }

    public int getUkrainianLangScope() {
        return ukrainianLangScope;
    }

    public void setUkrainianLangScope(int ukrainianLangScope) {
        this.ukrainianLangScope = ukrainianLangScope;
    }

    @Override
    public String toString() {
        return "  " + firstName +" "+lastName +" "+email + " " +faculty +" "+mathScope +" "+ukrainianLangScope;
    }
}
