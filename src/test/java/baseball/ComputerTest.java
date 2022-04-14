package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import baseball.constant.GameConfig;
import baseball.domain.Computer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

class ComputerTest {
    Computer computer = null;
    List<Integer> numbers = null;
    
    @BeforeEach
    void init () {
        computer = new Computer();
        computer.getNumbers();
        numbers = computer.getNumbers();
    }

    @Test
    @DisplayName("랜덤 번호 생성 범위 1 ~ 9 테스트")
    @RepeatedTest(1000)
    void getNumbers_range_test() {        
        for(int idx=0; idx<numbers.size(); idx++){
            assertThat(numbers.get(idx)).isBetween(GameConfig.START_NUM, GameConfig.END_NUM);
        }
    }
    
    @Test
    @DisplayName("랜덤 번호 생성 크기 3 테스트")
    void getNumbers_size_test() {        
        assertEquals(computer.getNumbers().size(), GameConfig.NUM_SIZE);
    }
}