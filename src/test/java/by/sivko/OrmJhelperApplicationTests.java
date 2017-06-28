package by.sivko;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@PropertySource("classpath:dao-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OrmJhelperApplication.class)
public class OrmJhelperApplicationTests {

	@Test
	public void contextLoads() {
	}


}
