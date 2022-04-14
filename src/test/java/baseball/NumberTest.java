package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import baseball.constant.GameConfig;
import baseball.util.NumberUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

class NumberTest {
    
    @Test
    @DisplayName("랜덤 번호 생성 범위 1 ~ 9 테스트")
    @RepeatedTest(1000)
    void generateNum_range_test() {
        List<Integer> numbers = NumberUtils.generateNum(GameConfig.NUM_SIZE);
        
        for(int idx=0; idx<numbers.size(); idx++){
            assertThat(numbers.get(idx)).isBetween(GameConfig.START_NUM, GameConfig.END_NUM);
        }
    }
    
    @Test
    @DisplayName("랜덤 번호 생성 크기 3 테스트")
    void generateNum_size_test() {
        List<Integer> numbers = NumberUtils.generateNum(GameConfig.NUM_SIZE);
        
        assertEquals(numbers.size(), GameConfig.NUM_SIZE);
    }
}