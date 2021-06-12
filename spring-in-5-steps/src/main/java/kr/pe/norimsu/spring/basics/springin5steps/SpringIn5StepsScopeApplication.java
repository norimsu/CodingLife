package kr.pe.norimsu.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import kr.pe.norimsu.spring.basics.springin5steps.scope.PersonDao;

@SpringBootApplication
public class SpringIn5StepsScopeApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsScopeApplication.class);

	public static void main(String[] args) {

		final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsScopeApplication.class, args);
		final PersonDao personDao = applicationContext.getBean(PersonDao.class);
		final PersonDao personDaoTwo = applicationContext.getBean(PersonDao.class);

		LOGGER.info("{}", personDao);
		LOGGER.info("{}", personDao.getJdbcConnection());
		LOGGER.info("{}", personDao.getJdbcConnection());
		LOGGER.info("{}", personDaoTwo);
		LOGGER.info("{}", personDaoTwo.getJdbcConnection());

	}

}
