package by.sivko;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class OrmJhelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrmJhelperApplication.class, args);
	}

	@Bean
	public SessionFactory sessionFactory(EntityManagerFactory entityManagerFactory) {
		return entityManagerFactory.unwrap(SessionFactory.class);
	}

}
