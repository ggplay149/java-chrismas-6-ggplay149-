package christmas.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderCreatorUnitTest {

    private OrderCreator orderCreator;

    @BeforeEach
    void setUp() {
        this.orderCreator = new OrderCreator();
    }

    @Test
    @DisplayName("input 값 메뉴 리스트형식으로 만들기")
    public void given_input_when_makeList_then_create_orderList() {
        //given
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        //when
        List<Order> list = orderCreator.makeList(input);
        //then
        assertEquals(list.size(), 4);
        assertEquals(list.get(1).name(), "바비큐립");
        assertEquals(list.get(2).quantity(), 2);
    }
}
