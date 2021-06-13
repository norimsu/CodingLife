package kr.pe.norimsu.spring.basics.springin5steps.basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//@Scope("prototype")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearchImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(BinarySearchImpl.class);

	@Autowired      // Setter Injection - No Setter & Constructor
	@Qualifier("quick")
	private SortAlgorithm sortAlgorithm; // use variable name 'bubbleSortAlgorithm'

//	//@Autowired    // Construction Injection via Constructor
//	public BinarySearchImpl(@Qualifier("quick") SortAlgorithm sortAlgorithm) {
//		this.sortAlgorithm = sortAlgorithm;
//	}

//	@Autowired      // Setter Injection with Setter
//	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
//		this.sortAlgorithm = sortAlgorithm;
//	}

	public int binarySearch(int[] numbers, int numberToSearchFor) {
		final int[] sortedNumbers = sortAlgorithm.sort(numbers);
		System.out.println("sortAlgorithm = " + sortAlgorithm);
		// Search the array
		return 3;
	}

	@PostConstruct
	public void postConstruct() {
		LOGGER.warn("postConstruct");
	}

	@PreDestroy
	public void preDestroy() {
		LOGGER.warn("preDestroy");
	}
}
