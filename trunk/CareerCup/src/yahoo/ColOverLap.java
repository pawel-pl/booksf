package yahoo;

public class ColOverLap {

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method
	 * stub
	 * 
	 * int n = 2; int i, j; int b[][] = new int[4 * n][4 * n]; int a = 1; for (i
	 * = 0; i < 4 * n; i++) { for (j = 0; j < 4 * n; j++) { b[i][j] = a; a++;
	 * System.out.print(b[i][j]); System.out.print("\t"); }
	 * System.out.println(""); }
	 * 
	 * int m = 8 * n * n; int c1[] = new int[m]; int c2[] = new int[m]; int p =
	 * 0, p1 = 0, q1 = 2, nflg = 1;
	 * 
	 * c1[p] = b[2 * n][2 * n - 1]; int tmp = c1[p]; p++; while (p < m) { for
	 * (p1 = 0; p1 < q1; p1++) { c1[p] = tmp - 4 * n * nflg; tmp = c1[p]; p++;
	 * if (p >= m) { break; } } if (p >= m) { break; } for (p1 = 0; p1 < q1;
	 * p1++) { c1[p] = tmp + nflg; tmp = c1[p]; p++; if (p >= m) { break; } }
	 * nflg = nflg * (-1); q1 += 2; }
	 * 
	 * get coil2 from coil1 for (i = 0; i < 8 * n * n; i++) { c2[i] = 16 * n * n
	 * + 1 - c1[i]; } System.out.println(); System.out.print("Coil1:"); for (i =
	 * 0; i < 8 * n * n; i++) { System.out.print(c1[i]); System.out.print("\t");
	 * } System.out.println(); System.out.print("Coil2:"); for (i = 0; i < 8 * n
	 * * n; i++) { System.out.print(c2[i]); System.out.print("\t"); } }
	 */

	public static void main(String[] args) {
		dumpcoils(1);
		dumpcoils(2);
		dumpcoils(3);
		dumpcoils(4);
	}

	static void dumpcoils(int n) {
		int a[][] = new int[4 * n][4 * n];
		initializeMatrix(a, n);
		dumpcoil(2 * n, 2 * n - 1, 0, a);
		dumpcoil(2 * n - 1, 2 * n, 2, a);
	}

	static void initializeMatrix(int a[][], int n) {
		int k = 1;
		for (int i = 0; i < a.length; ++i) {
			for (int j = 0; j < a[0].length; ++j) {
				a[i][j] = k++;
				if (n <= 2) {
					System.out.print(String.format("%02d", a[i][j]) + " ");
				} else {
					System.out.print(String.format("%03d", a[i][j]) + " ");
				}
			}
			System.out.print("\n");
		}
	}

	static void dumpcoil(int i, int j, int step, int a[][]) {
		int distance = 2;
		int k = 0;
		while (i < a.length && j < a.length && i >= 0 && j >= 0) {
			System.out.print(a[i][j] + " ");
			switch (step % 4) {
			case 0:
				--i;
				break;
			case 1:
				++j;
				break;
			case 2:
				++i;
				break;
			case 3:
				--j;
				break;
			}
			k++;
			if (k == distance) {
				k = 0;
				++step;
				if (step % 2 == 0) {
					distance += 2;
				}
			}
		}
		System.out.print("\n");
	}
}
