package kr.pe.norimsu.refactoring;

/**
 * 대여 정보 클래스
 */
public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    /**
     * 대여료 계산
     * @return 대여료
     */
    double getCharge() {
        return _movie.getCharge(_daysRented);
    }

    /**
     * 적립 포인트 계산
     * @return 적립 포인트
     */
    int getFrequentRenterPoints() {
        return _movie.getFrequeentRenterPoints(_daysRented);
    }
}
