package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QuantityTest {
    @Test
    @DisplayName("수량 정수 입력 생성")
    void from_integer() {
        assertThat(Quantity.from(1)).isInstanceOf(Quantity.class);
        assertThat(Quantity.from(99)).isInstanceOf(Quantity.class);
    }

    @Test
    @DisplayName("수량 문자열 입력 생성")
    void from_string() {
        assertThat(Quantity.from("1")).isInstanceOf(Quantity.class);
        assertThat(Quantity.from("99")).isInstanceOf(Quantity.class);
    }

    @Test
    @DisplayName("수량 99개 초과시 예외 발생")
    void from_exception_over_max() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Quantity.from(100));
    }

    @Test
    @DisplayName("수량 1개 미만일 때 예외 발생")
    void from_exception_under_min() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> Quantity.from(0));
    }

    @Test
    @DisplayName("수량 더하기 확인")
    void add() {
        assertThat(Quantity.from(30).add(Quantity.from(20))).isEqualTo(Quantity.from(50));
    }

    @Test
    @DisplayName("수량 객체 같은지 확인")
    void equals() {
        assertThat(Quantity.from(1)).isEqualTo(Quantity.from(1));
        assertThat(Quantity.from("1")).isEqualTo(Quantity.from(1));
        assertThat(Quantity.from("1")).isEqualTo(Quantity.from("1"));
    }

    @Test
    @DisplayName("수량 객체 다른지 확인")
    void equals_not() {
        assertThat(Quantity.from(1)).isNotEqualTo(Quantity.from(2));
        assertThat(Quantity.from("1")).isNotEqualTo(Quantity.from(2));
        assertThat(Quantity.from("1")).isNotEqualTo(Quantity.from("2"));
    }
}
