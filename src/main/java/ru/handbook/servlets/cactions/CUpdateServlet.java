package ru.handbook.servlets.cactions;

import org.apache.log4j.Logger;
import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Contact;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class CUpdateServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(CUpdateServlet.class);

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
        Integer id;
        RequestDispatcher dispatcher = context.getRequestDispatcher("/views/cactions/update.jsp");
        dispatcher.include(req, res);
        if (req.getParameter("id") != null) {
            if (req.getParameter("id").matches("[-+]?\\d+")) {
                id = Integer.parseInt(req.getParameter("id"));
                contact = new Contact(id, "");
                contact = menu.searchContactByID(contact);

                String name = req.getParameter("name");
                String phone = req.getParameter("phone");
                String skype = req.getParameter("skype");
                String mail =req.getParameter("mail");

                if (name != null) {
                    contact.setName(name);
                }
                if (phone != null) {
                    contact.setPhone(phone);
                }
                if (skype != null) {
                    contact.setSkype(skype);
                }
                if (mail != null) {
                    contact.setMail(mail);
                }
                if (name != null || phone != null || skype != null || mail != null) {
                    contact = menu.updateContact(contact);
                    req.setAttribute("contact", contact);
                    dispatcher = context.getRequestDispatcher("/views/cactions/updated.jsp");
                    dispatcher.include(req, res);
                }
            }
        }
    }
}
