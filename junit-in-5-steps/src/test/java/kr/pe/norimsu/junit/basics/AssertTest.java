package kr.pe.norimsu.junit.basics;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AssertTest {

	@Test
	void test() {
		boolean condition = true;
		Object nullObject = null;
		Object object = new Object();

		assertEquals(true, condition);
		assertTrue(condition);
		assertFalse(!condition);
		assertNull(nullObject);
		assertNotNull(object);
		assertNotEquals(nullObject, object);

//		assertArrayEquals();

//		assertAll();

//		assertSame();
//		assertNotSame();

//		assertIterableEquals();

//		assertLinesMatch();

//		assertThrows();
//		assertDoesNotThrow();

//		assertTimeout();
//		assertTimeoutPreemptively();
	}

}