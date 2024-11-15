package christmas.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuDataFixtureUnitTest {

    private MenuDataFixture menuData;

    @BeforeEach
    void setUp(){
        this.menuData = new MenuDataFixture();
    }

    @Test
    @DisplayName("정상 메뉴이름으로 가격,종류 조회")
    public void give_menuName_when_search_then_get_price_and_type(){
        //given
        String menuName = "양송이수프";
        //when
        Menu menu =  menuData.search(menuName);
        //then
        assertEquals(menu.price(),6000);
        assertEquals(menu.type(), MenuType.APPETIZER);
    }

    @Test
    @DisplayName("잘못된 메뉴이름으로 가격,종류 조회")
    public void give_wrong_menuName_when_search_then_get_price_and_type(){
        //given
        String menuName = "잘못된메뉴이름";
        //when
        Menu menu =  menuData.search(menuName);
        //then
        assertEquals(menu.price(),0);
        assertEquals(menu.type(), MenuType.WRONG);
    }
}
