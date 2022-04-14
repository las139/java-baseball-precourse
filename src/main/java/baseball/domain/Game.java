package baseball.domain;

import baseball.constant.GameConfig;
import baseball.util.NumberUtils;
import baseball.util.ValidationCheck;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private GameStatus gameStatus = null;
    private Computer computer = null;
    private Player player = null;

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    private void init() {
        setGameStatus(GameStatus.PLAYING);
        computer = new Computer();
        player = new Player();
    }

    public void startGame() {
        init();

        OutputView.viewInputMsg();

        String input = Console.readLine();
        ValidationCheck.checkAll(input, GameConfig.NUM_SIZE, GameConfig.START_NUM, GameConfig.END_NUM);

        player.setNumbers(NumberUtils.splitNum(input));
    }

    public void endGame() {
        OutputView.viewEndMsg();

        String input = Console.readLine();
        ValidationCheck.endChk(input);

        if(input.equals(GameConfig.KEY_END)){
            setGameStatus(GameStatus.END);
            return;
        }
    }
}