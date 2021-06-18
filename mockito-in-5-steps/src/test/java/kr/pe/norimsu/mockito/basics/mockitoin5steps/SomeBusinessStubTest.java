package kr.pe.norimsu.mockito.basics.mockitoin5steps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SomeBusinessStubTest {

	@Test
	void testFindTheGreatestFromAllData() {
		final SomeBusinessImpl businessImpl = new SomeBusinessImpl(new DataServiceStub());
		final int result = businessImpl.findTheGreatestFromAllData();
		Assertions.assertEquals(24, result);
	}
}

class DataServiceStub implements DataService {

	@Override
	public int[] retrieveAllDate() {
		return new int[]{24, 6, 15};
	}
}