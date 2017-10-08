package ua.company.model.entity;

/**
 * Created by Владислав on 02.10.2017.
 */
public class Users_Marks implements Identified<Integer> {
    private int user_id;
    private int marks_id;

    public Users_Marks() {
    }

    public Users_Marks(int user_id, int marks_id) {
        this.user_id = user_id;
        this.marks_id = marks_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMarks_id() {
        return marks_id;
    }

    public void setMarks_id(int marks_id) {
        this.marks_id = marks_id;
    }

    @Override
    public Integer getPK() {
        return null;
    }
}
