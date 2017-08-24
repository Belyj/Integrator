package ru.handbook.servlets.gactions;

import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Group;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class GCreateServlet extends HttpServlet {

    MenuController menu;
    Group group;

    @Override
    public void init() throws ServletException {
        menu = new MenuController();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/views/gactions/create.jsp");
        dispatcher.include(req, res);
        String name = req.getParameter("name");
        if (name != null) {
            group = new Group(name);
            group = menu.createGroup(group);
            req.setAttribute("group", group);
            dispatcher = context.getRequestDispatcher("/views/gactions/created.jsp");
            dispatcher.include(req, res);
        }
    }
}
