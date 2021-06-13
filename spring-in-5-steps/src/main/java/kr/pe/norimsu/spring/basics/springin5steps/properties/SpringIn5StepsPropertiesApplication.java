package kr.pe.norimsu.spring.basics.springin5steps.properties;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:app.properties")
public class SpringIn5StepsPropertiesApplication {

	public static void main(String[] args) {
		try (final ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringIn5StepsPropertiesApplication.class)) {
			final SomeExternalService service = applicationContext.getBean(SomeExternalService.class);
			System.out.println("url = " + service.returnServiceUrl());
		}
	}
}
