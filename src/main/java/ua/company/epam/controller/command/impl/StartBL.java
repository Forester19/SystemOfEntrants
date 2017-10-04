package ua.company.epam.controller.command.impl;

import ua.company.epam.bl.MainBL;
import ua.company.epam.controller.command.GenericCommand.CommandOriginal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Владислав on 03.10.2017.
 */
public class StartBL implements CommandOriginal {

    private MainBL mainBL = new MainBL();
    @Override
    public void execute(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {


        System.out.println(mainBL.doMainBL().toString());

    }


}
