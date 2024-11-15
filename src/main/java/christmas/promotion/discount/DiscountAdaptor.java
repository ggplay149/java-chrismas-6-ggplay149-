package christmas.promotion.discount;

import christmas.menu.MenuDataFixture;
import christmas.menu.MenuType;
import christmas.order.Order;
import christmas.promotion.Promotion;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DiscountAdaptor {

    private MenuDataFixture menu;

    public DiscountAdaptor(MenuDataFixture menu) {
        this.menu = menu;
    }

    public int discount(int inputDate, int beforePrice, List<Order> inputOrderList) {

        //기존가격
        int finalPrice = beforePrice;
        //할인된가격
        int minusPrice = 0;
        //적용된 프로모션 리스트
        List<Promotion> adaptedPromotionList = new ArrayList<>();

        //날짜기준 요일체크
        DayOfWeek day = LocalDate.of(2023, 12, inputDate).getDayOfWeek();

        // 크리스마스 디데이할인
        minusPrice = christmasDiscount(inputDate);
        finalPrice -= minusPrice;
        adaptedPromotionList.add(new Promotion("christmas", minusPrice));

        // 주말 할인
        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
            minusPrice = weekendDiscount(inputOrderList);
            finalPrice -= minusPrice;
            adaptedPromotionList.add(new Promotion("weekend", minusPrice));
        }

        // 평일 할인
        if (day == DayOfWeek.MONDAY  || day == DayOfWeek.TUESDAY  || day == DayOfWeek.WEDNESDAY
                || day == DayOfWeek.THURSDAY || day == DayOfWeek.FRIDAY) {
            minusPrice = weekdayDiscount(inputOrderList);
            finalPrice -= minusPrice;
            adaptedPromotionList.add(new Promotion("weekday", minusPrice));
        }


        //특별 할인
        if (inputDate == 25 || day == DayOfWeek.SUNDAY) {
            minusPrice = specialDiscount(finalPrice);
            finalPrice -= minusPrice;
            adaptedPromotionList.add(new Promotion("special", minusPrice));
        }

        return finalPrice;

    }


    public int christmasDiscount(int inputDate) {
        return 1000 + ((inputDate - 1) * 100);
    }

    public int weekendDiscount(List<Order> inputOrderList) {
        int count = 0;
        for(Order order : inputOrderList){
            MenuType type = menu.search(order.name()).type();
            if(type == MenuType.MAIN) count++;
        }
        return count*2023;
    }

    public int weekdayDiscount(List<Order> inputOrderList) {
        int count = 0;
        for(Order order : inputOrderList){
            MenuType type = menu.search(order.name()).type();
            if(type == MenuType.DESSERT) count++;
        }
        return count*2023;
    }

    public int specialDiscount(int finalPrice) {
        return 1000;
    }
}
