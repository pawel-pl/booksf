package interview;

public class MatrixPool {

    public static void main(String[] args) {
        int poolSize = 0;
        boolean secPool = false;
        int[][] m = { { 1, 1, 1, 1, 1 }, { 1, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 } };
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 0 && poolSize == 0) {
                    poolSize = findPool(i, j, m);
                } else if (m[i][j] == 0 && poolSize > 0) {
                    secPool = true;
                    break;
                }
            }
            if (secPool) {
                break;
            }
        }
        System.out.println("Found pool: " + (poolSize > 1 && !secPool));
    }

    public static int findPool(int i, int j, int[][] m) {
        if (m[i][j] == 1 || i < 0 || i > m.length - 1 || j < 0 || j > m[0].length - 1) {
            return 0;
        }
        m[i][j] = 1;
        int left = findPool(i, j - 1, m);
        int right = findPool(i, j + 1, m);
        int up = findPool(i - 1, j, m);
        int down = findPool(i + 1, j, m);
        return left + right + up + down + 1;
    }
}
