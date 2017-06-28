package by.sivko.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional
public abstract class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

    @PersistenceContext
    EntityManager entityManager;

    protected Class<T> entityClass;

    public GenericDaoImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass
                .getActualTypeArguments()[0];
    }

    @Override
    public T getById(PK pk) {
        T t = this.entityManager.find(entityClass, pk);
        return t;
    }

    @Override
    public void save(T t) {
        this.entityManager.persist(t);
    }

    @Override
    public void remove(T t) {
        this.entityManager.remove(t);
    }

    @Override
    public T removeById(PK pk) {
        T t = this.getById(pk);
        this.entityManager.remove(t);
        return t;
    }

    @Override
    abstract public List<T> getList();
}
