package service;

import java.util.Collection;
import java.util.List;

import domain.discount.ChickenDiscount;
import domain.menu.Menu;
import domain.menu.MenuRepository;
import domain.order.Order;
import domain.payment.Payment;
import domain.payment.PaymentGroup;
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

    public double payment(int selectTableNumber, int selectPaymentType) {
        final Table table = TableRepository.findByNumber(selectTableNumber);
        final Payment payment = PaymentGroup.get(selectPaymentType);
        return table.payment(payment, new ChickenDiscount());
    }

    public Collection<Order> findOrdersByTableNumber(int selectTableNumber) {
        final Table table = TableRepository.findByNumber(selectTableNumber);
        return table.orders();
    }
}
