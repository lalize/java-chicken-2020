package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputServiceNumber() {
        System.out.println("##메인화면");
        System.out.println("1-주문등록");
        System.out.println("2-결제하기");
        System.out.println("3-프로그램종료\n");
        System.out.println("##원하는기능을선택하세요");
        return scanner.nextInt();
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuNumber() {
        System.out.println("##등록할메뉴를선택하세요.");
        return scanner.nextInt();
    }

    public static int inputQuantityOfMenu() {
        System.out.println("##메뉴의수량을입력하세요. ");
        return scanner.nextInt();
    }
}
