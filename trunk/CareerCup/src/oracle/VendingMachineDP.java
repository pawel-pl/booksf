package oracle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * http://home.agh.edu.pl/~gajda/IILO/wyk2/dynamiczne.pdf
 */
public class VendingMachineDP {

    public static int INF = Integer.MAX_VALUE;
    public static int[] coins = { 1,2,3 };
    public static int value = 6;

    public static void main(String[] args) {
	findVendor();
	findVendor2();
    }

    /**
     * @param args
     */
    public static void findVendor2() {

	int[][] t = new int[coins.length][value + 1];
	for (int i = 0; i < t.length; i++) {
	    for (int j = 1; j < t[0].length; j++) {
		t[i][j] = INF;
	    }
	}
	for (int i = 0; i < t[0].length - coins[0]; i++) {
	    if (t[0][i] != INF) {
		if (t[0][i] + 1 < t[0][i + coins[0]]) {
		    t[0][i + coins[0]] = t[0][i] + 1;
		}
	    }
	}
	System.out.println(Arrays.toString(t[0]));
	for (int i = 1; i < coins.length; i++) {
	    int coin = coins[i];
	    for (int j = 0; j < t[0].length - coin; j++) {
		int val = t[i][j] != INF ? t[i][j] : t[i - 1][j]; // the value might have been already assigned for the current row
		if (val != INF) {
		    if (val + 1 < t[i - 1][j + coin]) {
			t[i][j + coin] = val + 1;
		    }
		} else {
		    t[i][j] = t[i - 1][j];
		}
	    }
	    System.out.println(Arrays.toString(t[i]));
	}
	int i = coins.length - 1;
	int j = t[0].length - 1;
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	while (i >= 0 && t[i][j] != 0) {
	    if (i == 0) {
		if (t[i][j] != INF) {
		    if (map.containsKey(coins[i])) {
			map.put(coins[i], map.get(coins[i]) + t[i][j]);
		    } else {
			map.put(coins[i], t[i][j]);
		    }
		}
		break;
	    } else {
		while (t[i][j] < t[i - 1][j]) {
		    if (map.containsKey(coins[i])) {
			map.put(coins[i], map.get(coins[i]) + 1);
		    } else {
			map.put(coins[i], 1);
		    }
		    j = j - coins[i];
		}
		i = i - 1;
	    }
	}
	System.out.println(map);
    }

    public static void findVendor() {

	int[] T = new int[value + 1]; // utwórz tablicê T o zakresie od 0 do k
	T[0] = 0; // dla kwoty 0 potrzebujesz 0 monet
	for (int i = 1; i <= value; ++i)
	    // dla ka¿dej kwoty od 1 do k
	    T[i] = INF; // potrzebujesz nieskoñczonoœæ monet
	for (int i = 0; i < coins.length; ++i) { // dla ka¿dego nomina³u
						 // wykonuj:
	    int n = coins[i]; // n – aktualnie analizowany nomina³
	    for (int j = 0; j <= T.length - n - 1; ++j)
		// dla j=0 do k-n wykonuj:
		if (T[j] < INF) // je¿eli T[j] ju¿ ma przypisan¹ wartoœæ i
				// je¿eli
		    if (T[j] + 1 < T[j + n]) // dodanie monety zmniejszy liczbê
					     // monet dla kwoty j+n,
			T[j + n] = T[j] + 1; // to zapisz now¹ liczbê monet dla
					     // zwiêkszonej kwoty.
	}

	System.out.println(Arrays.toString(T));
    }

}
