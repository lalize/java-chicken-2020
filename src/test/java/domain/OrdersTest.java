package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrdersTest {
    private Orders orders;

    @BeforeEach
    void setup() {
        orders = Orders.empty();
    }

    @Test
    @DisplayName("빈 주문리스트 확인")
    void empty() {
        assertThat(orders.values().size()).isEqualTo(0);
    }

    @Test
    @DisplayName("주문 추가 확인")
    void add() {
        orders.add(Order.of(1, 10));
        assertThat(orders.values().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("같은 메뉴 누적 주문 추가 확인")
    void add_same_menu() {
        orders.add(Order.of(2, 10));
        orders.add(Order.of(2, 10));
        assertThat(orders.values().get(MenuRepository.findByNumber(2))).isEqualTo(Quantity.from(20));
    }
}
