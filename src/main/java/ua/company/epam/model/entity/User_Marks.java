package ua.company.epam.model.entity;

/**
 * Created by Владислав on 25.09.2017.
     Entity which persist object from DB
 */
public class User_Marks implements Identified<Integer>{
    private int user_id;
    private int mark_1;
    private int mark_2;
    private int mark_3;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
    public Integer getPK() {
        return user_id;
    }
}
