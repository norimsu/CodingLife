package kr.pe.norimsu.spring.basics.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

	@Autowired      // Setter Injection - No Setter & Constructor
	@Qualifier("quick")
	private SortAlgorithm sortAlgorithm; // use variable name 'bubbleSortAlgorithm'

//	//@Autowired    // Construction Injection via Constructor
//	public BinarySearchImpl(@Qualifier("quick") SortAlgorithm sortAlgorithm) {
//		this.sortAlgorithm = sortAlgorithm;
//	}

//	@Autowired      // Setter Injection with Setter
//	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
//		this.sortAlgorithm = sortAlgorithm;
//	}

	public int binarySearch(int[] numbers, int numberToSearchFor) {
		final int[] sortedNumbers = sortAlgorithm.sort(numbers);
		System.out.println("sortAlgorithm = " + sortAlgorithm);
		// Search the array
		return 3;
	}
}
