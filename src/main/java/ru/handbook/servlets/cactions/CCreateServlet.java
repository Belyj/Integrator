package ru.handbook.servlets.cactions;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class CCreateServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/views/gactions/create.jsp");
        dispatcher.include(req, res);
    }
}
