package christmas.promotion;

import christmas.order.Order;
import christmas.promotion.badge.BadgeMaker;
import christmas.promotion.badge.BadgeType;
import christmas.promotion.discount.DiscountAdaptor;
import christmas.promotion.discount.GiftEventAdaptor;

import java.util.List;

public class PromotionAdaptor {

    private final DiscountAdaptor discountAdaptor;
    private final GiftEventAdaptor giftEventAdaptor;
    private final BadgeMaker badgeMaker;

    public PromotionAdaptor(DiscountAdaptor discountAdaptor, GiftEventAdaptor giftEventAdaptor, BadgeMaker badgeMaker) {
        this.discountAdaptor = discountAdaptor;
        this.giftEventAdaptor = giftEventAdaptor;
        this.badgeMaker = badgeMaker;
    }

    public int adaptDiscount(int beforePrice, List<Promotion> promotionList){
        for(Promotion promotion : promotionList) beforePrice -= promotion.minusPrice();
        return beforePrice;
    }

    public List<Promotion> getAdaptedPromotionList(int date, int beforePrice, List<Order> orderList){
        List<Promotion> promotionList = discountAdaptor.discount(date,beforePrice,orderList);
        if(beforePrice > 120000) promotionList.add(new Promotion("증정 이벤트",25000));
        return promotionList;
    }

    public int totalDiscountedPrice(List<Promotion> promotionList){
        int sum = 0;
        for(Promotion promotion : promotionList) sum+= promotion.minusPrice();
        return sum;
    }

    public int totalPaymentPrice(List<Promotion> promotionList){
        int sum = 0;
        for(Promotion promotion : promotionList){
            if(promotion.name().equals("증정 이벤트")) continue;
            sum+= promotion.minusPrice();
        }
        return sum;
    }

    public String presentGift(int beforePrice){
        if(beforePrice >120000) return "샴페인 1개";
        return "없음";
    }

    public String presentBadge(int beforePrice){
        BadgeType badge = badgeMaker.makeBadge(beforePrice);
        if(badge == BadgeType.SANTA) return "산타";
        if(badge == BadgeType.STAR) return "별";
        if(badge == BadgeType.TREE) return "트리";
        return "없음";
    }

    public boolean isPromotionApplicable(int beforeTotalPrice) {
        if(beforeTotalPrice<10000) return false;
        return true;
    }
}
