package interview;

public class NegativeValueBinSearch {

    public static void main(String[] args) {

        System.out.println(findIndex(new int[] { -2, -3, -4 }));
    }

    public static int findIndex(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == m) {
                return m;
            }
            if (arr[m] > m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
