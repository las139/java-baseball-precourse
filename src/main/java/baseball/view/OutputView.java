package baseball.view;

import baseball.constant.Message;

public class OutputView {

    public static void viewStrikeMsg() {
        System.out.println(Message.MSG_STRIKE);
    }
    public static void viewBallMsg() {
        System.out.println(Message.MSG_BALL);
    }
    public static void viewNothingMsg() {
        System.out.println(Message.MSG_NOTHING);
    }
    public static void viewInputMsg() {
        System.out.print(Message.MSG_INPUT);
    }
    public static void viewEndMsg() {
        System.out.println(Message.MSG_RESULT);
        System.out.println(Message.MSG_RESTART_YN);
    }

    public static void viewMsg(String msg) {
        System.out.println(msg);
    }
}