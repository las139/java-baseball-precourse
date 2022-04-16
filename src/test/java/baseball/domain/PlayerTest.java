package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.util.NumberUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

class PlayerTest {
    Player player = null;
    
    @BeforeEach
    void init () {
        player = new Player();
    }
    
    @Test
    @DisplayName("setNumber size 테스트")
    void setNumber_size_test() {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        player.setNumbers(numbers);

        assertThat(numbers.size()).isEqualTo(player.getNumbers().size());
    }
    
    @ParameterizedTest
    @DisplayName("splitNum 값 비교 테스트")
    @ValueSource(strings = {"123","456","789"})
    void setNumber_equal_test(String input) {
        List<Integer> numbers = NumberUtils.splitNum(input);
        player.setNumbers(numbers);

        for(int idx=0; idx<numbers.size(); idx++){
            assertEquals(numbers.get(idx), (player.getNumbers()).get(idx));
        }
    }
}