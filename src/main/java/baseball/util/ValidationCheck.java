package baseball.util;

import java.util.HashSet;
import java.util.List;

import baseball.constant.GameConfig;
import baseball.constant.Message;

public class ValidationCheck {

    public static boolean checkAll(String input, int size, int startNum, int endNum) {
		if(!lengthChk(input, size)) { return false; }
		if(!numRangeChk(input, startNum, endNum)) { return false; }
		if(!uniqueChk(input)) { return false; }
		
		return true;
	}

    public static boolean lengthChk(String input, int size) {
		if(input.length() != size) {
            throw new IllegalArgumentException(Message.MSG_ERROR_LENGTH);
		}
		
		return true;
	}

    public static boolean numRangeChk(String input, int startNum, int endNum) {
		String regex = "["+startNum+"-"+endNum+"]+";
		
		if(!input.matches(regex)) {
            throw new IllegalArgumentException(Message.MSG_ERROR_NOT_NUM);
		}
		
		return true;
	}

    public static boolean uniqueChk(String input) {
		List<Integer> numbers = NumberUtils.splitNum(input);
		HashSet<Integer> distinctNum = new HashSet<Integer>(numbers);
		
		if(numbers.size() != distinctNum.size()) {
            throw new IllegalArgumentException(Message.MSG_ERROR_NOT_UNIQUE);
		}
		
		return true;
	}

    public static boolean endChk(String input) {
		if(!input.equals(GameConfig.KEY_RESTART) && !input.equals(GameConfig.KEY_END)){
            throw new IllegalArgumentException(Message.MSG_ERROR_END);
		}
		
		return true;
	}
}