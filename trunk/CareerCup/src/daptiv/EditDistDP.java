package daptiv;

/*
 * http://allisons.org/ll/AlgDS/Dynamic/Edit/
 */
public class EditDistDP {

    public static void main(String[] args) {

	editDistance("abde", "cde");
	editDistance("appropriate meaning", "approximate matching");
	editDistance("sport", "spot");
    }

    public static void editDistance(String a, String b) {

	int[][] lengths = new int[b.length()][a.length()];
	for (int i = 0; i < a.length(); i++) {
	    if (a.charAt(i) == b.charAt(0)) {
		lengths[0][i] = 0;
	    } else if (i > 0) {
		lengths[0][i] = lengths[0][i - 1] + 1;
	    } else {
		lengths[0][i] = 1;
	    }
	}
	int v1 = 0;
	int v2 = 0;
	int v3 = 0;
	for (int i = 1; i < b.length(); i++) {
	    for (int j = 0; j < a.length(); j++) {
		v1 = j == 0 ? 1 : lengths[i][j - 1] + 1; // left
		v2 = lengths[i - 1][j] + 1; // above
		v3 = j == 0 ? 0 : lengths[i - 1][j - 1]; // above - left
		if (a.charAt(j) != b.charAt(i)) {
		    v3 += 1;
		}
		lengths[i][j] = Math.min(v1, Math.min(v2, v3));
	    }
	}

	// read the substring out from the matrix
	printMatrix(lengths);
	System.out.println("Distance: " + lengths[lengths.length - 1][lengths[0].length - 1]);
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
