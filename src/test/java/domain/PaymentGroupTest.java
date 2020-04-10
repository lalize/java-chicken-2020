package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.payment.CashPayment;
import domain.payment.CreditCardPayment;
import domain.payment.PaymentGroup;

public class PaymentGroupTest {
    @Test
    @DisplayName("결제 방법을 아이디로 가져온다")
    void get() {
        assertThat(PaymentGroup.get(1)).isInstanceOf(CreditCardPayment.class);
        assertThat(PaymentGroup.get(2)).isInstanceOf(CashPayment.class);
    }

    @Test
    @DisplayName("결제 방법이 존재하지 않는 경우 예외 발생")
    void get_invalid() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> PaymentGroup.get(3));
    }
}
