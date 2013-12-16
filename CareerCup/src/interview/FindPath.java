package interview;

public class FindPath {

    public static void main(String[] args) {

	int[][] m = { { 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 1, 1, 1, 0 }, { 0, 0, 0, 1, 1 } };
	System.out.println("Found path: " + findPath(0, 0, m.length - 1, m[0].length - 1, m));
    }

    private static boolean findPath(int startRow, int startCol, int endRow, int endCol, int[][] m) {

	if (startRow < 0 || startCol < 0 || endRow < 0 || endCol < 0 || startRow > m.length - 1
		|| startCol > m[0].length - 1 || endRow > m.length - 1 || endCol > m[0].length - 1) {

	    return false;
	}
	if (startRow == endRow && startCol == endCol) {
	    return true;
	}

	m[startRow][startCol] = -1;
	
	// go up
	boolean up = false;
	if (startRow - 1 >= 0 && m[startRow - 1][startCol] == 1) {
	    up = findPath(startRow - 1, startCol, endRow, endCol, m);
	}

	// go down
	boolean down = false;
	if (startRow + 1 <= m.length - 1 && m[startRow + 1][startCol] == 1) {
	    down = findPath(startRow + 1, startCol, endRow, endCol, m);
	}

	// go left
	boolean left = false;
	if (startCol - 1 >= 0 && m[startRow][startCol - 1] == 1) {
	    left = findPath(startRow, startCol - 1, endRow, endCol, m);
	}

	// go right
	boolean right = false;
	if (startCol + 1 <= m[0].length - 1 && m[startRow][startCol + 1] == 1) {
	    right = findPath(startRow, startCol + 1, endRow, endCol, m);
	}

	return up || down || right || left;
    }
}
