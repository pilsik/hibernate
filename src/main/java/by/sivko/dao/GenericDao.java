package by.sivko.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
    T getById(PK pk);
    void save(T t);
    void remove(T t);
    T removeById(PK pk);
    List<T> getList();
}
