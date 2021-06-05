package kr.pe.norimsu.spring.basics.springin5steps;

public class BinarySearchImpl {

	public int binarySearch(int[] numbers, int numberToSearchFor) {
		// Use Bubble Sort Algorithm
		final BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();
		final int[] sortedNumbers = bubbleSortAlgorithm.sort(numbers);
		// Search the array
		return 3;
	}
}
