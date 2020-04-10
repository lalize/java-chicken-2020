package domain;

public class CreditCardPayment implements Payment {
    @Override
    public double payment(Order order) {
        return order.price();
    }
}
