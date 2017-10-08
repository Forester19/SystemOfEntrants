package ua.company.bl.view;

import ua.company.bl.MainBL;
import ua.company.model.dao.impl.FacultiesDAO;
import ua.company.model.dao.impl.MarksDAO;
import ua.company.model.dao.impl.UserDAO;
import ua.company.model.entity.User;
import ua.company.model.entity.additional.ModelOfUserForShow;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 02.10.2017.
 */
public class ShowUsersInfo {
    private MainBL mainBL = new MainBL();
    private UserDAO userDAO = new UserDAO();
    private MarksDAO marksDAO = new MarksDAO();
    private FacultiesDAO facultiesDAO = new FacultiesDAO();
    private List<ModelOfUserForShow> list = new ArrayList<>();
    public List<ModelOfUserForShow> showInfo(){
        for (User user : userDAO.getAll()) {
            ModelOfUserForShow modelOfUserForShow = new ModelOfUserForShow();
            modelOfUserForShow.setFn(user.getFirstName());
            modelOfUserForShow.setLn(user.getLastName());
            modelOfUserForShow.setEmail(user.getEmail());
            modelOfUserForShow.setFac(facultiesDAO.getById(user.getFaculty_id()).getName());
            try {
                modelOfUserForShow.setMarkVal1(marksDAO.getMarksByUser(user).getMark_1());
                modelOfUserForShow.setMarkVal2(marksDAO.getMarksByUser(user).getMark_2());
                modelOfUserForShow.setMarkVal3(marksDAO.getMarksByUser(user).getMark_3());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            list.add(modelOfUserForShow);
        }
        return list;
    }
}
