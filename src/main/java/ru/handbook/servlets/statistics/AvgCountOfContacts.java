package ru.handbook.servlets.statistics;

import ru.handbook.dao.hibernatedao.hibernateobjdao.HibernateUserDAO;
import ru.handbook.dao.hibernatedao.hibernateobjdao.impl.HibernateUserDAOImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class AvgCountOfContacts extends HttpServlet {

    //    MySQLUserDAOImpl userDAO = MySQLUserDAOImpl.getInstance();
    HibernateUserDAO userDAO = HibernateUserDAOImpl.getInstance();
    Float count;


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher;
        count = userDAO.avgCountOfContacts();
        req.setAttribute("count", count);
        dispatcher = context.getRequestDispatcher("/views/statistics/avg-count-of-contacts.jsp");
        dispatcher.include(req, res);
    }
}
