package christmas.ioView;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        int inputDate = Integer.parseInt(Console.readLine());
        if(inputDate < 1 || inputDate >31) throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        return inputDate;
    }
}
