package domain;

public class CashPayment implements Payment {
    private static final double DISCOUNT_RATE = 0.95;

    @Override
    public double payment(Order order) {
        return order.price() * DISCOUNT_RATE;
    }
}
