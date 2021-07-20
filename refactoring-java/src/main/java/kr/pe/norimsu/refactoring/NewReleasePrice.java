package kr.pe.norimsu.refactoring;

public class NewReleasePrice extends Price {

    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    int getFrequentedRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
