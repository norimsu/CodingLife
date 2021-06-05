package kr.pe.norimsu.spring.basics.springin5steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIn5StepsApplication {

	public static void main(String[] args) {
		final BinarySearchImpl binarySearch = new BinarySearchImpl();
		final int result = binarySearch.binarySearch(new int[]{12, 4, 6}, 12);
		System.out.println("result = " + result);
		//SpringApplication.run(SpringIn5StepsApplication.class, args);
	}

}
