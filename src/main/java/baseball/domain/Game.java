package baseball.domain;

import java.util.Map;

import baseball.constant.GameConfig;
import baseball.constant.Message;
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

        gameResult();
    }

    public void gameResult() {
        Refree refree = new Refree(computer.getNumbers(), player.getNumbers());
        Map<BallStatus, Integer> score = refree.getScore();

        String scoreResult = getScoreMsg(score.get(BallStatus.STRIKE), score.get(BallStatus.BALL));
        OutputView.viewMsg(scoreResult);
        
        if(score.get(BallStatus.STRIKE) == GameConfig.NUM_SIZE) {
            endGame();
        }
    }

    public String getScoreMsg(int strikeCount, int ballCount) {
        String resultMsg = "";

        if(strikeCount > 0) { resultMsg += strikeCount + Message.MSG_STRIKE; }
        if(!resultMsg.isEmpty()) { resultMsg += " "; }
        if(ballCount > 0) { resultMsg += ballCount + Message.MSG_BALL; }
        if(strikeCount == 0 && ballCount == 0){ resultMsg += Message.MSG_NOTHING; }

        return resultMsg;
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