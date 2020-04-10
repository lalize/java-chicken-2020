package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MenuRepositoryTest {
    @Test
    void findByNumber() {
        assertThat(MenuRepository.findByNumber(1)).isEqualTo(MenuRepository.menus().get(0));
    }
}
