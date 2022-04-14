package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.constant.GameConfig;
import baseball.constant.Message;
import baseball.util.ValidationCheck;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationCheckTest {

    @ParameterizedTest
    @DisplayName("length 3 체크 테스트")
    @ValueSource(strings = {"1","12","1234","56789",""})
    public void lengthChk_test(String input) {
        assertThatThrownBy(() -> {
            ValidationCheck.lengthChk(input, GameConfig.NUM_SIZE);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Message.MSG_ERROR_LENGTH);
    }

    @ParameterizedTest
    @DisplayName("1 ~ 9 범위 확인 테스트")
    @ValueSource(strings = {"0","-1","TEST","테스트",""," "})
    public void numChk_test(String input) {
        assertThatThrownBy(() -> {
            ValidationCheck.numRangeChk(input, GameConfig.START_NUM, GameConfig.END_NUM);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Message.MSG_ERROR_NOT_NUM);
    }

    @ParameterizedTest
    @DisplayName("고유한 숫자 테스트")
    @ValueSource(strings = {"111","222","333","445","566","000"})
    public void uniqueChk_test(String input) {
        assertThatThrownBy(() -> {
            ValidationCheck.uniqueChk(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("게임 재시작 or 종료 시 1 or 2 입력 테스트")
    @ValueSource(strings = {"","a","ㄱ","4","56"})
    public void checkAll_test(String input) {
        assertThatThrownBy(() -> {
            ValidationCheck.endChk(input);
        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(Message.MSG_ERROR_END);
    }
}