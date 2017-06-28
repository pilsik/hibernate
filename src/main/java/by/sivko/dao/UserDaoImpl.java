package by.sivko.dao;

import by.sivko.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Админ on 28.06.2017.
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {
}
