package samsung;

public class FindClosest0And1InMatrix {

    public static void main(String[] args) {

	int arr[][] = { { 1, 1, 0 }, { 0, 0, 0 }, { 1, 0, 0 } };
	System.out.println(findShortestPath(arr, 0, 0));
    }

    private static Integer findShortestPath(int arr[][], int i, int j) {

	if (i == arr.length - 1 && j == arr[0].length - 1) {
	    return 0;
	}
	if (i == arr.length || j == arr[0].length || j < 0) {
	    return null;
	}
	Integer result = null;
	if (arr[i][j] == 1) {
	    Integer down = findShortestPath(arr, i + 1, j);
	    Integer right = findShortestPath(arr, i, j + 1);
	    if (down == null && right == null) {
		return null;
	    }
	    if (down != null) {
		result = down;
	    }
	    if (right != null) {
		result = result != null ? Math.min(result, right) : right;
	    }
	} else {
	    result = findShortestPath(arr, i + 1, j);
	}

	return result != null ? result + 1 : null;
    }

}
