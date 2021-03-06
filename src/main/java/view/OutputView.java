package view;

import java.util.Collection;
import java.util.List;

import domain.menu.Menu;
import domain.order.Order;
import domain.table.Table;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_LINE_ORDERED = "└ W ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        printLine(TOP_LINE, tables.size());
        printTableNumbers(tables);
        printTableBottoms(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    private static void printTableBottoms(final List<Table> tables) {
        for (final Table table : tables) {
            printTableBottom(table);
        }
        System.out.println();
    }

    private static void printTableBottom(Table table) {
        if (table.hasOrder()) {
            System.out.print(BOTTOM_LINE_ORDERED);
            return;
        }
        System.out.print(BOTTOM_LINE);
    }

    public static void printOrders(Collection<Order> ordersByTableNumber) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        ordersByTableNumber.forEach(order -> {
            System.out.println(order.getMenu().getName() + " " + order.getQuantity().getValue() + " " + order.price());
        });
    }

    public static void printPrice(double price) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(price + "원");
    }
}
