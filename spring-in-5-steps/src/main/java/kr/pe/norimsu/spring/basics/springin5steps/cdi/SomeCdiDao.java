package kr.pe.norimsu.spring.basics.springin5steps.cdi;

import javax.inject.Named;

//@Component
@Named
public class SomeCdiDao {

	public int[] getData() {
		// in real. it depends on dataSource.
		return new int[] {5, 89, 100};
	}

}
