package domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Orders {
    private Map<Menu, Quantity> orders;

    private Orders(Map<Menu, Quantity> orders) {
        this.orders = orders;
    }

    public static Orders empty() {
        return new Orders(new LinkedHashMap<>());
    }

    public void add(Order order) {
        orders.computeIfPresent(order.getMenu(), (menu, quantity) -> quantity.add(order.getQuantity()));
        orders.putIfAbsent(order.getMenu(), order.getQuantity());
    }

    public Map<Menu, Quantity> values() {
        return Collections.unmodifiableMap(orders);
    }
}
