package flipkart;

public class FindLongestLand {

    public static void main(String[] args) {

	// char[][] m = { { 'L', 'L', 'L', 'L' }, { 'L', 'L', 'W', 'L' }, { 'L',
	// 'W', 'L', 'W' }, { 'W', 'W', 'L', 'L' } };
	char[][] m = { { 'W', 'W', 'W', 'W' }, { 'W', 'L', 'L', 'W' }, { 'W', 'L', 'L', 'W' }, { 'W', 'W', 'W', 'W' } };
	findLongestLand(m);

    }

    public static void findLongestLand(char[][] m) {
	int result = 0;
	for (int i = 0; i < m.length; i++) {
	    for (int j = 0; j < m[0].length; j++) {
		if (m[i][j] == 'W') {
		    continue;
		}
		result = Math.max(result, findLongestLand(m, i, j));
	    }
	}
	System.out.println(result);
    }

    public static int findLongestLand(char[][] m, int i, int j) {

	if (i < 0 || j < 0 || i > m.length - 1 || j > m[0].length - 1 || m[i][j] == 'W') {
	    return 0;
	}

	m[i][j] = 'W';
	int count = 0;
	count += findLongestLand(m, i, j - 1);
	count += findLongestLand(m, i, j + 1);
	count += findLongestLand(m, i + 1, j);
	count += findLongestLand(m, i - 1, j);
	count += 1;

	return count;
    }
}
