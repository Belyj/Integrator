package ru.handbook.servlets;

import ru.handbook.dao.dbdao.mysql.mysqlfactorydao.MySQLUserFactoryDAOImpl;
import ru.handbook.dao.objectsdao.UserDAO;
import ru.handbook.dao.objectsdao.UserFactoryDAO;
import ru.handbook.model.objects.User;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    UserFactoryDAO factoryDAO;
    UserDAO userDAO;
    User user;
    private String login;
    private String password;

    @Override
    public void init() throws ServletException {
        factoryDAO = new MySQLUserFactoryDAOImpl();
        userDAO = factoryDAO.factoryMethod();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/views/login.jsp");

        login = req.getParameter("login");
        password = req.getParameter("password");
        System.out.println("login: " + login + "\tpassword: " + password);
        user = userDAO.getByParams(login, password);
        System.out.println("ID: " + user.getId() + "\tName: " + user.getName());

        if (user.getName() != null && !user.getName().equals("")) {
            dispatcher = context.getRequestDispatcher("/views/main.jsp");
            dispatcher.include(req, res);
        } else {
            dispatcher.include(req, res);
        }
    }
}
