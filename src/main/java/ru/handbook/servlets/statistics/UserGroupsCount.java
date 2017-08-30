package ru.handbook.servlets.statistics;

import ru.handbook.dao.hibernatedao.hibernateobjdao.HibernateUserDAO;
import ru.handbook.dao.hibernatedao.hibernateobjdao.impl.HibernateUserDAOImpl;
import ru.handbook.model.objects.User;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

public class UserGroupsCount extends HttpServlet {

//    MySQLUserDAOImpl userDAO = MySQLUserDAOImpl.getInstance();
    HibernateUserDAO userDAO = HibernateUserDAOImpl.getInstance();
    List<User> users;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher;
        users = userDAO.userGroupsCount();
        req.setAttribute("users", users);
        dispatcher = context.getRequestDispatcher("/views/statistics/user-groups-count.jsp");
        dispatcher.include(req, res);
    }
}