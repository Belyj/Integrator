package ru.handbook.servlets.cactions;

import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.Group;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class RemoveFromGroupServlet extends HttpServlet {

    MenuController menu;
    Contact contact;
    Group group;

    @Override
    public void init() throws ServletException {
        menu = new MenuController();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        Integer contactID;
        Integer groupID;
        RequestDispatcher dispatcher = context.getRequestDispatcher("/views/cactions/remove.jsp");
        dispatcher.include(req, res);
        if (req.getParameter("contactid") != null && req.getParameter("groupid") != null) {
            if (req.getParameter("contactid").matches("[-+]?\\d+") && req.getParameter("groupid").matches("[-+]?\\d+")) {
                contactID = Integer.parseInt(req.getParameter("contactid"));
                groupID = Integer.parseInt(req.getParameter("groupid"));
                contact = new Contact(contactID, "");
                contact = menu.searchContactByID(contact);
                group = new Group(groupID, "");
                group = menu.searchGroupByID(group);
                menu.removeFromGroup(contact, group);
                group = menu.searchGroup(group);
                req.setAttribute("group", group);
                dispatcher = context.getRequestDispatcher("/views/gactions/searched.jsp");
                dispatcher.include(req, res);
            }
        }
    }
}
