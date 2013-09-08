package facebook;

import java.util.Arrays;

public class UniqueThreeMemberSubsets {

    /**
     * @param args
     */
    public static void main(String[] args) {

	// int[] arr = { 2, 2, 2, 1, 1, 1, 4, 4, 4, 3, 3, 3, 5, 5 };
	// int[] arr = { 1, 1, 2, 1, 1, 3 };
	int[] arr = { 1, 1 };
	// int[] arr = { 2, 2, 2 };
	withDups(arr);
    }

    public static void withDups(int[] arr) {
	
	if (arr == null || arr.length < 3) {
	    return;
	}
	Arrays.sort(arr);
	int[] triplet = new int[3];
	triplet[0] = arr[0];
	triplet[1] = arr[1];
	triplet[2] = arr[2];
	System.out.println(Arrays.toString(triplet));
	for (int i = 2; i < arr.length; i++) {
	    if (arr[i] == triplet[2]) {
		continue;
	    }
	    triplet[2] = arr[i];
	    System.out.println(Arrays.toString(triplet));
	}
	for (int i = 3; i < arr.length; i++) {
	    while (i < arr.length && arr[i] == triplet[0]) {
		i++;
	    }
	    if (i == arr.length - 1) {
		break;
	    }
	    triplet[0] = triplet[1];
	    triplet[1] = arr[i];
	    triplet[2] = arr[i + 1];
	    System.out.println(Arrays.toString(triplet));
	    for (int j = i + 2; j < arr.length; j++) {
		if (arr[j] == triplet[2]) {
		    continue;
		}
		triplet[2] = arr[j];
		System.out.println(Arrays.toString(triplet));
	    }
	}
    }

    public static void withoutDups(int[] arr) {
	Arrays.sort(arr);
	int[] triplet = new int[3];
	for (int i = 0; i < arr.length - 2;) {
	    triplet[0] = arr[i];
	    while (i < arr.length && arr[i] == triplet[0]) {
		i++;
	    }
	    for (int j = i; j < arr.length - 1;) {
		triplet[1] = arr[j];
		while (j < arr.length && arr[j] == triplet[1]) {
		    j++;
		}
		for (int l = j; l < arr.length;) {
		    triplet[2] = arr[l];
		    System.out.println(Arrays.toString(triplet));
		    while (l < arr.length && arr[l] == triplet[2]) {
			l++;
		    }
		}
	    }
	}

    }

}
