package daptiv;

/*
 * http://allisons.org/ll/AlgDS/Dynamic/Edit/
 * http://programming4interviews.wordpress.com/2011/07/07/edit-distance-of-2-strings-using-dynamic-programming/
 */
public class EditDistDP {

    public static void main(String[] args) {

	editDistance("abxa", "axba");
	// editDistance("abde", "cde");
	// editDistance("appropriate meaning", "approximate matching");
	// editDistance("sport", "spot");
    }

    public static void editDistance(String s, String t) {
	
	int m = s.length();
	int n = t.length();
	int[][] d = new int[m + 1][n + 1];
	for (int i = 0; i <= m; i++) {
	    d[i][0] = i;
	}
	for (int j = 0; j <= n; j++) {
	    d[0][j] = j;
	}
	int v1, v2, v3;
	for (int j = 1; j <= n; j++) {
	    for (int i = 1; i <= m; i++) {
		v1 = d[i][j - 1] + 1;
		v2 = d[i - 1][j] + 1;
		v3 = d[i - 1][j - 1];
		if (s.charAt(i - 1) != t.charAt(j - 1)) {
		    v3 += 1;
		}
		d[i][j] = Math.min(Math.min(v1, v2), v3);

	    }
	}
	printMatrix(d);
	System.out.println(d[m][n]);
    }

    private static void printMatrix(int[][] m) {

	for (int i = 0; i < m.length; i++) {
	    for (int j = 0; j < m[0].length; j++) {
		System.out.print(m[i][j] + " ");
	    }
	    System.out.println();
	}
    }
}
