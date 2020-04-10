package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.menu.MenuRepository;

public class MenuTest {
    @Test
    @DisplayName("메뉴의 번호가 맞는지 확인")
    void isNumber() {
        assertThat(MenuRepository.findByNumber(1).isNumber(1)).isTrue();
    }

    @Test
    @DisplayName("메뉴의 번호가 다른지 확인")
    void isNumber_not() {
        assertThat(MenuRepository.findByNumber(1).isNumber(2)).isFalse();
    }
}
