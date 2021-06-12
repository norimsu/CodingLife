package kr.pe.norimsu.spring.basics.springin5steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

	@Autowired      // Setter Injection - No Setter & Constructor
	private SortAlgorithm bubbleSortAlgorithm; // use variable name

//	//@Autowired    // Construction Injection via Constructor
//	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
//		this.sortAlgorithm = sortAlgorithm;
//	}

//	@Autowired      // Setter Injection with Setter
//	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
//		this.sortAlgorithm = sortAlgorithm;
//	}

	public int binarySearch(int[] numbers, int numberToSearchFor) {
		final int[] sortedNumbers = bubbleSortAlgorithm.sort(numbers);
		System.out.println("sortAlgorithm = " + bubbleSortAlgorithm);
		// Search the array
		return 3;
	}
}
