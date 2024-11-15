package christmas.ioView;

import camp.nextstep.edu.missionutils.Console;
import christmas.menu.Menu;

public class InputView {

    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        int inputDate = Integer.parseInt(Console.readLine());
        return inputDate;
    }

    public String readMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String inputMenu = Console.readLine();
        return inputMenu;
    }
}
