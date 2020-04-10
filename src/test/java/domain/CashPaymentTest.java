package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CashPaymentTest {
    @Test
    @DisplayName("현금 결제 확인")
    void payment() {
        Payment cash = new CashPayment();
        Order order = Order.of(1, 10);
        double price = order.getMenu().getPrice() * order.getQuantity().getValue();
        assertThat(cash.payment(price)).isEqualTo(price * 0.95);
    }
}
