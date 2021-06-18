package kr.pe.norimsu.mockito.basics.mockitoin5steps;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SomeBusinessMockTest {

	@Test
	void testFindTheGreatestFromAllData() {
		final DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllDate()).thenReturn(new int[]{24, 6, 15});
		final SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		final int result = businessImpl.findTheGreatestFromAllData();
		Assertions.assertEquals(24, result);
	}

	@Test
	void testFindTheGreatestFromAllData_ForOneValue() {
		final DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveAllDate()).thenReturn(new int[]{15});
		final SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		final int result = businessImpl.findTheGreatestFromAllData();
		Assertions.assertEquals(15, result);
	}
}