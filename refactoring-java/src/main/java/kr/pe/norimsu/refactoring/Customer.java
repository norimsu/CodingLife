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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        String result = getName() + "고객님의 대여 기록\n";
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();

            // 경우에 따른 적립 포인트 지급 함수를 호출
            frequentRenterPoints += getFrequentRenterPoints(each);

            // 이번에 대여하는 비디오 정보와 대여료를 출력
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getChange()) + "\n";

            // 현재따지 누적된 총 대여료
            totalAmount += each.getChange();
        }

        // 푸터 행 추가
        result += "누적 대여료: " + String.valueOf(totalAmount) + "\n";
        result += "적립 포인트: " + String.valueOf(frequentRenterPoints);
        return result;
    }

    /**
     * 적립 포인트 계산
     * @param each 대여 정보
     * @return 적립 포인트
     */
    private int getFrequentRenterPoints(Rental each) {
        int point = 0;

        // 적립 포인트를 1 포인트 증가
        point++;

        // 최신물을 이틀 이상 대여하면 보너스 포인트 지급
        if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
            point++;
        }
        return point;
    }
}
