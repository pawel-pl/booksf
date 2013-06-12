package yahoo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberOfLetteredWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Scanner sc = new Scanner("this is a string");
		while (sc.hasNext()) {
			int l = sc.next().length();
			if (!map.containsKey(l)) {
				map.put(l, 1);
			} else {
				map.put(l, map.get(l) + 1);
			}
		}
		
		System.out.println(map);
	}

}
