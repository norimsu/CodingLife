package kr.pe.norimsu.spring.basics.springin5steps.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringIn5StepsScopeApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsScopeApplication.class);

	public static void main(String[] args) {

		try (final ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringIn5StepsScopeApplication.class)) {

			final PersonDao personDao = applicationContext.getBean(PersonDao.class);
			final PersonDao personDaoTwo = applicationContext.getBean(PersonDao.class);

			LOGGER.info("{}", personDao);
			LOGGER.info("{}", personDao.getJdbcConnection());
			LOGGER.info("{}", personDao.getJdbcConnection());
			LOGGER.info("{}", personDaoTwo);
			LOGGER.info("{}", personDaoTwo.getJdbcConnection());

		}

	}

}
