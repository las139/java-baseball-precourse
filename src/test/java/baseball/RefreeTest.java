package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.domain.Refree;
import baseball.domain.BallStatus;
import baseball.util.NumberUtils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class RefreeTest {

    @ParameterizedTest
    @DisplayName("점수 계산 결과 테스트")
    @CsvSource(value = {"123:0:1","456:1:1","425:0:3","789:0:0"}, delimiter = ':')
    public void getScore_test(String input, int ballCount, int strikeCount) {
        List<Integer> playerNumber = NumberUtils.splitNum(input);
        List<Integer> computerNumber = new ArrayList<Integer>();
        computerNumber.add(4);
        computerNumber.add(2);
        computerNumber.add(5);

        Refree refree = new Refree(computerNumber, playerNumber);
        Map<BallStatus, Integer> score = refree.getScore();

        assertThat(score.get(BallStatus.BALL)).isNotNull()
                                              .isEqualTo(ballCount);
        assertThat(score.get(BallStatus.STRIKE)).isNotNull()
                                                .isEqualTo(strikeCount);
    }
}