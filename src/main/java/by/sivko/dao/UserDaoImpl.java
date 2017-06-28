package by.sivko.dao;

import by.sivko.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Админ on 28.06.2017.
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

    @Override
    public List<User> getList() {
        return super.entityManager.createNamedQuery("User.getAllUsers", User.class).getResultList();
    }

    @Override
    public List<User> getUsersByName(String name) {
        return super.entityManager.createNamedQuery("User.findByName", User.class)
                .setParameter("name", name).getResultList();
    }
}
