package ru.handbook.servlets.gactions;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class GDeleteServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/views/gactions/delete.jsp");
        dispatcher.include(req, res);
    }
}
