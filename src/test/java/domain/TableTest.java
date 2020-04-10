package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.discount.ChickenDiscount;
import domain.order.Order;
import domain.payment.CashPayment;
import domain.payment.CreditCardPayment;
import domain.table.Table;

public class TableTest {
    private Table table;

    @BeforeEach
    void setup() {
        table = new Table(1);
    }

    @Test
    @DisplayName("테이블 번호 같은지 확인")
    void findByNumber() {
        assertThat(table.isNumber(1)).isTrue();
    }

    @Test
    @DisplayName("테이블 주문 추가 확인")
    void addOrder() {
        table.addOrder(Order.of(1, 10));
        assertThat(table.orders().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("테이블 신용 카드 결제 금액 확인")
    void payment_credit_card() {
        table.addOrder(Order.of(1, 10));
        assertThat(table.payment(new CreditCardPayment(), new ChickenDiscount())).isEqualTo(150000);
    }

    @Test
    @DisplayName("테이블 현금 결제 금액 확인")
    void payment_cash() {
        table.addOrder(Order.of(1, 10));
        assertThat(table.payment(new CashPayment(), new ChickenDiscount())).isEqualTo(142500);
    }

    @Test
    @DisplayName("테이블 주문이 존재하는지 확인")
    void hasOrder() {
        table.addOrder(Order.of(1, 10));
        assertThat(table.hasOrder()).isTrue();
    }
}
