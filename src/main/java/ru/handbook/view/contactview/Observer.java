package ru.handbook.view.contactview;

import ru.handbook.model.objects.Contact;

import java.util.List;

public interface Observer {

    /**
     * <p>Выполнение метода наблюдателя</p>
     *
     * @param contacts приходит информация об изменении в списке контактов
     */
    void handleEvent(List<Contact> contacts);
}
