package domain.order;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import domain.discount.Discount;
import domain.menu.Menu;

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

    public double price(Discount discount) {
        return orders.values()
                .stream()
                .mapToDouble(discount::discount)
                .sum();
    }

    public boolean isNotEmpty() {
        return !orders.isEmpty();
    }

    public void clear() {
        orders.clear();
    }
}
