package ru.handbook.servlets;

import ru.handbook.dao.hibernatedao.hibernatefactorydao.HibernateUserFactoryDAO;
import ru.handbook.dao.hibernatedao.hibernateobjdao.HibernateUserDAO;
import ru.handbook.model.objects.User;
import ru.handbook.view.UserInit;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

import static ru.handbook.Main.userInit;

public class LoginServlet extends HttpServlet {

//    UserFactoryDAO factoryDAO;
//    UserDAO userDAO;
    HibernateUserFactoryDAO factoryDAO;
    HibernateUserDAO userDAO;
    User user;
    private String login;
    private String password;

    @Override
    public void init() throws ServletException {
        factoryDAO = new HibernateUserFactoryDAO();
        userDAO = factoryDAO.factoryMethod();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/views/login.jsp");

        login = req.getParameter("login");
        password = req.getParameter("password");
        userInit = new UserInit(login, password);
        user = userInit.getUser();

        if (user.getName() != null && !user.getName().equals("")) {
            dispatcher = context.getRequestDispatcher("/views/main.jsp");
            dispatcher.include(req, res);
        } else {
            dispatcher.include(req, res);
        }
    }
}
