package kr.pe.norimsu.spring.basics.springin5steps.cdi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeCdiBusinessTest {

	//Inject Mock
	@InjectMocks
	SomeCdiBusiness business;

	//Create Mock
	@Mock
	SomeCdiDao daoMock;

	@Test
	void basicScenario() {
		when(daoMock.getData()).thenReturn(new int[]{2, 4});
		assertEquals(4, business.findGreatest());
	}

	@Test
	void basicScenario_NoElements() {
		when(daoMock.getData()).thenReturn(new int[]{});
		assertEquals(Integer.MIN_VALUE, business.findGreatest());
	}

	@Test
	void basicScenario_EqualElements() {
		when(daoMock.getData()).thenReturn(new int[]{2, 2});
		assertEquals(2, business.findGreatest());
	}
}