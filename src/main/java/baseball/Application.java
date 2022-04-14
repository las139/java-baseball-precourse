package baseball;

import baseball.domain.Game;
import baseball.domain.GameStatus;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        while(game.getGameStatus() != GameStatus.END){
            game.startGame();
        }
    }
}