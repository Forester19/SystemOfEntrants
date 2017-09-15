package ua.company.epam.model;

/**
 * Created by Владислав on 08.09.2017.
 */
public class Faculty {
    private String name;
    private int maxCountOfStudents;

    public Faculty(String name, int maxValueOfStudents) {
        this.name = name;
        this.maxCountOfStudents = maxValueOfStudents;
    }

    public int getMaxCountOfStudents() {
        return maxCountOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxCountOfStudents(int maxCountOfStudents) {
        this.maxCountOfStudents = maxCountOfStudents;
    }

    @Override
    public String toString() {
        return name;
    }
}
