package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.discount.ChickenDiscount;
import domain.discount.Discount;
import domain.order.Order;

public class ChickenDiscountTest {
    @Test
    @DisplayName("치킨 종류 10개 단위로 10000원 할인 확인")
    void discount() {
        Discount chicken = new ChickenDiscount();
        Order order = Order.of(1, 9);
        Order order2 = Order.of(1, 10);
        Order order3 = Order.of(1, 20);
        assertThat(chicken.discount(order)).isEqualTo(order.getMenu().getPrice() * order.getQuantity().getValue());
        assertThat(chicken.discount(order2)).isEqualTo(
                order2.getMenu().getPrice() * order2.getQuantity().getValue() - 10000);
        assertThat(chicken.discount(order3)).isEqualTo(
                order3.getMenu().getPrice() * order3.getQuantity().getValue() - 20000);
    }
}
