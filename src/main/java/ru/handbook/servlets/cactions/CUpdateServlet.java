package ru.handbook.servlets.cactions;

import ru.handbook.controller.MenuController;
import ru.handbook.model.objects.Contact;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class CUpdateServlet extends HttpServlet {

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
        RequestDispatcher dispatcher = context.getRequestDispatcher("/views/cactions/update.jsp");
        dispatcher.include(req, res);
        if (req.getParameter("id") != null) {
            if (req.getParameter("id").matches("[-+]?\\d+")) {
                id = Integer.parseInt(req.getParameter("id"));
                contact = new Contact(id, "");

                contact = menu.searchContactByID(contact);

                if (contact.getName() != null) {
                    req.setAttribute("contact", contact);
                    dispatcher = context.getRequestDispatcher("/views/cactions/updating.jsp");
                    dispatcher.include(req, res);
                    String name = null;
                    String phone = null;
                    String skype = null;
                    String mail = null;
                    name = req.getParameter("name");
                    phone = req.getParameter("phone");
                    skype = req.getParameter("skype");
                    mail = req.getParameter("mail");
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
//                    contact = menu.updateContact(contact);
//                    req.setAttribute("contact", contact);
//                    dispatcher = context.getRequestDispatcher("/views/cactions/updating.jsp");
//                    dispatcher.include(req, res);
                }
            }
        }
//        menu.updateContact(contact);
    }
}
