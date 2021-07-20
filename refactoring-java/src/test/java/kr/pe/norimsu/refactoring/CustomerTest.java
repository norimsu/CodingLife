package kr.pe.norimsu.refactoring;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CustomerTest {

    private static final String NAME = "이상현";
    private static final String MOVIE_TITLE_A = "a";
    private static final String MOVIE_TITLE_B = "b";
    private static final String MOVIE_TITLE_C = "c";

    private Customer customer;
    private Movie movie_a;
    private Movie movie_b;
    private Movie movie_c;

    @BeforeEach
    void setUp() {
        customer = new Customer(NAME);
        movie_a = new Movie(MOVIE_TITLE_A, Movie.REGULAR);
        movie_b = new Movie(MOVIE_TITLE_B, Movie.NEW_RELEASE);
        movie_c = new Movie(MOVIE_TITLE_C, Movie.CHILDREN);
    }

    @DisplayName("대여 안했을 때")
    @Test
    void statement_withNoRental() {
        //@formatter:off
        String expected = NAME + "고객님의 대여 기록\n" +
                "누적 대여료: 0.0\n" +
                "적립 포인트: 0";
        //@formatter:on
        then(customer.statement()).isEqualTo(expected);
    }

    @DisplayName("일반 영화 대여했을 때")
    @ParameterizedTest(name = "[{index}] when renting movie A with {0}days, total price is {1} and point is {2}")
    @CsvSource(value = {"1:2.0:1", "3:3.5:1", "5:6.5:1"}, delimiter = ':')
    void statement_withRental_MovieA(int daysRented, double expectedPrice, int expectedPoint) {
        //@formatter:off
        String expected = NAME + "고객님의 대여 기록\n" +
                "\t" + MOVIE_TITLE_A + "\t" + expectedPrice + "\n" +
                "누적 대여료: " + expectedPrice + "\n" +
                "적립 포인트: " + expectedPoint;
        //@formatter:on
        customer.addRental(new Rental(movie_a, daysRented));
        then(customer.statement()).isEqualTo(expected);
    }

    @DisplayName("신규 영화 대여했을 때")
    @ParameterizedTest(name = "[{index}] when renting movie B with {0}days, total price is {1} and point is {2}")
    @CsvSource(value = {"1:3.0:1", "3:9.0:2", "5:15.0:2"}, delimiter = ':')
    void statement_withRental_MovieB(int daysRented, double expectedPrice, int expectedPoint) {
        //@formatter:off
        String expected = NAME + "고객님의 대여 기록\n" +
                "\t" + MOVIE_TITLE_B + "\t" + expectedPrice + "\n" +
                "누적 대여료: " + expectedPrice + "\n" +
                "적립 포인트: " + expectedPoint;
        //@formatter:on
        customer.addRental(new Rental(movie_b, daysRented));
        then(customer.statement()).isEqualTo(expected);
    }

    @DisplayName("아동 영화 대여했을 때")
    @ParameterizedTest(name = "[{index}] when renting movie C with {0}days, total price is {1} and point is {2}")
    @CsvSource(value = {"1:1.5:1", "3:1.5:1", "5:4.5:1"}, delimiter = ':')
    void statement_withRental_MovieC(int daysRented, double expectedPrice, int expectedPoint) {
        //@formatter:off
        String expected = NAME + "고객님의 대여 기록\n" +
                "\t" + MOVIE_TITLE_C + "\t" + expectedPrice + "\n" +
                "누적 대여료: " + expectedPrice + "\n" +
                "적립 포인트: " + expectedPoint;
        //@formatter:on
        customer.addRental(new Rental(movie_c, daysRented));
        then(customer.statement()).isEqualTo(expected);
    }

    @DisplayName("모든 영화 대여했을 때")
    @ParameterizedTest(name = "[{index}] when renting All with {0}days, point is {4}")
    @CsvSource(value = {"1:2.0:3.0:1.5:3", "3:3.5:9.0:1.5:4", "5:6.5:15.0:4.5:4"}, delimiter = ':')
        //@formatter:off
    void statement_withRental_All(
            int daysRented,
            double expectedPriceA,
            double expectedPriceB,
            double expectedPriceC,
            int expectedPoint) {
        //@formatter:on
        final double expectedPrice = expectedPriceA + expectedPriceB + expectedPriceC;
        //@formatter:off
        String expected = NAME + "고객님의 대여 기록\n" +
                "\t" + MOVIE_TITLE_A + "\t" + expectedPriceA + "\n" +
                "\t" + MOVIE_TITLE_B + "\t" + expectedPriceB + "\n" +
                "\t" + MOVIE_TITLE_C + "\t" + expectedPriceC + "\n" +
                "누적 대여료: " + expectedPrice + "\n" +
                "적립 포인트: " + expectedPoint;
        //@formatter:on
        customer.addRental(new Rental(movie_a, daysRented));
        customer.addRental(new Rental(movie_b, daysRented));
        customer.addRental(new Rental(movie_c, daysRented));
        then(customer.statement()).isEqualTo(expected);
    }
}