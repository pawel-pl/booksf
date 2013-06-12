package yahoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListWithAutoAdjust {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
		List<Integer> l2 = new ArrayList<Integer>(Arrays.asList(new Integer[] { 4, 6, 9 }));
		Collections.sort(l2);
		System.out.println(l1);
		for (int i = l2.size() - 1; i >= 0; i--) {
			int index = l2.get(i);
			if (index >= l1.size()) {
				continue;
			}
			l1.remove(l2.get(i));
			System.out.println(l1);
		}

	}

}
