package domain.payment;

public class CashPayment implements Payment {
    private static final double DISCOUNT_RATE = 0.95;

    @Override
    public double payment(double price) {
        return price * DISCOUNT_RATE;
    }
}
