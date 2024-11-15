package christmas.order;

import christmas.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class OrderCreator {

    public List<Order> makeList(String input) {

        String[] inputList = input.split(",");
        List<Order> menuList = new ArrayList<>();

        for(String inputMenu : inputList){

            String[] NameAndQuantity = inputMenu.split("-");
            String name = NameAndQuantity[0];
            int quantity = Integer.parseInt(NameAndQuantity[1]);
            menuList.add(new Order(name,quantity));
        }

        return menuList;
    }
}
