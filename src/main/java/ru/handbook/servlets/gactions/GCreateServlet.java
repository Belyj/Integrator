package ru.handbook.servlets.gactions;

import org.apache.log4j.Logger;
import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Group;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class GCreateServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(GCreateServlet.class);

    MenuController menu;
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
