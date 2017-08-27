package ru.handbook.servlets;

import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Group;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GroupsServlet extends HttpServlet {

    MenuController menu;
    List<Group > groups;

    @Override
    public void init() throws ServletException {
        menu = new MenuController();
        groups = new ArrayList();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher;
        groups = menu.checkGroups();
        req.setAttribute("groups", groups);
        dispatcher = context.getRequestDispatcher("/views/groups.jsp");
        dispatcher.include(req, res);
    }
}
