package by.sivko.dao;

import by.sivko.model.User;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Админ on 28.06.2017.
 */

@DatabaseSetup({UserDaoImplTest.DATASETUSER, UserDaoImplTest.DATASETEMPLOYER})
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = {UserDaoImplTest.DATASETUSER, UserDaoImplTest.DATASETEMPLOYER})
@PropertySource("classpath:application.properties")
public class UserDaoImplTest extends AbstractDaoAnnotationIncludeTest {

    private static final Long USER_ID_1 = 100000L;
    private static final String USER_NAME_1 = "name_1";
    private static final String USER_PASSWORD_1 = "OPERATION_1";
    private static final Integer USER_AGE_1 = 123123;
    public static final String DATASETEMPLOYER = "classpath:datasets/employer-table.xml";
    public static final String DATASETUSER = "classpath:datasets/user-table.xml";

    @Autowired
    UserDao userDao;

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

    @Test
    public void getUsersByName() {
        assertThat(userDao.getUsersByName("name_1").size(), is(2));
    }



}