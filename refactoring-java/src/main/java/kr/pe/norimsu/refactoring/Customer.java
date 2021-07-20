package kr.pe.norimsu.refactoring;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 고객 클래스
 */
public class Customer {

    private String _name;
    private Vector<Rental> _rentals = new Vector<>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        Enumeration<Rental> rentals = _rentals.elements();
        String result = getName() + "고객님의 대여 기록\n";
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();

            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
        }

        // 푸터 행 추가
        result += "누적 대여료: " + getTotalCharge() + "\n";
        result += "적립 포인트: " + getTotalFrequentRenterPoints();
        return result;
    }

    public String htmlStatement() {
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "<h1><em>" + getName() + "고객님의 대여 기록</em></h1><p>\n";
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();

            // 모든 비디오 정보와 대여료를 출력
            result += each.getMovie().getTitle() + ": " + each.getCharge() + "<br>\n";
        }

        // 푸터 행 추가
        result += "<p>누적 대여료: <em>" + getTotalCharge() + "</em><p>\n";
        result += "적립 포인트: <em>" + getTotalFrequentRenterPoints() + "</em><p>";
        return result;
    }

    /**
     * 총 대여료 계산
     * @return 총 대여료
     */
    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
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
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
