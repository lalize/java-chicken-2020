package domain.payment;

public class CreditCardPayment implements Payment {
    @Override
    public double payment(double price) {
        return price;
    }
}
