package kr.pe.norimsu.spring.basics.springin5steps.cdi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringIn5StepsCdiApplication.class)
class SomeCdiBusinessTest {

	@Autowired
	SomeCdiBusiness business;

	@Test
	void basicScenario() {
		// it depends on real DataSources.
		assertEquals(100, business.findGreatest());
	}
}