package by.sivko.dao;

import by.sivko.model.User;

import java.util.List;

/**
 * Created by Админ on 28.06.2017.
 */
public interface UserDao extends GenericDao<User, Long> {

    List<User> getUsersByName(String name);

}
