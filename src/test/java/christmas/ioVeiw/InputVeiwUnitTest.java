package christmas.ioVeiw;

import christmas.ioView.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputVeiwUnitTest {

    private InputView inputVew;

    @BeforeEach
    void setUp() {
        this.inputVew = new InputView();    }

    @Test
    @DisplayName("정상 날짜 입력시 정상 날짜 입력")
    public void given_input_normal_when_readDate_then_return_date() {
        //given
        String testDate = "3";
        //when
        System.setIn(new ByteArrayInputStream((testDate.getBytes())));
        int returnDate = inputVew.readDate();
        //then
        assertEquals(3, returnDate);
    }

    @Test
    @DisplayName("1~31 외 날짜 입력시 에러메세지")
    public void given_input_wrong_date_when_readDate_then_error_message() {
        //given
        String testDate = "32";
        //when
        System.setIn(new ByteArrayInputStream((testDate.getBytes())));
        Exception e = assertThrows(IllegalArgumentException.class,()->inputVew.readDate());
        //then
        assertEquals(e, "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}
