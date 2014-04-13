package interview;

public class CountLetters {

    public static void main(String[] args) {

	int[] count = new int[128];
	char[] input = { 'A', 'B', 'C', 'B', 'A', 'C', 'A', 'B', 'C', 'A', '#' };
	for (int i = 0; i < input.length; i++) {
	    count[input[i]]++;
	}
	for (int i = 0; i < count.length; i++) {
	    if (count[i] > 0) {
		System.out.println((char) (i) + " = " + count[i]);
	    }
	}
    }
}
