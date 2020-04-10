package controller;

import java.util.HashMap;
import java.util.Map;

import service.ChickenHouseService;
import view.InputView;
import view.OutputView;

public class ChickenHouseController {
    private boolean isRunning = false;

    private ChickenHouseService chickenHouseService;
    private Map<Integer, Route> routes;

    public ChickenHouseController(ChickenHouseService chickenHouseService) {
        this.chickenHouseService = chickenHouseService;
        this.routes = new HashMap<Integer, Route>() {{
            put(1, () -> order());
            put(2, () -> payment());
            put(3, () -> exit());
        }};
    }

    private void service() {
        this.routes.get(InputView.inputServiceNumber()).route();
    }

    private void order() {
        OutputView.printTables(chickenHouseService.tables());
        final int selectTableNumber = InputView.inputTableNumber();
        OutputView.printMenus(chickenHouseService.menus());
        final int selectMenuNumber = InputView.inputMenuNumber();
        final int selectQuantityOfMenu = InputView.inputQuantityOfMenu();
        chickenHouseService.order(selectTableNumber, selectMenuNumber, selectQuantityOfMenu);
    }

    private void payment() {
        OutputView.printTables(chickenHouseService.tables());
        final int selectTableNumber = InputView.inputTableNumber();
        OutputView.printOrders(chickenHouseService.findOrdersByTableNumber(selectTableNumber));
        final int selectPaymentType = InputView.inputPaymentType();
        final double price = chickenHouseService.payment(selectTableNumber, selectPaymentType);
        OutputView.printPrice(price);
    }

    private void exit() {
        isRunning = false;
    }

    public void run() {
        isRunning = true;
        while (isRunning) {
            service();
        }
    }
}
