package kr.pe.norimsu.spring.basics.springin5steps;

public class BinarySearchImpl {

	public int binarySearch(int[] numbers, int numberToSearchFor) {
		// Use Quick Sort Algorithm
		final QuickSortAlgorithm quickSortAlgorithm = new QuickSortAlgorithm();
		final int[] sortedNumbers = quickSortAlgorithm.sort(numbers);
		// Search the array
		return 3;
	}
}
