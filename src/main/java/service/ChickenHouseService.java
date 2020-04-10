package service;

import java.util.List;

import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.Order;
import domain.table.Table;
import domain.table.TableRepository;

public class ChickenHouseService {
    public List<Table> tables() {
        return TableRepository.tables();
    }

    public List<Menu> menus() {
        return MenuRepository.menus();
    }

    public void order(int selectTableNumber, int selectMenuNumber, int selectQuantityOfMenu) {
        final Table table = TableRepository.findByNumber(selectTableNumber);
        final Order order = Order.of(selectMenuNumber, selectQuantityOfMenu);
        table.addOrder(order);
    }
}
