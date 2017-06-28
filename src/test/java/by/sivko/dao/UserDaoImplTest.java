package by.sivko.dao;

import by.sivko.model.User;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Админ on 28.06.2017.
 */
@DatabaseSetup(UserDaoImplTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = UserDaoImplTest.DATASET)
public class UserDaoImplTest extends AbstractDaoAnnotationIncludeTest {

    private static final Long USER_ID_1 = 100000L;
    private static final String USER_NAME_1 = "name_1";
    private static final String USER_PASSWORD_1 = "OPERATION_1";
    private static final Integer USER_AGE_1 = 123123;

    @Autowired
    UserDao userDao;

    public static final String DATASET = "classpath:datasets/user-table.xml";

    @Test
    public void findsAndReadsExistingPersonById() {
        User user = userDao.getById(USER_ID_1);
        assertThat(user.getName(), is(USER_NAME_1));
        assertThat(user.getPassword(), is(USER_PASSWORD_1));
        assertThat(user.getAge(), is(USER_AGE_1));
    }

    @Test
    public void countOfEntitieInDB() {
        assertThat(userDao.getList().size(), is(4));
    }


}