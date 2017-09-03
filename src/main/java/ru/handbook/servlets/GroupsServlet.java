package ru.handbook.servlets;

import org.apache.log4j.Logger;
import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Group;
import ru.handbook.model.objects.User;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static ru.handbook.Main.userInit;

public class GroupsServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(ContactsServlet.class);

    MenuController menu;
    List<Group > groups;

    @Override
    public void init() throws ServletException {
        log.info("Инициализация");
        menu = new MenuController();
        groups = new ArrayList();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        log.info("Запрос: ");
        List<Group> filterByUser = new ArrayList();
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher;
        groups = menu.checkGroups();
        for (Group group : groups) {
            for (User user : group.getUsers()) {
                if (user.getId() == userInit.getUser().getId()) {
                    filterByUser.add(group);
                }
            }
        }
        req.setAttribute("groups", filterByUser);
        dispatcher = context.getRequestDispatcher("/views/groups.jsp");
        dispatcher.include(req, res);
    }
}