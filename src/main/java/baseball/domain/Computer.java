package baseball.domain;

import java.util.List;

import baseball.constant.GameConfig;
import baseball.util.NumberUtils;

public class Computer {    
    private List<Integer> numbers = null;
    
    public Computer() {
        numbers = NumberUtils.generateNum(GameConfig.NUM_SIZE);
    }
    
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
