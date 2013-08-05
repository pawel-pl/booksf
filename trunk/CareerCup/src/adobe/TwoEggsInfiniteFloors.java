package adobe;

/*
 * The sub-optimal solution for the infinite problem for two eggs is to use the sequen 1, 2^2, 3^3, ,i^2, ... 
 * and start the second edge where the last value the first egg remains. 
 * So if the first edge remains at n^2, then the next one will do at most 2*n + 1 - 1 (minus 1 from the first) 
 * test to give the total of 3 * n in the worst case with n = sqrt(m). 
 * This is much better bound than the doubling strategy that result in log(m) + m/2 = 0(m) in the worst case.
 * 
 * Search infinite space:
 * http://stackoverflow.com/questions/12535241/find-an-element-in-infinite-sorted-array
 * 
 * Growing the window by powers of 2 means you'll find the end in log_2(n) iterations. Growing by factors of 3 means you'll find it in log_3(n) iterations,
 * which is smaller. But not asymptotically smaller, as O(log_2(n)) == O(log_3(n)). 
 * And your binary search is going to take log_2(n) steps anyway, so making the first part faster is not going to help your big-O running time.
 */
public class TwoEggsInfiniteFloors {

    public static void main(String[] args) {
	
	for (int i = 2; i < 5; i++) {
	    
	    System.out.println( 1 << i);
	}
    }
}
