package kr.pe.norimsu.refactoring;

/**
 * 대여 정보 클래스
 */
public class Rental {

    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    /**
     * 대여료 계산
     * @return 대여료
     */
    double getCharge() {
        return movie.getCharge(daysRented);
    }

    /**
     * 적립 포인트 계산
     * @return 적립 포인트
     */
    int getFrequentRenterPoints() {
        return movie.getFrequentedRenterPoints(daysRented);
    }
}
