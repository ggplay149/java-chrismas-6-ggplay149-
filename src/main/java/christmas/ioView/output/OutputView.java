package christmas.ioView.output;

import christmas.order.Order;
import christmas.promotion.Promotion;
import christmas.promotion.PromotionAdaptor;

import java.util.List;

public class OutputView {

    final PromotionAdaptor promotionAdaptor;

    public OutputView(PromotionAdaptor promotionAdaptor) {
        this.promotionAdaptor = promotionAdaptor;
    }


    public void printResult(int inputDate, List<Order> inputOrder, int beforeTotalPrice) {

        System.out.println("12월 " + inputDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");

        System.out.println("\n<주문 메뉴>");
        for (Order order : inputOrder) System.out.println(order.name() + " " + order.quantity() + "개");

        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(beforeTotalPrice + "원");

        System.out.println("\n<증정 메뉴>");
        System.out.println(promotionAdaptor.presentGift(beforeTotalPrice));

        boolean promotionFlag = promotionAdaptor.isPromotionApplicable(beforeTotalPrice);

        if(promotionFlag) {
            List<Promotion> promotionList = promotionAdaptor.getAdaptedPromotionList(inputDate, beforeTotalPrice, inputOrder);
            System.out.println("\n<혜택 내역>");
            for (Promotion promotion : promotionList)
                System.out.println(promotion.name() + ": -" + promotion.minusPrice() + "원");

            System.out.println("\n<총혜택 금액>");
            System.out.println("-" + promotionAdaptor.totalDiscountedPrice(promotionList) + "원");

            System.out.println("\n<할인 후 예상 결제 금액>");
            System.out.println((beforeTotalPrice-promotionAdaptor.totalPaymentPrice(promotionList))+"원");
        }

        if(!promotionFlag){
            System.out.println("\n<혜택 내역>");
            System.out.println("없음");

            System.out.println("\n<총혜택 금액>");
            System.out.println("0원");

            System.out.println("\n<할인 후 예상 결제 금액>");
            System.out.println(beforeTotalPrice+"원");

        }

        System.out.println("\n<12월 이벤트 배지>");
        System.out.println(promotionAdaptor.presentBadge(beforeTotalPrice));
    }
}