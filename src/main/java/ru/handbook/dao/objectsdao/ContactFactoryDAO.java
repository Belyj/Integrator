package ru.handbook.dao.objectsdao;

import ru.handbook.model.objects.Contact;

public interface ContactFactoryDAO {

    /**
     * <p>Создание новго DAO</p>
     *
     * @return Contact возвращает созданный экземпляр DAO
     */
    ObjectDAO factoryMethod();
}
