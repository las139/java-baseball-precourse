package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.Player;
import baseball.util.NumberUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

class PlayerTest {
    Player player = null;
    List<Integer> numbers = null;
    
    @BeforeEach
    void init () {
        player = new Player();
        numbers = new ArrayList<Integer>();
        
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    
    @Test
    @DisplayName("setNumber size 테스트")
    void setNumber_size_test(String input) {
        player.setNumbers(numbers);

        assertThat(numbers.size()).isEqualTo(player.getNumbers().size());
    }

    @Test
    @DisplayName("setNumber 값 비교 테스트")
    void setNumber_equal_test(String input) {
        List<Integer> numbers = NumberUtils.splitNum(input);
        player.setNumbers(numbers);

        for(int idx=0; idx<numbers.size(); idx++){
            assertEquals(numbers.get(idx), (player.getNumbers()).get(idx));
        }
    }
}