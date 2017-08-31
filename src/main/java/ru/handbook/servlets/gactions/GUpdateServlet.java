package ru.handbook.servlets.gactions;

import org.apache.log4j.Logger;
import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Group;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class GUpdateServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(GUpdateServlet.class);

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
        Integer id;
        RequestDispatcher dispatcher = context.getRequestDispatcher("/views/gactions/update.jsp");
        dispatcher.include(req, res);
        if (req.getParameter("id") != null) {
            if (req.getParameter("id").matches("[-+]?\\d+")) {
                id = Integer.parseInt(req.getParameter("id"));
                group = new Group(id, "");
                group = menu.searchGroupByID(group);
                String name = req.getParameter("name");

                if (name != null) {
                    group.setName(name);
                    System.out.println(group.getName());
                    group = menu.updateGroup(group);
                    req.setAttribute("group", group);
                    dispatcher = context.getRequestDispatcher("/views/gactions/updated.jsp");
                    dispatcher.include(req, res);
                }
            }
        }
    }
}
