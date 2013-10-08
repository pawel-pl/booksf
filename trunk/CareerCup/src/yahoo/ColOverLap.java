package yahoo;

public class ColOverLap {
    
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
