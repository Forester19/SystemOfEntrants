package ua.company.model.entity.additional;

/**
 * Created by Владислав on 02.10.2017.
 */
public class ModelOfUserForShow {
    private String fn;
    private String ln;
    private String email;
    private String fac;
    private int markVal1;
    private int markVal2;
    private int markVal3;

    public ModelOfUserForShow(String fn, String ln, String email, String fac, int markVal1, int markVal2,int markVal3) {
        this.fn = fn;
        this.ln = ln;
        this.email = email;
        this.fac = fac;
        this.markVal1 = markVal1;
        this.markVal2 = markVal2;
        this.markVal3 =markVal3;
    }

    public int getMarkVal3() {
        return markVal3;
    }

    public void setMarkVal3(int markVal3) {
        this.markVal3 = markVal3;
    }

    public ModelOfUserForShow() {
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFac() {
        return fac;
    }

    public void setFac(String fac) {
        this.fac = fac;
    }

    public int getMarkVal1() {
        return markVal1;
    }

    public void setMarkVal1(int markVal1) {
        this.markVal1 = markVal1;
    }

    public int getMarkVal2() {
        return markVal2;
    }

    public void setMarkVal2(int markVal2) {
        this.markVal2 = markVal2;
    }
}
