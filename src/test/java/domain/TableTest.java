package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TableTest {
    @Test
    @DisplayName("테이블 번호 같은지 확인")
    void findByNumber() {
        assertThat(new Table(1).isNumber(1)).isTrue();
    }

    @Test
    @DisplayName("테이블 주문 추가 확인")
    void addOrder() {
        Table table = new Table(1);
        table.addOrder(Order.of(1, 10));
        assertThat(table.orderSize()).isEqualTo(1);
    }
}
