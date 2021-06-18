package kr.pe.norimsu.junit.basics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyMathTest {

	MyMath myMath = new MyMath();

	@BeforeAll
	static void beforeAll() {
		System.out.println("BeforeAll");
	}

	@AfterAll
	static void afterALl() {
		System.out.println("AfterAll");
	}

	@BeforeEach
	void before() {
		System.out.println("Before");
	}

	@AfterEach
	void after() {
		System.out.println("After");
	}

	@Test
	void sum_with3Numbers() {
		System.out.println("Test1");
		assertEquals(6, myMath.sum(new int[]{1, 2, 3}));
	}

	@Test
	void sum_with1Number() {
		System.out.println("Test2");
		assertEquals(3, myMath.sum(new int[]{3}));
	}

}