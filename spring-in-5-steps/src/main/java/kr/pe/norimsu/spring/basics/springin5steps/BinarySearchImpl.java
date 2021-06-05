package kr.pe.norimsu.spring.basics.springin5steps;

public class BinarySearchImpl {

	private final SortAlgorithm sortAlgorithm;

	public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}

	public int binarySearch(int[] numbers, int numberToSearchFor) {
		final int[] sortedNumbers = sortAlgorithm.sort(numbers);
		System.out.println("sortAlgorithm = " + sortAlgorithm);
		// Search the array
		return 3;
	}
}
