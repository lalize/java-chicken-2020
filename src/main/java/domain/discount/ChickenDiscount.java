package domain.discount;

import domain.order.Order;

public class ChickenDiscount implements Discount {
    private static final double PRICE = 10000;
    private static final int UNIT = 10;

    @Override
    public double discount(Order order) {
        if (!order.getMenu().isChicken()) {
            return order.price();
        }
        int quantity = order.getQuantity().getValue();
        int count = quantity / UNIT;
        return order.price() - PRICE * count;
    }
}
