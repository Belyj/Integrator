package ru.handbook.servlets;

import org.apache.log4j.Logger;
import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Contact;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ContactsServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(ContactsServlet.class);

    MenuController menu;
    List<Contact> contacts;

    @Override
    public void init() throws ServletException {
        log.info("Инициализация");
        menu = new MenuController();
        contacts = new ArrayList();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        log.info("Запрос: ");
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher;
        contacts = menu.checkContacts();
        req.setAttribute("contacts", contacts);
        dispatcher = context.getRequestDispatcher("/views/contacts.jsp");
        dispatcher.include(req, res);
    }
}
