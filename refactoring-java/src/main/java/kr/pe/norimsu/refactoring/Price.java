package kr.pe.norimsu.refactoring;

public interface Price {

    int getPriceCode();

    double getCharge(int daysRented);

    default int getFrequentedRenterPoints(int daysRented) {
        return 1;
    }
}
