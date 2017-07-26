package ru.handbook.model.storage;

import ru.handbook.view.contactview.Observer;

import java.io.Serializable;

public interface Observable extends Serializable {

    /**
     *<p>Добавление нового подписчика</p>
     *@param observer эземпляр наблюдателя
     */
    void addObserver(Observer observer);

    /**
     *<p>Удаление подписчика</p>
     *@param observer эземпляр наблюдателя
     */
    void removeObserver(Observer observer);

    /**
     *<p>Рассылка подписчикам</p>
     */
    void notifyObservers();
}
