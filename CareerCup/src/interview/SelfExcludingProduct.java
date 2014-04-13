package interview;

import java.util.Arrays;

public class SelfExcludingProduct {

    public static void main(String[] args) {
        int prod = 1;
        int noOfZeros = 0;
        int[] arr = { 3, 0, 0, 2 };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                prod *= arr[i];
            } else {
                noOfZeros++;
                if (noOfZeros > 1) {
                    break;
                }
            }
        }
        if (noOfZeros > 1) {
            Arrays.fill(arr, 0);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (noOfZeros == 1) {
                    if (arr[i] == 0) {
                        arr[i] = prod;
                    } else {
                        arr[i] = 0;
                    }
                } else {
                    arr[i] = prod / arr[i];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
