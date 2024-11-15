package christmas.ioView.input;

import christmas.menu.MenuDataFixture;
import christmas.menu.MenuType;
import christmas.order.Order;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private MenuDataFixture menu;

    public InputValidator(MenuDataFixture menu) {
        this.menu = menu;
    }

    public boolean validDate(String date) {

        //숫자가 아닌경우 에러처리
        if(!date.matches("\\d+")){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }

        int selectedDate = Integer.parseInt(date);
        if (selectedDate < 1 || selectedDate > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }

        return true;
    }

    public boolean validOrder(List<Order> orderList) {

        boolean result = true;
        List<String> nameList = new ArrayList<>();

        //중복체크용 주문 음식명 리스트
        for(Order order : orderList) nameList.add(order.name());

        //input 체크
        for(Order order : orderList){

            String name = order.name();
            int quantity = 0;
            try {
                quantity = Integer.parseInt(order.quantity());
            } catch (NumberFormatException e){
                result = false;
            }

            //없는 메뉴 체크
            if(menu.search(name).type() == MenuType.WRONG) result = false;

            //주문수량 1개 미만 체크
            if(quantity<1) result = false;

            //중복 메뉴 체크
            Set<String> set = new HashSet<>(nameList);
            if(set.size() != nameList.size()) result = false;

        }

        if(!result) throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

        return true;
    }

    public boolean validFormat(String input){
        if(!input.matches("\\d+")){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        return true;
    }

}
