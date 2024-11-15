package christmas.ioView;

import christmas.menu.Menu;
import christmas.menu.MenuDataFixture;
import christmas.menu.MenuType;

public class InputValidator {

    private MenuDataFixture menu;

    public InputValidator(MenuDataFixture menu) {
        this.menu = menu;
    }

    public boolean validDate(String date){
        int selectedDate = Integer.parseInt(date);
        if(selectedDate < 1 || selectedDate >31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return true;
    }

    public boolean validMenu(String menuName){
        Menu selectedMenu = menu.search(menuName);
        if(selectedMenu.type() == MenuType.WRONG) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return true;
    }

}
