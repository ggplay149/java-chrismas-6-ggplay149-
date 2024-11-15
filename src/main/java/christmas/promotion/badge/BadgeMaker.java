package christmas.promotion.badge;

public class BadgeMaker {
    public BadgeType makeBadge(int finalDiscountedPrice){
        if(finalDiscountedPrice >= 5000 && finalDiscountedPrice < 10000) return BadgeType.STAR;
        if(finalDiscountedPrice >= 10000 && finalDiscountedPrice < 20000) return BadgeType.TREE;
        if(finalDiscountedPrice >= 20000) return BadgeType.SANTA;
        return null;
    }
}
