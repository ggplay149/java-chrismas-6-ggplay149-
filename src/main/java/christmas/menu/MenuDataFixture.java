package christmas.menu;
public class MenuDataFixture {

    public Menu search(String menuName) {

        //APPETIZER
        if(menuName.equals("양송이수프")) return new Menu(6000,MenuType.APPETIZER);
        if(menuName.equals("타파스")) return new Menu(5500,MenuType.APPETIZER);
        if(menuName.equals("시저샐러드")) return new Menu(8000,MenuType.APPETIZER);

        //MAIN
        if(menuName.equals("티본스테이크")) return new Menu(55000,MenuType.MAIN);
        if(menuName.equals("바비큐립")) return new Menu(54000,MenuType.MAIN);
        if(menuName.equals("해산물파스타")) return new Menu(35000,MenuType.MAIN);
        if(menuName.equals("크리스마스파스타")) return new Menu(25000,MenuType.MAIN);

        //DESSERT
        if(menuName.equals("초코케이크")) return new Menu(15000,MenuType.DESSERT);
        if(menuName.equals("아이스크림")) return new Menu(5000,MenuType.DESSERT);

        //DRINK
        if(menuName.equals("제로콜라")) return new Menu(3000,MenuType.DRINK);
        if(menuName.equals("레드와인")) return new Menu(60000,MenuType.DRINK);
        if(menuName.equals("샴페인")) return new Menu(25000,MenuType.DRINK);

        return new Menu(0,MenuType.WRONG);
    }
}
