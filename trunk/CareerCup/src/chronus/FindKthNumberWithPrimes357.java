package chronus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * CTC p 195
 */
public class FindKthNumberWithPrimes357 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<Integer>();
		LinkedList<Integer> q3 = new LinkedList<Integer>();
		LinkedList<Integer> q5 = new LinkedList<Integer>();
		LinkedList<Integer> q7 = new LinkedList<Integer>();
		List<LinkedList<Integer>> queues = new ArrayList<LinkedList<Integer>>(3);
		q3.add(3);
		q5.add(5);
		q7.add(7);
		queues.add(q3);
		queues.add(q5);
		queues.add(q7);

		int k = 15;
		for (int i = 0; i < k; i++) {
			int min = Integer.MAX_VALUE;
			int minQueue = 0;
			for (int j = 0; j < 3; j++) {
				if (queues.get(j).getFirst() < min) {
					min = queues.get(j).getFirst();
					minQueue = j;
				}
			}
			queues.get(minQueue).removeFirst();
			numbers.add(min);
			switch (minQueue) {
			case 0:
				q3.add(min * 3);
			case 1:
				q5.add(min * 5);
			case 2:
				q7.add(min * 7);

			}
		}

		System.out.println(numbers);
	}

}
