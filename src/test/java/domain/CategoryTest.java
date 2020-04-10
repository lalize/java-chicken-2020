package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.menu.Category;

public class CategoryTest {
    @Test
    @DisplayName("카테고리 이름 확인")
    void name() {
        assertThat(Category.CHICKEN.toString()).isEqualTo("[치킨]");
        assertThat(Category.BEVERAGE.toString()).isEqualTo("[음료]");
    }
}
