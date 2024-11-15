package christmas.promotion.discount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GiftEventAdaptorUnitTest {

    private GiftEventAdaptor giftEventAdaptor;

    @BeforeEach
    void setUp() {
        this.giftEventAdaptor = new GiftEventAdaptor();
    }

    @Test
    @DisplayName("증정이벤트 적용")
    public void giftEventAdaptor(){
        //given
        //when
        int minusPrice = giftEventAdaptor.offer();
        //then
        assertEquals(minusPrice,25000);
    }

}
