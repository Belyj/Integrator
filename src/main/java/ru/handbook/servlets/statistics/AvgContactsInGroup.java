package ru.handbook.servlets.statistics;

import ru.handbook.dao.dbdao.mysql.MySQLUserDAOImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class AvgContactsInGroup extends HttpServlet {

    MySQLUserDAOImpl userDAO = MySQLUserDAOImpl.getInstance();
    Float count;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher;
        count = userDAO.avgContactsInGroups();
        req.setAttribute("count", count);
        dispatcher = context.getRequestDispatcher("/views/statistics/avg-contacts-in-group.jsp");
        dispatcher.include(req, res);
    }
}
