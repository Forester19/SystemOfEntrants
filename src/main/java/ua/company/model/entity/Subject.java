package ua.company.model.entity;

/**
 * Created by Владислав on 30.09.2017.
 */
public class Subject {
    private int subjectId;
    private String subjectTitle;

    public Subject(int subjectId, String subjectTitle) {
        this.subjectId = subjectId;
        this.subjectTitle = subjectTitle;
    }

    public Subject() {
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }
}
