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

    public List<Promotion> discount(int inputDate, int beforeTotalPrice, List<Order> inputOrderList) {

        //할인가격
        int minusPrice = 0;

        //적용된 프로모션 리스트
        List<Promotion> adaptedPromotionList = new ArrayList<>();

        //날짜기준 요일체크
        DayOfWeek day = LocalDate.of(2023, 12, inputDate).getDayOfWeek();

        // 크리스마스 디데이할인
        minusPrice = christmasDiscount(inputDate);
        adaptedPromotionList.add(new Promotion("크리스마스 디데이 할인", minusPrice));

        // 주말 할인
        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
            minusPrice = weekendDiscount(inputOrderList);
            adaptedPromotionList.add(new Promotion("주말 할인", minusPrice));
        }

        // 평일 할인
        if (day == DayOfWeek.MONDAY  || day == DayOfWeek.TUESDAY  || day == DayOfWeek.WEDNESDAY
                || day == DayOfWeek.THURSDAY || day == DayOfWeek.FRIDAY) {
            minusPrice = weekdayDiscount(inputOrderList);
            adaptedPromotionList.add(new Promotion("평일 할인", minusPrice));
        }


        //특별 할인
        if (inputDate == 25 || day == DayOfWeek.SUNDAY) {
            minusPrice = specialDiscount();
            adaptedPromotionList.add(new Promotion("특별 할인", minusPrice));
        }

        return adaptedPromotionList;

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

    public int specialDiscount() {
        return 1000;
    }


}
