package riverbed;

public class ReturnKthLargestElIn2SortedArsPosition {
    
    public static int mergedPosition(int[] a, int[] b, int k) {
	    int ai = 0;
	    int bi = 0;
	    int counter = 0;
	    int curr = 0;
	    while(ai < a.length && bi < b.length) {
	        if(a[ai] < b[bi]) {
	            curr = a[ai++];
	        }
	        else {
	            curr = b[bi++];
	        }
	        counter++;
	        if(k == counter) return curr;
	    }
	    while(ai < a.length) {
	        curr = a[ai++];
	        counter++;
	        if(k == counter) return curr;
	    }
	    while(bi < b.length) {
	        curr = b[bi++];
	        counter++;
	        if(k == counter) return curr;
	    }
	    return -1; // if k > a.length + b.length
	}
}
