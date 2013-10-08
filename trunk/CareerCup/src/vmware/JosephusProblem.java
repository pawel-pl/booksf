	package vmware;

import java.util.LinkedList;
import java.util.Queue;

/*
 * http://en.wikipedia.org/wiki/Josephus_problem
 */
public class JosephusProblem {

    public static void main(String[] args) {

        int M = 2;
        int N = 17;

        // initialize the queue
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 1; i <= N; i++)
            q.offer(i);

        while (q.size() > 1) {
            for (int i = 0; i < M - 1; i++)
                q.offer(q.poll());
            System.out.print(q.poll() + " ");
        } 
        System.out.println(q.poll());
	System.out.println(josephus(17, 2));
    }

    private static int josephus(int n, int k) {
	
	return josephus(n, k, 1);
    }

    private static int josephus(int n, int k, int startingPoint) {
	
	//System.out.println(startingPoint);
	if (n == 1)
	    return 1;
	int newSp = (startingPoint + k - 2) % n + 1;

	int survivor = josephus(n - 1, k, newSp);
	if (survivor < newSp) {
	    return survivor;
	} else
	    return survivor + 1;
    }
}
