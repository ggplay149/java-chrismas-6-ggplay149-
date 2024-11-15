package christmas.ioVeiw;

import christmas.ioView.input.InputValidator;
import christmas.menu.Menu;
import christmas.menu.MenuDataFixture;
import christmas.menu.MenuType;
import christmas.order.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class InputValidatorUnitTest {

    private InputValidator inputValidator;
    private MenuDataFixture menuDataFixture;

    @BeforeEach
    void setUp() {
        menuDataFixture = mock(MenuDataFixture.class);
        this.inputValidator = new InputValidator(menuDataFixture);
    }

    @Test
    @DisplayName("정상적인 메뉴 입력시 true")
    public void given_date_when_validDate_then_ok() {
        //given
        String date = "3";
        //when
        boolean result = inputValidator.validDate(date);
        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("비정상적인 메뉴 입력시 false")
    public void given_wrong_date_when_validDate_then_false() {
        //given
        String date = "0";
        //when
        Exception e = assertThrows(IllegalArgumentException.class, () -> inputValidator.validDate(date));
        //then
        assertEquals(e.getClass(), IllegalArgumentException.class);
        assertEquals(e.getMessage(), "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("정상적인 주문 입력시 true")
    public void given_menu_when_validMenu_then_true() {
        //given
        List<Order> testInput = new ArrayList<>();
        testInput.add(new Order("양송이수프","1"));
        testInput.add(new Order("제로콜라","2"));
        given(menuDataFixture.search(any())).willReturn(new Menu(6000, MenuType.APPETIZER));
        //when
        boolean result = inputValidator.validOrder(testInput);
        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("없는 메뉴 주문 입력시 에러메세지")
    public void given_wrong_order_when_validMenu_then_error() {
        //given
        List<Order> testInput = new ArrayList<>();
        testInput.add(new Order("개밥","1"));
        given(menuDataFixture.search(any())).willReturn(new Menu(0, MenuType.WRONG));
        //when
        Exception e = assertThrows(IllegalArgumentException.class, () -> inputValidator.validOrder(testInput));
        //then
        assertEquals(e.getClass(), IllegalArgumentException.class);
        assertEquals(e.getMessage(), "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("0개 주문 입력시 에러메세지")
    public void given_0_quantity_when_validMenu_then_error() {
        //given
        List<Order> testInput = new ArrayList<>();
        testInput.add(new Order("양송이수프","0"));
        given(menuDataFixture.search(any())).willReturn(new Menu(6000, MenuType.APPETIZER));
        //when
        Exception e = assertThrows(IllegalArgumentException.class, () -> inputValidator.validOrder(testInput));
        //then
        assertEquals(e.getClass(), IllegalArgumentException.class);
        assertEquals(e.getMessage(), "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("중복 주문 입력시 에러메세지")
    public void given_duplicated_order_when_validMenu_then_error() {
        //given
        List<Order> testInput = new ArrayList<>();
        testInput.add(new Order("양송이수프","1"));
        testInput.add(new Order("양송이수프","2"));
        given(menuDataFixture.search(any())).willReturn(new Menu(6000, MenuType.APPETIZER));
        //when
        Exception e = assertThrows(IllegalArgumentException.class, () -> inputValidator.validOrder(testInput));
        //then
        assertEquals(e.getClass(), IllegalArgumentException.class);
        assertEquals(e.getMessage(), "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }



}
