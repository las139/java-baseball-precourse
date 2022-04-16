package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.ParameterizedTest;

import baseball.constant.GameConfig;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

class NumberUtilsTest {
    
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
    
    @ParameterizedTest
    @DisplayName("splitNum size 비교 테스트")
    @ValueSource(strings = {"123","456","789"})
    void splitNum_size_test(String input) {
        List<Integer> numbers = NumberUtils.splitNum(input);
        
        assertEquals(numbers.size(), input.length());
    }

    @ParameterizedTest
    @DisplayName("splitNum 값 비교 테스트")
    @ValueSource(strings = {"123","456","789"})
    void splitNum_equal_test(String input) {
        List<Integer> numbers = NumberUtils.splitNum(input);
        
        for(int idx=0; idx<numbers.size(); idx++){
            assertEquals(numbers.get(idx).toString(), String.valueOf(input.charAt(idx)));
        }
    }
}