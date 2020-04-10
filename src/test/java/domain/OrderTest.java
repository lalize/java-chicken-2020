package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    @DisplayName("메뉴 번호와 수량을 입력받으면 주문 객체를 생성")
    void of() {
        assertThat(Order.of(1, 10)).isInstanceOf(Order.class);
    }


    @Test
    @DisplayName("같은 주문인지 확인")
    void equals() {
        assertThat(Order.of(1, 10)).isEqualTo(Order.of(1, 10));
        assertThat(Order.of(1, 20)).isEqualTo(Order.of(1, 20));
        assertThat(Order.of(2, 10)).isEqualTo(Order.of(2, 10));
        Order order = Order.of(3, 10);
        assertThat(order).isEqualTo(order);
    }

    @Test
    @DisplayName("다른 주문인지 확인")
    void equals_not() {
        assertThat(Order.of(1, 10)).isNotEqualTo(Order.of(1, 11));
        assertThat(Order.of(1, 10)).isNotEqualTo(Order.of(2, 10));
    }

    @Test
    @DisplayName("주문이 null이 아닌지 확인")
    void equals_not_null() {
        assertThat(Order.of(1, 10)).isNotEqualTo(null);
    }

    @Test
    @DisplayName("주문이 정상적으로 입력됐는지 확인")
    void get() {
        Order order = Order.of(1, 10);
        assertThat(order.getMenu().isNumber(1)).isTrue();
        assertThat(order.getQuantity()).isEqualTo(Quantity.from(10));
    }
}
