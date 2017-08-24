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

    String action;

    public void chose() {
        switch (action) {
            case "CREATE":
                create();
                break;
            case "UPDATE":
                update();
                break;
            case "DELETE":
                delete();
                break;
            case "GETALL":
                gettAll();
                break;
            case "ADDINGROUP":
                addInGroup();
                break;
            case "DELETEFROMGROUP":
                deleteFromGroup();
                break;
            default:
                invalidCommand();
        }
    }

    private void create() {
        //todo: create contact
    }

    private void update() {
        //todo: update contact
    }

    private void delete() {
        //todo: delete contact
    }

    private void gettAll() {
        //todo: gettAll contact
    }

    private void invalidCommand() {
        //todo: invalid command
    }

    private void addInGroup() {
        //todo: addInGroup
    }

    private void deleteFromGroup() {
        //todo: removeFromGroup
    }
}
