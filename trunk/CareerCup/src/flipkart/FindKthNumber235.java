package flipkart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindKthNumber235 {

    /**
     * @param args
     */
    public static void main(String[] args) {

	List<Integer> numbers = new ArrayList<Integer>();
	numbers.add(1);
	LinkedList<Integer> q2 = new LinkedList<Integer>();
	LinkedList<Integer> q3 = new LinkedList<Integer>();
	LinkedList<Integer> q5 = new LinkedList<Integer>();
	List<LinkedList<Integer>> queues = new ArrayList<LinkedList<Integer>>(3);
	q2.add(2);
	q3.add(3);
	q5.add(5);
	queues.add(q2);
	queues.add(q3);
	queues.add(q5);

	int k = 15;
	for (int i = 1; i < k; i++) {
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
		q2.add(min * 2);
	    case 1:
		q3.add(min * 3);
	    case 2:
		q5.add(min * 5);

	    }
	}

	System.out.println(numbers);
    }

}
