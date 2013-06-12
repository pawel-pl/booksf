package nvidia;

public class ReplaceBits {

	public static void main(String[] args) {

		Integer a = 255;
		Integer b = 0;
		printBinary(b);
		printBinary(a);
		printBinary(updateBits(b, a, 2, 6));
	}

	public static int updateBits(int n, int m, int i, int j) {
		
		int max = ~0; /* All 1’s */

		// 1’s through position j, then 0’s
		int left = max - ((1 << j) - 1);
		// 1’s after position i
		int right = ((1 << i) - 1);
		// 1’s, with 0s between i and j
		int mask = left | right;
		printBinary(mask);
		// Clear i through j, then put m in there
		return (n & mask) | (m << i);
	}

	private static void printBinary(Integer v) {

		String bin = Integer.toBinaryString(v);
		String res = "";
		for (int i = 0; i < 8 - bin.length(); i++) {
			res = res + "0";
		}
		System.out.println(res + bin);
	}

}
