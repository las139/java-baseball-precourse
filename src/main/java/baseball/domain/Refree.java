package baseball.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Refree {
    private int strikeCount = 0;
    private int ballCount = 0;
    private List<Integer> computerNumber = null;
    private List<Integer> userNumber = null;

    public Refree(List<Integer> computerNumber, List<Integer> userNumber) {
        this.computerNumber = computerNumber;
        this.userNumber = userNumber;
    }

    public Map<BallStatus, Integer> getScore(){
        Map<BallStatus, Integer> score = new HashMap<BallStatus, Integer>();
        
		for(int idx=0; idx<userNumber.size(); idx++){
            scoreCount(idx);
        }

        score.put(BallStatus.STRIKE, strikeCount);
        score.put(BallStatus.BALL, ballCount);

        return score;
    }

    public void scoreCount(int idx) {
        if(strikeChk(idx)) {
            strikeCount++;
            return;
        }

        if(ballChk(idx)) {
            ballCount++;
            return;
        }
    }

    public boolean strikeChk(int idx) {
        if(computerNumber.get(idx) == userNumber.get(idx)) {
            return true;
        }
        return false;
    }

    public boolean ballChk(int idx) {
        if(computerNumber.contains(userNumber.get(idx))) {
            return true;
        }
        return false;
    }
}
