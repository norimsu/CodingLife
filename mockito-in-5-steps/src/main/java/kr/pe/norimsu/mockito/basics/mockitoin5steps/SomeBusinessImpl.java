package kr.pe.norimsu.mockito.basics.mockitoin5steps;

public class SomeBusinessImpl {

	private DataService dataService;

	public SomeBusinessImpl(DataService dataService) {
		this.dataService = dataService;
	}

	int findTheGreatestFromAllData() {
		final int[] data = dataService.retrieveAllDate();
		int greatest = Integer.MIN_VALUE;

		for (int value : data) {
			if (value > greatest) {
				greatest = value;
			}
		}
		return greatest;
	}
}