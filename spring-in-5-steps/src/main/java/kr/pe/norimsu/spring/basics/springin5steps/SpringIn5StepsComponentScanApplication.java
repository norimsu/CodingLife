package kr.pe.norimsu.spring.basics.springin5steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import kr.pe.norimsu.spring.basics.componantscan.ComponentDao;

@Configuration
@ComponentScan("kr.pe.norimsu.spring.basics.componantscan")
public class SpringIn5StepsComponentScanApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsComponentScanApplication.class);

	public static void main(String[] args) {

		try (final ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringIn5StepsComponentScanApplication.class)) {
			final ComponentDao componentDao = applicationContext.getBean(ComponentDao.class);

			LOGGER.info("{}", componentDao);
		}

	}

}
