package ru.handbook.servlets.cactions;

import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Contact;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class CSearchServlet extends HttpServlet {

    MenuController menu;
    Contact contact;

    @Override
    public void init() throws ServletException {
        menu = new MenuController();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        Integer id;
        String name;
        RequestDispatcher dispatcher;
        if (req.getParameter("id") != null) {
            if (req.getParameter("id").matches("[-+]?\\d+")) {
                id = Integer.parseInt(req.getParameter("id"));
                name = req.getParameter("name");
                contact = new Contact(id, name);
                contact = menu.searchContact(contact);
            } else id = null;
        } else id = null;



        if (id != null) {
            req.setAttribute("contact", contact);
            dispatcher = context.getRequestDispatcher("/views/cactions/searched.jsp");
            dispatcher.include(req, res);
        } else {
            dispatcher = context.getRequestDispatcher("/views/cactions/search.jsp");
            dispatcher.include(req, res);
        }
    }
}
