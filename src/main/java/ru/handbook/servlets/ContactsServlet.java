package ru.handbook.servlets;

import org.apache.log4j.Logger;
import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Contact;
import ru.handbook.model.objects.User;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ru.handbook.Main.userInit;


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
        List<Contact> filterByUser = new ArrayList();
        log.info("Запрос: ");
        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher;
        contacts = menu.checkContacts();
        for (Contact contact : contacts) {
            for (User user : contact.getUsers()) {
                if (user.getId() == userInit.getUser().getId()) {
                    filterByUser.add(contact);
                }
            }
        }
        req.setAttribute("contacts", filterByUser);
        dispatcher = context.getRequestDispatcher("/views/contacts.jsp");
        dispatcher.include(req, res);
    }
}
