package qualcomm;

import java.util.HashMap;

public class GenerateRandomNum {

	public static void generateRandomNumNoRep(int[][] test, int maxValue) {

		if (maxValue < test.length * test[0].length) {
			System.out.println("No way!");
			return;
		}
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int i = 0; i != test.length; i++) {
			for (int j = 0; j != test[0].length; j++) {
				int setValue = 0;
				do {
					setValue = (int) (Math.random() * maxValue);
				} while (map.containsKey(setValue));
				map.put(setValue, true);
				test[i][j] = setValue;
			}
		}
	}
}
