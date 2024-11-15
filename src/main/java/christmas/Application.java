package christmas;

import christmas.ioView.input.InputValidator;
import christmas.ioView.input.InputView;
import christmas.ioView.output.OutputView;
import christmas.menu.MenuDataFixture;
import christmas.order.Order;
import christmas.order.OrderCreator;
import christmas.promotion.PromotionAdaptor;
import christmas.promotion.badge.BadgeMaker;
import christmas.promotion.discount.DiscountAdaptor;
import christmas.promotion.discount.GiftEventAdaptor;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        //메뉴데이터
        final MenuDataFixture menuDataFixture = new MenuDataFixture();

        //필요객체 초기화
        final InputView inputView = new InputView();
        final InputValidator inputValidator = new InputValidator(menuDataFixture);
        final OrderCreator orderCreator = new OrderCreator(menuDataFixture);
        final DiscountAdaptor discountAdaptor = new DiscountAdaptor(menuDataFixture);
        final GiftEventAdaptor giftEventAdaptor = new GiftEventAdaptor();
        final BadgeMaker badgeMaker = new BadgeMaker();
        PromotionAdaptor promotionAdaptor = new PromotionAdaptor(discountAdaptor, giftEventAdaptor, badgeMaker);
        final OutputView outputView = new OutputView(promotionAdaptor);

        String inputDate;
        String inputOrder;
        List<Order> orderList;

        //1.날짜 입력
        while (true) {
            try {
                inputDate = inputView.readDate();
                if (inputValidator.validDate(inputDate)) break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //2.주문입력
        while (true) {
            try {
                orderList = orderCreator.makeList(inputView.readMenu());
                if (inputValidator.validOrder(orderList)) break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //3.결과출력
        outputView.printResult(Integer.parseInt(inputDate), orderList, orderCreator.countTotalPrice(orderList));
    }
}
