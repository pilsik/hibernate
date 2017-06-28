package by.sivko.dao;

import by.sivko.OrmJhelperApplication;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * Created by Админ on 28.06.2017.
 */

@TestExecutionListeners(DbUnitTestExecutionListener.class)
@SpringBootTest(classes = OrmJhelperApplication.class)
@DirtiesContext
public abstract class AbstractDaoAnnotationIncludeTest extends AbstractTransactionalJUnit4SpringContextTests {
}
