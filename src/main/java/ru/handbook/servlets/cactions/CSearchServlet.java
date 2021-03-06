package ru.handbook.servlets.cactions;

import org.apache.log4j.Logger;
import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Contact;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

public class CSearchServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(CSearchServlet.class);

    MenuController menu;
    List<Contact> contacts;
    Contact contact;

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
