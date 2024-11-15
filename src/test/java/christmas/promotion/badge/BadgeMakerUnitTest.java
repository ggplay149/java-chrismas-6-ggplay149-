package christmas.promotion.badge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadgeMakerUnitTest {

    private BadgeMaker badgeMaker;

    @BeforeEach
    void setUp(){
        this.badgeMaker = new BadgeMaker();
    }
    @Test
    @DisplayName("최종 0 할인시 금액별 별 뱃지 증정 테스트 ")
    public void given_wrong_price_then_BadgeTest(){
        //given
        final int finalDiscountedPrice = 0;
        //when
        BadgeType badgeType = badgeMaker.makeBadge(finalDiscountedPrice);
        //then
        assertEquals(badgeType,null);
    }

    @Test
    @DisplayName("최종 6000원 할인시 금액별 별 뱃지 증정 테스트 ")
    public void starBadgeTest(){
        //given
        final int finalDiscountedPrice = 6000;
        //when
        BadgeType badgeType = badgeMaker.makeBadge(finalDiscountedPrice);
        //then
        assertEquals(badgeType,BadgeType.STAR);
    }

    @Test
    @DisplayName("최종 16000원 할인시 금액별 트리 뱃지 증정 테스트 ")
    public void treeBadgeTest(){
        //given
        final int finalDiscountedPrice = 16000;
        //when
        BadgeType badgeType = badgeMaker.makeBadge(finalDiscountedPrice);
        //then
        assertEquals(badgeType,BadgeType.TREE);
    }

    @Test
    @DisplayName("최종 26000원 할인시 금액별 산타 뱃지 증정 테스트 ")
    public void santaBadgeTest(){
        //given
        final int finalDiscountedPrice = 26000;
        //when
        BadgeType badgeType = badgeMaker.makeBadge(finalDiscountedPrice);
        //then
        assertEquals(badgeType,BadgeType.SANTA);
    }
}
