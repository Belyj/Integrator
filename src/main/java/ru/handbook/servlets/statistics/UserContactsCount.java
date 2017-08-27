package ru.handbook.servlets.statistics;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class UserContactsCount extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/views/statistics/user-contacts-count.jsp");
        dispatcher.include(req, res);
    }
}
