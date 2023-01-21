package org.example.db.dao;

import org.example.db.exception.PositionTransactionException;
import org.springframework.stereotype.Component;

@Component
public interface IBaseCommands<E> {
    E selectByID(int id);
    void insert(E e);
    void update(E e);
    void delete(E e);
}
