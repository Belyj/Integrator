package ru.handbook.servlets;

public class ContactActionServlet {
    String action;

    public void chose() {
        switch (action) {
            case "CREATE":
                create();
                 break;
            case "UPDATE":
                update();
                 break;
            case "DELETE":
                delete();
                break;
            case "GETALL":
                gettAll();
                break;
            default:
                invalidCommand();
        }
    }

    private void create() {
        //todo: create contact
    }

    private void update() {
        //todo: update contact
    }

    private void delete() {
        //todo: delete contact
    }

    private void gettAll() {
        //todo: gettAll contact
    }

    private void invalidCommand() {
        //todo: invalid command
    }
}
