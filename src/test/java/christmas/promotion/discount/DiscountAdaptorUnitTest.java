package christmas.promotion.discount;

import christmas.menu.MenuDataFixture;
import christmas.order.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountAdaptorUnitTest {

    private DiscountAdaptor discountAdaptor;
    private MenuDataFixture menu;

    @BeforeEach
    void setUp(){
        menu = new MenuDataFixture();
        this.discountAdaptor = new DiscountAdaptor(menu);
    }

    @Test
    @DisplayName("크리스마스 디데이할인 적용테스트")
    public void christmas_discount(){
        //given
        int inputDate = 2;
        //when
        int minusPrice = discountAdaptor.christmasDiscount(inputDate);
        //then
        assertEquals(minusPrice,1100);
    }

    @Test
    @DisplayName("평일할인 적용테스트")
    public void weekday_discount(){
        //given
        List<Order> inputList = new ArrayList<>();
        inputList.add(new Order("초코케이크","2"));
        inputList.add(new Order("양송이수프","2"));
        //when
        int minusPrice = discountAdaptor.weekdayDiscount(inputList);
        //then
        assertEquals(minusPrice,2023);
    }

    @Test
    @DisplayName("주말할인 적용테스트")
    public void weekend_discount(){
        //given
        List<Order> inputList = new ArrayList<>();
        inputList.add(new Order("티본스테이크","1"));
        inputList.add(new Order("해산물파스타","2"));
        //when
        int minusPrice = discountAdaptor.weekendDiscount(inputList);
        //then
        assertEquals(minusPrice,4046);
    }

    @Test
    @DisplayName("스페셜할인 적용테스트")
    public void special_discount(){
        //given
        int finalPrice = 10000;
        //when
        int minusPrice = discountAdaptor.specialDiscount();
        //then
        assertEquals(minusPrice,1000);
    }

}
