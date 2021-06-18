package kr.pe.norimsu.spring.basics.springin5steps.basic;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringIn5StepsBasicApplication {

	// What are the beans?                  => @Component
	// What are the dependencies of bean?   => @Autowired
	// Where to search for beans?           => No need (default package)

	public static void main(String[] args) {
		//final BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());

		// Application Context
		try (final ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringIn5StepsBasicApplication.class)) {

//			applicationContext.registerShutdownHook();

			final BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
			final BinarySearchImpl binarySearchTwo = applicationContext.getBean(BinarySearchImpl.class);

			System.out.println("binarySearch = " + binarySearch);
			System.out.println("binarySearchTwo = " + binarySearchTwo);

			final int result = binarySearch.binarySearch(new int[]{12, 4, 6}, 12);
			System.out.println("result = " + result);

		}
	}

}
