package domain.payment;

import java.util.Arrays;

public enum PaymentGroup {
    CREDIT_CARD(1, new CreditCardPayment()),
    CASH(2, new CashPayment());

    private final int id;
    private final Payment payment;

    PaymentGroup(int id, Payment payment) {
        this.id = id;
        this.payment = payment;
    }

    public static PaymentGroup from(int id) {
        return Arrays.stream(values())
                .filter(payment -> payment.id == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 결제 방법입니다."));
    }

    public double payment(double price) {
        return payment.payment(price);
    }
}
