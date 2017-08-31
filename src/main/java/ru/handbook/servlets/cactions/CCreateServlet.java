package ru.handbook.servlets.cactions;

import org.apache.log4j.Logger;
import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Contact;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class CCreateServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(CCreateServlet.class);

    MenuController menu;
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