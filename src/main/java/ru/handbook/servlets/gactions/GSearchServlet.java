package ru.handbook.servlets.gactions;

import org.apache.log4j.Logger;
import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Group;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

public class GSearchServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(GSearchServlet.class);

    MenuController menu;
    List<Group> groups;
    Group group;

    @Override
    public void init() throws ServletException {
        log.info("Инициализация");
        menu = new MenuController();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        log.info("Запрос: ");
        ServletContext context = this.getServletContext();
        String name;
        RequestDispatcher dispatcher;
        name = req.getParameter("name");
        if (name != null) {
            group = new Group(name);
            System.out.println(group.getName());
            groups = menu.searchGroup(group);
            req.setAttribute("groups", groups);
            dispatcher = context.getRequestDispatcher("/views/gactions/searched.jsp");
            dispatcher.include(req, res);
        } else {
            dispatcher = context.getRequestDispatcher("/views/gactions/search.jsp");
            dispatcher.include(req, res);
        }
    }
}
