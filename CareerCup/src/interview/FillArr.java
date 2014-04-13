package interview;

import java.util.Arrays;

public class FillArr {

    public static void main(String[] args) {
        int[][] m = { { 1, 2, 3, 1 }, { 1, 0, -1, 2 }, { -1, 1, 1, 1 } };
        int[] row = new int[m.length];
        int[] col = new int[m[0].length];
        Arrays.fill(row, 1);
        Arrays.fill(col, 1);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] < 0) {
                    row[i] *= -1;
                    col[j] *= -1;
                } else if (m[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }
                m[i][j] = 1;
            }
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] *= row[i] * col[j];
            }
        }
    }

}
