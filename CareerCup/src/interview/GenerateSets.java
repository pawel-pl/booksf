package interview;

import java.util.HashSet;
import java.util.Set;

//S[i]={a[i],a[a[i]],a[a[a[i]]]…};
public class GenerateSets {

    public static void main(String[] args) {
	int[] arr = { 3, 1, 2, 0 };
	for (int i = 0; i < arr.length; i++) {
	    int index = i;
	    Set<Integer> set = new HashSet<Integer>();
	    while (!set.contains(arr[index])) {
		set.add(arr[index]);
		index = arr[i];
	    }
	    System.out.println(set);
	}
    }
}
