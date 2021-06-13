package kr.pe.norimsu.spring.basics.springin5steps.cdi;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
@Named
public class SomeCdiBusiness {

//	@Autowired
	@Inject
	private SomeCdiDao someCDIDao;

	public SomeCdiDao getSomeCDIDao() {
		return someCDIDao;
	}

	public void setSomeCDIDao(SomeCdiDao someCDIDao) {
		this.someCDIDao = someCDIDao;
	}
}
