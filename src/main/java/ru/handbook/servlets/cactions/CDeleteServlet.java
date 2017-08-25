package ru.handbook.servlets.cactions;

import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Contact;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class CDeleteServlet extends HttpServlet {

    MenuController menu;
    Contact contact;

    @Override
    public void init() throws ServletException {
        menu = new MenuController();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/views/cactions/delete.jsp");
        dispatcher.include(req, res);
        Integer id;
        if (req.getParameter("id") != null) {
            if (req.getParameter("id").matches("[-+]?\\d+")) {
                id = Integer.parseInt(req.getParameter("id"));
                contact = new Contact(id, "");
                contact = menu.searchContactByID(contact);
            }
        }
        if (contact != null) {
            contact = menu.deleteContact(contact);
            req.setAttribute("contact", contact);
            dispatcher = context.getRequestDispatcher("/views/cactions/deleted.jsp");
            dispatcher.include(req, res);
        }
    }
}
