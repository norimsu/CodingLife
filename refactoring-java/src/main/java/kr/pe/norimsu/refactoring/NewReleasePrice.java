package kr.pe.norimsu.refactoring;

public class NewReleasePrice implements Price {

    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3.0;
    }

    @Override
    public int getFrequentedRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
