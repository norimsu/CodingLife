//package kr.pe.norimsu.spring.basics.springin5steps.cdi;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//
//import kr.pe.norimsu.spring.basics.componantscan.ComponentDao;
//
//@SpringBootApplication
//public class SpringIn5StepsCdiApplication {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsCdiApplication.class);
//
//	public static void main(String[] args) {
//
//		final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsCdiApplication.class, args);
//		final SomeCdiBusiness business = applicationContext.getBean(SomeCdiBusiness.class);
//
//		LOGGER.info("{} dao-{}", business, business.getSomeCDIDao());
//
//	}
//
//}
