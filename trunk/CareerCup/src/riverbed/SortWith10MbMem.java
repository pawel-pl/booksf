package riverbed;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/*
 * 
 http://tianrunhe.wordpress.com/2012/04/08/generate-an-integer-which-is-not-in-a-file-with-4-billion-integers-limited-memory/
 http://stackoverflow.com/questions/7153659/find-an-integer-not-among-four-billion-given-ones?page=1&tab=votes#tab-top
 p. 202
 1 byte = 8 bits
 1 kilobyte (K / Kb) = 2^10 bytes = 1,024 bytes
 1 megabyte (M / MB) = 2^20 bytes = 1,048,576 bytes
 1 gigabyte (G / GB) = 2^30 bytes = 1,073,741,824 bytes
 1 terabyte (T / TB) = 2^40 bytes = 1,099,511,627,776 bytes
 1 petabyte (P / PB) = 2^50 bytes = 1,125,899,906,842,624 bytes
 1 exabyte (E / EB) = 2^60 bytes = 1,152,921,504,606,846,976 bytes
 */
public class SortWith10MbMem {

	public static void main(String[] args) {

		try {
			findOpenNumber2("d:/numbers.txt");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void findOpenNumber2(String fileName) throws FileNotFoundException {

		byte[] bitfield = new byte[(int) (Math.pow(2, 32) / 8)];
		System.out.println(bitfield.length);
		Scanner in = new Scanner(new FileReader(fileName));
		while (in.hasNextInt()) {
			int n = in.nextInt();

			// Finds the corresponding number in the bitfield by using the
			// OR operator to set the nth bit of a byte (e.g.. 10 would
			// correspond to the 2nd bit of index 2 in the byte array).

			bitfield[n / 8] |= 1 << (n % 8);
		}

		for (int i = 0; i < bitfield.length; i++) {
			for (int j = 0; j < 8; j++) {

				// Retrieves the individual bits of each byte. When 0 bit
				// is found, finds the corresponding value.

				if ((bitfield[i] & (1 << j)) == 0) {
					System.out.println(i * 8 + j);
					return;
				}
			}
		}
	}

	public static void findOpenNumber() throws FileNotFoundException {

		int bitsize = 1048576; // 2^20 bits (2^17 bytes)
		int blockNum = 4096; // 2^12
		byte[] bitfield = new byte[bitsize / 8];
		int[] blocks = new int[blockNum];
		int starting = -1;
		Scanner in = new Scanner(new FileReader("d:/numbers.txt"));

		while (in.hasNextInt()) {
			int n = in.nextInt();
			blocks[n / bitsize]++;
		}

		for (int i = 0; i < blocks.length; i++) {
			if (blocks[i] < bitsize) {
				/*
				 * if value < 2^20, then at least 1 number is missing in that
				 * section.
				 */
				starting = i * bitsize;
				break;
			}
		}

		in = new Scanner(new FileReader("d:/numbers.txt"));
		while (in.hasNextInt()) {
			int n = in.nextInt();
			/*
			 * If the number is inside the block that’s missing numbers, we
			 * record it
			 */
			if (n >= starting && n < starting + bitsize) {
				bitfield[(n - starting) / 8] |= 1 << ((n - starting) % 8);
			}
		}

		for (int i = 0; i < bitfield.length; i++) {
			for (int j = 0; j < 8; j++) {
				/*
				 * Retrieves the individual bits of each byte. When 0 bit is
				 * found, finds the corresponding value.
				 */
				if ((bitfield[i] & (1 << j)) == 0) {
					System.out.println(i * 8 + j + starting);
					return;
				}
			}
		}
	}

}
