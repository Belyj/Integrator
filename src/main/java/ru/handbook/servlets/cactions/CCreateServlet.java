package ru.handbook.servlets.cactions;

import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Contact;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class CCreateServlet extends HttpServlet {

    MenuController menu;
    Contact contact;

    @Override
    public void init() throws ServletException {
        menu = new MenuController();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/views/cactions/create.jsp");
        dispatcher.include(req, res);
        String name = req.getParameter("name");
        if (name != null) {
            contact = new Contact(name);
            contact = menu.createContact(contact);
            req.setAttribute("contact", contact);
            dispatcher = context.getRequestDispatcher("/views/cactions/created.jsp");
            dispatcher.include(req, res);
        }
    }
}
