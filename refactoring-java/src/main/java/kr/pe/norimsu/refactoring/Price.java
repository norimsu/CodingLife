package kr.pe.norimsu.refactoring;

public abstract class Price {

    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    int getFrequentedRenterPoints(int daysRented) {
        return 1;
    }
}
