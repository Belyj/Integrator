package ru.handbook.servlets.gactions;

import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Group;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class GSearchServlet extends HttpServlet {

    MenuController menu;
    Group group;

    @Override
    public void init() throws ServletException {
        menu = new MenuController();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        Integer id;
        String name;
        RequestDispatcher dispatcher;
        if (req.getParameter("id") != null) {
            if (req.getParameter("id").matches("[-+]?\\d+")) {
                id = Integer.parseInt(req.getParameter("id"));
                name = req.getParameter("name");
                group = new Group(id, name);
                group = menu.searchGroup(group);
            } else id = null;
        } else id = null;



        if (id != null) {
            req.setAttribute("group", group);
            dispatcher = context.getRequestDispatcher("/views/gactions/searched.jsp");
            dispatcher.include(req, res);
        } else {
            dispatcher = context.getRequestDispatcher("/views/gactions/search.jsp");
            dispatcher.include(req, res);
        }
    }
}
