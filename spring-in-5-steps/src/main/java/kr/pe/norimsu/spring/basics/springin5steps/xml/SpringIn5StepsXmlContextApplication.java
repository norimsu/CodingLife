package kr.pe.norimsu.spring.basics.springin5steps.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIn5StepsXmlContextApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsXmlContextApplication.class);

	public static void main(String[] args) {

		try (final ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml")) {

			LOGGER.info("Bean Loaded -> {}", (Object) applicationContext.getBeanDefinitionNames());
			// [xmlJdbcConnection, xmlPersonDao]

			// [componentDao, scopedTarget.componentJdbcConnection, componentJdbcConnection,
			// springIn5StepsComponentScanApplication, binarySearchImpl, bubbleSortAlgorithm,
			// quickSortAlgorithm, springIn5StepsBasicApplication, someCdiBusiness, someCdiDao,
			// springIn5StepsCdiApplication, scopedTarget.jdbcConnection, jdbcConnection, personDao,
			// springIn5StepsScopeApplication,
			// org.springframework.context.annotation.internalConfigurationAnnotationProcessor,
			// org.springframework.context.annotation.internalAutowiredAnnotationProcessor,
			// org.springframework.context.annotation.internalCommonAnnotationProcessor,
			// org.springframework.context.event.internalEventListenerProcessor,
			// org.springframework.context.event.internalEventListenerFactory,
			// xmlJdbcConnection, xmlPersonDao]

			final XmlPersonDao personDao = applicationContext.getBean(XmlPersonDao.class);
			final XmlPersonDao personDaoTwo = applicationContext.getBean(XmlPersonDao.class);

			LOGGER.info("{}", personDao);
			LOGGER.info("{}", personDao.getXmlJdbcConnection());
			LOGGER.info("{}", personDao.getXmlJdbcConnection());
			LOGGER.info("{}", personDaoTwo);
			LOGGER.info("{}", personDaoTwo.getXmlJdbcConnection());

		}

	}

}
