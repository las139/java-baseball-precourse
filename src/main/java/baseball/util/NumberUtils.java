package baseball.util;

import java.util.ArrayList;
import java.util.List;

import baseball.constant.GameConfig;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberUtils {

    public static List<Integer> generateNum(int size) {
		List<Integer> numbers = new ArrayList<Integer>();

		while(numbers.size() < size) {
			addRandomNum(numbers);
		}
		
		return numbers;
	}

    public static void addRandomNum(List<Integer> numbers) {
		int num = Randoms.pickNumberInRange(GameConfig.START_NUM, GameConfig.END_NUM);
		if(!numbers.contains(num)){
			numbers.add(num);
		}
	}

    public static List<Integer> splitNum(String input) {
		List<Integer> numbers = new ArrayList<Integer>();

		for(String number : input.split("")){
			numbers.add(Integer.valueOf(number));
		}

		return numbers;
	}
}