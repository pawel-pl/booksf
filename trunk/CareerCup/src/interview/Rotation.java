package interview;

public class Rotation {

    public static void main(String[] args) {
        // int[] arr = { 4, 4, 5, 5, 5, 6, 1, 1, 2, 2, 3, 3, 3 };
//         int[] arr = { 2, 1, 6, 5, 4, 3 };
         int[] arr = { 1, 2, 3, 4, 5 };
//         int[] arr = { 5, 4, 3, 2, 1 };
//         int[] arr = { 6, 7, 0, 1, 2, 4, 5 };
//        int[] arr = { 5, 4, 2, 1, 0, 7, 6 };
        int l = 0;
        int r = arr.length - 1;
        while (arr[l] > arr[r]) {
            int m = l + (r - l) / 2;
            if (arr[m] > arr[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        int minAcs = arr[l];
        l = 0;
        r = arr.length - 1;
        while (arr[r] > arr[l]) {
            int m = (l + (r - l) / 2) + 1;
            if (arr[m] > arr[l]) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        System.out.println("value: " + Math.min(minAcs, arr[r]));
    }
}
