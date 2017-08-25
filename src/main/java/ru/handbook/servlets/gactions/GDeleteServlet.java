package ru.handbook.servlets.gactions;

import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Group;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class GDeleteServlet extends HttpServlet {

    MenuController menu;
    Group group;

    @Override
    public void init() throws ServletException {
        menu = new MenuController();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/views/gactions/delete.jsp");
        dispatcher.include(req, res);
        Integer id;
        if (req.getParameter("id") != null) {
            if (req.getParameter("id").matches("[-+]?\\d+")) {
                id = Integer.parseInt(req.getParameter("id"));
                group = new Group(id, "");
                group = menu.searchGroupByID(group);
            }
        }
        if (group != null) {
            group = menu.deleteGroup(group);
            req.setAttribute("group", group);
            dispatcher = context.getRequestDispatcher("/views/gactions/deleted.jsp");
            dispatcher.include(req, res);
        }
    }
}
