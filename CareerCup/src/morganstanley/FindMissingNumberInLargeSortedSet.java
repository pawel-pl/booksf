package morganstanley;

/*
 * time complexity is O(log n)

 variation of binary search i.e.. reverse binary search.
 check the target number is present in below index ranges i.e.. 2^n index range
 0-1
 2-3
 4-7
 8-15
 16-31
 32-63
 .
 .

 if target number is found in any of the above range then apply binary search on that data

 int start=0, end = 1;
 if target <= a[end]
 apply binary search for the range start and end
 else
 start = end +1;
 end = end*2+1;
 */
public class FindMissingNumberInLargeSortedSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
