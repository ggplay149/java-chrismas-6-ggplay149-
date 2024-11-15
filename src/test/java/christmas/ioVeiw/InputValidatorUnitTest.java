package christmas.ioVeiw;

import christmas.ioView.InputValidator;
import christmas.menu.Menu;
import christmas.menu.MenuDataFixture;
import christmas.menu.MenuType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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
        Exception e = assertThrows(IllegalArgumentException.class,()-> inputValidator.validDate(date));
        //then
        assertEquals(e.getClass(),IllegalArgumentException.class);
        assertEquals(e.getMessage(), "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("정상적인 메뉴 입력시 true")
    public void given_menu_when_validDate_then_true() {
        //given
        String menu = "양송이수프";
        given(menuDataFixture.search(menu)).willReturn(new Menu(6000, MenuType.APPETIZER));
        //when
        boolean result = inputValidator.validMenu(menu);
        //then
        assertTrue(result);
    }

    @Test
    @DisplayName("비정상적인 메뉴 입력시 false")
    public void given_wrong_menu_when_validDate_then_false() {
        //given
        String menu = "개밥";
        given(menuDataFixture.search(menu)).willReturn(new Menu(0, MenuType.WRONG));
        //when
        Exception e = assertThrows(IllegalArgumentException.class, () -> inputValidator.validMenu(menu));
        //then
        assertEquals(e.getClass(),IllegalArgumentException.class);
        assertEquals(e.getMessage(), "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
