package qualcomm;

public class BitCount {

	public static void main(String[] args) {

		int v = 1010;
		int org = v;
		int bitCount = 0;
		while (v > 0) {

			if ((v & 1) == 1) {
				bitCount++;
			}
			v = v >> 1;
		}
		System.out.println(org + " has " + bitCount + " bits");
	}
}
