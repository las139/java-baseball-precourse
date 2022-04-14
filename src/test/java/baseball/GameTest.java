package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.Game;
import baseball.domain.GameStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
    Game game = null;
    
    @BeforeEach
    void init () {
        game = new Game();
    }
    
    @Test
    @DisplayName("gameStatus 테스트")
    void gameStatus_test() {
        game.setGameStatus(GameStatus.PLAYING);
        assertEquals(game.getGameStatus(), GameStatus.PLAYING);
    }
}