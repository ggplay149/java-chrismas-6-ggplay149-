package christmas.Menu;

import christmas.MenuDataFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuDataFixtureUnitTest {

    private MenuDataFixture menuData;

    @BeforeEach
    void setUp(){
        this.menuData = menuData;
    }

    @Test
    @DisplayName("메뉴이름으로 가격,종류 조회")
    public void give_menuName_when_search_then_get_price_and_type(){
        //given
        String menuName = "양송이 수프";
        //when
        Menu menu =  menuData.search(menuName);
        //then
        assertEquals(menu.price,6000);
        assertEquals(menu.type,MenuType.Appetizer);
    }
}
