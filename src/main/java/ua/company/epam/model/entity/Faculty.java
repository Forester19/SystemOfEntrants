package ua.company.epam.model.entity;

/**
 * Created by Владислав on 08.09.2017.
 */
public class Faculty implements Identified<Integer>{
    private int id;
    private String name;
    private int maxCountOfStudents;
    private int subject1;
    private int subject2;
    private int subject3;

    public Faculty(String name, int maxCountOfStudents, int subject1, int subject2, int subject3) {
        this.name = name;
        this.maxCountOfStudents = maxCountOfStudents;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }
    public Faculty(int id, String name, int maxCountOfStudents, int subject1, int subject2, int subject3) {
        this.id = id;
        this.name = name;
        this.maxCountOfStudents = maxCountOfStudents;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }

    public Faculty() {
        super();
    }

    @Override
    public Integer getPK() {
        return id;
    }

    public int getMaxCountOfStudents() {
        return maxCountOfStudents;
    }

    public int getSubject1() {
        return subject1;
    }

    public void setSubject1(int subject1) {
        this.subject1 = subject1;
    }

    public int getSubject2() {
        return subject2;
    }

    public void setSubject2(int subject2) {
        this.subject2 = subject2;
    }

    public int getSubject3() {
        return subject3;
    }

    public void setSubject3(int subject3) {
        this.subject3 = subject3;
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
