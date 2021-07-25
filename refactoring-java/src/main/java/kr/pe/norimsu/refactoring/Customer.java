package kr.pe.norimsu.refactoring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 고객 클래스
 */
public class Customer {

    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Iterator<Rental> iterator = this.rentals.iterator();
        StringBuilder result = new StringBuilder(getName() + "고객님의 대여 기록\n");
        while (iterator.hasNext()) {
            Rental each = iterator.next();

            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(each.getCharge()).append("\n");
        }

        // 푸터 행 추가
        result.append("누적 대여료: ").append(getTotalCharge()).append("\n");
        result.append("적립 포인트: ").append(getTotalFrequentRenterPoints());
        return result.toString();
    }

    public String htmlStatement() {
        Iterator<Rental> iterator = this.rentals.iterator();
        StringBuilder result = new StringBuilder("<h1><em>" + getName() + "고객님의 대여 기록</em></h1><p>\n");
        while (iterator.hasNext()) {
            Rental each = iterator.next();

            // 모든 비디오 정보와 대여료를 출력
            result.append(each.getMovie().getTitle()).append(": ").append(each.getCharge()).append("<br>\n");
        }

        // 푸터 행 추가
        result.append("<p>누적 대여료: <em>").append(getTotalCharge()).append("</em><p>\n");
        result.append("적립 포인트: <em>").append(getTotalFrequentRenterPoints()).append("</em><p>");
        return result.toString();
    }

    /**
     * 총 대여료 계산
     * @return 총 대여료
     */
    private double getTotalCharge() {
        double result = 0;
        for (Rental each : this.rentals) {
            result += each.getCharge();
        }
        return result;
    }

    /**
     * 총 적립 포인트 계산
     * @return 총 적립 포인트
     */
    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental each : this.rentals) {
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
