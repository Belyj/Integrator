package ru.handbook.servlets;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class StatisticsServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/views/statistics.jsp");
        dispatcher.include(req, res);
    }
}
