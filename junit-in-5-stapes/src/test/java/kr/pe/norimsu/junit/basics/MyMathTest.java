package kr.pe.norimsu.junit.basics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	MyMath myMath = new MyMath();

	@Test
	void sum_with3Numbers() {
		assertEquals(6, myMath.sum(new int[]{1, 2, 3}));
	}

	@Test
	void sum_with1Number() {
		assertEquals(3, myMath.sum(new int[]{3}));
	}

}