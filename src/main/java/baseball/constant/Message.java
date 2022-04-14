package baseball.constant;

public class Message {
    public static final String MSG_STRIKE = "스트라이크";
    public static final String MSG_BALL = "볼";
    public static final String MSG_NOTHING = "낫싱";

    public static final String MSG_INPUT = "숫자를 입력해주세요 : ";
    public static final String MSG_RESULT = GameConfig.NUM_SIZE+"개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String MSG_RESTART_YN = "게임을 시작하려면 "+GameConfig.KEY_RESTART+", 종료하려면 "+GameConfig.KEY_END+"를 입력하세요.";

    public static final String MSG_ERROR_LENGTH = GameConfig.NUM_SIZE+"개의 숫자를 입력하세요.";
    public static final String MSG_ERROR_NOT_NUM = GameConfig.START_NUM+"부터 "+GameConfig.END_NUM+"까지의 숫자만 입력하세요.";
    public static final String MSG_ERROR_NOT_UNIQUE = "서로 다른 숫자를 입력하세요.";
    public static final String MSG_ERROR_END = GameConfig.KEY_RESTART+" 또는 "+GameConfig.KEY_END+"를 입력하세요.";
}