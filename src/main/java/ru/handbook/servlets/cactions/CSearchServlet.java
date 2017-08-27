package ru.handbook.servlets.cactions;

import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Contact;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

public class CSearchServlet extends HttpServlet {

    MenuController menu;
    List<Contact> contacts;
    Contact contact;

    @Override
    public void init() throws ServletException {
        menu = new MenuController();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        String name;
        RequestDispatcher dispatcher;

        name = req.getParameter("name");

        if (name != null) {
            contact = new Contact(name);
            contacts = menu.searchContact(contact);
            req.setAttribute("contacts", contacts);
            dispatcher = context.getRequestDispatcher("/views/cactions/searched.jsp");
            dispatcher.include(req, res);
        } else {
            dispatcher = context.getRequestDispatcher("/views/cactions/search.jsp");
            dispatcher.include(req, res);
        }
    }
}
