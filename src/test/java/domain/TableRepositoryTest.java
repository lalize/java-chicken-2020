package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.table.TableRepository;

public class TableRepositoryTest {
    @Test
    @DisplayName("테이블 번호로 테이블 찾기")
    void findByNumber() {
        assertThat(TableRepository.findByNumber(1)).isEqualTo(TableRepository.tables().get(0));
    }
}
