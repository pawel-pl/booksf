package interview;

public class FindBinarySearch {

    public static void main(String[] args) {
        
        System.out.println(-1 % 5);
//         int[] a = { 0, 2, 3, 10 };
//        int[] a = { 0, 2 };
//        System.out.println(findFirst(a, 3));
//        System.out.println(findLast(a, 3));

    }

    public static int findFirst(int[] a, int n) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] == n) {
                if (m == 0 || a[m - 1] != n) {
                    return m;
                } else {
                    r = m;
                }
            } else if (a[m] > n) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static int findLast(int[] a, int n) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] == n) {
                if (m == a.length - 1 || a[m + 1] != n) {
                    return m;
                } else {
                    l = m;
                }
            } else if (a[m] > n) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
