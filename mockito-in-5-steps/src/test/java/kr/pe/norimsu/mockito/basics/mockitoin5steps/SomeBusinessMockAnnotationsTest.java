package kr.pe.norimsu.mockito.basics.mockitoin5steps;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessMockAnnotationsTest {

	@Mock
	DataService dataServiceMock;

	@InjectMocks
	SomeBusinessImpl businessImpl;

	@Test
	void test_FindTheGreatestFromAllData() {
		when(dataServiceMock.retrieveAllDate()).thenReturn(new int[]{24, 6, 15});
		Assertions.assertEquals(24, businessImpl.findTheGreatestFromAllData());
	}

	@Test
	void test_FindTheGreatestFromAllData_ForOneValue() {
		when(dataServiceMock.retrieveAllDate()).thenReturn(new int[]{15});
		Assertions.assertEquals(15, businessImpl.findTheGreatestFromAllData());
	}

	@Test
	void test_FindTheGreatestFromAllData_NoData() {
		when(dataServiceMock.retrieveAllDate()).thenReturn(new int[]{});
		Assertions.assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
	}
}