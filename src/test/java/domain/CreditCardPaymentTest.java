package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreditCardPaymentTest {
    @Test
    @DisplayName("신용 카드 결제 확인")
    void payment() {
        Payment creditCard = new CreditCardPayment();
        Order order = Order.of(1, 10);
        double price = order.getMenu().getPrice() * order.getQuantity().getValue();
        assertThat(creditCard.payment(price)).isEqualTo(price);
    }
}
