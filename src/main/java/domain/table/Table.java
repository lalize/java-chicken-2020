package domain.table;

import java.util.Collection;

import domain.discount.Discount;
import domain.order.Order;
import domain.order.Orders;
import domain.payment.Payment;

public class Table {
    private final int number;
    private final Orders orders;

    public Table(final int number) {
        this.number = number;
        this.orders = Orders.empty();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean isNumber(int number) {
        return this.number == number;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public double payment(Payment payment, Discount discount) {
        return orders()
                .stream()
                .mapToDouble(discount::discount)
                .map(payment::payment)
                .sum();
    }

    public Collection<Order> orders() {
        return orders.values()
                .values();
    }
}
