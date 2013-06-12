package yahoo;

import java.util.HashMap;
import java.util.Map;

public class NumberOfUniqEl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 3, 5, 2, 2, 7 };
		int uniqueCount = 0;
		
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			if(!m.containsKey(a[i])) {
				m.put(a[i], 1);
				uniqueCount++;
			} else if (m.get(a[i]) == 1) {
				uniqueCount--;
				m.put(a[i], 2);
			}
		}
		System.out.println(uniqueCount);
	}

}
