package ru.handbook.servlets.statistics;

import org.apache.log4j.Logger;
import ru.handbook.dao.hibernatedao.hibernateobjdao.HibernateUserDAO;
import ru.handbook.dao.hibernatedao.hibernateobjdao.impl.HibernateUserDAOImpl;
import ru.handbook.model.objects.User;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

public class UserContactsCount extends HttpServlet {

    private static final Logger log = Logger.getLogger(UserContactsCount.class);

    // MySQLUserDAOImpl userDAO = MySQLUserDAOImpl.getInstance();
    HibernateUserDAO userDAO;
    List<User> users;

    @Override
    public void init() throws ServletException {
        log.info("Инициализация");
        userDAO = HibernateUserDAOImpl.getInstance();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        log.info("Запрос: ");
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher;
        users = userDAO.userContactsCount();
        req.setAttribute("users", users);
        dispatcher = context.getRequestDispatcher("/views/statistics/user-contacts-count.jsp");
        dispatcher.include(req, res);
    }
}