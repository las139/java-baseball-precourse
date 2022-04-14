package baseball.domain;

import java.util.List;

public class Player {
    private List<Integer> numbers = null;

    public List<Integer> getNumbers() {
        return this.numbers;
    }
    
    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}