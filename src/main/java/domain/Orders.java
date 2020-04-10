package domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Orders {
    private Map<Menu, Order> orders;

    private Orders(Map<Menu, Order> orders) {
        this.orders = orders;
    }

    public static Orders empty() {
        return new Orders(new LinkedHashMap<>());
    }

    public void add(Order newOrder) {
        orders.computeIfPresent(newOrder.getMenu(), (menu, order) -> order.addQuantity(newOrder.getQuantity()));
        orders.putIfAbsent(newOrder.getMenu(), newOrder);
    }

    public Map<Menu, Order> values() {
        return Collections.unmodifiableMap(orders);
    }

    public int size() {
        return orders.size();
    }

    public double price(Discount discount) {
        return orders.values()
                .stream()
                .mapToDouble(discount::discount)
                .sum();
    }
}
