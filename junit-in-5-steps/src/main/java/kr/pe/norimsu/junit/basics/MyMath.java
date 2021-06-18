package kr.pe.norimsu.junit.basics;

public class MyMath {

	int sum(int[] numbers) {
		int sum = 0;
		for (int i : numbers) {
			sum += i;
		}
		return sum;
	}
}