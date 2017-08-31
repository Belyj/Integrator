package ru.handbook.servlets.statistics;

import org.apache.log4j.Logger;
import ru.handbook.dao.hibernatedao.hibernateobjdao.HibernateUserDAO;
import ru.handbook.dao.hibernatedao.hibernateobjdao.impl.HibernateUserDAOImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class UserCount extends HttpServlet {

    private static final Logger log = Logger.getLogger(UserCount.class);

    //    MySQLUserDAOImpl userDAO = MySQLUserDAOImpl.getInstance();
    HibernateUserDAO userDAO;
    Float count;

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
        count = userDAO.userCount();
        req.setAttribute("count", count);
        dispatcher = context.getRequestDispatcher("/views/statistics/user-count.jsp");
        dispatcher.include(req, res);
    }
}
