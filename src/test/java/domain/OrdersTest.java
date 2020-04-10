package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.discount.ChickenDiscount;
import domain.menu.MenuRepository;
import domain.order.Order;
import domain.order.Orders;

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
        assertThat(orders.values().get(MenuRepository.findByNumber(2))).isEqualTo(Order.of(2, 20));
    }

    @Test
    @DisplayName("치킨 할인 적용한 주문 금액 확인")
    void price() {
        orders.add(Order.of(1, 10));
        orders.add(Order.of(22, 10));
        assertThat(orders.price(new ChickenDiscount())).isEqualTo(160000);
    }

    @Test
    @DisplayName("주문이 존재하는지 확인")
    void isNotEmpty() {
        orders.add(Order.of(1, 10));
        assertThat(orders.isNotEmpty()).isTrue();
    }
}
