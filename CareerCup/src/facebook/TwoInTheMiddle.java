package facebook;

import java.util.Arrays;

public class TwoInTheMiddle {

    public static void main(String[] args) {

        int[] a = { 3, -1, 105, 108 };
        sort(a);
        // int[] a = { 1, 3, 3, 2, 1 };
        // threeWayPartition(a.clone(), 2);
    }

    public static void sort(int[] a) {
        int i = 0;
        int p = 0;
        int r = a.length - 1;
        while (i <= r) {
            if (isLow(a[i])) {
                swap(a, i++, p++);
            } else if (isHigh(a[i])) {
                swap(a, i, r--);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static boolean isLow(int input) {
        if (input < 0)
            return true;
        return false;
    }

    public static boolean isHigh(int input) {
        if (input > 100)
            return true;
        return false;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void threeWayPartition(int[] a, int pivot) {

        int p = 0;
        int q = a.length - 1;
        for (int i = 0; i <= q;) {
            if (a[i] < pivot)
                swap(a, i++, p++);
            else if (a[i] > pivot)
                swap(a, i, q--);
            else
                i++;
        }
    }

}
