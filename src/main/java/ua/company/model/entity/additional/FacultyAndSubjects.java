package ua.company.model.entity.additional;

import ua.company.model.entity.Faculty;
import ua.company.model.entity.Subject;

/**
 * Created by Владислав on 01.10.2017.
 */
public class FacultyAndSubjects {
    private Faculty faculty;
    private Subject subject1;
    private Subject subject2;
    private Subject subject3;

    public FacultyAndSubjects(Faculty faculty, Subject subject1, Subject subject2, Subject subject3) {
        this.faculty = faculty;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }

    public FacultyAndSubjects() {
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Subject getSubject1() {
        return subject1;
    }

    public void setSubject1(Subject subject1) {
        this.subject1 = subject1;
    }

    public Subject getSubject2() {
        return subject2;
    }

    public void setSubject2(Subject subject2) {
        this.subject2 = subject2;
    }

    public Subject getSubject3() {
        return subject3;
    }

    public void setSubject3(Subject subject3) {
        this.subject3 = subject3;
    }
}
