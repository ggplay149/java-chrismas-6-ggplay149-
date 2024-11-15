package christmas.order;

import christmas.menu.MenuDataFixture;

import java.util.ArrayList;
import java.util.List;

public class OrderCreator {

    private MenuDataFixture menu;

    public OrderCreator(MenuDataFixture menu) {
        this.menu = menu;
    }

    public List<Order> makeList(String input) {

        String[] inputList = input.split(",");
        List<Order> orderList = new ArrayList<>();

        for(String inputMenu : inputList){
            String[] NameAndQuantity = inputMenu.split("-");
            String name = NameAndQuantity[0];
            int quantity = Integer.parseInt(NameAndQuantity[1]);
            orderList.add(new Order(name,quantity));
        }

        return orderList;
    }

    public int countTotalPrice(List<Order> orderList) {
        int totalPrice = 0;
        for (Order order : orderList) totalPrice += (menu.search(order.name()).price()) * (order.quantity());
        return totalPrice;
    }

}
