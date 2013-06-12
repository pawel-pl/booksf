package yahoo;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProbabOfSumRep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		checkSum(10, new LinkedHashMap<Integer, Integer>(), 10);
	}

	public static void checkSum(int num, Map<Integer, Integer> map, int currentDigit) {

		if (currentDigit == 1) {
			map.put(currentDigit, num);
			System.out.println(map);
			map.remove(currentDigit);
			return;
		}

		for (int i = 0; num - (currentDigit * i) >= 0; i++) {
			if (i > 0) {
				map.put(currentDigit, i);
			}
			if (num - (currentDigit * i) > 0) {
				checkSum(num - (currentDigit * i), map, currentDigit - 1);
			} else {
				System.out.println(map);
			}
		}
		
		map.remove(currentDigit);
	}
}
