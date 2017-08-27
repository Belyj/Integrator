package ru.handbook.servlets.Statistics;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class AvgCountOfContacts extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/statistics/avg-count-of-contacts.jsp");
        dispatcher.include(req, res);
    }
}
