package kr.pe.norimsu.spring.basics.springin5steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringIn5StepsApplication {

	// What are the beans?                  => @Component
	// What are the dependencies of bean?   => @Autowired
	// Where to search for beans?           => No need (default package)

	public static void main(String[] args) {
		//final BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());

		// Application Context
		final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringIn5StepsApplication.class, args);
		final BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		final int result = binarySearch.binarySearch(new int[]{12, 4, 6}, 12);
		System.out.println("result = " + result);
	}

}
